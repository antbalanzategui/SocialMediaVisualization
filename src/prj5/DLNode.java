// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of 
// those who do.
// -- Lukyan Sukhachevskyi (lukyan)

package prj5;

/**
 * Project: socialmediavisualization
 * Class: DLNode
 *
 * @param <T> the type parameter
 * @author Lukyan Sukhachevskyi (lukyan)
 * @version 2022.11.14
 */
public class DLNode<T> {

    private T data;
    private DLNode<T> next;
    private DLNode<T> previous;


    /**
     * Instantiates a new default Doubly Linked Node.
     *
     * @param data the data
     */
    public DLNode(T data) {

        this(null, data, null);
    }


    /**
     * Instantiates a new Doubly Linked Node.
     *
     * @param previous the previous node
     * @param data     the data
     * @param next     the next node
     */
    public DLNode(DLNode<T> previous, T data, DLNode<T> next) {

        this.previous = previous;
        this.data = data;
        this.next = next;
    }


    /**
     * Get data.
     *
     * @return the data
     */
    public T getData() {

        return this.data;
    }


    /**
     * Set data.
     *
     * @param data the data
     */
    public void setData(T data) {

        this.data = data;
    }


    /**
     * Get next doubly linked node.
     *
     * @return the doubly linked node
     */
    public DLNode<T> getNext() {

        return next;
    }


    /**
     * Set next doubly linked node.
     *
     * @param next the next node
     */
    public void setNext(DLNode<T> next) {

        this.next = next;
    }


    /**
     * Get previous doubly linked node.
     *
     * @return the previous doubly linked node
     */
    public DLNode<T> getPrevious() {

        return previous;
    }


    /**
     * Set previous doubly linked node.
     *
     * @param previous the previous node
     */
    public void setPrevious(DLNode<T> previous) {

        this.previous = previous;
    }
}
