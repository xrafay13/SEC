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
public class addSong extends JFrame{
    JButton b1,b2;
    JLabel l1,l2,l3;
    JTextField t1,t2,t3;
    JPanel p1,p2;
    
    addSong()
    {
        setSize(800,500);
        setLayout (new BorderLayout());
        
        l1 = new JLabel (" Enter song");
        
          
              
        t1 = new JTextField(20);
        
            
        b1 = new JButton("Submit");
        b2 = new JButton("Main Menu");
        
        p1 = new JPanel();
        p1.setLayout(new GridLayout(3,2));
        
         
         
        p2 = new JPanel();
        p2.setLayout(new FlowLayout());
              
        
            p1.add(l1);
            p1.add( t1);
            
            
            
            add(p1,BorderLayout.CENTER);
            add(p2, BorderLayout.SOUTH);
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
            try{
                
            if (e.getActionCommand().equalsIgnoreCase("Submit"))
            {
                if(t1.getText().isEmpty()){
                    
                    JOptionPane.showMessageDialog(null,"ENTER ALL FIELDS");
                }
                if(songs.searchSong(t1.getText()))
                {
                    JOptionPane.showMessageDialog(null, "ITEM ALREADY PRESENT");
                }
                else{
                    songs f1 = new songs (t1.getText());
           
          
                    songs.writeToFile(f1);
                    JOptionPane.showMessageDialog(null, "ADDED SUCCESSFULLY");
                }
            }
            }
            catch(NumberFormatException ex){ 
                
            } 
             
            if (e.getActionCommand().equalsIgnoreCase("Main Menu"))
            {
                dispose();
                mainMenu m = new mainMenu();
            }
        }
    }
    }

