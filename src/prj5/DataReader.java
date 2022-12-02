// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of
// those who do.
// -- Team

package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Project: socialmediavisualization
 * Class: DataReader
 * The DataReader class will read the input files of influencers and store them
 * in our linked list. and begin the GUI Window.
 *
 * @author Lukyan Sukhachevskyi (lukyan)
 * @author Nana Yaw Barimah Oteng (nanayawo21)
 * @version 2022.11.14
 */
public class DataReader {

    private LinkedList list;

    /**
     * Instantiates a new Data reader.
     *
     * @param fileName
     *            the file name
     * @throws FileNotFoundException
     *             the file not found exception is thrown if the file is not
     *             found.
     */
    public DataReader(String fileName) throws FileNotFoundException {

        list = new LinkedList();
        list = readFile(fileName);
        new GUIWindow(list);
    }


    /**
     * Returns the list of influencers.
     *
     * @return Returns the list of influencers.
     */
    public LinkedList getList() {
        return list;
    }


    /**
     * The file with fileName as a parameter is parsed to create influencers
     * with the data in the file. The influencers are then added to a linked
     * list.
     *
     * 
     * @param fileName
     *            is the planet file being parsed.
     * @throws FileNotFoundException
     *             the planet file cannot be found.
     * 
     * @return returns the linked list of influencers.
     * 
     */
    private LinkedList readFile(String fileName) throws FileNotFoundException {

        // create the list to store influencers
        // DLinkedList newList = new DLinkedList();

        // create the scanner
        // throws FileNotFound
        Scanner file = new Scanner(new File(fileName));

        // while the file has a next line
        while (file.hasNextLine()) {

            // get the next line
            String lineToParse = file.nextLine();
            // split the line at every comma
            String[] elements = lineToParse.split(",");

            // make sure that the month is valid
            if (getMonth(elements[0]) != null) {

                // create the influencer for that line
                Influencer influencer = new Influencer(elements[1], elements[2],
                    elements[3], elements[4]);

                // create engagement for that line
                Engagement engagement = new Engagement(getMonth(elements[0]),
                    Integer.parseInt(elements[5]), Integer.parseInt(
                        elements[6]), Integer.parseInt(elements[7]), Integer
                            .parseInt(elements[8]), Integer.parseInt(
                                elements[9]));

                // if its a new influencer...
                if (newInfluencer(influencer)) {

                    // set their engagement
                    influencer.setEngagements(new Engagement[] { engagement });
                    // add the influencer to the list
                    this.list.add(influencer);
                }
                else { // if its an influencer that already exists
                    Influencer origInfluencer = this.list.getEntry(this.list
                        .getIndex(influencer));

                    // expand the capacity of the old influencer array
                    int newLen = origInfluencer.getEngagements().length + 1;

                    // create a new array with the expanded size
                    Engagement[] newEngagements = new Engagement[newLen];

                    // add the old entries to the new array
                    for (int i = 0; i < origInfluencer
                        .getEngagements().length; i++) {

                        newEngagements[i] = origInfluencer.getEngagements()[i];
                    }

                    // add the new engagement entry to the array
                    newEngagements[newLen - 1] = engagement;

                    // find the location of the old influencer

                    // update the engagement array of the influencer
                    origInfluencer.setEngagements(newEngagements);
                }
            }
        }

        return list;
    }


    /**
     * 
     * @param influencer
     *            is the influencer being checked to see if the list contains
     *            it.
     * @return returns true/false depending on whether the list already contains
     *         the influencer.
     */
    private boolean newInfluencer(Influencer influencer) {

        return !list.contains(influencer);
    }


    /**
     * Helper method for the readFile() method, to help locate the month for
     * which an Influencer's data is being added to.
     * 
     * @param  is the string of the month that data is being added for.
     * @return returns the month for which influencer data is being added to.
     */
    private MonthEnum getMonth(String month) {

        switch (month) {

            case "January":
                return MonthEnum.JANUARY;
            case "February":
                return MonthEnum.FEBRUARY;
            case "March":
                return MonthEnum.MARCH;
            case "April":
                return MonthEnum.APRIL;
            case "May":
                return MonthEnum.MAY;
            case "June":
                return MonthEnum.JUNE;
            case "July":
                return MonthEnum.JULY;
            case "August":
                return MonthEnum.AUGUST;
            case "September":
                return MonthEnum.SEPTEMBER;
            case "October":
                return MonthEnum.OCTOBER;
            case "November":
                return MonthEnum.NOVEMBER;
            case "December":
                return MonthEnum.DECEMBER;
            default:
                return null;
        }
    }
}
