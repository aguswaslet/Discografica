/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas;

import Controladores.ControladorArtista;
import Modelos.Artista;
import java.awt.BorderLayout;
import java.util.TreeMap;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author agust
 */
public class ArtistasPanel extends javax.swing.JPanel {
    
    
    public ArtistasPanel() {
        initComponents();
        
        this.setVisible(true);
    }

    public void MostrarLista() {  
        TreeMap<String,Artista> Artistas;
        ControladorArtista control = new ControladorArtista();
        DefaultTableModel model = new DefaultTableModel();
        int integrantesf = getFiltroIntegrantes();
        String generof = getFiltroGenero();
        
        
        Artistas = control.getArtistas();
        
        model.addColumn("Codigo");
        model.addColumn("Nombre");
        model.addColumn("Genero");
        model.addColumn("Integrantes");
        model.addColumn("Rango");
        TablaArtistas.setModel(model);
        
        model.setRowCount(0);
        for (Artista act:Artistas.values()) {
            if(((integrantesf == act.getIntegrantes()) && generof.equals(act.getGeneroMusical())) || ((integrantesf == act.getIntegrantes()) || generof.equals(act.getGeneroMusical())) || (integrantesf == 0 && generof.isEmpty())){
                Object[] fila = {
                    act.getId(),
                    act.getNombre(),
                    act.getGeneroMusical(),
                    act.getIntegrantes(),
                    act.getRango(),
                };
                System.out.println(act);
                model.addRow(fila);
            }
        }
        //TablaArtistas.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
        //TablaArtistas.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(new JCheckBox(), TablaArtistas));
    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bodyPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaArtistas = new javax.swing.JTable();
        BTNPanel = new javax.swing.JPanel();
        EliminarArtistaBTN = new javax.swing.JButton();
        AgregarArtistaBTN = new javax.swing.JButton();
        FiltrarBTN = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        integrantesFiltroFild = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        GeneroFiltroFild = new javax.swing.JTextField();

        setBackground(new java.awt.Color(102, 102, 102));
        setPreferredSize(new java.awt.Dimension(831, 481));

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BTNPanel.setBackground(new java.awt.Color(0, 153, 204));
        BTNPanel.setForeground(new java.awt.Color(255, 255, 255));
        BTNPanel.setPreferredSize(new java.awt.Dimension(375, 136));

        EliminarArtistaBTN.setBackground(new java.awt.Color(255, 0, 0));
        EliminarArtistaBTN.setForeground(new java.awt.Color(0, 0, 0));
        EliminarArtistaBTN.setText("Eliminar Artista");

        AgregarArtistaBTN.setBackground(new java.awt.Color(51, 255, 0));
        AgregarArtistaBTN.setForeground(new java.awt.Color(0, 0, 0));
        AgregarArtistaBTN.setText("Nuevo Artista");
        AgregarArtistaBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarArtistaBTNActionPerformed(evt);
            }
        });

        FiltrarBTN.setBackground(new java.awt.Color(255, 255, 0));
        FiltrarBTN.setForeground(new java.awt.Color(0, 0, 0));
        FiltrarBTN.setText("Filtrar");
        FiltrarBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FiltrarBTNActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Filtros");

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Integrantes:");

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Genero Musical:");

        javax.swing.GroupLayout BTNPanelLayout = new javax.swing.GroupLayout(BTNPanel);
        BTNPanel.setLayout(BTNPanelLayout);
        BTNPanelLayout.setHorizontalGroup(
            BTNPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BTNPanelLayout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addGroup(BTNPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AgregarArtistaBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(EliminarArtistaBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(FiltrarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addGroup(BTNPanelLayout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(integrantesFiltroFild, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(GeneroFiltroFild, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(133, Short.MAX_VALUE))
        );
        BTNPanelLayout.setVerticalGroup(
            BTNPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BTNPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BTNPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(integrantesFiltroFild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(GeneroFiltroFild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(BTNPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AgregarArtistaBTN)
                    .addComponent(EliminarArtistaBTN)
                    .addComponent(FiltrarBTN))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 819, Short.MAX_VALUE)
                    .addComponent(BTNPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 819, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bodyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTNPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );
    }// </editor-fold>//GEN-END:initComponents

    public int getFiltroIntegrantes(){
        int dato = 0;
        if(!integrantesFiltroFild.getText().isEmpty()){
            dato = Integer.parseInt(integrantesFiltroFild.getText());
        }
        return dato;
    }
    
    public String getFiltroGenero(){
        String genero = new String();
        if(!GeneroFiltroFild.getText().isEmpty()){
            genero = GeneroFiltroFild.getText().toUpperCase();
        }
        return genero;
    }
    
    private void AgregarArtistaBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarArtistaBTNActionPerformed
        AltaArtistaPanel panel = new AltaArtistaPanel();
        setBackground(panel);
        
    }//GEN-LAST:event_AgregarArtistaBTNActionPerformed

    private void FiltrarBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiltrarBTNActionPerformed
        MostrarLista();
    }//GEN-LAST:event_FiltrarBTNActionPerformed

    public void setBackground(JPanel panel) {
       
       panel.setSize(500,500);
       panel.setLocation(0,0);
       bodyPanel.removeAll();
       bodyPanel.add(panel, BorderLayout.CENTER);
       bodyPanel.revalidate();
       bodyPanel.repaint(); 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarArtistaBTN;
    private javax.swing.JPanel BTNPanel;
    private javax.swing.JButton EliminarArtistaBTN;
    private javax.swing.JButton FiltrarBTN;
    private javax.swing.JTextField GeneroFiltroFild;
    private javax.swing.JTable TablaArtistas;
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JTextField integrantesFiltroFild;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
