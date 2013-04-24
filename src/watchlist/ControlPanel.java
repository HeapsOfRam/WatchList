/*
 * ControlPanel.java
 * Author: HeapsOfRam
 */
package watchlist;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ControlPanel extends JPanel{
    private ViewPanel view;
    private TextPanel text;
    
    JButton addButton, deleteButton, editButton, helpButton, exitButton;
    JPanel buttonPanel;
    
    ButtonHandler action;

    private ArrayList<Show> list = new <Show>ArrayList();
    
    public ControlPanel(ViewPanel view, TextPanel text){
        this.view = view;
        this.text = text;
        
        buttonPanel = new JPanel();
        action = new ButtonHandler();
        
        addButton = new JButton("ADD");
        addButton.setToolTipText("Add a new show");
        addButton.setMargin(new Insets(5, 5, 10, 5));
        addButton.addActionListener(action);
        
        deleteButton = new JButton("DELETE");
        deleteButton.setToolTipText("Deletes a show");
        deleteButton.setMargin(new Insets(5, 5, 10, 5));
        deleteButton.addActionListener(action);
        
        editButton = new JButton("EDIT");
        editButton.setToolTipText("Edits a show");
        editButton.setMargin(new Insets(5, 5, 10, 5));
        editButton.addActionListener(action);
        
        helpButton = new JButton("HELP");
        helpButton.setToolTipText("Display help menu");
        helpButton.setMargin(new Insets(5, 5, 10, 5));
        helpButton.addActionListener(action);
        
        exitButton = new JButton("EXIT");
        exitButton.setToolTipText("Exit program and save");
        exitButton.setMargin(new Insets(5, 5, 10, 5));
        exitButton.addActionListener(action);
        
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(editButton);
        buttonPanel.add(helpButton);
        buttonPanel.add(exitButton);
        
        add(buttonPanel);
    }
    
    class ButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Show show;
            String name;
            int episode, totEps, rating;
            boolean finished, movie;
            
            if(e.getActionCommand().equals("ADD")){
                name = text.getName();
                episode = text.getEpisodes();
                totEps = text.getTotEps();
                finished = text.getFin();
                movie = text.getMovie();
                rating = text.getRating();
                show = new Show(name, episode, totEps, finished, movie, rating);
                list.add(show);
                view.addToModel(show);
                System.out.println(show);
                text.resetFields();
            }
            if(e.getActionCommand().equals("DELETE")){
                
            }
            if(e.getActionCommand().equals("EDIT")){
                
            }
            if(e.getActionCommand().equals("HELP")){
                
            }
            if(e.getActionCommand().equals("EXIT")){
                //write out to file
                System.exit(0);
            }
        }        
    }    
}
