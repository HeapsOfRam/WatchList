/*
 * WatchList.java
 * Author: HeapsOfRam
 * A helpful tool to keep track of progress in shows
 */
package watchlist;

import java.io.*;
import java.awt.*;
import javax.swing.*;

public class WatchList {

    public static void main(String[] args) {
        //Frame for the GUI
        final JFrame jFrame = new WatchListGUI();
        //Exits program when X is clicked

        jFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
	//Sets size of the window to 600x500
        jFrame.setSize(600,600);
	//Allow visibility of the frame
        jFrame.setVisible(true); // Show frame
    }
}
