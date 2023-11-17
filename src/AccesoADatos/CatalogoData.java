
package AccesoADatos;

import Entidades.Catalogo;
import Entidades.Especie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class CatalogoData {
    //Especie especie;
    Connection conexion;
    String msj=null;String sql="";
    public Integer  totalRegistros;
    public CatalogoData(){
        conexion=Conexion.getConexion();
    }
    
    public DefaultTableModel mostrarCatalogo(String dato){
        
        
            DefaultTableModel modelo;
            String [] titulos = {"ID","Especie","Nombre","Variedad","Mac","Stock","Precio","Peso"};
            String [] registros = new String [8];
            totalRegistros = 0;
            modelo= new DefaultTableModel(null,titulos);
//                public boolean idCellEditable(int f,int c){
//                    return false;
//                }
//            };
         String sql="SELECT * FROM catalogo";
         String sql1="SELECT * FROM catalogo Where especie= "+dato+"";
         try {  
           
            Statement st=conexion.createStatement();
            ResultSet rs=st.executeQuery(sql);
            
            while(rs.next()){
            registros [0]=rs.getString("id_Catalogo");
            registros [1]=rs.getString("especie");
            registros [2]=rs.getString("nombre");
            registros [3]=rs.getString("var");
            registros [4]=rs.getString("mac");
            registros [5]=rs.getString("stock");
            registros [6]=rs.getString("precio");
            registros [7]=rs.getString("peso");
            
            totalRegistros=totalRegistros+1;
            modelo.addRow(registros);
            }
            return modelo;
        } catch (SQLException ex) {
        msj="Error en metodo mostrarCatalogo/CatalogoData/linea 28 . "+ex.getMessage();
            mensaje(msj);
        return null;
        }
         
    }
    public DefaultTableModel filtrar(String [] f){
          DefaultTableModel modelo;
            String [] titulos = {"ID","Especie","Nombre","Variedad","Mac","Stock","Precio","Peso"};
            String [] registros = new String [8];
            totalRegistros = 0;
            modelo= new DefaultTableModel(null,titulos);
//                public boolean idCellEditable(int f,int c){
//                    return false;
//                }
//            };
         String coma=" , ";
         String sql="SELECT * FROM catalogo WHERE ";
         String sql1=" id_Catalogo="+f[0];
         String sql2=" especie="+f[1];
         String sql3=" nombre="+f[2];
         String sql4=" var ="+f[3];
         String sql5=" mac="+f[4];
         String sql6="stock="+f[5];
         String sql7=" precio="+f[6];
         String sql8=" peso="+f[7];
         
         while(f.length==1){
             if(f[0]!=null){
                 sql=sql+coma+sql1;
             }else if(f[1]!=null ){
                 sql=sql+coma+sql2;
             }else if(f[2]!= null){
         sql=sql=sql+coma+sql3;   
         }else if(f[3]!= null){
         sql=sql=sql+coma+sql4;   
         }else if(f[4]!= null){
         sql=sql=sql+coma+sql5;   
         }else if(f[5]!= null){
         sql=sql=sql+coma+sql6;   
         }else if(f[6]!= null){
         sql=sql=sql+coma+sql7;   
         }else if(f[7]!= null){
         sql=sql=sql+coma+sql8;   
         }
            
//             if(f[0]!=null){
//                 sql=sql+coma+sql1;
//             }else{sql=sql;}
//             
//         if(f[1]!=null ){
//                 sql=sql+coma+sql2;
//             }else{sql=sql;}
//         
//         if(f[2]!= null){
//         sql=sql=sql+coma+sql3;   
//         }else{sql=sql;}
//         
//         if(f[3]!= null){
//         sql=sql=sql+coma+sql4;   
//         }else{sql=sql;}
//         
//         if(f[4]!= null){
//         sql=sql=sql+coma+sql5;   
//         }else{sql=sql;}
//         
//         
//         if(f[5]!= null){
//         sql=sql=sql+coma+sql6;   
//         }else{sql=sql;}
//         
//         if(f[6]!= null){
//         sql=sql=sql+coma+sql7;   
//         }else{sql=sql;}
//         
//         if(f[7]!= null){
//         sql=sql=sql+coma+sql8;   
//         }else{sql=sql;}
//            
         
         }
        
        
         try {  
           
            Statement st=conexion.createStatement();
            ResultSet rs=st.executeQuery(sql);
            
            while(rs.next()){
            registros [0]=rs.getString("id_Catalogo");
            registros [1]=rs.getString("especie");
            registros [2]=rs.getString("nombre");
            registros [3]=rs.getString("var");
            registros [4]=rs.getString("mac");
            registros [5]=rs.getString("stock");
            registros [6]=rs.getString("precio");
            registros [7]=rs.getString("peso");
            
            totalRegistros=totalRegistros+1;
            modelo.addRow(registros);
            }
            return modelo;
        } catch (SQLException ex) {
        msj="Error en metodo filtrarCatalogo/CatalogoData/linea 60 . "+ex.getMessage();
            mensaje(msj);
        return null;
        }
         
        
    }
    
    public boolean isCellEditable(int f ,int c){
         return false;   
        }
    public void guardarCatalogo(Catalogo catalogo){
        //funciona
        try {
            
            sql="INSERT INTO catalogo(especie,nombre,var,mac,stock,precio, peso)"
                    +" VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps=conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, catalogo.getEspecie()+"");
            ps.setString(2, catalogo.getNombre());
            ps.setString(3, catalogo.getVar());
            ps.setDouble(4, catalogo.getMac());
            ps.setInt(5, catalogo.getStock());
            ps.setDouble(6, catalogo.getPrecio());
            ps.setDouble(7, catalogo.getPeso());
            ps.executeUpdate();
             ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                catalogo.setIdCatalogo(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Catalogo guardado");
            }
            ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Error al cargar Catalogo ");
        }
        
    }
    public void elimniarCatalogo(int id){
       sql=" UPDATE catalogo SET stock=0 WHERE idCatalogo=?";

        try{
        PreparedStatement PS=conexion.prepareStatement(sql);
        PS.setInt(1, id);
        int fila= PS.executeUpdate();
        if(fila==1){
        JOptionPane.showMessageDialog(null, "Catalogo"+id +" Eliminado");
        }
        PS.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar Catalogo"+id +e.getMessage());
        }
    }
    
    public void eliminarCatalogoDefinitivo(int id){
        try {
            sql="DELETE FROM catalogo WHERE catalogo.id_catalogo= ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1,id);
            int a=ps.executeUpdate();
            if(a==1){
              msj="Catalogo Eliminado";
              mensaje(msj);     
            }else{
                msj="No se pudo eliminar el catalogo";
                mensaje(msj);
            }
        } catch (SQLException ex) {
            msj="Error al acceder al Catalogo";
            mensaje(msj);
        }
    }
    
    public void modificar(Catalogo catalogo){
        sql="UPDATE catalogo SET especie=?,nombre = ? , var = ? ,"
                + "mac= ? , stock = ? ,precio = ? , peso = ?"
                 + "  WHERE catalogo.id_catalogo= ?";
       
        try {
            
            PreparedStatement ps = conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
           
            ps.setString(1, catalogo.getEspecie()+"");
            ps.setString(2,catalogo.getNombre());
            ps.setString(3,catalogo.getVar());
            ps.setDouble(4, catalogo.getMac());
            ps.setInt(5,catalogo.getStock());
            ps.setDouble(6, catalogo.getPrecio());
            ps.setDouble(7, catalogo.getPeso());
            ps.setInt(8, catalogo.getIdCatalogo());
            
            int exito= ps.executeUpdate();
            if (exito==1) {
                JOptionPane.showMessageDialog(null, "Catalogo modificado ");
             
         } else{
              JOptionPane.showMessageDialog(null, "Catalogo no encontrado");
            }
            
        } catch (SQLException ex) {
        msj="Error al modificar catalogo en CatalogoData"+catalogo.getIdCatalogo()+ex.getMessage();    
        mensaje(msj);  
        }
    }
    public List <Catalogo> listarCatalogo(){
         List <Catalogo> cat=new ArrayList<>();
         
        try {
            sql="SELECT * FROM catalogo";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                

                
                //Especie especie=(Especie.valueOf(rs.getString("Drosera")));
                //Especie especie = (Especie.valueof(Especie rs.getObject("especie");
                Catalogo catalogo=new Catalogo();
                
                catalogo.setIdCatalogo(rs.getInt("id_Catalogo"));
                catalogo.setEspecie(Especie.valueOf((rs.getString("especie"))));
                catalogo.setNombre(rs.getString("nombre"));
                catalogo.setNombre(rs.getString("var"));
                catalogo.setMac(rs.getDouble("mac"));
                catalogo.setStock(rs.getInt("stock"));
                catalogo.setPrecio(rs.getDouble("precio"));
                catalogo.setPeso(rs.getDouble("peso"));
                
                cat.add(catalogo);
            }
            ps.close();
        } catch (SQLException ex) {
            msj="Error al listar Catalogo "+ex.getMessage();
            mensaje(msj);
        }
        return cat;
    }
    
    
    public void mensaje(String msj){
JOptionPane.showMessageDialog(null,msj);
}
    
    
    
    
}
