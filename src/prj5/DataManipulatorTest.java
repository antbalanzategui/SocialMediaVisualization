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
 * Class: DataManipulatorTest
 *
 * @author Lukyan Sukhachevskyi (lukyan)
 * @version 2022.11.14
 */
public class DataManipulatorTest extends TestCase {

    public void setUp() throws FileNotFoundException {

        DataManipulator data = new DataManipulator("SampleInput1_2022.csv");
    }

    public void testReadFile(){


    }
}
