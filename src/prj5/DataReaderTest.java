// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of 
// those who do.
// -- Lukyan Sukhachevskyi (lukyan)

package prj5;

import student.TestCase;

import java.io.FileNotFoundException;

/**
 * Project: socialmediavisualization
 * Class: DataReaderTest
 *
 * @author Lukyan Sukhachevskyi (lukyan)
 * @version 2022.11.21
 */
public class DataReaderTest extends TestCase {

    private DataReader reader1;
    private DataReader reader2;


    /**
     * Initial setUp().
     */
    public void setUp() throws FileNotFoundException {

        reader1 = new DataReader("SampleInput1_2022.csv");
        reader2 = new DataReader("SampleInput2_2022.csv");
    }


    /**
     * Test get list.
     *
     * No assertions. For debug purposes.
     */
    public void testGetList() {

        for (Object inf : reader1.getList().toArray()) {

            System.out.println(inf.toString());
        }

        System.out.println();

        for (Object inf : reader2.getList().toArray()) {

            System.out.println(inf.toString());
        }
    }
}
