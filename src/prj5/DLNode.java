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
 * @author Lukyan Sukhachevskyi (lukyan)
 * @version 2022.11.14
 */
public class DLNode <T>{

    private T data;
    private DLNode<T> next;
    private DLNode<T> previous;

    public DLNode(T data){

        this(null, data, null);
    }

    public DLNode(DLNode<T> previous, T data, DLNode<T> next){

        this.previous = previous;
        this.data = data;
        this.next = next;
    }
}
