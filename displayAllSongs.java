/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secproject;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class displayAllSongs extends JFrame{
    JTable tb1; 
    JButton b1;
    
    displayAllSongs(){
        setSize(800,400);
        setLayout(new BorderLayout());
        
        tb1=new JTable(0,3 );
        DefaultTableModel model = (DefaultTableModel) tb1.getModel();
        
        ArrayList<songs> array=songs.readFromFile();
        Object rowData[] = new Object[3];
        for(int i = 0; i < array.size(); i++)
        {
            rowData[0] = array.get(i).name;
            model.addRow(rowData);
        }
        
        JScrollPane sp = new JScrollPane(tb1);
        add(sp,BorderLayout.CENTER);
        
        b1=new JButton("Main Menu");
        add(b1,BorderLayout.SOUTH);
        MyListener m = new MyListener();
        b1.addActionListener(m);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    public class MyListener implements ActionListener
    {
        
        
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equalsIgnoreCase("Main Menu"))
            {
                dispose();
                mainMenu m=new mainMenu();
            }
            
        }
    
    }
}
