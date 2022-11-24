// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of
// those who do.
// -- Team

package prj5;

// Import Statements

import list.ListInterface;

/**
 * Project: socialmediavisualization
 * Class: DLNode
 *
 * @author Nana Yaw Barimah Oteng (nanyawo21)
 * @author Lukyan Sukhachevskyi (lukyan)
 * @version 2022.11.14
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
     * Replaces the influencer, at the specified index, with the new influencer
     * parameter.
     *
     * @param influencer
     *            is an influencer
     * @param index
     *            is the index
     * @return returns the old influencer that has been replaced.
     */
    @Override
    public Influencer replace(int index, Influencer influencer) {

        DLNode<Influencer> oldNode = this.getNodeAtIndex(index);
        Influencer oldInfluencer = oldNode.getData();
        oldNode.setData(influencer);
        return oldInfluencer;
    }


    /**
     * Returns true if the list contains the influencer.
     *
     * @param influencer
     *            is
     *            the influencer being checked.
     * @return a boolean value as to whether there is an influencer in the list
     *         with the same channel name as the influencer parameter.
     */
    @Override
    public boolean contains(Influencer influencer) {
        if (influencer == null) {
            return false;
        }

        if (isEmpty()) {
            return false;
        }

        DLNode<Influencer> curr = head;
        while (curr != null) {
            if (curr.getData().getChannelName().equals(influencer
                .getChannelName())) {
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
     *
     * @param index
     *            is
     *            the index at which an influencer is being returned.
     * @return returns an influencer at a specified index.
     */
    @Override
    public Influencer getEntry(int index) {
        return getNodeAtIndex(index).getData();
    }


    /**
     * This adds an influencer at the end of the list.
     *
     * @param influencer
     *            is
     *            the influencer being added.
     */
    @Override
    public void add(Influencer influencer) {
        DLNode<Influencer> newNode = new DLNode<Influencer>(tail, influencer,
            null);
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
     *
     * @param index
     *            is the index where the influencer is being added.
     * @param influencer
     *            is the influencer being added.
     */
    @Override
    public void add(int index, Influencer influencer) {
        throw new IndexOutOfBoundsException();

    }


    /**
     * Finds the index of an influencer.
     *
     * @param influencer
     *            is the influencer whose index is being searched.
     * @return the index at which the specified influencer is stored.
     */
    public int getIndex(Influencer influencer) {
        int index = 0;
        DLNode<Influencer> currNode = head;
        while (currNode != null) {
            if (influencer.getChannelName().equals(currNode.getData()
                .getChannelName())) {
                return index;
            }
            index++;
            currNode = currNode.getNext();
        }
        return -1;

    }


    /**
     * removes an Influencer at a specified index.
     *
     * @param index
     *            is the index at which an influencer is being removed.
     * @return returns the removed influencer.
     */
    public Influencer remove(int index) {
        tail.getPrevious();
        return null;

    }


    /**
     * Returns true or false as two whether two DLLists are equal.
     *
     * @param obj
     *            is the object being checked for equality.
     * @return returns a boolean value as to whether two LinkedLists have the
     *         same objects.
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
                currNode = currNode.getNext();
            }

        }
        else {
            return false;
        }
        return true;
    }


    /**
     * Sorts by engagement.
     */
    public void sortByEngagement() {
        if (getLength() > 1) {
            DLNode<Influencer> unsortedPart = head.getNext();
            DLNode<Influencer> sortedPart = head;
            sortedPart.setNext(null);

            while (unsortedPart != null) {
                DLNode<Influencer> nodeToInsert = unsortedPart;
                unsortedPart = unsortedPart.getNext();
                engInsertIntoSorted(nodeToInsert);
            }
        }

    }


    /**
     * Sorts by name.
     */
    public void sortByName() {
        if (getLength() > 1) {
            DLNode<Influencer> unsortedPart = head.getNext();
            DLNode<Influencer> sortedPart = head;
            sortedPart.setNext(null);

            while (unsortedPart != null) {
                DLNode<Influencer> nodeToInsert = unsortedPart;
                unsortedPart = unsortedPart.getNext();
                nameInsertIntoSorted(nodeToInsert);
            }
        }

    }


    /**
     * Helper method to help sort by engagement.
     *
     * @param nodeToInsert
     *            is the insertion node.
     */
    private void engInsertIntoSorted(DLNode<Influencer> nodeToInsert) {
        Influencer influencer = nodeToInsert.getData();
        DLNode<Influencer> currNode = head;
        DLNode<Influencer> previousNode = null;

        while ((currNode != null) && (influencer.compareTo(currNode
            .getData()) < 0)) {
            previousNode = currNode;
            currNode = currNode.getNext();
        }

        if (previousNode != null) {
            previousNode.setNext(nodeToInsert);
            nodeToInsert.setNext(currNode);
        }
        else {
            nodeToInsert.setNext(head);
            head = nodeToInsert;
        }
    }


    /**
     * Helper method to insert a node into its proper location in a sorted
     * linked chain.
     *
     * @param nodeToInsert
     *            :
     *            node to add to sorted section of list
     */
    private void nameInsertIntoSorted(DLNode<Influencer> nodeToInsert) {
        Influencer influencer = nodeToInsert.getData();
        DLNode<Influencer> currNode = head;
        DLNode<Influencer> previousNode = null;

        while ((currNode != null) && (influencer.getChannelName()
            .compareToIgnoreCase(currNode.getData().getChannelName()) > 0)) {
            previousNode = currNode;
            currNode = currNode.getNext();
        }

        if (previousNode != null) {
            previousNode.setNext(nodeToInsert);
            nodeToInsert.setNext(currNode);
        }
        else {
            nodeToInsert.setNext(head);
            head = nodeToInsert;
        }
    }


    /**
     * Returns an array.
     *
     * @return returns an array of Influencers of this list.
     */
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


    /**
     * Returns a string representation of the list.
     *
     * @return returns the influencer list string.
     */
    @Override
    public String toString() {

        if (isEmpty()) {

            return "[]";
        }
        StringBuilder str = new StringBuilder("[");

        DLNode<Influencer> current = head;
        str.append(current.getData().toString());

        while (current.getNext() != null) {

            str.append(", ");
            str.append(current.getNext().getData().toString());
            current = current.getNext();
        }

        str.append("]");

        return str.toString();
    }
}
