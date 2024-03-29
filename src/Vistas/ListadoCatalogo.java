/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import AccesoADatos.CatalogoData;
import Entidades.Catalogo;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author matias
 */
public class ListadoCatalogo extends javax.swing.JInternalFrame {
    DefaultTableModel modelo=new DefaultTableModel();
private CatalogoData CD;
    /**
     * Creates new form Listado
     */
    public ListadoCatalogo(CatalogoData cat) {
        this.CD=cat;
        initComponents();
        cabecera();
        cargarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jcbFiltarEspecie = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jtBuscar = new javax.swing.JTextField();

        jLabel1.setText("Listado de Catalogo");

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Especie", "Nombre", "Variedad", "Maceta", "Stock", "Precio", "Peso"
            }
        ));
        jScrollPane1.setViewportView(Tabla);

        jLabel2.setText("Filtrar por Especie");

        jcbFiltarEspecie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todas", "Brocchinia", "Dionaea", "Drosera", "Nepenthes", "Pinguicula", "Sarracenia", "Stylidium", "Utricularia", " " }));

        jLabel3.setText("Buscar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(287, 287, 287))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jcbFiltarEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtBuscar)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbFiltarEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbFiltarEspecie;
    private javax.swing.JTextField jtBuscar;
    // End of variables declaration//GEN-END:variables

public void cargarTabla() {
        for (Catalogo c : CD.listarCatalogo()) {
            modelo.addRow(new Object[]{c.getIdCatalogo(),c.getEspecie(),c.getNombre(),c.getVar(),c.getMac(),c.getStock(),c.getPrecio(),c.getPeso()});
        }
}
public void cabecera(){
    modelo.addColumn("Id");
    modelo.addColumn("Especie");
    modelo.addColumn("Nombre");
    modelo.addColumn("Variedad");
    modelo.addColumn("Maceta");
    modelo.addColumn("Stock");
    modelo.addColumn("Precio");
    modelo.addColumn("Peso");
    Tabla.setModel(modelo);
                        
}

}
