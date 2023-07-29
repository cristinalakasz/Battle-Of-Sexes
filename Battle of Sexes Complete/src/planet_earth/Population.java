
package planet_earth;
import java.util.*;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;


/**
 * The Population class is fundamental to analyze the data to be collected for each generation
 * by establishing whether there is stability or not. Save through static attributes:
 *  - the parameters a , b , c
 *  - the number of four types per generation
 *
 *
 */

public class Population {


    // PARAMETRO A : Premio per il successo della generazione di figli (default 15)
    private  static int a;
    //PARAMETRO B :  Costo per crescere i figli (default 20)
    private static int b;
    //PARAMETRO C : Costo del corteggiamento (default 3)
    private static int c;

    private static Random randomico = new Random();

    //elenchiamo quanti sono inizialmente i 4 tipi:
    //Uomini
    private final  int numPhl;
    private final int numFaith;
    //Donne
    private final int numCoy;
    private final int numFast;

    //Code della popolazione
    protected static LinkedList<String> popolazione = new LinkedList<>();
    //Code dei morti
    private static Queue<String> morti = new ConcurrentLinkedQueue<>();

    private static ConcurrentLinkedQueue<String> Coda_Phl = new ConcurrentLinkedQueue<>();
    private static ConcurrentLinkedQueue<String> Coda_Faith= new ConcurrentLinkedQueue<>();
    private static ConcurrentLinkedQueue<String> Coda_Coy = new ConcurrentLinkedQueue<>();
    private static ConcurrentLinkedQueue<String> Coda_Fast = new ConcurrentLinkedQueue<>();


    //liste di numeri
    protected static LinkedList<Integer> lista_num_uomini = new LinkedList<>();
    protected static LinkedList<Integer> lista_num_donne = new LinkedList<>();


    /**
     *     The constructor is given the parameters and how many types there are initially
     *     Then the creation method is invoked so that they are put in the queues and in the population
     *     the input data types
     *
     * @param parA
     * @param parB
     * @param parC
     * @param phl
     * @param faith
     * @param coy
     * @param fast
     */
    public Population(int parA , int parB , int parC, int phl , int faith , int coy , int fast)  {
        a= parA;
        b= parB;
        c = parC;

        numPhl=phl;
        numFaith=faith;
        numCoy=coy;
        numFast=fast;

        creation(numPhl, numFaith , numCoy , numFast);

    }

    /**
     *
     * @return return static attribute a = the evolutionary benefit for having a baby
     * useful for the calculation of payoff for method evoRules in class Evolution
     */
    public static  int getA(){
        return a;
    }

    /**
     *
     * @return return static attribute b =  the cost of parenting a baby
     * useful for the calculation of payoff for method evoRules in class Evolution
     */
    public static int getB(){
        return b;
    }
    /**
     *
     * @return return static attribute c = the cost of courtship
     * useful for the calculation of payoff for method evoRules in class Evolution
     */
    public static  int getC(){
        return c;
    }


    /**
     *
     * @return returns the lowest payoff based on variables a , b , c
     * this method will serve us for the setLife method of Human class
     */
    public static int getMin(){
        int s1 = a - b/2 -c;
        int s2 = a - b/2 ;
        int s3 = 0;
        int s4 = a - b;
        int s5 = a;
        return Collections.min(Arrays.asList(s1,s2 ,s3 ,s4 ,s5));
    }

    /**
     *
     * @return returns the maximum payoff based on variables a , b , c
     * this method will serve us for the setLife method of Human
     */
    public static int getMax(){
        int s1 = a - b/2 -c;
        int s2 = a - b/2 ;
        int s3 = 0;
        int s4 = a - b;
        int s5 = a;
        return Collections.max(Arrays.asList(s1,s2 ,s3 ,s4 ,s5));
    }

    /**
     * the creation of the population takes place , adding in the queues the quantity
     * of data types in input and inserting in the population list all the types
     */
    protected static void creation(int numPhl, int numFaith , int numCoy, int numFast){
        for (int i=0 ; i<numPhl; i++){
            Coda_Phl.add("Philander");
            popolazione.add("Philander");
        }
        for (int i=0 ; i<numFaith; i++){
            Coda_Faith.add("Faithfull");
            popolazione.add("Faithfull");
        }
        for (int i=0 ; i<numCoy; i++){
            Coda_Coy.add("Coy");
            popolazione.add("Coy");
        }
        for (int i=0 ; i<numFast; i++){
            Coda_Fast.add("Fast");
            popolazione.add("Fast");
        }
    }


    /**
     *
     * @return the woman is extracted from one of the two tails
     */
    public static String ExtractWoman(){
        if (Coda_Coy.isEmpty())
            return Coda_Fast.poll();

        if (Coda_Fast.isEmpty())
            return Coda_Coy.poll();

        int r = randomico.nextInt(Coda_Coy.size()+ Coda_Fast.size());
        if(r < Coda_Coy.size())
            return Coda_Coy.poll();
        else
            return Coda_Fast.poll();
    }
    /**
     *
     * @return the men is extracted from one of the two tails
     */
    public static String ExtractMen(){
        if (Coda_Phl.isEmpty())
            return Coda_Faith.poll();

        if (Coda_Faith.isEmpty())
            return Coda_Phl.poll();


        int r = randomico.nextInt(Coda_Phl.size()+ Coda_Faith.size());
        if(r < Coda_Phl.size())
            return Coda_Phl.poll();
        else
            return Coda_Faith.poll();
    }

    /**
     *
     * @return  True if the women’s Queues is empty , otherwise False
     */

    //Vengono usati per checkare se sono vuote o no
    public static boolean isEmptyWomen(){
        return Coda_Fast.isEmpty() && Coda_Coy.isEmpty();
    }

    /**
     *
     * @return  True if the men’s Queues is empty , otherwise False
     */
    public static boolean isEmptyMen(){return Coda_Phl.isEmpty() && Coda_Faith.isEmpty();}


    /**
     *  serves to empty the queues of the four types at the end of the generation so that you analyze the next
     */
    public static void clearQueue(){Coda_Phl.clear();Coda_Coy.clear();Coda_Fast.clear();Coda_Faith.clear();}

    /**
     * serves to empty the queues of the four types at the end of the generation so that you analyze the next
     */
    public static void clearPopul(){
        popolazione.clear();
    }

}
