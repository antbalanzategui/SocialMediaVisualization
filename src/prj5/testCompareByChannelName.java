// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of 
// those who do.
// -- Team
package prj5;

import student.TestCase;
/**
 * Project: socialmediavisualization
 * Class: testCompareByChannelName
 * Tests the compareByChannelName class.
 * @author Nana Yaw Barimah Oteng(nanayawo21)
 * 
 * @version 2022.12.02
 */
public class testCompareByChannelName extends TestCase {
    private CompareByChannelName comp;
    private Influencer inf;
    private Influencer inf1;
    private Influencer inf2;
    private Influencer inf3;
    
    /**
     * Sets up before every test method.
     */
    public void setUp() {
        comp = new CompareByChannelName();         
        inf = new Influencer("Test", "Attack", "Brazil", "Topic");
        inf1 = new Influencer("Test1", "Attack", "Ghana", "Topic1");
        inf2 = new Influencer("Test2", "Career", "America", "Topic2");
        inf3 = new Influencer("Test3", "Domino", "America3", "Topic3");
    }
    
    /**
     * Tests the compare() method to ensure it successfully compares 
     * different influencers by ChannelName.
     */
    public void testCompare() {
        assertEquals(0, comp.compare(inf, inf1));
        assertTrue(comp.compare(inf2, inf3) < 0);
        assertTrue(comp.compare(inf3, inf1) > 0);
        
        
    }
    
    /**
     * Tests the compare() method throws an Exception when either 
     * Influencers being compared is null.
     */
    public void testCompareException() {
        NullPointerException exception = null;
        NullPointerException exception1 = null;
        
        try {
            comp.compare(null, null);
            
        }
        catch(NullPointerException e) {
            exception = e;
        }
        assertNotNull(exception);
        
        try {
            comp.compare(inf, null);
            
        }
        catch(NullPointerException e) {
            exception1 = e;
        }
        assertNotNull(exception);
        assertNotNull(exception1);
        
        
    }

}
