
package conexion;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class conexion {
    Connection con;
    public conexion(){
        try {
                Class.forName("com.mysql.jdbc.Driver");
                con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dbcolegios","root","");
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null ,"ERROR"+e);
           
        }
    }
    public Connection getConnection(){
    return con;
    }
//       public static void main(String[] args) {
//        conexion cn=new conexion();
//        Statement st;
//        ResultSet rs;
//        try {
//            st=cn.con.createStatement();
//            rs=st.executeQuery("select * from login");
//            while (rs.next()) {                
//                System.out.println(rs.getInt("ID")+" " +rs.getString("usuarios")+" " +rs.getString("claves"));
//            }
//            cn.con.close();
//        } catch (Exception e) {
//             System.err.println("Error:" +e);
//        }
//        
//    }
}
