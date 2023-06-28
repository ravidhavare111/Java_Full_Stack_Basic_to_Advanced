/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swingdemo;

import java.awt.Image;
import java.io.*;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * 
 * 
 * 
 *
 * @author HP
 */
public class Helper {
    public static ImageIcon getImageIconByID(int id, Connection con){
        ImageIcon icon = null;
        
        try{
            
            String query = "select pic from images where id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            
            pstmt.setInt(1, id);
            
            ResultSet table = pstmt.executeQuery();
            
            while(table.next()){
                Blob b = table.getBlob("pic");
                
            InputStream is = b.getBinaryStream();
            
            Image image = ImageIO.read(is);
            
            icon = new ImageIcon(image);
            
            }

            
        
        }
        catch(Exception e){
        e.printStackTrace();
        }
        
        
        
        return icon;
    }
    
}
