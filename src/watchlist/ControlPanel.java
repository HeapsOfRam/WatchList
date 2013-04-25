/*
 * ControlPanel.java
 * Author: HeapsOfRam
 */
package watchlist;

import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ControlPanel extends JPanel{
    private ViewPanel view;
    private TextPanel text;
    private String filename = "shows.txt";
    
    JButton addButton, deleteButton, editButton, helpButton, exitButton;
    JPanel buttonPanel;
    
    ButtonHandler action;

    private ArrayList<Show> list;// = new <Show>ArrayList();
    
    public ControlPanel(ViewPanel view, TextPanel text, ArrayList<Show> list){
        this.view = view;
        this.text = text;
        this.list = list;
        
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
                
                showInList(show);
                
                list.add(show);
                view.addToModel(show);
                    
                System.out.println(show);
                text.resetFields();
            }
            if(e.getActionCommand().equals("DELETE")){
                if(view.getSelectedShow() != null){
                    show = view.getSelectedShow();
                    list.remove(show);
                    view.removeFromModel(show);
                }
            }
            if(e.getActionCommand().equals("EDIT")){
                if(view.getSelectedShow() != null){
                    show = view.getSelectedShow();
                    text.setName(show.getName());
                    text.setEpisodes(show.getEpisode());
                    text.setTotEps(show.getTotEpisode());
                    text.setRating(show.getRating());
                    text.setFin(show.getFinished());
                    text.setMovie(show.getMovie());
                }
            }
            if(e.getActionCommand().equals("HELP")){
                JOptionPane.showMessageDialog(null, "Welcome to the WatchList!\n"
                        + "This program helps keep track of shows you are watching or have watched\n"
                        + "\nAdd adds a show to the list\n"
                        + "Delete removes a show from the list\n"
                        + "Edit edits a show in the list\n"
                        + "Help displays this menu\n"
                        + "Exit quits the program, and saves your list\n"
                        + "\nName is the name of the show\n"
                        + "Episode is the current episode you are on\n"
                        + "Total is the total number of episodes in the series\n"
                        + "If you have finished the series, make sure to select \"Finished\" in status\n"
                        + "If the show is a movie, make sure to select that in movie\n"
                        + "For rating, give your own personal rating of the show out of 10", "Help Menu", JOptionPane.PLAIN_MESSAGE);
            }
            if(e.getActionCommand().equals("EXIT")){
                writeToFile();
                System.exit(0);
            }
        }        
        
        public Show showInList(Show show){
            Iterator<Show> iter = list.iterator();
            Show temp;                
            while(iter.hasNext()){
                temp = iter.next();
                if(show.getName().equals(temp.getName())){
                    list.remove(temp);
                    view.removeFromModel(temp);
                    return temp;
                    //list.add(show);
                    //view.addToModel(show);
                }
            } 
            return null;
        }
        
        public void writeToFile(){
            Iterator<Show> iter = list.iterator();
            Show temp;
            
            try{
                File file = new File(filename);
                if(!file.exists()){
                    file.createNewFile();
                }
                
                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                
                while(iter.hasNext()){
                    temp = iter.next();
                    bw.write(temp.saveString());
                }
                bw.close();
            }
            catch(IOException e){
                System.out.println("IOException " + e);
            }
        }
    }    
}
