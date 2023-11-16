
package AccesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Conexion {
    private static Connection conexion=null;
    private static final String driver  = "org.mariadb.jdbc.Driver";
    private static final String url="jdbc:mariadb://localhost/";
    private static final String DE= "exoticasbanfield";
    private static final String root="root";
    private static final String password="";
    
    public static Connection getConexion(){
        if(conexion==null){
               
            try {
                Class.forName(driver);
                conexion=DriverManager.getConnection(url+DE,root,password);
                JOptionPane.showMessageDialog(null,"Conectado");
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null,"Driver no conectado");
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Base de datos no encontrada");            }      
            } 
        
        return conexion ;
    }
}
