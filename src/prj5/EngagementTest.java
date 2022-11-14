package prj5;

import student.TestCase;

public class EngagementTest extends TestCase {
    
    private Engagement eng1;
    private Engagement eng2;
    
    public void setUp() {
        eng1 = new Engagement("Jan", 7, 9, 8, 100, 5);
        eng2 = new Engagement("Feb", 6, 9, 80, 1000, 50);
    }
    
    public void testGetMonth() {
        assertEquals(eng1.getMonth(), "Jan");
        assertEquals(eng2.getMonth(), "Feb");
    }
    public void testGetNumLikes() {
        assertEquals(eng1.getNumLikes(), 7);
        assertEquals(eng2.getNumLikes(), 6);
    }
    
    public void testGetNumPosts() {
        assertEquals(eng1.getNumPosts(), 9);
        assertEquals(eng2.getNumPosts(), 9);
    }
    
    public void testGetNumFollowers() {
        assertEquals(eng1.getNumFollowers(), 8);
        assertEquals(eng2.getNumFollowers(), 80);
        
    }
    
    public void testGetNumComments() {
        assertEquals(eng1.getNumComments(), 100);
        assertEquals(eng2.getNumComments(), 1000);
    }
    
    public void testGetNumViews() {
        assertEquals(eng1.getNumViews(), 5);
        assertEquals(eng2.getNumViews(), 50);
    }
    
    public void testGetTradEngagementRate() {
        assertEquals(eng1.getTradEngagementRate(), 1337.5, 0.0001);
        assertEquals(eng2.getTradEngagementRate(), 1257.5, 0.0001);
    }
    
    public void testGetReachEngagementRate() {
        assertEquals(eng1.getReachEngagementRate(), 2140.0, 0.0001);
        assertEquals(eng2.getReachEngagementRate(), 2012.0, 0.0001);
    }
    

}
