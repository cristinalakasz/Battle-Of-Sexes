package planet_earth;

import java.util.ArrayList;
import java.util.Random;

import human.*;

/**
 * In the Evolution method the evolutionary rules given by payoff
 * calculations dictated by Dawkins' studies are set
 */

public class Evolution {

    /* ATTRIBUTI
    Gli attributi servono per vedere quanti figli fanno uomini e donne in quella generazione
     */
    private static Random randomic = new Random();
    private static int figlioPhl;
    private static int figlioFaith;
    private static int figlioCoy;
    private static int figlioFast;

    /**
     *
     * the evoRules method takes a man and a woman as input and according
     * to them is assigned the payoff through the setScore() method of the Human abstract class
     * @param u
     * @param d
     */
    public static void evoRules(Man u , Woman d){
        int a = Population.getA();
        int b = Population.getB();
        int c = Population.getC();

        if (u.getName() == "Faithfull"  && d.getName()=="Coy" ){
            d.setScore(a- b/2 - c);
            u.setScore(a- b/2 - c);
        }

        else if (u.getName()=="Faithfull" && d.getName()=="Fast"){
            u.setScore(a - b/2);
            d.setScore(a - b/2);
        }

        else if (u.getName()=="Philander" && d.getName()=="Coy"){
            u.setScore(0);
            d.setScore(0);
        }

        else if (u.getName()=="Philander" && d.getName()=="Fast"){
            u.setScore(a);
            d.setScore(a - b);
        }
    }

    /**
     * the baby method takes in man and woman input and according to their type they create children
     * @param u
     * @param d
     */
    public static void baby(Man u , Woman d){
        int r=randomic.nextInt(2);
        if (u.getName() == "Faithfull"  && d.getName()=="Coy" ){
            figlioCoy++;figlioFaith++;
        }
        else if (u.getName()=="Faithfull" && d.getName()=="Fast"){

            if (r==0){figlioFaith++;}
            else{figlioFast++;}
        }

        else if (u.getName()=="Philander" && d.getName()=="Coy"){
        }

        else if (u.getName()=="Philander" && d.getName()=="Fast"){
            figlioPhl++;
            if (r==0){figlioPhl++;}
            else{figlioFast++;}
        }
    }

    /**
     *
     * @return return number of children Philanderers in that particular generation
     */
    public static int getFiglioPhl(){
        return figlioPhl;
    }

    /**
     *
     * @return return number of children Faihfullers in that particular generation
     */
    public static int getFiglioFaith(){
        return figlioFaith;
    }

    /**
     *
     * @return return number of children Coy in that particular generation
     */
    public static int getFiglioCoy(){
        return figlioCoy;
    }

    /**
     *
     * @return return number of children Fast in that particular generation
     */
    public static int getFiglioFast(){
        return figlioFast;
    }

    /**
     *
     *serves to reset the number of children created to move to a new generation
     */
    public static void get0(){figlioPhl=0;figlioFast=0;figlioFaith=0;figlioCoy=0;}

}
