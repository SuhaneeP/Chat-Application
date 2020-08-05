/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms_test1;

import java.sql.*;

/**
 *
 * @author SUHANEE PATEL
 */
public class Dbms_test1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       Connection conn = null;
        try{
            String driverName = "oracle.jdbc.OracleDriver";
            Class.forName(driverName);
            String serverName = "LAPTOP-HM1ODVV9";
            String serverPort = "1521";
            String sid = "XE";
            String url = "jdbc:oracle:thin:@" + serverName +":" + serverPort + ":" + sid;
            String username = "Suhanee";
            String password = "Suhanee";
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Successful login");
        }catch(Exception e){
           System.out.println("Exception caught --> " + e); 
        }
        
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from testing");
            while(rs.next()){
                int no = rs.getInt(1);
                String name = rs.getString(2);
                System.out.println("no: "+no+" name: "+name);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
