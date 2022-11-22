// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of 
// those who do.
// -- Lukyan Sukhachevskyi (lukyan)

package prj5;

import cs2.Button;
import cs2.Shape;
import cs2.Window;
import cs2.WindowSide;

/**
 * Project: P5 Social Media Visualization
 * Class: GUIWindow
 *
 * @author Lukyan Sukhachevskyi (lukyan)
 * @version 2022.11.14
 */
public class GUIWindow {

    private final Window window;
    private final int WINDOW_X = 960;
    private final int WINDOW_Y = 540;

    private DLinkedList list;

    private Shape monthLbl;
    private Shape engagementTypeLbl;
    private Shape sortTypeLbl;


    public GUIWindow(DLinkedList list) {

        //create a window
        window = new Window("Social Media Visualization");
        window.setSize(WINDOW_X, WINDOW_Y);

        //initialize the list
        this.list = list;

        //*************** create buttons *******************\\
        //Quit Button
        Button quitBtn = new Button("Quit");
        quitBtn.onClick(this, "clickedQuit");
        window.addButton(quitBtn, WindowSide.NORTH);

        //Sort By Engagement Button
        Button sortEngBtn = new Button("Sort by Engagement Rate");
        sortEngBtn.onClick(this, "clickedSort");
        window.addButton(sortEngBtn, WindowSide.NORTH);

        //Sort By Channel Button
        Button sortNameBtn = new Button("Sort by Channel Name");
        sortNameBtn.onClick(this, "clickedSort");
        window.addButton(sortNameBtn, WindowSide.NORTH);

        //January Button
        Button janBtn = new Button("January");
        janBtn.onClick(this, "clickedMonth");
        window.addButton(janBtn, WindowSide.SOUTH);

        //February Button
        Button febBtn = new Button("February");
        febBtn.onClick(this, "clickedMonth");
        window.addButton(febBtn, WindowSide.SOUTH);

        //March Button
        Button marBtn = new Button("March");
        marBtn.onClick(this, "clickedMonth");
        window.addButton(marBtn, WindowSide.SOUTH);

        //First Quarter Button
        Button frstQrtBtn = new Button("First Quarter (Jan - March)");
        frstQrtBtn.onClick(this, "clickedMonth");
        window.addButton(frstQrtBtn, WindowSide.SOUTH);

        //Traditional Engagement Rate Button
        Button tradEngBtn = new Button("Traditional Engagement Rate");
        tradEngBtn.onClick(this, "clickedEngagementCalc");
        window.addButton(tradEngBtn, WindowSide.WEST);

        //Traditional Engagement Rate Button
        Button reachEngBtn = new Button("Reach Engagement Rate");
        reachEngBtn.onClick(this, "clickedEngagementCalc");
        window.addButton(reachEngBtn, WindowSide.WEST);
        //**************************************************\\
    }


    /**
     * Quit button exits application.
     *
     * @param button the quit button
     */
    public void clickedQuit(Button button) {

        System.exit(0);
        //System exit with 0 errors.
    }


    /**
     * Sorts the list the user defined way.
     *
     * @param button the sort by engagement rate btn, or sort by name btn
     */
    public void clickedSort(Button button) {

        switch (button.getTitle()) {

            case "Sort by Engagement Rate":

                //TODO: Implement
                break;
            case "Sort by Channel Name":

                //TODO: Implement
                break;
        }
    }


    /**
     * Displays the data for the button specified month.
     *
     * @param button month button
     */
    public void clickedMonth(Button button) {

        switch (button.getTitle()) {

            case "January":

                //TODO: Implement
                break;
            case "February":

                //TODO: Implement
                break;
            case "March":

                //TODO: Implement
                break;
            case "First Quarter (Jan - March)":

                //TODO: Implement
                break;
        }
    }


    /**
     * Calculates the engagement rate the button specified way.
     *
     * @param button engagement rate type button
     */
    public void clickedEngagementCalc(Button button) {

        switch (button.getTitle()) {

            case "Traditional Engagement Rate":

                //TODO: Implement
                break;
            case "Reach Engagement Rate":

                //TODO: Implement
                break;
        }
    }
}
