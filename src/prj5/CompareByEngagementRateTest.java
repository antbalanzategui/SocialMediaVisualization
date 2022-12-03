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
 * Class: CompareByEngagementRateTest
 *
 * Tests the compareByEngagementRate class.
 *
 * @author Nana Yaw Barimah Oteng(nanayawo21)
 * @version 2022.12.02
 */
public class CompareByEngagementRateTest extends TestCase {

    private CompareByEngagementRate comp;
    private Influencer inf;
    private Influencer inf1;
    private Influencer inf2;


    /**
     * Sets up before every test method.
     */
    public void setUp() {

        comp = new CompareByEngagementRate(MonthEnum.JANUARY,
            "Traditional Engagement Rate");
        inf = new Influencer("Test", "Attack", "Brazil", "Topic");
        inf1 = new Influencer("Test1", "Attack", "Ghana", "Topic1");
        inf2 = new Influencer("Test2", "Career", "America", "Topic2");

        Engagement eng1 = new Engagement(MonthEnum.JANUARY, 5, 6, 1, 3, 5);
        Engagement eng2 = new Engagement(MonthEnum.FEBRUARY, 5, 8, 1, 3, 6);
        Engagement eng3 = new Engagement(MonthEnum.MARCH, 6, 6, 1, 1, 5);

        Engagement eng4 = new Engagement(MonthEnum.JANUARY, 1, 0, 1, 1, 1);
        Engagement eng5 = new Engagement(MonthEnum.FEBRUARY, 1, 0, 1, 1, 1);
        Engagement eng6 = new Engagement(MonthEnum.MARCH, 1, 0, 1, 1, 1);

        Engagement[] eng = new Engagement[3];
        eng[0] = eng1;
        eng[1] = eng2;
        eng[2] = eng3;

        Engagement[] engArr = new Engagement[3];
        engArr[0] = eng4;
        engArr[1] = eng5;
        engArr[2] = eng6;

        inf.setEngagements(eng);
        inf2.setEngagements(eng);

        inf1.setEngagements(engArr);
    }


    /**
     * Tests the compare() method to ensure it successfully compares
     * different influencers by Engagement Rate.
     */
    public void testCompare() {

        assertEquals(0, comp.compare(inf, inf2));
        assertTrue(comp.compare(inf1, inf) < 0);
        assertTrue(comp.compare(inf2, inf1) > 0);
    }


    /**
     * Tests the compare() method throws an Exception when either
     * influencers being compared is null.
     */
    public void testCompareException() {

        NullPointerException exception = null;
        NullPointerException exception1 = null;

        try {
            comp.compare(null, null);

        }
        catch (NullPointerException e) {
            exception = e;
        }
        assertNotNull(exception);

        try {
            comp.compare(inf, null);

        }
        catch (NullPointerException e) {
            exception1 = e;
        }
        assertNotNull(exception);
        assertNotNull(exception1);
    }
}
