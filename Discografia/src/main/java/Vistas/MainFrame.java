/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import java.awt.BorderLayout;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JPanel;

/**
 *
 * @author agust
 */
public class MainFrame extends javax.swing.JFrame {
    
    
    public MainFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.FechaLB.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bodyPanel = new javax.swing.JPanel();
        sideBarPanel = new javax.swing.JPanel();
        ArtistasBTN = new javax.swing.JButton();
        LiquidasionesBTN = new javax.swing.JButton();
        ReportesBTN = new javax.swing.JButton();
        GuardarSalirBTN = new javax.swing.JButton();
        DiscosBTN = new javax.swing.JButton();
        CancionesBTN = new javax.swing.JButton();
        RecitalesBTN = new javax.swing.JButton();
        navBarPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        FechaLB = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bodyPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout bodyPanelLayout = new javax.swing.GroupLayout(bodyPanel);
        bodyPanel.setLayout(bodyPanelLayout);
        bodyPanelLayout.setHorizontalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        sideBarPanel.setBackground(new java.awt.Color(0, 102, 204));

        ArtistasBTN.setBackground(new java.awt.Color(0, 0, 0));
        ArtistasBTN.setForeground(new java.awt.Color(255, 255, 255));
        ArtistasBTN.setText("Artistas");
        ArtistasBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArtistasBTNActionPerformed(evt);
            }
        });

        LiquidasionesBTN.setBackground(new java.awt.Color(0, 0, 0));
        LiquidasionesBTN.setForeground(new java.awt.Color(255, 255, 255));
        LiquidasionesBTN.setText("Liquidaciones");
        LiquidasionesBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LiquidasionesBTNActionPerformed(evt);
            }
        });

        ReportesBTN.setBackground(new java.awt.Color(0, 0, 0));
        ReportesBTN.setForeground(new java.awt.Color(255, 255, 255));
        ReportesBTN.setText("Reportes");
        ReportesBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReportesBTNActionPerformed(evt);
            }
        });

        GuardarSalirBTN.setBackground(new java.awt.Color(0, 0, 0));
        GuardarSalirBTN.setForeground(new java.awt.Color(255, 255, 255));
        GuardarSalirBTN.setText("Guardar y Salir");
        GuardarSalirBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarSalirBTNActionPerformed(evt);
            }
        });

        DiscosBTN.setBackground(new java.awt.Color(0, 0, 0));
        DiscosBTN.setForeground(new java.awt.Color(255, 255, 255));
        DiscosBTN.setText("Discos");
        DiscosBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiscosBTNActionPerformed(evt);
            }
        });

        CancionesBTN.setBackground(new java.awt.Color(0, 0, 0));
        CancionesBTN.setForeground(new java.awt.Color(255, 255, 255));
        CancionesBTN.setText("Canciones");
        CancionesBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancionesBTNActionPerformed(evt);
            }
        });

        RecitalesBTN.setBackground(new java.awt.Color(0, 0, 0));
        RecitalesBTN.setForeground(new java.awt.Color(255, 255, 255));
        RecitalesBTN.setText("Recitales");
        RecitalesBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecitalesBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sideBarPanelLayout = new javax.swing.GroupLayout(sideBarPanel);
        sideBarPanel.setLayout(sideBarPanelLayout);
        sideBarPanelLayout.setHorizontalGroup(
            sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideBarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ArtistasBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LiquidasionesBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ReportesBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(GuardarSalirBTN, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(DiscosBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CancionesBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RecitalesBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        sideBarPanelLayout.setVerticalGroup(
            sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideBarPanelLayout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(ArtistasBTN)
                .addGap(18, 18, 18)
                .addComponent(LiquidasionesBTN)
                .addGap(18, 18, 18)
                .addComponent(DiscosBTN)
                .addGap(18, 18, 18)
                .addComponent(CancionesBTN)
                .addGap(18, 18, 18)
                .addComponent(RecitalesBTN)
                .addGap(18, 18, 18)
                .addComponent(ReportesBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
                .addComponent(GuardarSalirBTN)
                .addGap(25, 25, 25))
        );

        navBarPanel.setBackground(new java.awt.Color(0, 51, 204));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Nirmala UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MyDiscografia");

        FechaLB.setBackground(new java.awt.Color(255, 255, 255));
        FechaLB.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        FechaLB.setForeground(new java.awt.Color(255, 255, 255));
        FechaLB.setText("Fecha");

        javax.swing.GroupLayout navBarPanelLayout = new javax.swing.GroupLayout(navBarPanel);
        navBarPanel.setLayout(navBarPanelLayout);
        navBarPanelLayout.setHorizontalGroup(
            navBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navBarPanelLayout.createSequentialGroup()
                .addContainerGap(338, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(FechaLB, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        navBarPanelLayout.setVerticalGroup(
            navBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navBarPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(navBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FechaLB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sideBarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(navBarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sideBarPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(navBarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ArtistasBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArtistasBTNActionPerformed
        System.out.println("holagey");
        ArtistasPanel panel = new  ArtistasPanel();
        setBackground(panel);
        panel.MostrarLista();
    }//GEN-LAST:event_ArtistasBTNActionPerformed

    private void LiquidasionesBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LiquidasionesBTNActionPerformed
        LiquidacionPanel panel = new LiquidacionPanel();
        setBackground(panel);
    }//GEN-LAST:event_LiquidasionesBTNActionPerformed

    private void ReportesBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReportesBTNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ReportesBTNActionPerformed

    private void GuardarSalirBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarSalirBTNActionPerformed
        dispose();
    }//GEN-LAST:event_GuardarSalirBTNActionPerformed

    private void DiscosBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiscosBTNActionPerformed
        DiscosPanel panel = new DiscosPanel();
        setBackground(panel);
        panel.MostrarLista("");
    }//GEN-LAST:event_DiscosBTNActionPerformed

    private void CancionesBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancionesBTNActionPerformed
        CancionesPanel panel = new CancionesPanel();
        setBackground(panel);
        panel.MostrarLista();
    }//GEN-LAST:event_CancionesBTNActionPerformed

    private void RecitalesBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecitalesBTNActionPerformed
        RecitalPanel panel = new RecitalPanel();
        setBackground(panel);
        panel.MostrarLista();
    }//GEN-LAST:event_RecitalesBTNActionPerformed

    public void setBackground(JPanel panel) {
       
       panel.setSize(1000,500);
       panel.setLocation(0,0);
       bodyPanel.removeAll();
       bodyPanel.add(panel, BorderLayout.CENTER);
       bodyPanel.revalidate();
       bodyPanel.repaint(); 
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ArtistasBTN;
    private javax.swing.JButton CancionesBTN;
    private javax.swing.JButton DiscosBTN;
    private javax.swing.JLabel FechaLB;
    private javax.swing.JButton GuardarSalirBTN;
    private javax.swing.JButton LiquidasionesBTN;
    private javax.swing.JButton RecitalesBTN;
    private javax.swing.JButton ReportesBTN;
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel navBarPanel;
    private javax.swing.JPanel sideBarPanel;
    // End of variables declaration//GEN-END:variables
}
