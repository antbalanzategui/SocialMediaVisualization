// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of 
// those who do.
// -- Lukyan Sukhachevskyi (lukyan)

package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Project: socialmediavisualization
 * Class: DataManipulator
 *
 * @author Lukyan Sukhachevskyi (lukyan)
 * @version 2022.11.14
 */
public class DataManipulator {

    private final DLinkedList<Influencer> list;


    /**
     * Instantiates a new Data reader.
     *
     * @param fileName the file name
     * @throws FileNotFoundException the file not found exception
     */
    public DataManipulator(String fileName) throws FileNotFoundException {

        list = readFile(fileName);
        GUIWindow window = new GUIWindow(list);
    }


    private DLinkedList<Influencer> readFile(String fileName)
        throws FileNotFoundException {

        //create the list to store influencers
        DLinkedList<Influencer> list = new DLinkedList<Influencer>();

        //create the scanner
        //throws FileNotFound
        Scanner file = new Scanner(new File(fileName));

        //while the file has a next line
        while (file.hasNextLine()) {

            //get the next line
            String lineToParse = file.nextLine();
            //split the line at every comma
            String[] elements = lineToParse.split(",");

            //make sure that the month is valid
            if (getMonth(elements[0]) != null) {

                //create the influencer for that line
                Influencer influencer =
                    new Influencer(elements[1], elements[2], elements[3],
                        elements[4]);

                //create engagement for that line
                Engagement engagement = new Engagement(getMonth(elements[0]),
                    Integer.parseInt(elements[5]),
                    Integer.parseInt(elements[6]),
                    Integer.parseInt(elements[7]),
                    Integer.parseInt(elements[8]),
                    Integer.parseInt(elements[9]));

                //if its a new influencer...
                if (newInfluencer(influencer)) {

                    //set their engagement
                    influencer.setEngagements(new Engagement[] { engagement });
                    //add the influencer to the list
                    list.add(influencer);
                }
                else {  //if its an influencer that already exists

                    //expand the capacity of the old influencer array
                    int newLen = influencer.getEngagements().length + 1;

                    //create a new array with the expanded size
                    Engagement[] newEngagements = new Engagement[newLen];

                    //add the old entries to the new array
                    for (int i = 0;
                         i < influencer.getEngagements().length; i++) {

                        newEngagements[i] = influencer.getEngagements()[i];
                    }

                    //add the new engagement entry to the array
                    newEngagements[newLen - 1] = engagement;

                    //find the location of the old influencer
                    int infIndex = list.getIndex(influencer);

                    //update the engagement array of the influencer
                    influencer.setEngagements(newEngagements);

                    //replace the old influencer with old engagements to new
                    list.replace(infIndex, influencer);
                }
            }
        }

        return list;
    }


    private boolean newInfluencer(Influencer influencer) {

        return !list.contains(influencer);
    }


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
        }

        return null;
    }
}
