// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of
// those who do.
// -- Team

package prj5;

import java.util.Arrays;

import student.TestCase;

/**
 * Test Class for Doubly Linked List.
 *
 * @author Nana Yaw Barimah Oteng
 * @version 2022.11.18
 */
public class DLinkedListTest extends TestCase {
    // Fields------------------------------------
    private DLinkedList list;
    private Influencer inf;
    private Influencer inf1;
    private Influencer inf2;
    private Influencer inf3;


    /**
     * Sets up test method.
     */
    public void setUp() {
        list = new DLinkedList();
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
     * Tests add() method
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
     * Tests clear();
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
     * Tests isEmpty().
     */
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add(inf);
        assertFalse(list.isEmpty());
    }


    /**
     * Tests replace().
     */
    public void testReplace() {
        assertNull(list.replace(1, inf));
    }


    /**
     * Tests contains().
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
     * Tests getEntry().
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
     * Tests getIndex().
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
     * Tests remove().
     */
    public void testRemove() {
        list.add(inf);
        list.add(inf1);
        list.add(inf2);

        assertNull(list.remove(1));

    }


    /**
     * Tests equals().
     */
    public void testEquals() {
        DLinkedList list1 = new DLinkedList();
        DLinkedList list2 = new DLinkedList();
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
     * Tests sortByName().
     */
    public void testSortByName() {
        list.add(inf);
        list.add(inf1);
        list.add(inf2);
        list.sortByName();
        assertTrue(list.getEntry(0).equals(inf));
    }


    /**
     * Tests sortbyEngagement().
     */
    public void testSortByEngagement() {
        DLinkedList list1 = new DLinkedList();
        list1.sortByEngagement();
        list.add(inf);
        list.add(inf1);
        list.add(inf2);
        list.sortByEngagement();
        assertTrue(list.getEntry(0).equals(inf2));
    }


    /**
     * Tests sortbyEngagement().
     */
    public void testToArray() {
        DLinkedList list1 = new DLinkedList();
        list1.sortByName();
        list.add(inf);
        list.add(inf1);
        assertEquals("[" + inf.toString() + ", " + inf1.toString() + "]",
            Arrays.toString(list.toArray()));
    }


    /**
     * Tests toString().
     */
    public void testToString() {

        //test empty list
        assertEquals("[]", list.toString());

        //test non empty list
        list.add(inf);
        list.add(inf1);
        String str = "[" + inf.toString() + ", " + inf1.toString() + "]";
        assertEquals(str, list.toString());
    }
}
