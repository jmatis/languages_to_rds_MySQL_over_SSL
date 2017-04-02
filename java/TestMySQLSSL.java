import java.sql.*;
import java.util.*;

public class TestMySQLSSL {
        public static void main (String[] args) {
                // update your url variable to your database
                String url = "jdbc:mysql://someRDSurl.rds.amazonaws.com:3306/somedatabase";
                String sslurl = url + "?verifyServerCertificate=true"+
                                        "&useSSL=true"+
                                        "&requireSSL=true";
                // update user and password variables to your login and password
                String user = "login";
                String password = "passwd";
                
                Connection con = null;
                try {
                        System.out.println("Before loading SQLServerDriver:");
                        listDrivers();
                        Class.forName("com.mysql.jdbc.Driver") ;
                        System.out.println("After loading SQLServerDriver:");
                        listDrivers();
                } catch (Exception e) {
                        System.err.println("Exception: "+e.getMessage());
                }
                try {
                        Class dbDriver = Class.forName("com.mysql.jdbc.Driver");
                        con = DriverManager.getConnection(sslurl, user, password);
                }
                catch (Exception e) {
                        e.printStackTrace();
                }
                Statement stmt = null;
                ResultSet rs = null;

                try {
                        stmt = con.createStatement();
                        if (stmt.execute("SHOW STATUS like 'Ssl_cipher'")) {
                                rs = stmt.getResultSet();
                                //System.out.println(rs.getString(2));
                                ResultSetMetaData rsmd = rs.getMetaData();
                                int columnsNumber = rsmd.getColumnCount();
                                while (rs.next()) {
                                        for (int i = 1; i <= columnsNumber; i++) {
                                                if (i > 1) System.out.print(",  ");
                                                String columnValue = rs.getString(i);
                                                System.out.print(columnValue + " " + rsmd.getColumnName(i));
                                        }
                                        System.out.println("");
                                }
                        }
                }
                catch (SQLException e){
                        System.err.println("SQLException: " + e.getMessage());
                        System.err.println("SQLState: " + e.getSQLState());
                        System.err.println("VendorError: " + e.getErrorCode());
                } finally {
                        if (rs != null) {
                                try {
                                        rs.close();
                                } catch (SQLException sqlEx) { } // ignore
                                rs = null;
                        }
                        if (stmt != null) {
                                try {
                                        stmt.close();
                                } catch (SQLException sqlEx) { } // ignore
                                stmt = null;
                        }
                        if (con != null) {
                                try {
                                        con.close();
                                } catch (Exception e) {
                                        e.printStackTrace();
                                }
                        }
                }
        }

        private static void listDrivers() {
                Enumeration driverList = DriverManager.getDrivers();
                while (driverList.hasMoreElements()) {
                        Driver driverClass = (Driver) driverList.nextElement();
                        System.out.println("   "+driverClass.getClass().getName());
                }
        }
}
