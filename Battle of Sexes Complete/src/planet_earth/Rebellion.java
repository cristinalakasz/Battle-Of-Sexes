package planet_earth;
import java.util.ArrayList;

/**
 * The Rebellion method serves, as the name says, to make faithfull rebel in philander and Coy in Fast.
 * this rebellion occurs when the percentage of Faithfull exceeds by that much 63% of  Men
 * or when the percentage of Coy far exceeds 83% of Women.
 *
 */

public class Rebellion extends Evolution {

    /**
     * next_generation method is used at the end of the generation to produce , with the number of children born ,
     * the new procreation and manage eventual stages of rebellion
     */
    public static void next_generation(){
        ArrayList<Integer> numPhlFaith = rebellion_men(getFiglioFaith(), getFiglioPhl());
        int numFaith2= numPhlFaith.get(0); int numPhl2= numPhlFaith.get(1);
        ArrayList<Integer> numFastCoy = rebellion_women(getFiglioCoy(), getFiglioFast());
        int numCoy2= numFastCoy.get(0);  int numFast2= numFastCoy.get(1);
        print_rebels(getFiglioFaith() , numFaith2 ,  getFiglioCoy() , numCoy2 , getFiglioPhl(),  numPhl2 ,  getFiglioFast() ,  numFast2);

        Population.creation(numPhl2 , numFaith2 , numCoy2 , numFast2);
        get0();
    }

    /**
     * Making appropriate calculations we observe that 63% of Faithfull corresponds to having the following expressions:
     * NumFaithfull = 1.7 * NumPhilander
     *
     *
     * @param tipo
     * @param anti_tipo
     * @return In the method, taken as input the number of Faith and Philander ,
     * so that the number of Faith does not turn
     * around 63% we place the condition of rebellion equal to 4 * Philander:
     * return True if number Philander is bigger to condition , False otherwise
     */
    private static boolean check_rebel_men(int tipo , int anti_tipo){ //PER UOMO
        int condizione = 4 * anti_tipo; // o 3 o 4
        if (tipo>condizione){return true;}
        else{return false;}
    }

    /**
     * Making appropriate calculations we observe that 63% of Faithfull corresponds to having the following expressions:
     *  NumCoy = 5 * NumFast
     * @param tipo
     * @param anti_tipo
     * @return In the method, taken as input the number of Coy and Fast ,
     * so that the number of Faith does not turn
     * around 83% we place the condition of rebellion equal to 8 * Fast:
     *return True if number Coy is bigger to condition , False otherwise
     */

    private static boolean check_rebel_women(int tipo , int anti_tipo){ //PER DONNA
        int condizione = 8 * anti_tipo;
        if (tipo>condizione){return true;}
        else{return false;}
    }


    /**
     *
     * @param tipo
     * @param tipo_rib
     * @return If the rebellious phase occurs that occurred in the Check method
     *       this method takes into input the number of Faithfull and the number of Philander
     *       makes rebel a quarter of the number of Faithfull
     */

    private static ArrayList<Integer> rebels_men( int tipo , int tipo_rib){
        ArrayList<Integer> da_sostituire= new ArrayList<>();
        int perloop = tipo/4;
        for (int i=0 ; i<perloop; i++){
            tipo--;tipo_rib++;
        }
        da_sostituire.add(0 , tipo);
        da_sostituire.add(1 , tipo_rib);
        return da_sostituire;
    }


    /**
     *
     * @param tipo
     * @param tipo_rib
     * @return   If the rebellious phase occurs that occurred in the Check method
     *      this method takes into input the number of Coy and the number of Fast
     *      makes rebel a quarter of the number of Coy
     */
    private static ArrayList<Integer> rebels_women( int tipo , int tipo_rib){
        ArrayList<Integer> da_sostituire= new ArrayList<>();
        int perloop =tipo/12;
        for (int i=0 ; i<perloop; i++){
            tipo--;tipo_rib++;
        }
        da_sostituire.add(0 , tipo);
        da_sostituire.add(1 , tipo_rib);
        return da_sostituire;
    }

    private static ArrayList<Integer> rebellion_men(int type , int type_rib){
        ArrayList<Integer> orig = new ArrayList<>();
        orig.add(0,type); orig.add(1,type_rib);
        if (check_rebel_men(type,type_rib)){
            ArrayList<Integer> subst = rebels_men(type , type_rib);
            orig.clear();
            orig.add(0,subst.get(0));orig.add(1,subst.get(1));
        }
        return orig;
    }

    private static ArrayList<Integer> rebellion_women(int type , int type_rib){
        ArrayList<Integer> orig = new ArrayList<>();
        orig.add(0,type); orig.add(1,type_rib);
        if (check_rebel_women(type,type_rib)){
            ArrayList<Integer> subst = rebels_women(type , type_rib);
            orig.clear();
            orig.add(0,subst.get(0));orig.add(1,subst.get(1));
        }
        return orig;
    }

    /**
     * the method prints the people who rebelled
     * @param numFaith
     * @param numFaith2
     * @param numCoy
     * @param numCoy2
     * @param numPhl
     * @param numPhl2
     * @param numFast
     * @param numFast2
     *
     */
    private static void print_rebels(int numFaith , int numFaith2 , int numCoy , int numCoy2 , int numPhl, int numPhl2 , int numFast , int numFast2){
        System.out.println("Si sono ribellati?");
        if (numFaith!=numFaith2){
            System.out.println("SI, alcuni Faith si sono ribellati");
            System.out.println("In " + numFaith + " Faith si sono ribllati in " + (numFaith-numFaith2) );
            System.out.println("Da "+ numPhl + " Philander ora sono " + numPhl2);
            System.out.println();
        }
        else if (numCoy!=numCoy2){
            System.out.println("SI, alcune Coy si sono ribellate");
            System.out.println("In " + numCoy + " Faith si sono ribllati in " + (numCoy-numCoy2) );
            System.out.println("Da "+ numFast + " Philander ora sono " + numFast2);
            System.out.println();
        }
        else{
            System.out.println("Non si è ribellato nessuno");
        }
    }

}
