/*
 * TextPanel.java
 * Author: HeapsOfRam
 */
package watchlist;

import java.util.*;
import java.awt.*;
import javax.swing.*;

public class TextPanel extends JPanel{
    private JTextField name, episode, totEp;
    private JLabel nameLabel, episodeLabel, totEpLabel, statusLabel, ratingLabel, movieLabel;
    private JComboBox status, rating, movie;
    private JPanel fieldPanel, comboPanel, clPanel, flPanel, leftPanel, rightPanel;
    final int textLength = 15;
    
    public TextPanel(){
        fieldPanel = new JPanel();
        comboPanel = new JPanel();
        clPanel = new JPanel();
        flPanel = new JPanel();
        leftPanel = new JPanel();
        rightPanel = new JPanel();
        
        nameLabel = new JLabel("Name: ");
        episodeLabel = new JLabel("Episode: ");
        totEpLabel = new JLabel("Total: ");
        statusLabel = new JLabel("Status: ");
        ratingLabel = new JLabel("Rating: ");
        movieLabel = new JLabel("Movie: ");
        
        name = new JTextField();
        name.setColumns(textLength);
        episode = new JTextField();
        episode.setColumns(textLength);
        totEp = new JTextField();
        totEp.setColumns(textLength);
        
        status = new JComboBox();
        status.addItem("NOT FINISHED");
        status.addItem("FINISHED");
        
        rating = new JComboBox();
        for(int i = 0; i <= 10; i++){
            rating.addItem(i);
        }
        
        movie = new JComboBox();
        movie.addItem("NO");
        movie.addItem("YES");
        
        
        //CHANGE ALL TO GRIDLAYOUT
        flPanel.setLayout(new GridLayout(0, 1, 0, 5));
        flPanel.add(nameLabel);
        flPanel.add(episodeLabel);
        flPanel.add(totEpLabel);
        
        clPanel.setLayout(new GridLayout(0, 1, 0, 10));
        clPanel.add(statusLabel);
        clPanel.add(ratingLabel);
        clPanel.add(movieLabel);
        
        fieldPanel.setLayout(new GridLayout(0, 1, 0, 5));
        fieldPanel.add(name);
        fieldPanel.add(episode);
        fieldPanel.add(totEp);
        
        comboPanel.setLayout(new GridLayout(0, 1, 0, 5));        
        comboPanel.add(status);
        comboPanel.add(rating);
        comboPanel.add(movie);
        
        leftPanel.add(BorderLayout.WEST, flPanel);
        leftPanel.add(BorderLayout.EAST, fieldPanel);
        rightPanel.add(BorderLayout.WEST, clPanel);
        rightPanel.add(BorderLayout.EAST, comboPanel);
        
        setLayout(new BorderLayout());
        add(BorderLayout.WEST, leftPanel);
        add(BorderLayout.EAST, rightPanel);
    }
    
    public String getName()
    {return name.getText();}
    
    public int getEpisodes(){
        String eps = episode.getText();
        System.out.println("EPS = " + eps);
        if(eps.isEmpty())
            return 0;
        else
            return Integer.parseInt(eps);
    }
    
    public int getTotEps(){
        String eps = totEp.getText();
        System.out.println("TOT EPS = " + eps);
        if(eps.isEmpty())
            return 0;
        else
            return Integer.parseInt(eps);        
    }
    
    public boolean getMovie(){
        String m = (String) movie.getSelectedItem();
        if(m.equalsIgnoreCase("YES"))
            return true;
        else
            return false;
    }
    
    public boolean getFin(){
        String s = (String) status.getSelectedItem();
        if(s.equalsIgnoreCase("FINISHED"))
            return true;
        else
            return false;
    }
    
    public int getRating()
    {return (int) rating.getSelectedItem();}
    
    public void resetFields(){
        name.setText("");
        episode.setText("");
        totEp.setText("");
        status.setSelectedIndex(0);
        movie.setSelectedIndex(0);
        rating.setSelectedIndex(0);
    }
    
    public void setName(String name){
        this.name.setText(name);
    }
    
    public void setEpisodes(int episode){
        this.episode.setText(Integer.toString(episode));
    }
    
    public void setTotEps(int totEp){
        this.totEp.setText(Integer.toString(totEp));
    }
    
    public void setMovie(boolean m){
        if(m)
            movie.setSelectedItem("YES");
        else
            movie.setSelectedItem("NO");
    }
    
    public void setRating(int n){
        rating.setSelectedItem(n);
    }
    
    public void setFin(boolean f){
        if(f)
            status.setSelectedItem("FINISHED");
        else
            status.setSelectedItem("NOT FINISHED");
    }
}
