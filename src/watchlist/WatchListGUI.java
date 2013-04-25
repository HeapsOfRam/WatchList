/*
 * WatchListGUI.java
 * Author: HeapsOfRam
 */
package watchlist;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class WatchListGUI extends JFrame{
    private ControlPanel control;
    private ViewPanel view;
    private TextPanel text;

    ArrayList<Show> list = new <Show>ArrayList();
    String filename = "shows.txt";
    
    public WatchListGUI(){
        super("The Watchlist");
        
        view = new ViewPanel();
        view.setPreferredSize(new Dimension(600, 300));
        view.setBorder(BorderFactory.createEtchedBorder());
        
        text = new TextPanel();
        text.setPreferredSize(new Dimension(300, 100));
        text.setBorder(BorderFactory.createEtchedBorder());
        
        control = new ControlPanel(view, text, list);
        control.setPreferredSize(new Dimension(300, 100));
        control.setBorder(BorderFactory.createEtchedBorder());
        
        setLayout(new BorderLayout());
        add(BorderLayout.SOUTH, control);
        add(BorderLayout.NORTH, view);
        add(BorderLayout.CENTER, text);
        
        BuildService();
    }
    public void BuildService(){
        try{
            Show show;
            Scanner scan = new Scanner(new File(filename));
            Scanner linescan;
            String line, bname, beps, btoteps, bfin, bmov, brate;
            
            while(scan.hasNext()){
                line = scan.nextLine();
                linescan = new Scanner(line);
                linescan.useDelimiter(",");
                
                bname = linescan.next();
                beps = linescan.next();
                btoteps = linescan.next();
                bfin = linescan.next();
                bmov = linescan.next();
                brate = linescan.next();
                
                show = new Show(bname, Integer.parseInt(beps), Integer.parseInt(btoteps), Boolean.parseBoolean(bfin), Boolean.parseBoolean(bmov), Integer.parseInt(brate));
                
                list.add(show);
                view.addToModel(show);
            }
        }
        catch(IOException e){
            System.out.println("IOException " + e);
        }
    }
}
