// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of
// those who do.
// -- Team

package prj5;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import student.TestCase;

/**
 * Test Class for Doubly Linked List.
 *
 * @author Nana Yaw Barimah Oteng (nanayawo21)
 * @version 2022.11.18
 */
public class LinkedListTest extends TestCase {
    // Fields------------------------------------
    private LinkedList list;
    private Influencer inf;
    private Influencer inf1;
    private Influencer inf2;
    private Influencer inf3;

    /**
     * Sets up test method.
     */
    public void setUp() {
        list = new LinkedList();
        inf = new Influencer("Test", "Channel", "Brazil", "Topic");
        inf1 = new Influencer("Test1", "Channel1", "Ghana", "Topic1");
        inf2 = new Influencer("Test2", "Channel2", "America", "Topic2");
        inf3 = new Influencer("Test3", "Channel3", "America3", "Topic3");

        Engagement eng1 = new Engagement(MonthEnum.JANUARY, 5, 6, 4, 3, 5);
        Engagement eng2 = new Engagement(MonthEnum.FEBRUARY, 5, 8, 4, 3, 6);
        Engagement eng3 = new Engagement(MonthEnum.MARCH, 6, 6, 4, 1, 5);
        Engagement[] eng = new Engagement[3];
        eng[0] = eng1;
        eng[1] = eng2;
        eng[2] = eng3;
        inf.setEngagements(eng);
        inf1.setEngagements(eng);
        inf2.setEngagements(eng);
        inf3.setEngagements(eng);

    }


    /**
     * Tests that add() method adds an Influencer to the list.
     */
    public void testAdd() {
        assertEquals(0, list.getLength());

        list.add(inf);
        assertEquals(1, list.getLength());

        list.add(inf2);
        assertEquals(2, list.getLength());

        list.add(inf1);
        assertEquals(3, list.getLength());

        IndexOutOfBoundsException exception = null;
        try {
            list.add(0, inf);
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertNotNull(exception);

    }


    /**
     * Tests that clear resets the entire list.
     */
    public void testClear() {
        assertEquals(0, list.getLength());

        list.add(inf);
        assertEquals(1, list.getLength());

        list.add(inf2);
        assertEquals(2, list.getLength());

        list.add(inf1);
        assertEquals(3, list.getLength());

        list.clear();
        assertEquals(0, list.getLength());
    }


    /**
     * Tests isEmpty() returns true when there's nothing in the list. Otherwise,
     * it returns false.
     */
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add(inf);
        assertFalse(list.isEmpty());
    }


    /**
     * Tests replace() replaces an influencer in the list.
     */
    public void testReplace() {
        list.add(inf);
        list.add(inf1);
        list.add(inf2);
        assertEquals(inf1, list.getEntry(1));

        list.replace(1, inf3);
        assertEquals(inf3, list.getEntry(1));
    }


    /**
     * Tests contains() checks if an influencer is contained in the list.
     */
    public void testContains() {
        assertFalse(list.contains(inf));
        list.add(inf);
        assertTrue(list.contains(inf));

        assertFalse(list.contains(inf1));
        assertFalse(list.contains(inf2));
        assertFalse(list.contains(null));

        list.add(inf1);
        list.add(inf2);
        assertTrue(list.contains(inf1));
        assertTrue(list.contains(inf2));

    }


    /**
     * Tests getEntry() returns an influencer at a specified index.
     */
    public void testGetEntry() {
        list.add(inf);
        list.add(inf1);
        list.add(inf2);

        assertEquals(inf, list.getEntry(0));
        assertEquals(inf1, list.getEntry(1));
        assertEquals(inf2, list.getEntry(2));

        IndexOutOfBoundsException exception = null;
        IndexOutOfBoundsException exception1 = null;
        try {
            list.getEntry(1000);
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }

        try {
            list.getEntry(-1000);
        }
        catch (IndexOutOfBoundsException e) {
            exception1 = e;
        }
        assertNotNull(exception);
        assertNotNull(exception1);

    }


    /**
     * Tests getIndex() returns an influencer at a specified index.
     */
    public void testGetIndex() {
        list.add(inf);
        list.add(inf1);
        list.add(inf2);

        assertEquals(0, list.getIndex(inf));
        assertEquals(1, list.getIndex(inf1));
        assertEquals(2, list.getIndex(inf2));

        assertEquals(-1, list.getIndex(inf3));

    }


    /**
     * Tests remove() removes an influencer at a specified index.
     */
    public void testRemove() {
        list.add(inf);
        list.add(inf1);
        list.add(inf2);

        assertEquals(inf1, list.remove(1));
        assertEquals("[" + inf.toString() + ", " + inf2.toString() + "]", list
            .toString());
        assertEquals(2, list.getLength());

    }


    /**
     * Tests equals() returns boolean value depending on whether or not two
     * lists are equal.
     */
    public void testEquals() {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        list.add(inf);
        list.add(inf);
        list1.add(inf1);
        list1.add(inf2);
        assertEquals(list, list);
        assertFalse(list.equals(null));
        assertFalse(list.equals(new Object()));
        assertFalse(list1.equals(list));
        assertFalse(list2.equals(list));

    }


    /**
     * Tests sortByName() sorts lists by name.
     */
    public void testSortByName() {
        list.add(inf);
        list.add(inf1);
        list.add(inf2);
        list.sort(new CompareByChannelName());
        assertTrue(list.getEntry(0).equals(inf));
    }


    /**
     * Tests sortbyEngagement() sorts lists by engagement.
     */
    public void testSortByEngagement() {
        LinkedList list1 = new LinkedList();
        list1.sort(new CompareByEngagementRate(MonthEnum.FIRSTQUART, "Traditional Engagement Rate"));
        list.add(inf);
        list.add(inf1);
        list.add(inf2);
        list.sort(new CompareByEngagementRate(MonthEnum.FIRSTQUART, "Traditional Engagement Rate"));
        assertTrue(list.getEntry(0).equals(inf2));
    }


    /**
     * Tests toArray() returns an array version of the list.
     */
    public void testToArray() {
        LinkedList list1 = new LinkedList();
        list1.sort(new CompareByChannelName());
        list.add(inf);
        list.add(inf1);
        assertEquals("[" + inf.toString() + ", " + inf1.toString() + "]", Arrays
            .toString(list.toArray()));
    }


    /**
     * Tests toString() returns an string version of the list.
     */
    public void testToString() {

        // test empty list
        assertEquals("[]", list.toString());

        // test non empty list
        list.add(inf);
        list.add(inf1);
        String str = "[" + inf.toString() + ", " + inf1.toString() + "]";
        assertEquals(str, list.toString());
    }
    
    /**
     * Tests that the iterator traverses the list appropriately. If next is called when 
     * the iterator is at the end of the list, a NoSuchElementException is thrown.
     */
    public void testIterator() {
        list.add(inf);
        list.add(inf1);
        list.add(inf2);
        Iterator<Influencer> iter = list.iterator();
        
        assertTrue(iter.hasNext());
        assertEquals(inf, iter.next());
        assertTrue(iter.hasNext());
        assertEquals(inf1, iter.next());
        assertTrue(iter.hasNext());
        assertEquals(inf2, iter.next());
        assertFalse(iter.hasNext());
        
        NoSuchElementException exception = null;
        
        try {
            iter.next();
        }
        catch (NoSuchElementException e) {
            exception = e;      
        }
        assertNotNull(exception);
    }
}
