
package AccesoADatos;


import Entidades.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ClienteData {
    Cliente cliente; 
    Connection conexion;
    
    String msj;String sql;
    
 public ClienteData(){
     conexion=Conexion.getConexion();
 }   
 
 //funciona
 public void guardarCliente(Cliente cliente){
        try {
            sql="INSERT INTO cliente (nombre,apellido,localidad,provincia,direccion,cp,dni,telefono)" +
                    "VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps=conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cliente.getNombre());
            ps.setString(2,cliente.getApellido());
            ps.setString(3, cliente.getLocalidad());
            ps.setString(4, cliente.getProvincia());
            ps.setString(5,cliente.getDireccion());
            ps.setString(6, cliente.getCp());
            ps.setInt(7, cliente.getDni());
            ps.setInt(8, cliente.getTelefono());
            ps.executeUpdate();
            
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                cliente.setIdCliente(rs.getInt(1));
                msj="Cliente Guardado";
                mensaje(msj);
            }
            ps.close();
        } catch (SQLException ex) {
            msj="Error al Guardar el Cliente ..  "+ex.getMessage();
            mensaje(msj);
        }
     
 }
    
 public void eliminarCliente(int id){
     sql="DELETE FROM cliente WHERE cliente.id_cliente= ?";
     
        try {
            PreparedStatement ps= conexion.prepareStatement(sql);
            ps.setInt(1,id);
            if(ps.executeUpdate()==1){
                msj="Cliente "+cliente.getNombre()+"eliminado";
                mensaje(msj);
            }else{
                
            }
        } catch (SQLException ex) {
           msj="Error al intentar eliminar Cliente";mensaje(msj);
        }
     
 }   
    
    
    
 public void mensaje(String msj){
     JOptionPane.showMessageDialog(null, msj);
 }   
}
