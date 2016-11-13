package Main;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ярослав
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Config {
    private static final String PROPERTIES_FILE = "./config.properties";

    public static String IP_BROADCAST;
    public static int PORT;
    

    static {
        Properties properties = new Properties();
        FileInputStream propertiesFile = null;
        

        try {
            propertiesFile = new FileInputStream(PROPERTIES_FILE);
            properties.load(propertiesFile);

            IP_BROADCAST    = properties.getProperty("IP_BROADCAST");
            PORT             = Integer.parseInt(properties.getProperty("PORT"));
            

        } catch (FileNotFoundException ex) {
           File flt = new File("config.properties");
            try {
                
                FileWriter wrt = new FileWriter(flt);
                wrt.append("IP_BROADCAST=192.168.0.255"+"\n");
                wrt.append("PORT=2002");
                wrt.flush();
                wrt.close();
                propertiesFile = new FileInputStream(PROPERTIES_FILE);
            properties.load(propertiesFile);

            IP_BROADCAST    = properties.getProperty("IP_BROADCAST");
            PORT             = Integer.parseInt(properties.getProperty("PORT"));
            
            
                         
            } catch (IOException ex1) {
                
            }
        } catch (IOException ex) {
            
        } finally {
            try {
                propertiesFile.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
