package simulation;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import planet_earth.*;

import java.util.ArrayList;

/**
 * As a visualization aid we implemented two graphical plot charts to help with the understanding
 * of the population trends and the ratio of each individual type of the men population
 * in relation to the complete men population and each individual type of the women
 * in relation to the complete women population
 */
public class Graphics extends Population{
    //ATTIRBUTI PER I GRAFICI

    private static ArrayList<Double> generation = new ArrayList<>();
    private static int num_generation=0;

    private static ArrayList<Double> numeri_p = new ArrayList<>();
    private static ArrayList<Double> numeri_c = new ArrayList<>();
    private static ArrayList<Double> numeri_fas =new ArrayList<>();
    private static ArrayList<Double>numeri_fai = new ArrayList<>();

    private static ArrayList<Double> perc_p =new ArrayList<>();
    private static ArrayList<Double> perc_c = new ArrayList<>();
    private static ArrayList<Double> perc_fas = new ArrayList<>();
    private static ArrayList<Double> perc_fai = new ArrayList<>();

    public Graphics(int parA, int parB, int parC, int phl, int faith, int coy, int fast) {
        super(parA, parB, parC, phl, faith, coy, fast);
    }

    /* nei metodi num_men e num_women vengono:
    -creati tre variabili locali che contano i numeri di maschi e femmine (e i tipi)
    -infine vengono aggiunti in index stabilità nella lista dei num
     */

    private static void num_men(){
        int counter_m = 0; int counter_phil = 0; int counter_faith=0;
        for (int i = 0 ; i<popolazione.size(); i++){
            if (popolazione.get(i)=="Faithfull"){
                counter_m++;
                counter_faith++;
            }
            if (popolazione.get(i)=="Philander"){
                counter_m++;
                counter_phil++;
            }
        }
        lista_num_uomini.add(0,counter_m);
        lista_num_uomini.add(1, counter_phil);
        lista_num_uomini.add(2,counter_faith);
    }
    private static void num_women(){
        int counter_d = 0; int counter_coy = 0; int counter_fast=0;
        for (int i = 0 ; i<popolazione.size(); i++){
            if (popolazione.get(i)=="Fast"){
                counter_d++;counter_fast++;
            }
            if (popolazione.get(i)=="Coy"){
                counter_d++;counter_coy++;
            }
        }
        lista_num_donne.add(0,counter_d);
        lista_num_donne.add(1, counter_coy);lista_num_donne.add(2,counter_fast);
    }

    /*
    Nei get vengono returnati i numeri dei tipi prendendo il valore dell'indice della lista num
     */

    private static int getNumMen(){
        return lista_num_uomini.get(0);
    }
    private static int getNumPhil(){
        return lista_num_uomini.get(1);
    }
    private static int getNumFaith(){
        return lista_num_uomini.get(2);
    }

    private static int getNumWomen(){
        return lista_num_donne.get(0);
    }
    private static int getNumCoy(){
        return lista_num_donne.get(1);
    }
    private static int getNumFast(){
        return lista_num_donne.get(2);
    }


    //Il metodo print è per visionare quante persone ci sono in quella generazione richiamando i diversi metodi get
    public static void print() {
        num_men();
        num_women();

        System.out.println("Numero di Uomini: " + getNumMen());
        System.out.println("Numero di Faithfull: " + getNumFaith());
        System.out.println("Numero di Philander: " + getNumPhil());

        System.out.println("Numero di Donne: " + getNumWomen());
        System.out.println("Numero di Coy: " + getNumCoy());
        System.out.println("Numero di Fast: " + getNumFast());

        System.out.println();

        double PercFaith = (getNumFaith() * 100) / getNumMen();
        double PercCoy = (getNumCoy() * 100) / getNumWomen();

        double PercPhil = (getNumPhil() * 100) / getNumMen();
        double PercFast = (getNumFast() * 100) / getNumWomen();

        System.out.println("Percentuali: ");
        System.out.println("I Morigerati sono " + PercFaith + "% di uomini");
        System.out.println("Le Prudenti sono " + PercCoy + "% di donne");

        System.out.println();
        generation.add((double)num_generation);
        numeri_fai.add((double)getNumFaith());numeri_c.add((double)getNumCoy());
        numeri_p.add((double)getNumPhil());numeri_fas.add((double)getNumFast());

        perc_fai.add(PercFaith); perc_c.add(PercCoy);
        perc_p.add(PercPhil);perc_fas.add(PercFast);
        num_generation++;
    }

    public static void design_population() {
        // Create Chart
        //XYChart chart = QuickChart.getChart("The Battle of Sexes", "X", "Y","generazioni", generazioni , generazioni);
        XYChart chart = QuickChart.getChart("The Battle of Sexes population trend", "X", "Y","Coy", generation , numeri_c);
        //chart.addSeries(numeri_c);
        //chart.addSeries("Coy", numeri_c, numeri_c);
        chart.addSeries("Faithfull", generation, numeri_fai);
        chart.addSeries("Fast", generation, numeri_fas);
        chart.addSeries("Philander", generation, numeri_p);

        // Show it
        SwingWrapper grafico_popolazione = new SwingWrapper(chart);
        grafico_popolazione.displayChart();
    }

    public static void design_percentuale() {

        XYChart chartratio = QuickChart.getChart("The Battle of Sexes percentage trend", "X", "Y","Coy", generation , perc_c);
        //chart.addSeries(numeri_c);
        //chart.addSeries("Coy", numeri_c, numeri_c);
        chartratio.addSeries("Faithfull", generation, perc_fai);
        chartratio.addSeries("Fast", generation, perc_fas);
        chartratio.addSeries("Philander", generation, perc_p);

        // Show it

        SwingWrapper grafico_percentuale = new SwingWrapper(chartratio);
        grafico_percentuale.displayChart();

    }


}
