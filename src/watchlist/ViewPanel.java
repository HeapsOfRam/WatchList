/*
 * ViewPanel.java
 * Author: HeapsOfRam
 */
package watchlist;

import java.util.*;
import java.awt.*;
import javax.swing.*;

public class ViewPanel extends JPanel{
    private JList list;
    private DefaultListModel listModel;
    private JScrollPane scroll;
        
    public ViewPanel(){
        listModel = new DefaultListModel();
        list = new JList(listModel);
        
        //list.setPreferredSize(new Dimension(3000, 2000));
        
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(-1);
        
        scroll = new JScrollPane(list);
        scroll.setPreferredSize(new Dimension(585, 300));
        
        add(scroll);
    }
    
    public void addToModel(Show show){
        listModel.addElement(show);
    }
    
    public void removeFromModel(Show show){
        listModel.removeElement(show);
    }
    
    public Show getSelectedShow(){
        return (Show) list.getSelectedValue();
    }
}
