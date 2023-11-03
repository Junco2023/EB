
package eb;

import AccesoADatos.CatalogoData;
import AccesoADatos.ClienteData;
import AccesoADatos.Conexion;
import AccesoADatos.PedidoData;
import Entidades.Catalogo;
import Entidades.Cliente;
import Entidades.Especie;
import Entidades.Pedido;
import java.sql.Connection;
import java.time.LocalDate;

public class EB {

    public static void main(String[] args) {
      Connection c = Conexion.getConexion();
      CatalogoData cd=new CatalogoData();
      //
      
      Especie especie=Especie.Nepenthes;
      String nombre="Ventrata";
      String var="sp"; 
      double mac=12;
      int stock=6; 
      double precio=5000;
      double peso=1;
      Catalogo c1=new Catalogo(especie,nombre,var,mac,stock,precio,peso);
      //funciona
      //cd.guardarCatalogo(c1);
      //cd.eliminarCatalogo(8);
      //cliente (nombre,apellido,localidad,provincia,direccion,cp,dni,telefono)
      String n="pepe";
      String a="sdsd";
      String l="f";
      String provincia="";
      String direccion ="dfdsf";
      String cp="1564";
      int dni=231232;
      int tel=1156892436;
    // Cliente jorge=new Cliente(n,a,l,provincia,direccion,cp,dni,tel);
    
     //ClienteData CLD=new ClienteData();
     //CLD.guardarCliente(jorge);
     //CLD.eliminarCliente(4);
     PedidoData pd=new PedidoData ();
     
     LocalDate fecha = LocalDate.of(2023,4,20);
     Catalogo catalogo;
     Cliente cliente;
     String MetodoDePago="EFectivo";
     String entrega="Envios";
     String empresa="via Cargo";
     String opcion="Sucursal";
     String seguimiento="sd7645675487AR";
     LocalDate despacho=LocalDate.of(2023, 4, 21);
     LocalDate recibido=LocalDate.of(2023, 5, 22);
     String telef= "1145645677";
     boolean pago = true;
     String anotaciones="Nada";
     //for(Catalogo cc: pd.){
         
    // }
     //Pedido p=new Pedido( fecha,jorge,c1, MetodoDePago, entrega, empresa,opcion,seguimiento,despacho,recibido,telef,pago,anotaciones);
     //Pedido p=new Pedido( fecha,jorge,c1, MetodoDePago, entrega, empresa,opcion,seguimiento,despacho,recibido,telef,pago,anotaciones);

     
    //pd.guardarPedido(p);
     
     //cd.listarCatalogo();
   for (Catalogo aa: cd.listarCatalogo()){
         System.out.println("Catalogo");
        System.out.println(aa.toString());
    }
    }    
}
