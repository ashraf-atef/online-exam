/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package online_exam;

import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.swing.JOptionPane;
//import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
//import sun.security.util.BigInt;

/**
 *
 * @author ashraf
 */
public class connection {
    
     final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static Connection conn = null;
    static Statement stmt = null;

    // String unicode= "?useUnicode=true&amp;characterEncoding=utf8 ";
    void conn(String user_name, String password) throws ClassNotFoundException, SQLException {
        String unicode = "?useUnicode=yes&characterEncoding=UTF-8";
        String ip = JOptionPane.showInputDialog(null, "ip");
        final String DB_URL = "jdbc:mysql://" + ip + "/online_exam";
        final String USER = user_name;
        final String PASS = password;

        JOptionPane.showMessageDialog(null, USER + " " + PASS);
        Class.forName("com.mysql.jdbc.Driver");

        conn = DriverManager.getConnection(DB_URL + unicode, USER, PASS);
        stmt = conn.createStatement();
        System.out.println("Connecting to database...");
    }

String time_now() {
     String output="";
     try {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar c = Calendar.getInstance();
        c.setTime(c.getTime()); // Now use today date.

        output = sdf.format(c.getTime());
        System.out.println(output);
     }catch (Exception e){}
        return output;
    }
    ResultSet search_admin(String user_name , String password)
    { ResultSet rs =null;
        try {
            stmt=conn.createStatement();
           rs=stmt.executeQuery("select * from admins where user_name='"+user_name+"' and password='"+password+"'");
      
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
         return rs ; 
    }
     ResultSet search_student_login(String user_name , String password)
    { ResultSet rs =null;
        try {
            stmt=conn.createStatement();
           rs=stmt.executeQuery("select * from students where user_name='"+user_name+"' and password='"+password+"'");
      
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
         return rs ; 
    }
}
