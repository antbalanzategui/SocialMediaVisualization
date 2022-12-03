// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of
// those who do.
// -- Team

package prj5;

import student.TestCase;

/**
 * Class to test Node class
 *
 * @author Antonio Balanzategui (antbalanzategui)
 * @version 2022.11.18
 */
public class NodeTest extends TestCase {

    private Node<String> dn1;
    private Node<String> dn2;
    private Node<String> dn3;

    /**
     * Sets up
     */
    public void setUp() {

        dn1 = new Node<String>("Do");
        dn2 = new Node<String>("Yo");
        dn3 = new Node<String>("Fo", dn2);
    }


    /**
     * Tests getData()
     */
    public void testGetData() {
        assertEquals(dn1.getData(), "Do");
        assertEquals(dn2.getData(), "Yo");
        assertEquals(dn3.getData(), "Fo");
    }


    /**
     * Tests setData()
     */
    public void testSetData() {
        dn1.setData("Test");
        assertEquals(dn1.getData(), "Test");
    }


    /**
     * Tests getNext()
     */
    public void testGetNext() {
        assertNull(dn1.getNext());
        assertNull(dn2.getNext());
        assertEquals(dn3.getNext(), dn2);
    }


    /**
     * Tests setNext()
     */
    public void testSetNext() {
        dn1.setNext(dn2);
        assertEquals(dn1.getNext(), dn2);
        dn3.setNext(dn1);
        assertEquals(dn3.getNext(), dn1);
    }
}
