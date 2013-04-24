/*
 * WatchListGUI.java
 * Author: HeapsOfRam
 */
package watchlist;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WatchListGUI extends JFrame{
    private ControlPanel control;
    private ViewPanel view;
    private TextPanel text;
    
    public WatchListGUI(){
        super("The Watchlist");
        
        view = new ViewPanel();
        view.setPreferredSize(new Dimension(600, 300));
        view.setBorder(BorderFactory.createEtchedBorder());
        
        text = new TextPanel();
        text.setPreferredSize(new Dimension(300, 100));
        text.setBorder(BorderFactory.createEtchedBorder());
        
        control = new ControlPanel(view, text);
        control.setPreferredSize(new Dimension(300, 100));
        control.setBorder(BorderFactory.createEtchedBorder());
        
        setLayout(new BorderLayout());
        add(BorderLayout.SOUTH, control);
        add(BorderLayout.NORTH, view);
        add(BorderLayout.CENTER, text);
    }    
}
