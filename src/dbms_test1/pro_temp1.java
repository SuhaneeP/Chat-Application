/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms_test1;

import static dbms_test1.pro_temp.logServerOutput;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author SUHANEE PATEL
 */
public class pro_temp1 {
     public static void main(String[] args) throws SQLException, Exception {
        Connection conn = null;
        try {
            String driverName = "oracle.jdbc.OracleDriver";
            Class.forName(driverName);
            String serverName = "LAPTOP-HM1ODVV9";
            String serverPort = "1521";
            String sid = "XE";
            String url = "jdbc:oracle:thin:@" + serverName + ":" + serverPort + ":" + sid;
            String username = "Suhanee";
            String password = "Suhanee";
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Successful login");
        } catch (Exception e) {
            System.out.println("Exception caught --> " + e);
        }

        try (
                Statement s = conn.createStatement()) {
                 logServerOutput(conn, ()
                    -> s.executeUpdate("begin p1(1); end;"));
        }
    }
}
