/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas;

import Controladores.ControladorArtista;
import Controladores.ControladorDisco;
import Modelos.Artista;
import Modelos.Disco;
import java.awt.BorderLayout;
import java.util.TreeMap;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author agust
 */
public class DiscosPanel extends javax.swing.JPanel {

    /**
     * Creates new form DiscosPanel
     */
    public DiscosPanel() {
        initComponents();
        setVisible(true);
    }
    public void MostrarLista(String filtro) {  
        TreeMap<Integer,Disco> discos;
        ControladorDisco control = new ControladorDisco();
        DefaultTableModel model = new DefaultTableModel();
        
        discos = control.getDiscos();
        
        model.addColumn("Nombre");
        model.addColumn("Unidades Vendidas");
        model.addColumn("Owner");
        model.addColumn("id");
        TablaArtistas.setModel(model);
        
        model.setRowCount(0);
        for (Disco act:discos.values()) {
            if(filtro.isEmpty() || act.getOwner().equals(filtro)){
                Object[] fila = {
                    act.getNombre(),
                    act.getUnidadesVendidas(),
                    act.getOwner(),
                    act.getId()
                };
                System.out.println(act);
                model.addRow(fila);
            }    
        }
        //TablaArtistas.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());
        //TablaArtistas.getColumnModel().getColumn(3).setCellEditor(new ButtonEditor(new JCheckBox(), TablaArtistas));
    
    }      
    
    public void setBackground(JPanel panel) {
       
       panel.setSize(500,500);
       panel.setLocation(0,0);
       bodyPanel.removeAll();
       bodyPanel.add(panel, BorderLayout.CENTER);
       bodyPanel.revalidate();
       bodyPanel.repaint(); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bodyPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaArtistas = new javax.swing.JTable();
        BTNPanel = new javax.swing.JPanel();
        EliminarArtistaBTN = new javax.swing.JButton();
        AgregarDiscoBTN = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(831, 481));

        bodyPanel.setBackground(new java.awt.Color(255, 255, 255));
        bodyPanel.setPreferredSize(new java.awt.Dimension(456, 481));

        TablaArtistas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TablaArtistas);

        javax.swing.GroupLayout bodyPanelLayout = new javax.swing.GroupLayout(bodyPanel);
        bodyPanel.setLayout(bodyPanelLayout);
        bodyPanelLayout.setHorizontalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BTNPanel.setBackground(new java.awt.Color(0, 153, 204));
        BTNPanel.setForeground(new java.awt.Color(255, 255, 255));
        BTNPanel.setPreferredSize(new java.awt.Dimension(375, 136));

        EliminarArtistaBTN.setBackground(new java.awt.Color(255, 0, 0));
        EliminarArtistaBTN.setText("Eliminar Artista");

        AgregarDiscoBTN.setBackground(new java.awt.Color(51, 255, 0));
        AgregarDiscoBTN.setText("Nuevo Disco");
        AgregarDiscoBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarDiscoBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BTNPanelLayout = new javax.swing.GroupLayout(BTNPanel);
        BTNPanel.setLayout(BTNPanelLayout);
        BTNPanelLayout.setHorizontalGroup(
            BTNPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BTNPanelLayout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(AgregarDiscoBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 256, Short.MAX_VALUE)
                .addComponent(EliminarArtistaBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124))
        );
        BTNPanelLayout.setVerticalGroup(
            BTNPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BTNPanelLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(BTNPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AgregarDiscoBTN)
                    .addComponent(EliminarArtistaBTN))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 819, Short.MAX_VALUE)
                    .addComponent(BTNPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 819, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(BTNPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 831, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 481, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AgregarDiscoBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarDiscoBTNActionPerformed
        AltaDiscoPanel panel = new AltaDiscoPanel();
        setBackground(panel);

    }//GEN-LAST:event_AgregarDiscoBTNActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarDiscoBTN;
    private javax.swing.JPanel BTNPanel;
    private javax.swing.JButton EliminarArtistaBTN;
    private javax.swing.JTable TablaArtistas;
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}