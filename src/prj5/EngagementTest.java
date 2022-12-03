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
 * @author Lukyan Sukhachevskyi (lukyan)
 * @version 2022.12.02
 */
public class EngagementTest extends TestCase {

    private Engagement eng1;
    private Engagement eng2;
    private Engagement eng3;


    /**
     * Sets up objects that will be used
     */
    public void setUp() {
        eng1 = new Engagement(MonthEnum.JANUARY, 7, 9, 8, 100, 5);
        eng2 = new Engagement(MonthEnum.FEBRUARY, 6, 9, 80, 1000, 50);
        eng3 = new Engagement(MonthEnum.JANUARY, 233, 10, 0, 1000, 0);
    }


    /**
     * Tests getMonth
     */
    public void testGetMonth() {
        assertEquals(MonthEnum.JANUARY, eng1.getMonth());
        assertEquals(MonthEnum.FEBRUARY, eng2.getMonth());
    }


    /**
     * Tests getNumLikes
     */
    public void testGetNumLikes() {
        assertEquals(7, eng1.getNumLikes());
        assertEquals(6, eng2.getNumLikes());
    }


    /**
     * Tests getNumPosts
     */
    public void testGetNumPosts() {
        assertEquals(9, eng1.getNumPosts());
        assertEquals(9, eng2.getNumPosts());
    }


    /**
     * Tests getNumFollowers
     */
    public void testGetNumFollowers() {
        assertEquals(8, eng1.getNumFollowers());
        assertEquals(80, eng2.getNumFollowers());
    }


    /**
     * Tests getNumComments
     */
    public void testGetNumComments() {
        assertEquals(100, eng1.getNumComments());
        assertEquals(1000, eng2.getNumComments());
    }


    /**
     * Tests getNumViews
     */
    public void testGetNumViews() {
        assertEquals(5, eng1.getNumViews());
        assertEquals(50, eng2.getNumViews());
    }


    /**
     * Tests getTradEngagementRate
     */
    public void testGetTradEngagementRate() {
        assertEquals(1337.5, eng1.getTradEngagementRate(), 0.0001);
        assertEquals(1257.5, eng2.getTradEngagementRate(), 0.0001);
        assertEquals(0.0, eng3.getTradEngagementRate(), 0.001);

    }


    /**
     * Tests getReachEngagementRate
     */
    public void testGetReachEngagementRate() {
        assertEquals(2140.0, eng1.getReachEngagementRate(), 0.0001);
        assertEquals(2012.0, eng2.getReachEngagementRate(), 0.0001);
        assertEquals(0.0, eng3.getReachEngagementRate(), 0.001);
    }


    /**
     * Tests equals
     */
    public void testEquals() {

        //null check
        assertFalse(eng1.equals(null));
        //self check
        assertTrue(eng1.equals(eng1));
        //type check
        assertFalse(eng1.equals("Do"));
        //bad field check
        assertFalse(eng1.equals(eng2));

        //true fields check
        eng3 = new Engagement(MonthEnum.JANUARY, 7, 9, 8, 100, 5);
        assertTrue(eng1.equals(eng3));

        //field by field check
        //unequal months
        eng3 = new Engagement(MonthEnum.FEBRUARY, 7, 8, 8, 100, 5);
        assertFalse(eng1.equals(eng3));

        //unequal likes
        eng3 = new Engagement(MonthEnum.JANUARY, 8, 9, 9, 100, 5);
        assertFalse(eng1.equals(eng3));

        //unequal posts
        eng3 = new Engagement(MonthEnum.JANUARY, 7, 10, 8, 101, 5);
        assertFalse(eng1.equals(eng3));

        //unequal followers
        eng3 = new Engagement(MonthEnum.JANUARY, 7, 9, 9, 100, 6);
        assertFalse(eng1.equals(eng3));

        //unequal comments
        eng3 = new Engagement(MonthEnum.FEBRUARY, 7, 9, 8, 101, 5);
        assertFalse(eng1.equals(eng3));

        //unequal views
        eng3 = new Engagement(MonthEnum.FEBRUARY, 7, 9, 8, 100, 6);
        assertFalse(eng1.equals(eng3));
    }


    /**
     * Tests toString
     */
    public void testToString() {
        assertEquals("[JANUARY, 7, 9, 8, 100, 5]", eng1.toString());
    }
}
