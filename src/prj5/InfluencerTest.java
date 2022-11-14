package prj5;

import student.TestCase;

/**
 * Test class for Influencer
 * 
 *Virginia Tech Honor Code Pledge:
 *As a Hokie, I will conduct myself with honor and integrity at all times.
 *I will not lie, cheat, or steal, 
 *nor will I accept the actions of those who do.
 * 
 * @author Antonio Balanzategui, antbalanzategui
 * 
 * @version 2022.11.14
 *
 */

public class InfluencerTest extends TestCase {
    
    private Influencer inf;
    private Engagement[] eng;
    private Engagement eng1;
    private Engagement eng2;
    private Engagement eng3;
    
    /**
     * Sets up
     */
    public void setUp() {
        eng1 = new Engagement(MonthEnum.JANUARY, 5, 6, 4, 3, 5);
        eng2 = new Engagement(MonthEnum.FEBRUARY, 5, 8, 4, 3, 6);
        eng3 = new Engagement(MonthEnum.MARCH, 6, 6, 4, 1, 5);
        eng = new Engagement[3];
        eng[0] = eng1;
        eng[1] = eng2;
        eng[2] = eng3;
        inf = new Influencer("Test", "Channel", "Brazil", "Topic", eng);
    }
    /**
     * Tests getUsername
     */
    public void testGetUsername() {
        assertEquals(inf.getUsername(), "Test");
    }
    /**
     * Tets getChannelName
     */
    public void testGetChannelName() {
        assertEquals(inf.getChannelName(), "Channel");
    }
    /**
     * Tests getCountry
     */
    public void testGetCountry() {
        assertEquals(inf.getCountry(), "Brazil");
    }
    /**
     * Tests getMainTopic
     */
    public void testGetMainTopic() {
        assertEquals(inf.getMainTopic(), "Topic");
    }
    /**
     * Tests getEngagements
     */
    public void testGetEngagements() {
        for (int i = 0; i < 3; i++) {
            assertTrue(eng[i].equals(inf.getEngagements()[i]));
        }
    }
    /**
     * Tests getEngagementForMonth
     */
    public void testGetEngagementForMonth() {
        assertTrue(eng1.equals(inf.getEngagementForMonth(MonthEnum.JANUARY)));
        assertNull(inf.getEngagementForMonth(MonthEnum.FIRSTQUART));
    }
    /**
     * Tests equals
     */
    public void testEquals() {
        
    }
    /**
     * Tests toString
     */
    public void testToString() {
        
    }
}
