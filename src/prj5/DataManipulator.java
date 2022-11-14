// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of 
// those who do.
// -- Lukyan Sukhachevskyi (lukyan)

package prj5;

/**
 * Project: socialmediavisualization
 * Class: DataManipulator
 *
 * @author Lukyan Sukhachevskyi (lukyan)
 * @version 2022.11.14
 */
public class DataManipulator {

    private DLinkedList list;

    public DataManipulator(String fileName){

        list = readFile(fileName);
        GUIWindow window = new GUIWindow(list);
    }

    private DLinkedList<Influencer> readFile(String fileName){

        DLinkedList<Influencer> list = new DLinkedList<Influencer>();

        return list;
    }
}
