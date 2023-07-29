package simulation;

import human.*;
import match.*;
import planet_earth.*;


/**
 * in the class Simulation the simulation of the program takes place considering 5 generations
 * to analyze the trend of stability
 */
public class Simulation {
    public static void start() throws InterruptedException {
        Population population = new Population(15, 20, 3, 10, 10, 10, 10);

        int generation = 5;
        for (int i = 0; i < generation; i++) {
            while (!Population.isEmptyWomen() && !Population.isEmptyMen()) {
                String Uomo = Population.ExtractMen();String Donna = Population.ExtractWoman();
                Man myU = new Man(Uomo);Woman myD = new Woman(Donna);
                Thread.currentThread().sleep(100);
                //myU.interrupt();myD.interrupt();
                Dance.go_out(myU, myD);
            }
            System.out.println("sono uscito dal while : FINISCE LA GENERAZIONE "+ i);
            System.out.println();
            System.out.println("Nella Generazione " + i + " abbiamo:");

            Graphics.print();Population.clearQueue();Population.clearPopul();
            System.out.println("I figli nati sono :");
            System.out.println("Faith: " + Evolution.getFiglioFaith());
            System.out.println("Philander: " +  Evolution.getFiglioPhl());
            System.out.println("Coy: " + Evolution.getFiglioCoy());
            System.out.println("Fast: " +Evolution.getFiglioFast());
            System.out.println();

            Rebellion.next_generation();
            System.out.println("Scopriamo cosa accadrà nella prossima generazione");
            System.out.println();
        }
        System.out.println();
        System.out.println("FINE ESECUZIONE");
        Graphics.print();Graphics.design_percentuale();Graphics.design_population();
    }
    public static void main(String[] args) throws InterruptedException{
        Simulation.start();
    }

}
