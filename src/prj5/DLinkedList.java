// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of
// those who do.
// -- Lukyan Sukhachevskyi (lukyan)

//
package prj5;

// Import Statements
import java.util.Iterator;
import java.util.NoSuchElementException;
import list.ListInterface;

/**
 * Project: socialmediavisualization
 * Class: DLNode
 *
 * @param <Influencer>
 *            the Influencer parameter
 * @author Nana Yaw Barimah Oteng (nanyawo21)
 * @version 2022.11.14
 * @param <T>
 */
public class DLinkedList implements ListInterface<Influencer> {
    // Fields----------------------------------------------------------------
    private DLNode<Influencer> head;
    private DLNode<Influencer> tail;
    private int size;

    /**
     * Constructor for DLinkedList.
     */
    public DLinkedList() {
        init();
    }


    /**
     * Initializes the object to have the head and tail nodes
     */
    private void init() {
        head = new DLNode<Influencer>(null);
        tail = new DLNode<Influencer>(null);

        head.setNext(tail);
        tail.setPrevious(head);
        size = 0;
    }


    /**
     * Removes all of the elements from the list
     */
    public void clear() {
        init();
    }


    /**
     * Checks if the array is empty
     *
     * @return true if the array is empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Returns the number of elements in the list.
     * 
     * @return size of list.
     */
    @Override
    public int getLength() {
        return size;
    }


    /**
     * Function should not be implemented.
     * 
     * @return returns null. Function should not be implemented.
     * @param arg1 is an influencer
     * @param arg0 is the index
     */
    @Override
    public Influencer replace(int arg0, Influencer arg1) {
        return null;
    }


    /**
     * Returns true if the list contains the influencer.
     * 
     * @return a boolean value as to whether there is an influencer in the list
     *          with the same channel name as the influencer parameter.
     * @param is the influencer being checked.  
     */
    @Override
    public boolean contains(Influencer influencer) {
        if (influencer == null ) {
            return false;
        }
        
        if (isEmpty()) {
            return false;
        }
        
        DLNode<Influencer> curr = head;
        while (curr != null) {
            if (curr.getData().equals(influencer)) {
                return true;
            }
            curr = curr.getNext();
        }
        return false;
        
    }


    /**
     * gets the node at that index
     * 
     * @param index
     * @return node at index
     */
    private DLNode<Influencer> getNodeAtIndex(int index) {
        if (index < 0 || size <= index) {
            throw new IndexOutOfBoundsException("No element exists at "
                + index);
        }
        DLNode<Influencer> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }


    /**
     * Returns the Influencer at the specified index of the list.
     * @return returns an influencer at a specified index.
     * @param is the index at which an influencer is being returned.
     */
    @Override
    public Influencer getEntry(int index) {
        return getNodeAtIndex(index).getData();
    }


    /**
     * This adds an influencer at the end of the list.
     * @param is the influencer being added.
     */
    @Override
    public void add(Influencer influencer) {
        DLNode<Influencer> newNode = new DLNode<Influencer>(tail,influencer, null);
        newNode.setData(influencer);
        newNode.setPrevious(tail);
        newNode.setNext(null);

        if (isEmpty()) {
            head = newNode;
        }
        else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
        }
        tail = newNode;
        size++;
    }

    

    /**
     * Adds an Influencer at specified index
     * @param index is the index where the influencer is being added.
     * @param influencer is the influencer being added.
     */
    @Override
    public void add(int index, Influencer influencer) {
        throw new IndexOutOfBoundsException();

    }


    /**
     * Finds the index of an influencer.
     * 
     * @param influencer is the influencer whose index is being searched.
     * @return the index at which the specified influencer is stored.
     */
    public int getIndex(Influencer influencer) {
        int index = 0;
        DLNode<Influencer> currNode = head;
        while (currNode != null) {
            if (influencer.equals(currNode.getData())) {
                return index;
            }
            index++;
            currNode = currNode.getNext();
        }
        return -1;

    }


    /**
     * removes an Influencer at a specified index.
     * @param index is the index at which an influencer is being removed.
     * @return returns the removed influencer.
     */
    public Influencer remove(int index) {
        if (head == null || index <= 0) {
            return null;
        }
        if (index >= size) {
            return null;
        }
        
        DLNode<Influencer> curr = head;
        
        for (int i=1; i < index; i++) {
            curr = curr.getNext();
        }
        return curr.getData();
        
        

    }


    /**
     * Returns true or false as two whether two DLLists are equal.
     * 
     * @param obj is the object being checked for equality.
     * @return returns a boolean value as to whether two LinkedLists have the same objects.
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }

        DLinkedList objList = (DLinkedList)obj;
        if (objList.getLength() == getLength()) {

            DLNode<Influencer> currNode = head;
            DLNode<Influencer> otherNode = objList.head;

            while (currNode != null) {
                if (!currNode.getData().equals(otherNode.getData())) {
                    return false;
                }
            }

        }
        return true;
    }


    public void sortByEngagement() {

    }


    public void sortByName() {

    }


    /**
     * Iterator method creates Iterator object
     *
     * @return new Iterator object
     */
    public Iterator<Influencer> iterator() {
        return new LListIterator();
    }


    @Override
    public Object[] toArray() {
        Object[] array = new Object[this.size];

        DLNode<Influencer> current = head;
        int count = 0;
        while (count < size) {
            array[count] = current.getData();
            current = current.getNext();
            count++;
        }

        return array;
    }

    private class LListIterator implements Iterator<Influencer> {
        private DLNode<Influencer> prev;
        private DLNode<Influencer> curr;
        private DLNode<Influencer> next;
        private boolean newCurr;

        /**
         * Creates a new DLListIterator
         */
        public LListIterator() {
            prev = null;
            curr = null;
            next = head;
            newCurr = false;
        }


        /**
         * Checks if there are more elements in the list
         *
         * @return true if there are more elements in the list
         */
        @Override
        public boolean hasNext() {
            return (next != null);
        }


        /**
         * Gets the next value in the list
         *
         * @return the next value
         * @throws NoSuchElementException
         *             if there are no nodes left in the list
         */
        @Override
        public Influencer next() {
            prev = curr;
            curr = next;
            next = next.getNext();
            if (curr == null) {
                throw new NoSuchElementException("No nodes left in the list.");
            }
            newCurr = true;
            return curr.getData();
        }


        /**
         * Removes the last object returned with next() from the list
         *
         * @throws IllegalStateException
         *             if next has not been called yet
         *             and if the element has already been removed
         */
        @Override
        public void remove() {
            if (next == head) {
                throw new IllegalStateException(
                    "Next has not been called yet.");
            }
            else if (!newCurr) {
                throw new IllegalStateException(
                    "The Element has already been removed.");
            }
            else if (curr == head) {
                head = next;
                curr = null;
            }
            else {
                prev.setNext(curr.getNext());
                curr = prev;
            }
            size--;
            newCurr = false;
        }
    }

}
