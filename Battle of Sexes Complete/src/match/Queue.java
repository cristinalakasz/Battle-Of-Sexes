package match;

/**
 * The Queue class provides a simple implementation of the queue data structure,
 * through liked lists, which will be broadly used throughout the project.
 * @param <E>
 */
public class Queue <E>{
    public E value;
    public Queue<E> next=null;

    Queue(E value){
        this.value=value;
    }
}
