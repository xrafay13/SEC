/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secproject;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author hmahm
 */
public class login extends JFrame {
    JButton b1,b2;
    JTextField t1;
    JPasswordField t2;
    JLabel l1,l2;
    
    login()
    {
        setSize(400,150);
        setLayout(new FlowLayout());
        
        l1=new JLabel("Enter Username ");
        t1=new JTextField(20);
        
        l2=new JLabel("Enter Password ");
        t2=new JPasswordField(20);
        
        b1=new JButton("SUBMIT");
        b2=new JButton("HOME");
        
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(b1);
        add(b2);
   
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        MyActionListener m = new MyActionListener();
        b1.addActionListener(m);
        b2.addActionListener(m);
        
    
    }
    
    public class MyActionListener implements ActionListener
    {
        
        
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand() == "SUBMIT")
            {
                if (t1.getText().equalsIgnoreCase("admin") && t2.getText().equals("12345")){
                dispose();
                mainMenu m=new mainMenu();
            }
                else
                JOptionPane.showMessageDialog(null,"WrongEntry");
                
            }
            if (e.getActionCommand() == "HOME")
            {
                dispose();
                AdminOrUser a=new AdminOrUser();
                
            }
                
            
        }
    
    }
}
