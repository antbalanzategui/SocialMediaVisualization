// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of
// those who do.
// -- Lukyan Sukhachevskyi (lukyan)

package prj5;

import list.ListInterface;

/**
 * Project: socialmediavisualization
 * Class: DLNode
 *
 * @param <Influencer> the Influencer parameter
 * @author Nana Yaw Barimah Oteng (nanyawo21)
 * @version 2022.11.14
 */
public class DLinkedList<Influencer> implements ListInterface<Influencer> {

    private DLNode<Influencer> head;
    private DLNode<Influencer> tail;
    private int size;


    public DLinkedList(){

        head = null;
        tail = null;
        size = 0;
    }

    //find the index of an influencer
    public int getIndex(Influencer influencer){

        return -1;
    }

    @Override
    public void add(Influencer influencer) {

        DLNode<Influencer> newNode = new DLNode<Influencer>(influencer);

        if(head == null){

            head = tail = newNode;
            size++;
        }else{

            newNode.setPrevious(tail);
            tail.setNext(newNode);
            tail = tail.getNext();
            size++;
        }
    }

    @Override
    public void add(int index, Influencer influencer) {
        
    }

    @Override
    public void clear() {

    }

    //RETURN TRUE IF USERNAME MATCHES (not .equals) - Lukyan
    @Override
    public boolean contains(Influencer arg0) {
        return false;
    }

    @Override
    public Influencer getEntry(int arg0) {
        return null;
    }

    @Override
    public int getLength() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Influencer remove(int arg0) {
        return null;
    }

    @Override
    public Influencer replace(int arg0, Influencer arg1) {
        return null;
    }

    @Override
    public Object[] toArray() {
        return null;
    }

}
