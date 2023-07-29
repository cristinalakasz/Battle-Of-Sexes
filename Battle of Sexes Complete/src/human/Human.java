package human;

import planet_earth.*;

/**
 * the Human abstact class is a class that extends Thread
 * and contains all the attributes and methods of a human being
 */

public abstract class Human extends Thread{

    private int score;
    private int life = 15;


    /**
     * the method, takes as input an integer, serves to assign the human score
     * @param s
     */
    public void setScore(int s){score=s;}

    /**
     *
     * @return the method return True if the Human is empty, otherwise False
     */
    public boolean isDead(){return life<=0;}


    /**
     * the method is used to decrease the life according to the payoff
     */
    public void setLife(){
        if (score == Population.getMin())
            life-= 13;  //13
        else if (score == Population.getMax())
            life-= 1; //1
        else if (score > Population.getMin() && score <= 0)
            life-= 5; //5
        else
            life-= 3; //3
    }
}
