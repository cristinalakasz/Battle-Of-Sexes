package human;
import planet_earth.*;
import match.*;

/**
 * the Man class extends the Human class which in turn extends the Thread class.
 */
public class Man extends Human{

    /**
     * The constructor of Man takes in input the type of the Man
     * and sets the name in base with the type
     * @param type
     */
    public Man(String type) {
        super();
        setName(type);
        start();
    }

    /**
     *    The run method is for :
     *     -To join the list alone
     *     -Extracting women and men from meeting lists
     *     -Make the meeting happen , score and child creation in a class Evolution
     */
    public void run() {
        try {
            for (int i = 0; i < Dance.getDancing(); i++) {
                if (isInterrupted()) throw new InterruptedException();
                sleep(20);
                //System.out.println("sono entrato");
                if (!isDead()) {
                    Dance.getUomo().insert(this);
                    Woman myDonna = Dance.getDonna().extract();
                    Man myUomo = Dance.getUomo().extract();
                    myDonna.wakeup();
                    Evolution.evoRules(myUomo, myDonna);
                    myDonna.setLife(); myUomo.setLife();
                    Evolution.baby(myUomo,myDonna);
                    Dance.check_dead(myUomo, myDonna);
                }

            }
        } catch (InterruptedException e) {
            //System.out.println("è finito il Thread");
        }

    }

}
