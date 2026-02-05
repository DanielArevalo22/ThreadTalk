package com.talk.threadtalk.View;


public class ForoFrame extends javax.swing.JFrame {

    private int idUser;
    
    public ForoFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public ForoFrame(int idUsuario) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.idUser = idUsuario;
    }

    public void changeForo(String type, int idUsuario){
        ForoInfo foro = new ForoInfo(type, idUsuario);
        foro.setVisible(true);
        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        base = new javax.swing.JPanel();
        pnlSidebar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnGeneral = new javax.swing.JButton();
        btnTech = new javax.swing.JButton();
        btnMusic = new javax.swing.JButton();
        btnCinema = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnCinema1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblUsername = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ThreadTalk - Home");

        base.setBackground(new java.awt.Color(243, 244, 246));
        base.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlSidebar.setBackground(new java.awt.Color(31, 41, 55));

        jLabel1.setFont(new java.awt.Font("Yu Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Foros");

        btnGeneral.setBackground(new java.awt.Color(31, 41, 55));
        btnGeneral.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnGeneral.setForeground(new java.awt.Color(255, 255, 255));
        btnGeneral.setText("Bases de datos");
        btnGeneral.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGeneral.setBorderPainted(false);
        btnGeneral.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnGeneral.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGeneralMouseClicked(evt);
            }
        });
        btnGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeneralActionPerformed(evt);
            }
        });

        btnTech.setBackground(new java.awt.Color(31, 41, 55));
        btnTech.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnTech.setForeground(new java.awt.Color(255, 255, 255));
        btnTech.setText("Programacion");
        btnTech.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnTech.setBorderPainted(false);
        btnTech.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTechActionPerformed(evt);
            }
        });

        btnMusic.setBackground(new java.awt.Color(31, 41, 55));
        btnMusic.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnMusic.setForeground(new java.awt.Color(255, 255, 255));
        btnMusic.setText("Tecnologia");
        btnMusic.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMusic.setBorderPainted(false);
        btnMusic.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMusic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMusicActionPerformed(evt);
            }
        });

        btnCinema.setBackground(new java.awt.Color(31, 41, 55));
        btnCinema.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCinema.setForeground(new java.awt.Color(255, 255, 255));
        btnCinema.setText("Videojuegos");
        btnCinema.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCinema.setBorderPainted(false);
        btnCinema.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCinema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCinemaActionPerformed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(255, 51, 51));
        btnExit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("Salir");
        btnExit.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnExit.setBorderPainted(false);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnCinema1.setBackground(new java.awt.Color(31, 41, 55));
        btnCinema1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCinema1.setForeground(new java.awt.Color(255, 255, 255));
        btnCinema1.setText("Off-Topic");
        btnCinema1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCinema1.setBorderPainted(false);
        btnCinema1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCinema1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCinema1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSidebarLayout = new javax.swing.GroupLayout(pnlSidebar);
        pnlSidebar.setLayout(pnlSidebarLayout);
        pnlSidebarLayout.setHorizontalGroup(
            pnlSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSidebarLayout.createSequentialGroup()
                .addGroup(pnlSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSidebarLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(pnlSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSidebarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCinema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMusic, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTech, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)))
                    .addGroup(pnlSidebarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlSidebarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCinema1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlSidebarLayout.setVerticalGroup(
            pnlSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSidebarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTech, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMusic, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCinema, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCinema1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        base.add(pnlSidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 412));

        jPanel1.setBackground(new java.awt.Color(37, 99, 235));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        base.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 0, 580, -1));

        lblUsername.setFont(new java.awt.Font("Yu Gothic", 1, 36)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(51, 51, 255));
        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblUsername.setText("Bienvenido, Usuario");
        base.add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 60, 560, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(base, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(base, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnGeneralMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGeneralMouseClicked
        changeForo("Base de Datos",idUser);
    }//GEN-LAST:event_btnGeneralMouseClicked

    private void btnTechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTechActionPerformed
        changeForo("Programación",idUser);
    }//GEN-LAST:event_btnTechActionPerformed

    private void btnMusicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMusicActionPerformed
        changeForo("Tecnología",idUser);
    }//GEN-LAST:event_btnMusicActionPerformed

    private void btnCinemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCinemaActionPerformed
        changeForo("Videojuegos",idUser);
    }//GEN-LAST:event_btnCinemaActionPerformed

    private void btnGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeneralActionPerformed
        changeForo("Base de Datos",idUser);
    }//GEN-LAST:event_btnGeneralActionPerformed

    private void btnCinema1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCinema1ActionPerformed
        changeForo("Off Topic", idUser);
    }//GEN-LAST:event_btnCinema1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ForoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForoFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel base;
    private javax.swing.JButton btnCinema;
    private javax.swing.JButton btnCinema1;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnGeneral;
    private javax.swing.JButton btnMusic;
    private javax.swing.JButton btnTech;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel pnlSidebar;
    // End of variables declaration//GEN-END:variables
}
