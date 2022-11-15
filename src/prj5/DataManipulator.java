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

    private final DLinkedList list;


    public DataManipulator(String fileName) throws FileNotFoundException {

        list = readFile(fileName);
        GUIWindow window = new GUIWindow(list);
    }


    private DLinkedList<Influencer> readFile(String fileName)
        throws FileNotFoundException {

        DLinkedList<Influencer> list = new DLinkedList<Influencer>();

        Scanner file = new Scanner(new File(fileName));

        while (file.hasNextLine()) {

            String toParsePlanet = file.nextLine();
            String[] elements = toParsePlanet.split(",");

            if(getMonth(elements[0]) != null){

                Influencer influencer =
                    new Influencer(elements[1], elements[2], elements[3],
                        elements[4]);

                Engagement engagement = new Engagement(getMonth(elements[0]),
                    Integer.parseInt(elements[5]), Integer.parseInt(elements[6]),
                    Integer.parseInt(elements[7]), Integer.parseInt(elements[8]),
                    Integer.parseInt(elements[9]));

                if (newInfluencer(influencer)) {

                    influencer.setEngagements(new Engagement[]{engagement});
                    list.add(influencer);
                }else{

                    int newLen = influencer.getEngagements().length + 1;
                    Engagement[] newEngagements = new Engagement[newLen];

                    for (int i = 0; i < influencer.getEngagements().length; i++) {

                        newEngagements[i] = influencer.getEngagements()[i];
                    }

                    newEngagements[newLen - 1] = engagement;
                    int infIndex = list.getIndex(influencer);
                    influencer.setEngagements(newEngagements);
                    list.replace(infIndex, influencer);
                }
            }
        }

        return list;
    }


    private boolean newInfluencer(Influencer influencer) {

        return !list.contains(influencer);
    }

    private MonthEnum getMonth(String month){

        switch (month){

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
