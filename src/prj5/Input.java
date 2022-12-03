// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of
// those who do.
// -- Team

package prj5;

import java.io.FileNotFoundException;

/**
 * Project: P5 Social Media Visualization
 * Class: Input
 *
 * Driver class for the program
 *
 * @author Nana Yaw Barimah Oteng (nanayawo21)
 * @version 2022.12.02
 */
public class Input {

    /**
     * Driver class constructor.
     */
    public Input() {

        //Left empty on purpose
    }


    /**
     * Driver code for the socialmediavisualization project.
     *
     * @param args is the array parameter containing an input file.
     * @throws FileNotFoundException File not found Exception
     */
    public static void main(String[] args) throws FileNotFoundException {
        DataReader reader;

        if (args.length == 1) {

            reader = new DataReader(args[0]);
        }
        else {

            reader = new DataReader("SampleInput1_2022.csv");
        }
    }
}
