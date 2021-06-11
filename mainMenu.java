/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secproject;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Lenovo
 */
public class mainMenu extends JFrame{
    JButton b1, b2,b3,b4,b9;
    mainMenu()
    {
        setSize(400,500);
        setLayout(new GridLayout(8,1));
        
        b1= new JButton("Add Song");
        b2= new JButton("Delete Song");
        b3=new JButton("Search song");
        b4= new JButton("Display All Songs");
        
        b9= new JButton("HOME");
        
        MyActionListener m = new MyActionListener();
        
        b1.addActionListener(m);
        b2.addActionListener(m);
        b3.addActionListener(m);
        b4.addActionListener(m);
        b9.addActionListener(m);
        
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b9);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public class MyActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equalsIgnoreCase("Add Song"))
            {
                dispose();
                addSong add = new addSong();
            }
             if (e.getActionCommand().equalsIgnoreCase("Delete song"))
            {
                dispose();
                deleteSong del = new deleteSong();
            }
             
            if (e.getActionCommand().equalsIgnoreCase("Search Song"))
            {
                dispose();
                searchSong s= new searchSong();
                
                
            }
            
            if (e.getActionCommand().equalsIgnoreCase("Display All Songs"))
            {
                dispose();
                displayAllSongs d= new displayAllSongs();
                
                
            }
            
            
            
            if (e.getActionCommand() == "HOME")
            {
                dispose();
                AdminOrUser a=new AdminOrUser();
                
            }
        }
    }
    
}
