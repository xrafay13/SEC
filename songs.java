/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secproject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class songs implements Serializable{
    String name;
    
    
    songs()
    {}
    
    songs(String name)
    {
        this.name=name;
        
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    
    

    @Override
    public String toString() {
        return "song{" + "name=" + name + "}'";
    }
    
    public static boolean searchSong(String s)
    {
        ArrayList<songs> array=readFromFile();
        
        for(songs f : array)
        {
            if(f.getName().equalsIgnoreCase(s))
                return true;
            
        }
        return false;
    }
    
    public static void deleteSong(String s)
    {
        ArrayList<songs> array=songs.readFromFile();  
        
         for(songs f:array)
         {
           if(f.getName().equalsIgnoreCase(s)) {
            
            array.remove(array.indexOf(f));
            break;
           }
         }
         
         
        try
        {
        ObjectOutputStream output = new ObjectOutputStream ( new FileOutputStream ( "Song Details"));
        output.writeObject(array);
        output.close();
        }
        catch (IOException e)
        {
            
        }
         
        
    }
    
     
    
      
     
    public static void writeToFile(songs f )
    {
        ArrayList<songs> array = readFromFile();
        array.add(f);
        try
        {
        ObjectOutputStream output = new ObjectOutputStream ( new FileOutputStream ( "Song Details"));
        output.writeObject(array);
        output.close();
        }
        catch (IOException e)
        {
            
        }
        
    }
    
    public static ArrayList<songs> readFromFile( )
    {
        ArrayList<songs> array = new ArrayList<songs>();
       
        try
        {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("Song Details"));
            
                
            array = (ArrayList <songs>) input.readObject();
           
        }
        
        catch ( ClassNotFoundException c)
        {
            
        }
        catch ( ClassCastException c)
        {
            
        }
         catch ( IOException e)
        {
            
        }
        return array;
    }
            
            
       public static void displayAllDataFromFile()
       {
           ArrayList<songs> array = readFromFile();
           for (songs f: array)
           {
               System.out.println(f.toString());
           }
           
       }
}
