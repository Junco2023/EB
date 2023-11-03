
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


public class CatalogoData {
    //Especie especie;
    Connection conexion;
    String msj=null;String sql="";
    public CatalogoData(){
        conexion=Conexion.getConexion();
    }
    
    public void mostrarCatalogo(String c){
        //DefaultTableModel
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
    
    public void eliminarCatalogo(int id){
        try {
            sql="DELETE FROM catalogo WHERE catalogo.id_catalogo= ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1,id);
            int a=ps.executeUpdate();
            if(a==1){
              msj="Catalogo Eliminado";
              mensaje(msj);     
            }
        } catch (SQLException ex) {
            msj="Error al acceder al Catalogo";
            mensaje(msj);
        }
    }
    
    public void modificar(Catalogo catalogo){
        try {
            sql="UPDATE catalogo SET id_catalogo=? especie=?,nombre=?,var=?,mac=?',stock=?,precio=?,peso=?"
                    + "WHERE catalogo.id_catalogo=6";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1,catalogo.getIdCatalogo());
            ps.setString(2, catalogo.getEspecie()+"");
            ps.setString(3,catalogo.getNombre());
            ps.setString(4,catalogo.getVar());
            ps.setDouble(5, catalogo.getMac());
            ps.setInt(6,catalogo.getStock());
            ps.setDouble(7, catalogo.getPrecio());
            ps.setDouble(8, catalogo.getPeso());
        } catch (SQLException ex) {
        msj="Error al modificar catalogo "+catalogo.getIdCatalogo();    
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
