/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secproject;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 *
 * @author Lenovo
 */
public class searchSong extends JFrame{
    JButton b1,b2;
    JLabel l1;
    JPanel p1,p2;
    JTextField t1;
    
    searchSong()
    {
        setSize(800,400);
        setLayout(new BorderLayout());
        
        l1=new JLabel("Enter song name which you want to search");
        t1=new JTextField(20);
        b1=new JButton("Search");
        b2=new JButton("Main Menu");
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(1,2));
        
        p2=new JPanel();
        p2.setLayout(new FlowLayout());
        
        p1.add(l1);
        p1.add(t1);
        
        add(p1,BorderLayout.CENTER);
        add(p2,BorderLayout.SOUTH);
        
        p2.add(b1);
        p2.add(b2);
        
        b1.addActionListener(new MyListener());
        b2.addActionListener(new MyListener());
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
    
    public class MyListener implements ActionListener
            
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equalsIgnoreCase("search"))
            {
                
                if(t1.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"ERROR! FIELD IS BLANK");
                }
                else if(songs.searchSong(t1.getText()))
                { 
                   
                   JOptionPane.showMessageDialog(null, "SONG FOUND SUCCESSFULLY");
                }
                else
                    JOptionPane.showMessageDialog(null, "SONG NOT FOUND");
                
            }
            if (e.getActionCommand().equalsIgnoreCase("Main Menu"))
            {
                dispose();
                mainMenu m = new mainMenu();
            }
        
    }
    }}
