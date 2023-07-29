package match;

/**
 * The synchro class takes usage of the queue structure implemented in the queue class
 * in order to collect man and women separately and in a synchronized way.
 * @param <E>
 */
public class Synchro<E> {
    protected Queue<E> first=null;
    protected Queue<E> last=null;

    /**
     *
     * @return True if the Synchro is Empty, otherwise False
     */
    public synchronized boolean isEmpty () {
        return (first == null);
    }

    /**
     * The method permits to put the element that takes as input
     * @param elem
     */
    public synchronized void insert (E elem) {
        if (isEmpty()) {
            first = last = new Queue<E>(elem);
            notifyAll();
        }
        else {
            last.next = new Queue<E>(elem);
            last = last.next;
        }
    }


    /**
     *
     * @return The method permits to extract and to return the first element in Queue
     * if the Queue is empty invoke the method wait() for waiting the extraction from Man or Woman
     * @throws InterruptedException
     */
    public synchronized E extract () throws InterruptedException {
        while (isEmpty())
            wait();
        E result = first.value;
        first = first.next;
        if (first == null) last = null;
        return result;
    }
}
