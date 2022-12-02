// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of
// those who do.
// -- Team

package prj5;

import student.TestCase;

/**
 * Class to test all methods within Engagement class
 *
 * @author Antonio Balanzategui (antbalanzategui)
 * @version 2022.11.13
 */

public class EngagementTest extends TestCase {

    private Engagement eng1;
    private Engagement eng2;

    /**
     * Sets up objects that will be used
     */
    public void setUp() {
        eng1 = new Engagement(MonthEnum.JANUARY, 7, 9, 8, 100, 5);
        eng2 = new Engagement(MonthEnum.FEBRUARY, 6, 9, 80, 1000, 50);
    }


    /**
     * Tests getMonth
     */
    public void testGetMonth() {
        assertEquals(eng1.getMonth(), MonthEnum.JANUARY);
        assertEquals(eng2.getMonth(), MonthEnum.FEBRUARY);
    }
    
    /**
     * Tests totalEngagement();
     */
    public void testTotalEngagement() {
        assertEquals(eng1.getTotalEngagement(), 107);
    }


    /**
     * Tests getNumLikes
     */
    public void testGetNumLikes() {
        assertEquals(eng1.getNumLikes(), 7);
        assertEquals(eng2.getNumLikes(), 6);
    }


    /**
     * Tests getNumPosts
     */
    public void testGetNumPosts() {
        assertEquals(eng1.getNumPosts(), 9);
        assertEquals(eng2.getNumPosts(), 9);
    }


    /**
     * Tests getNumFollowers
     */
    public void testGetNumFollowers() {
        assertEquals(eng1.getNumFollowers(), 8);
        assertEquals(eng2.getNumFollowers(), 80);

    }


    /**
     * Tests getNumComments
     */
    public void testGetNumComments() {
        assertEquals(eng1.getNumComments(), 100);
        assertEquals(eng2.getNumComments(), 1000);
    }


    /**
     * Tests getNumViews
     */
    public void testGetNumViews() {
        assertEquals(eng1.getNumViews(), 5);
        assertEquals(eng2.getNumViews(), 50);
    }


    /**
     * Tests getTradEngagementRate
     */
    public void testGetTradEngagementRate() {
        assertEquals(eng1.getTradEngagementRate(), 1337.5, 0.0001);
        assertEquals(eng2.getTradEngagementRate(), 1257.5, 0.0001);
    }


    /**
     * Tests getReachEngagementRate
     */
    public void testGetReachEngagementRate() {
        assertEquals(eng1.getReachEngagementRate(), 2140.0, 0.0001);
        assertEquals(eng2.getReachEngagementRate(), 2012.0, 0.0001);
    }


    /**
     * Tests equals
     */
    public void testEquals() {
        assertFalse(eng1.equals(null));
        assertTrue(eng1.equals(eng1));
        assertFalse(eng1.equals("Do"));
        assertFalse(eng1.equals(eng2));
        Engagement eng3 = new Engagement(MonthEnum.JANUARY, 7, 9, 8, 100, 5);
        assertTrue(eng1.equals(eng3));
        eng3 = new Engagement(MonthEnum.JANUARY, 7, 8, 8, 100, 5);
        assertFalse(eng1.equals(eng3));
        eng3 = new Engagement(MonthEnum.JANUARY, 7, 9, 9, 100, 5);
        assertFalse(eng1.equals(eng3));
        eng3 = new Engagement(MonthEnum.JANUARY, 7, 9, 8, 101, 5);
        assertFalse(eng1.equals(eng3));
        eng3 = new Engagement(MonthEnum.JANUARY, 7, 9, 8, 100, 6);
        assertFalse(eng1.equals(eng3));
        eng3 = new Engagement(MonthEnum.FEBRUARY, 7, 9, 8, 100, 5);
        assertFalse(eng1.equals(eng3));
    }


    /**
     * Tests toString
     */
    public void testToString() {
        assertEquals("Month: JANUARY, Number of Likes: 7, Number of Posts: 9,"
            + " Number of Followers: 8, "
            + "Number of Comments: 100, Number of Views: 5", eng1.toString());
    }


//    /**
//     * Tests compareTradEngagementRate
//     */
//    public void testCompareTradEngagementRate() {
//        assertEquals(1, eng1.compareTradEngagementRate(eng2));
//        assertEquals(-1, eng2.compareTradEngagementRate(eng1));
//        assertEquals(0, eng1.compareTradEngagementRate(eng1));
//    }


//    /**
//     * Tests compareReachEngagementRate
//     */
//    public void testCompareReachEngagementRate() {
//        assertEquals(1, eng1.compareReachEngagementRate(eng2));
//        assertEquals(-1, eng2.compareReachEngagementRate(eng1));
//        assertEquals(0, eng1.compareReachEngagementRate(eng1));
//    }
}
