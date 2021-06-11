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
public class AdminOrUser extends JFrame {
 

       JButton b1,b2;
    
    AdminOrUser(){
        setSize(300,400);
        setLayout(new GridLayout(2,1));
        
        
        b1= new JButton("Admin");
        b2= new JButton("User");
        
        add(b1);
        add(b2);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //registration
        MyActionListener a= new MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);
    }
    
    public class MyActionListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e){
            
            if (e.getActionCommand() == "Admin")
            {
                dispose();
                login l = new login();
            }
             if (e.getActionCommand() == "User")
            {
                dispose();
                displayAllSongs d=new displayAllSongs();
            }
            
        }
        
    }
    
}