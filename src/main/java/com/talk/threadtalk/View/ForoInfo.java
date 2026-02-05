package com.talk.threadtalk.View;

import com.talk.threadtalk.Services.ForoService;
import com.talk.threadtalk.Services.MensajeService;
import com.talk.threadtalk.Services.UsuarioService;
import com.talk.threadtalk.models.MensajeForoDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class ForoInfo extends javax.swing.JFrame {

    String foroType = "";
    int idUser = 0;
    int idForo = 0;
    List<MensajeForoDTO> lista = new ArrayList<>();

    public ForoInfo() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public ForoInfo(String foroName, int idUsuario) {
        initComponents();
        foroType = foroName;
        idUser = idUsuario;
        lblTittle.setText(foroType.toUpperCase().trim());
        cargaDataForo(foroName);
        this.setLocationRelativeTo(null);
    }

    public void changeForo(String type, int idUsuario) {
        ForoInfo foro = new ForoInfo(type, idUsuario);
        foro.setVisible(true);
        this.dispose();
    }

    public void cargaDataForo(String tipo) {
        ForoService foroService = new ForoService();
        lista = foroService.cargarForo(tipo);

        // LIMPIA EL PANEL ANTES DE CARGARLO
        pnlContent.removeAll();
        pnlContent.setLayout(new BoxLayout(pnlContent, BoxLayout.Y_AXIS));
        pnlContent.setBackground(Color.WHITE);

        // IMPRESION DE MENSAJES
        for (int i = 0; i < lista.size(); i++) {
            MensajeForoDTO m = lista.get(i);
            idForo = m.getIdForo();
            // PANEL DE BURBUJA CON MARGEN
            JPanel contenedorBurbuja = new JPanel();
            contenedorBurbuja.setLayout(new BorderLayout());
            contenedorBurbuja.setBackground(Color.WHITE);
            contenedorBurbuja.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));

            // PANEL DE BURBUJA DE MENSAJE
            JPanel burbuja = new JPanel();
            burbuja.setLayout(new BoxLayout(burbuja, BoxLayout.Y_AXIS));
            burbuja.setBackground(new Color(245, 250, 255));
            burbuja.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(220, 230, 240), 1, true),
                    BorderFactory.createEmptyBorder(12, 16, 12, 16)
            ));

            // LBL USUARIO
            JLabel user = new JLabel(m.getNombres());
            user.setFont(new Font("Segoe UI", Font.BOLD, 14));
            user.setForeground(new Color(45, 85, 140));
            user.setAlignmentX(Component.LEFT_ALIGNMENT);
            user.setBorder(BorderFactory.createEmptyBorder(0, 0, 6, 0));

            String mensajeHTML = "<html><body style='width: 100%; padding: 0;'>"
                    + m.getMensaje() + "</body></html>";
            JLabel msg = new JLabel(mensajeHTML);
            msg.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            msg.setForeground(new Color(60, 60, 60));
            msg.setAlignmentX(Component.LEFT_ALIGNMENT);
            burbuja.add(user);
            burbuja.add(msg);

            contenedorBurbuja.add(burbuja, BorderLayout.CENTER);
            pnlContent.add(contenedorBurbuja);

            if (i < lista.size() - 1) {
                JSeparator separador = new JSeparator();
                separador.setForeground(new Color(230, 230, 230));
                separador.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
                pnlContent.add(separador);
            }
        }

        pnlContent.add(Box.createVerticalGlue());
        JPanel pnlEntrada = crearPanelEntrada(tipo);
        pnlContent.add(pnlEntrada);

        pnlContent.revalidate();
        pnlContent.repaint();
    }

    private JPanel crearPanelEntrada(String tipo) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 0));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(2, 0, 0, 0, new Color(220, 220, 220)),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));

        // TXT PARA ESCRIBIR MENSAJES
        JTextField txtMensaje = new JTextField();
        txtMensaje.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        txtMensaje.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1, true),
                BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
        txtMensaje.setBackground(new Color(250, 250, 250));

        // BOTON DE ENIVO
        JButton btnEnviar = new JButton("Enviar");
        btnEnviar.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnEnviar.setBackground(new Color(45, 85, 140));
        btnEnviar.setForeground(Color.WHITE);
        btnEnviar.setFocusPainted(false);
        btnEnviar.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
        btnEnviar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnEnviar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEnviar.setBackground(new Color(35, 75, 130));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEnviar.setBackground(new Color(45, 85, 140));
            }
        });

        // CREACION DE MENASJE
        btnEnviar.addActionListener(e -> {
            String mensaje = txtMensaje.getText().trim();
            if (!mensaje.isEmpty()) {
                // METODO PARA ENVAR MENSJE
                enviarMensaje(mensaje, idUser, idForo);
                txtMensaje.setText("");
            }
        });

        // KEY EVENT PARA CREAR MENSAJE
        txtMensaje.addActionListener(e -> btnEnviar.doClick());

        panel.add(txtMensaje, BorderLayout.CENTER);
        panel.add(btnEnviar, BorderLayout.EAST);

        return panel;
    }

    private void enviarMensaje(String texto, int idUsuario, int idForo) {
        MensajeService mensajeService = new MensajeService();
        boolean enviado = mensajeService.crearMensaje(texto, idUsuario, idForo);
        UsuarioService userService = new UsuarioService();
        if (enviado) {
            MensajeForoDTO nuevoMensaje = new MensajeForoDTO(userService.buscarUsuarioPorId(idUsuario), texto, idForo);
            lista.add(nuevoMensaje);
            agregarBurbujaMensaje(nuevoMensaje);
        }
    }

    //ANIMACION DE CREACION DE MENSAJE EN EL FORO
    private void agregarBurbujaMensaje(MensajeForoDTO m) {
        Component panelEntrada = pnlContent.getComponent(pnlContent.getComponentCount() - 1);
        Component glue = pnlContent.getComponent(pnlContent.getComponentCount() - 2);
        pnlContent.remove(panelEntrada);
        pnlContent.remove(glue);

        if (pnlContent.getComponentCount() > 0) {
            JSeparator separador = new JSeparator();
            separador.setForeground(new Color(230, 230, 230));
            separador.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
            pnlContent.add(separador);
        }

        JPanel contenedorBurbuja = new JPanel(new BorderLayout());
        contenedorBurbuja.setBackground(Color.WHITE);
        contenedorBurbuja.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));

        JPanel burbuja = new JPanel();
        burbuja.setLayout(new BoxLayout(burbuja, BoxLayout.Y_AXIS));
        burbuja.setBackground(new Color(245, 250, 255));
        burbuja.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 230, 240), 1, true),
                BorderFactory.createEmptyBorder(12, 16, 12, 16)
        ));

        JLabel user = new JLabel(m.getNombres());
        user.setFont(new Font("Segoe UI", Font.BOLD, 14));
        user.setForeground(new Color(45, 85, 140));
        user.setAlignmentX(Component.LEFT_ALIGNMENT);
        user.setBorder(BorderFactory.createEmptyBorder(0, 0, 6, 0));

        JLabel msg = new JLabel("<html><body style='width: 100%; padding: 0;'>" + m.getMensaje() + "</body></html>");
        msg.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        msg.setForeground(new Color(60, 60, 60));
        msg.setAlignmentX(Component.LEFT_ALIGNMENT);

        burbuja.add(user);
        burbuja.add(msg);
        contenedorBurbuja.add(burbuja, BorderLayout.CENTER);
        pnlContent.add(contenedorBurbuja);
        pnlContent.add(Box.createVerticalGlue());
        pnlContent.add(panelEntrada);

        pnlContent.revalidate();
        pnlContent.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBase = new javax.swing.JPanel();
        pnlSidebar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnGeneral = new javax.swing.JButton();
        btnTech = new javax.swing.JButton();
        btnMusic = new javax.swing.JButton();
        btnCinema = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnOffTopic = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblTittle = new javax.swing.JLabel();
        pnlScroll = new javax.swing.JScrollPane();
        pnlContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ThreadTalk - Foro");

        pnlBase.setBackground(new java.awt.Color(255, 255, 255));
        pnlBase.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlSidebar.setBackground(new java.awt.Color(31, 41, 55));

        jLabel1.setFont(new java.awt.Font("Yu Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Foros");

        btnGeneral.setBackground(new java.awt.Color(31, 41, 55));
        btnGeneral.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnGeneral.setForeground(new java.awt.Color(255, 255, 255));
        btnGeneral.setText("Bases de Datos");
        btnGeneral.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGeneral.setBorderPainted(false);
        btnGeneral.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnGeneral.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGeneralMouseClicked(evt);
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

        btnOffTopic.setBackground(new java.awt.Color(31, 41, 55));
        btnOffTopic.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnOffTopic.setForeground(new java.awt.Color(255, 255, 255));
        btnOffTopic.setText("Off - Topic");
        btnOffTopic.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnOffTopic.setBorderPainted(false);
        btnOffTopic.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnOffTopic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOffTopicActionPerformed(evt);
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
                        .addComponent(btnOffTopic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                .addComponent(btnOffTopic, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlBase.add(pnlSidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 412));

        jPanel2.setBackground(new java.awt.Color(37, 99, 235));

        lblTittle.setFont(new java.awt.Font("Yu Gothic", 1, 24)); // NOI18N
        lblTittle.setForeground(new java.awt.Color(255, 255, 255));
        lblTittle.setText(" ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblTittle, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTittle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlBase.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 0, 580, -1));

        pnlContent.setBackground(new java.awt.Color(255, 255, 255));
        pnlContent.setLayout(new javax.swing.BoxLayout(pnlContent, javax.swing.BoxLayout.Y_AXIS));
        pnlScroll.setViewportView(pnlContent);

        pnlBase.add(pnlScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 52, 580, 360));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGeneralMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGeneralMouseClicked
        changeForo("Base de Datos", idUser);
    }//GEN-LAST:event_btnGeneralMouseClicked

    private void btnTechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTechActionPerformed
        changeForo("Programación", idUser);
    }//GEN-LAST:event_btnTechActionPerformed

    private void btnMusicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMusicActionPerformed
        changeForo("Tecnología", idUser);
    }//GEN-LAST:event_btnMusicActionPerformed

    private void btnCinemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCinemaActionPerformed
        changeForo("Videojuegos", idUser);
    }//GEN-LAST:event_btnCinemaActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnOffTopicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOffTopicActionPerformed
        changeForo("Off Topic", idUser);
    }//GEN-LAST:event_btnOffTopicActionPerformed

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
            java.util.logging.Logger.getLogger(ForoInfo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForoInfo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForoInfo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForoInfo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForoInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCinema;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnGeneral;
    private javax.swing.JButton btnMusic;
    private javax.swing.JButton btnOffTopic;
    private javax.swing.JButton btnTech;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblTittle;
    private javax.swing.JPanel pnlBase;
    private javax.swing.JPanel pnlContent;
    private javax.swing.JScrollPane pnlScroll;
    private javax.swing.JPanel pnlSidebar;
    // End of variables declaration//GEN-END:variables
}
