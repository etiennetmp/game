/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonapplication;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Iterator;

/**
 *
 * @author 20693
 */
public class JsonApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        JSONParser parser = new JSONParser(); 
        try { 
            
            Object obj = parser.parse(new FileReader("Z:\\test.json")); 
            
            JSONObject jsonObject = (JSONObject) obj; 
            System.out.println(jsonObject); 
            
            String name = (String) jsonObject.get("Product name"); 
            System.out.println(name); 
            
            long age = (Long) jsonObject.get("anumber"); 
            System.out.println(age); 
            
            // loop array 
            JSONArray msg = (JSONArray) jsonObject.get("Main processors"); 
            Iterator<String> iterator = msg.iterator(); 
            while (iterator.hasNext()) {
                System.out.println(iterator.next()); 
            }
        
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
                e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } 
    }
    
}
