
package AccesoADatos;

import Entidades.Catalogo;
import Entidades.Cliente;
import Entidades.Pedido;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class PedidoData {
 Catalogo catalago;
 Cliente cliente ;
 Connection conexion;

ArrayList <Catalogo>cat = new ArrayList<>(); 
 public PedidoData () {
     conexion=Conexion.getConexion();
 }
 
 public void guardarPedido(Pedido pedido){
 String sql="INSERT INTO pedidos(fecha,id_cliente,id_catalogo,metodoDePago,entrega,empresa,opcion,seguimiento,despacho,recibido,tel,pago,anotaciones)"+
         " VALUES (? ,? ,? ,? ,? ,? ,? ,? ,?,?,?,?,? )";
 for(Catalogo c : cat)    
 try {
         PreparedStatement ps = conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
         ps.setDate(1,Date.valueOf(pedido.getFecha()));
         ps.setInt(2,pedido.getCliente().getIdCliente());
         ps.setInt(3,pedido.getCatalogo().getIdCatalogo());
         ps.setString(4,pedido.getMetodoDePago());
         ps.setString(5,pedido.getEntrega());
         ps.setString(6,pedido.getEmpresa());
         ps.setString(7, pedido.getOpcion());
         ps.setString(8,pedido.getSeguimiento());
         ps.setDate(9, Date.valueOf(pedido.getDespacho()));
         ps.setDate(10,Date.valueOf(pedido.getRecibido()));
         ps.setString(11,pedido.getTel());
         ps.setBoolean(12, pedido.isPago());
         ps.setString(13,pedido.getAnotaciones());
         ps.executeUpdate();
         ResultSet rs = ps.getGeneratedKeys();
         if(rs.next()){
             pedido.setIdPedido(rs.getInt(1));
             String m="Pedido guardado ";
             msj(m);
         }
         
     } catch (SQLException ex) {
     String m="Error al guardar pedido  ."+ex.getMessage();
     msj(m);
     }
 
 
 } 
 
 
 
 
 
public void msj(String m){
JOptionPane.showMessageDialog(null,m);    
}   
}
