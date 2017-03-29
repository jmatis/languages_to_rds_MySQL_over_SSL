import java.sql.*;
import java.util.*;


public class TestMySQLSSL
{
        public static void main (String[] args)
        {
                // update your url variable to your database
                String url = "jdbc:mysql://someRDSurl.rds.amazonaws.com:3306/somedatabase";
                String sslurl = url +
                                "?verifyServerCertificate=true"+
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
                try
                {
                        Class dbDriver = Class.forName("com.mysql.jdbc.Driver");
                        con = DriverManager.getConnection(sslurl, user, password);
                }
                catch (Exception e)
                {
                        e.printStackTrace();
                }
                finally
                {
                        if (con != null)
                        {
                                try
                                {
                                        con.close();
                                }
                                catch (Exception e)
                                {
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
