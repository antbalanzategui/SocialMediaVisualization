// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of
// those who do.
// -- Team

package prj5;

/**
 * Project: socialmediavisualization
 * Class: Node
 *
 * @param <T> the type parameter
 * @author Lukyan Sukhachevskyi (lukyan)
 * @version 2022.11.14
 */
public class Node<T> {

    private T data;
    private Node<T> next;


    /**
     * Instantiates a new default Doubly Linked Node.
     *
     * @param data the data
     */
    public Node(T data) {

        this(data, null);
    }


    /**
     * Instantiates a new Doubly Linked Node.
     *
     * @param data     the data
     * @param next     the next node
     */
    public Node(T data, Node<T> next) {

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
    public Node<T> getNext() {

        return next;
    }


    /**
     * Set next doubly linked node.
     *
     * @param next the next node
     */
    public void setNext(Node<T> next) {

        this.next = next;
    }
}
