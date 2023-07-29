package human;
import planet_earth.*;
import match.*;

/**
 * the Woman class extends the Human class which in turn extends the Thread class.
 */
public class Woman extends Human {

    /**
     * The constructor of Man takes in input the type of the Man
     *  and sets the name in base with the type
     * @param type
     */
    public Woman(String type) {
        super();
        setName(type);
        start();
    }

    /**
     * the method is used to wake up the woman who is called by the man
     */
    public synchronized void wakeup() {
        notify();
    }

    /**
     *The run method is for :
     *     -Join the meeting list alone
     *     -make the woman wait, by the wait() method, until the man not the alarm
     */
    public synchronized void run() {
        try {
            for (int i = 0; i < Dance.getDancing(); i++) {
                if (isInterrupted()) throw new InterruptedException();
                if (!isDead()){
                    Dance.getDonna().insert(this);
                    sleep(20);
                    wait();}
            }
        } catch (InterruptedException e) { }
    }

}

