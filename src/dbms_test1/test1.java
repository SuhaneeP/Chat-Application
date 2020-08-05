/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms_test1;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author SUHANEE PATEL
 */
public class test1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
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
            ResultSet rs = st.executeQuery("Select * from history where userID='hardii' ");
            while(rs.next()){
                //int no = rs.getInt(1);
                String in = rs.getString(2);
                String out = rs.getString(3);
                Date d1=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").parse(in);
                 Date d2=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").parse(out);
                DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");  
                String intime = dateFormat.format(d1); 
                String outtime = dateFormat.format(d2); 
               // System.out.println("no: "+no+" date: "+d);
//               String  substr1 = intime.substring(11, 21);
//               String  substr2 = outtime.substring(11, 21);
               
                System.out.println(intime);
                 System.out.println(outtime);
               
//               int t1=Integer.parseInt(substr1);
//               int t2=Integer.parseInt(substr2);
//               
//                System.out.println(t2-t1);
//                DateTimeFormatter dtf = DateTimeFormatter.ofPattern(" HH:mm:ss");  
//                LocalDateTime now = LocalDateTime.now();  
//                System.out.println(dtf.format(now)); 
                
            }
//            String query = "INSERT INTO datetemp VALUES (2,sysdate)";
//            PreparedStatement pstmt = conn.prepareStatement(query);
//            pstmt.execute();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
//                Date date =Calendar.getInstance().getTime();  
//                DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
//                String strDate = dateFormat.format(date);  
//                System.out.println("Converted String: " + strDate);  
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
//   LocalDateTime now = LocalDateTime.now();  
//   System.out.println(dtf.format(now));  
    }
    
}
