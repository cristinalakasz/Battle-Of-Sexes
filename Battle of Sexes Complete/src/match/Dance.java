package match;
import human.*;

/**
 * The Dance class is a place where Man and Woman are placed (in a Queue) and then extracted so that they may meet
 */
public class Dance {


    private static final int DANCING=1000;

    private static Synchro<Woman> donna  =new Synchro<>();
    private static Synchro<Man> uomo = new Synchro<>();

    /**
     *
     * @return return time of dancing
     */
    public static int getDancing(){return DANCING;}

    /**
     *
     * @return return the SynchroQueue women
     */
    public static Synchro<Woman> getDonna(){return donna;}

    /**
     *
     * @return return the SynchroQueue women
     */
    public static Synchro<Man> getUomo(){return uomo;}

    /**
     * The method , takes as input Man and Woman, permits to re-insert in SynchroQueue or Man or Woman
     * if the human is not dead.
     * @param u
     * @param d
     */
    public static void check_dead(Man u , Woman d){
        if (!u.isDead()){
            uomo.insert(u);
        }
        if (!d.isDead()){
            donna.insert(d);
        }
    }

    /**
     * the method , takes as input Man and Woman , permits to get man and women out of
     * the dance room with method interrupt()
     * @param u
     * @param d
     */
    public static void go_out(Man u , Woman d){
        u.interrupt();
        d.interrupt();
    }
}
