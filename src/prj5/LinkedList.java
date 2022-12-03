// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of
// those who do.
// -- Team

package prj5;

import list.ListInterface;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Project: P5 Social Media Visualization
 * Class: LinkedList
 *
 * Linked List class to store influencers.
 *
 * @author Nana Yaw Barimah Oteng (nanyawo21)
 * @author Lukyan Sukhachevskyi (lukyan)
 * @version 2022.12.02
 */
public class LinkedList
    implements Iterable<Influencer>, ListInterface<Influencer> {
    // Fields----------------------------------------------------------------
    private Node<Influencer> head;
    private Node<Influencer> tail;
    private int size;


    /**
     * Constructor for DLinkedList.
     */
    public LinkedList() {

        init();
    }


    /**
     * Initializes the object to have the head and tail nodes
     */
    private void init() {

        head = tail = new Node<Influencer>(null);
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
     * @return true if the array is empty. Otherwise, return false.
     */
    @Override public boolean isEmpty() {

        return size == 0;
    }


    /**
     * Returns the number of elements in the list.
     *
     * @return size of list.
     */
    @Override public int getLength() {

        return size;
    }


    /**
     * Replaces the influencer, at the specified index, with the new influencer
     * parameter.
     *
     * @param influencer is an influencer
     * @param index      is the index
     * @return returns the old influencer that has been replaced.
     */
    @Override public Influencer replace(int index, Influencer influencer) {

        Node<Influencer> oldNode = this.getNodeAtIndex(index);
        Influencer oldInfluencer = oldNode.getData();
        oldNode.setData(influencer);

        return oldInfluencer;
    }


    /**
     * Returns true if the list contains the influencer.
     *
     * @param influencer is
     *                   the influencer being checked.
     * @return a boolean value as to whether there is an influencer in the list
     * with the same channel name as the influencer parameter.
     */
    @Override public boolean contains(Influencer influencer) {

        if (influencer == null) {
            return false;
        }

        if (isEmpty()) {
            return false;
        }

        for (Influencer iterInfluencer : this) {
            if (iterInfluencer.getChannelName()
                .equals(influencer.getChannelName())) {

                return true;
            }
        }
        return false;
    }


    /**
     * Gets the node at the specified index
     *
     * @param index is the index at which a node is being returned.
     * @return returns node at index.
     */
    private Node<Influencer> getNodeAtIndex(int index) {

        if (index < 0 || size <= index) {
            throw new IndexOutOfBoundsException(
                "No element exists at " + index);
        }

        Node<Influencer> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current;
    }


    /**
     * Returns the Influencer at the specified index of the list.
     *
     * @param index the index at which an influencer is being returned.
     * @return returns an influencer at a specified index.
     */
    @Override public Influencer getEntry(int index) {

        return getNodeAtIndex(index).getData();
    }


    /**
     * This adds an influencer at the end of the list.
     *
     * @param newEntry the influencer being added.
     */
    @Override public void add(Influencer newEntry) {

        Node<Influencer> newNode = new Node<Influencer>(newEntry);
        if (isEmpty()) {

            head = tail = newNode;
        }
        else {
            tail.setNext(newNode);
        }

        tail = newNode;
        size++;
    } // end add


    /**
     * Throws an IndexOutOfBoundsEception() because this method is not used in
     * our project, but it is required to implement the List Interface.
     *
     * @param index      is the index where the influencer is being added.
     * @param influencer is the influencer being added.
     */
    @Override public void add(int index, Influencer influencer) {

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

        for (Influencer iterInfluencer : this) {
            if (iterInfluencer.getChannelName()
                .equals(influencer.getChannelName())) {

                return index;

            }
            index++;
        }
        return -1;
    }


    /**
     * Removes an Influencer at a specified index.
     *
     * @param index is the index at which an influencer is being removed.
     * @return returns the removed influencer.
     */
    public Influencer remove(int index) {

        // if the index is invalid
        if (index < 0 || index > getLength()) {
            throw new IndexOutOfBoundsException(
                "Index " + index + " out of bounds");
        }

        Influencer removeNode = null;

        Node<Influencer> current = head;
        if (index == 0) {
            removeNode = head.getData();
            head = head.getNext();
            size--;
            return removeNode;
        }

        int currentIndex = 0;
        while (current != null) {

            if ((currentIndex + 1) == index) {
                removeNode = current.getNext().getData();
                Node<Influencer> newNext = current.getNext().getNext();
                current.setNext(newNext);
                size--;
            }
            currentIndex++;
            current = current.getNext();
        }
        return removeNode;
    }


    /**
     * Returns true or false as two whether two DLLists are equal.
     *
     * @param obj is the object being checked for equality.
     * @return returns a boolean value as to whether two LinkedLists have the
     * same objects.
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }

        LinkedList objList = (LinkedList)obj;
        if (objList.getLength() == getLength()) {

            Node<Influencer> currNode = head;
            Node<Influencer> otherNode = objList.head;

            while (currNode != null) {
                if (!currNode.getData().equals(otherNode.getData())) {
                    return false;
                }
                currNode = currNode.getNext();
            }

        }
        else {
            return false;
        }
        return true;
    }


    /**
     * The insertion sort method that sorts Influencers using a comparator
     * provided.
     *
     * @param c the comparator
     */
    public void sort(Comparator<Influencer> c) {
        // If zero or one item is in the chain, there is nothing to do
        if (getLength() > 1) {
            assert head != null;
            // Break chain into 2 pieces: sorted and unsorted
            Node<Influencer> unsortedPart = head.getNext();
            assert unsortedPart != null;
            head.setNext(null);
            while (unsortedPart != null) {
                Node<Influencer> nodeToInsert = unsortedPart;
                unsortedPart = unsortedPart.getNext();
                insertInOrder(c, nodeToInsert);
            } // end while
        } // end if
    } // end insertionSort


    private void insertInOrder(
        Comparator<Influencer> c, Node<Influencer> nodeToInsert) {
        Influencer inf = nodeToInsert.getData();
        Node<Influencer> currentNode = head;
        Node<Influencer> previousNode = null;
        // Locate insertion point
        while ((currentNode != null) && (c.compare(inf, currentNode.getData())
            < 0)) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        } // end while
        // Make the insertion
        if (previousNode != null) { // Insert between previousNode and
            // currentNode
            previousNode.setNext(nodeToInsert);
            nodeToInsert.setNext(currentNode);
        }
        else // Insert at beginning
        {
            nodeToInsert.setNext(head);
            head = nodeToInsert;
        } // end if
    } // end insertInOrder


    /**
     * Returns an array.
     *
     * @return returns an array of Influencers of this list.
     */
    @Override public Object[] toArray() {
        Object[] array = new Object[this.size];

        Node<Influencer> current = head;
        int count = 0;
        while (count < size) {
            array[count] = current.getData();
            current = current.getNext();
            count++;
        }

        return array;
    }


    /**
     * Returns a string representation of the list.
     *
     * @return returns the influencer list string.
     */
    @Override public String toString() {

        if (isEmpty()) {

            return "[]";
        }
        StringBuilder str = new StringBuilder("[");

        Node<Influencer> current = head;
        str.append(current.getData().toString());

        while (current.getNext() != null) {

            str.append(", ");
            str.append(current.getNext().getData().toString());
            current = current.getNext();
        }

        str.append("]");

        return str.toString();
    }


    /**
     * Iterator method creates Iterator object
     *
     * @return new Iterator object
     */
    public Iterator<Influencer> iterator() {

        return new ListIterator();
    }


    /**
     * Project: P5 Social Media Visualization
     * Class: ListIterator
     *
     * Private List Iterator to traverse the Linked list.
     * Iterator does not use a remove() method, because the DLinkedList
     * implements a remove() method.
     *
     * @author Nana Yaw Barimah Oteng(nanayawo21)
     * @version 2021.12.02
     */
    private class ListIterator implements Iterator<Influencer> {

        private Node<Influencer> next;


        /**
         * Creates a new DLListIterator
         */
        public ListIterator() {

            next = head;
        }


        /**
         * Checks if there are more elements in the list
         *
         * @return true if there are more elements in the list
         */
        @Override public boolean hasNext() {

            return (next != null);
        }


        /**
         * Gets the next value in the list
         *
         * @return the next value
         * @throws NoSuchElementException if there are no nodes left in the list
         */
        @Override public Influencer next() {

            if (next == null) {
                throw new NoSuchElementException("No nodes left in the list.");
            }

            Influencer value = next.getData();
            next = next.getNext();
            return value;
        }
    }
}
