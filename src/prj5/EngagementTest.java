package prj5;

import student.TestCase;

public class EngagementTest extends TestCase {
    
    private Engagement eng1;
    private Engagement eng2;
    
    public void setUp() {
        eng1 = new Engagement(7, 9, 8, 100, 5);
        eng2 = new Engagement(6, 9, 80, 1000, 50);
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

}
