
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
import javax.swing.table.DefaultTableModel;


public class PedidoData {
 Catalogo catalago;
 Cliente cliente ;
 Connection conexion;
public Integer totalRegistros;
String sql ,msj;
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
 
 public DefaultTableModel mostrarPedido(String dato){

         DefaultTableModel modelo;
         totalRegistros=0;
         String []titulos={"Id","Cliente","Catalogo","Pago","Entrega","Empresa","Opcion","Seguimiento","Despacho","Recibido","Celular","Pago","Anotaciones"};
         String []registros =new String[14];
         modelo= new DefaultTableModel(null,titulos);
         sql="SELECT * FROM pedidos";
    try {    
         Statement st =conexion.createStatement();
         ResultSet rs=st.executeQuery(sql);
         
         while(rs.next()){
         registros[0]=rs.getString("id_pedido");
         registros[1]=rs.getString("fecha");
         registros[2]=rs.getString("id_cliente");
         registros[3]=rs.getString("id_Catalogo");
         registros[4]=rs.getString("metodoDePago");
         registros[5]=rs.getString("entrega");
         registros[6]=rs.getString("empresa");
         registros[7]=rs.getString("opcion");
         registros[8]=rs.getString("seguimiento");
         registros[9]=rs.getString("despacho");
         registros[10]=rs.getString("recibido");
         registros[11]=rs.getString("tel");
         registros[12]=rs.getString("pago");
         registros[13]=rs.getString("anotaciones");

         totalRegistros=totalRegistros+1;
         modelo.addRow(registros);
             
         }
         return modelo;
     } catch (SQLException ex) {
msj="Error al mostrar Tabla Pedidos /PedidoData/mostrarPedido.  "+ex.getMessage();
msj(msj);
return null;
     }
 
 }
 
public void msj(String m){
JOptionPane.showMessageDialog(null,m);    
}   
}
