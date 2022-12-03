// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of
// those who do.
// -- Team

package prj5;

import student.TestCase;

/**
 * Project: P5 Social Media Visualization
 * Class: InfluencerTest
 *
 * Tests the Influencer Class
 *
 * @author Antonio Balanzategui (antbalanzategui)
 * @author Nana Yaw Barimah Oteng (nanayawo21)
 * @author Lukyan Sukhachevskyi (lukyan)
 * @version 2022.12.02
 */
public class InfluencerTest extends TestCase {

    private Influencer inf;
    private Engagement[] engArr;
    private Engagement eng1;
    private Engagement eng2;
    private Engagement eng3;


    /**
     * Sets up
     */
    public void setUp() {

        // set up engagements
        eng1 = new Engagement(MonthEnum.JANUARY, 5, 6, 4, 3, 5);
        eng2 = new Engagement(MonthEnum.FEBRUARY, 5, 8, 4, 3, 6);
        eng3 = new Engagement(MonthEnum.MARCH, 6, 6, 4, 1, 5);
        engArr = new Engagement[] { eng1, eng2, eng3 };

        // set up influencer
        inf = new Influencer("Test", "Channel", "Brazil", "Topic");
        inf.setEngagements(engArr);
    }


    /**
     * Tests getUsername
     */
    public void testGetUsername() {

        assertEquals("Test", inf.getUsername());
    }


    /**
     * Tets getChannelName
     */
    public void testGetChannelName() {

        assertEquals("Channel", inf.getChannelName());
    }


    /**
     * Tests getCountry
     */
    public void testGetCountry() {

        assertEquals("Brazil", inf.getCountry());
    }


    /**
     * Tests getMainTopic
     */
    public void testGetMainTopic() {

        assertEquals("Topic", inf.getMainTopic());
    }


    /**
     * Tests getEngagements
     */
    public void testGetEngagements() {

        for (int i = 0; i < 3; i++) {

            assertTrue(engArr[i].equals(inf.getEngagements()[i]));
        }
    }


    /**
     * Tests setEngagements
     */
    public void testSetEngagements() {

        engArr = new Engagement[] { eng1 };
        inf.setEngagements(engArr);

        assertTrue(engArr[0].equals(inf.getEngagements()[0]));
        assertEquals(1, inf.getEngagements().length);
    }


    /**
     * Tests getEngagementForMonth()
     */
    public void testGetEngagementForMonth() {

        // firstQuarter case
        Engagement frstQrtEng = inf.getEngagementForMonth(MonthEnum.FIRSTQUART);
        Engagement expected =
            new Engagement(MonthEnum.FIRSTQUART, 16, 20, 4, 7, 16);
        assertTrue(expected.equals(frstQrtEng));

        // all other cases
        assertEquals(eng1, inf.getEngagementForMonth(MonthEnum.JANUARY));
        assertEquals(eng2, inf.getEngagementForMonth(MonthEnum.FEBRUARY));
        assertEquals(eng3, inf.getEngagementForMonth(MonthEnum.MARCH));

        // engagement not found
        assertNull(inf.getEngagementForMonth(MonthEnum.DECEMBER));
    }


    /**
     * Tests equals
     */
    public void testEquals() {

        // null check
        assertFalse(inf.equals(null));

        // self check
        assertTrue(inf.equals(inf));

        // type check
        assertFalse(inf.equals(engArr));

        // setup for fields
        inf = new Influencer("Test", "Channel", "Country", "Topic");
        inf.setEngagements(engArr);
        Influencer inf2 = new Influencer("Test", "Channel", "Country", "Topic");
        inf2.setEngagements(engArr);

        // all fields true
        assertTrue(inf.equals(inf2));

        // engagement length check
        inf2.setEngagements(new Engagement[] { eng1, eng2 });
        assertFalse(inf.equals(inf2));

        // engagement elements check
        inf2.setEngagements(new Engagement[] { eng1, eng2, eng2 });
        assertFalse(inf.equals(inf2));

        // fields check
        // unequal name
        inf2 = new Influencer("Test1", "Channel", "Country", "Topic");
        inf2.setEngagements(engArr);
        assertFalse(inf.equals(inf2));

        // unequal channel name
        inf2 = new Influencer("Test", "Channel1", "Country", "Topic");
        inf2.setEngagements(engArr);
        assertFalse(inf.equals(inf2));

        // unequal country
        inf2 = new Influencer("Test", "Channel", "Country1", "Topic");
        inf2.setEngagements(engArr);
        assertFalse(inf.equals(inf2));

        // unequal topic
        inf2 = new Influencer("Test", "Channel", "Country", "Topic1");
        inf2.setEngagements(engArr);
        assertFalse(inf.equals(inf2));
    }


    /**
     * Tests getEngagementRate(), to ensure it returns appropriate values.
     */
    public void testGetEngagementRate() {

        assertEquals(0.00, inf.getEngagementRate(MonthEnum.APRIL,
            "Traditional Engagement Rate"), 0.01);
        assertEquals(200.0, inf.getEngagementRate(MonthEnum.FEBRUARY,
            "Traditional Engagement Rate"), 0.01);
        assertEquals(160,
            inf.getEngagementRate(MonthEnum.JANUARY, "Reach Engagement Rate"),
            0.01);
    }


    /**
     * Tests toString
     */
    public void testToString() {

        engArr = new Engagement[] { eng1 };
        inf.setEngagements(engArr);
        String expected =
            "[Test, Channel, Brazil, Topic, [JANUARY, 5, 6, 4, 3, 5]]";
        assertEquals(expected, inf.toString());
    }
}
