/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms_test1;

/**
 *
 * @author SUHANEE PATEL
 */
import java.sql.*;
import java.util.stream.Stream;

public class pro_temp {

    interface WhyUNoCheckedExceptionRunnable {

        void run() throws Exception;
    }

    static void logServerOutput(
            Connection connection,
            WhyUNoCheckedExceptionRunnable runnable
    ) throws Exception {
        try (Statement s = connection.createStatement()) {
            try {
                s.executeUpdate("begin dbms_output.enable(); end;");
                runnable.run();

                try (CallableStatement call = connection.prepareCall(
                        "declare "
                        + "  num integer := 50;"
                        + "begin "
                        + "  dbms_output.get_lines(?, num);"
                        + "end;"
                )) {
                    call.registerOutParameter(1, Types.ARRAY,
                            "DBMSOUTPUT_LINESARRAY");
                    call.execute();

                    Array array = null;
                    try {
                        array = call.getArray(1);
                        if(array != null){
                        Stream.of((Object[]) array.getArray())
                                .forEach(System.out::println);
                        }
                    } finally {
                        if (array != null) {
                            System.out.println("HERE");
                        }
                    }
                }
            } finally {
                s.executeUpdate("begin dbms_output.disable(); end;");
            }
        }
    }

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
