/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import apoio.*;
import javax.swing.UIManager;

/**
 *
 * @author roger
 */
public class Main extends javax.swing.JFrame {

    GerenciarJanelas gerenciarJanelas;

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon.jpg")).getImage());
        this.setTitle("Caronex");
        this.gerenciarJanelas = new GerenciarJanelas(dktInicial);
        this.setExtendedState(MAXIMIZED_BOTH);
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel.class");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dktInicial = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmCadastros = new javax.swing.JMenu();
        jimPessoas = new javax.swing.JMenuItem();
        jimGrupos = new javax.swing.JMenuItem();
        jimUsuarios = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jimFechar = new javax.swing.JMenuItem();
        jmControles = new javax.swing.JMenu();
        jimInfoGrupo = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jimRelatorio1 = new javax.swing.JMenuItem();
        jimRelatorio2 = new javax.swing.JMenuItem();
        jmAjuda = new javax.swing.JMenu();
        jimSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(getIconImage());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/CaronexLogo.png"))); // NOI18N

        dktInicial.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout dktInicialLayout = new javax.swing.GroupLayout(dktInicial);
        dktInicial.setLayout(dktInicialLayout);
        dktInicialLayout.setHorizontalGroup(
            dktInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dktInicialLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 729, Short.MAX_VALUE)
                .addContainerGap())
        );
        dktInicialLayout.setVerticalGroup(
            dktInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dktInicialLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                .addContainerGap())
        );

        jmCadastros.setText("Cadastros");

        jimPessoas.setText("Pessoas");
        jimPessoas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jimPessoasActionPerformed(evt);
            }
        });
        jmCadastros.add(jimPessoas);

        jimGrupos.setText("Grupos");
        jimGrupos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jimGruposActionPerformed(evt);
            }
        });
        jmCadastros.add(jimGrupos);

        jimUsuarios.setText("Usuarios");
        jimUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jimUsuariosActionPerformed(evt);
            }
        });
        jmCadastros.add(jimUsuarios);

        jMenuItem1.setText("Veiculo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jmCadastros.add(jMenuItem1);

        jMenuItem2.setText("Cidade");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jmCadastros.add(jMenuItem2);

        jMenuItem3.setText("Endereço");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jmCadastros.add(jMenuItem3);

        jimFechar.setText("Fechar");
        jimFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jimFecharActionPerformed(evt);
            }
        });
        jmCadastros.add(jimFechar);

        jMenuBar1.add(jmCadastros);

        jmControles.setText("Controles");

        jimInfoGrupo.setText("Info Grupo");
        jimInfoGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jimInfoGrupoActionPerformed(evt);
            }
        });
        jmControles.add(jimInfoGrupo);

        jMenuItem5.setText("Next");
        jmControles.add(jMenuItem5);

        jMenuItem6.setText("Next");
        jmControles.add(jMenuItem6);

        jMenuBar1.add(jmControles);

        jMenu3.setText("Relatorios");

        jimRelatorio1.setText("Relatorio 1");
        jMenu3.add(jimRelatorio1);

        jimRelatorio2.setText("Relatorio 2");
        jMenu3.add(jimRelatorio2);

        jMenuBar1.add(jMenu3);

        jmAjuda.setText("Ajuda");

        jimSobre.setText("Sobre");
        jmAjuda.add(jimSobre);

        jMenuBar1.add(jmAjuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dktInicial)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(dktInicial)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jimGruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jimGruposActionPerformed
        GerenciarJanelas.abreJanela(IfrCadGrupo.getInstancia());
    }//GEN-LAST:event_jimGruposActionPerformed

    private void jimPessoasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jimPessoasActionPerformed
        GerenciarJanelas.abreJanela(IfrCadPessoa.getInstancia());
    }//GEN-LAST:event_jimPessoasActionPerformed

    private void jimUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jimUsuariosActionPerformed
        GerenciarJanelas.abreJanela(IfrCadLogin.getInstancia());
    }//GEN-LAST:event_jimUsuariosActionPerformed

    private void jimInfoGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jimInfoGrupoActionPerformed
        GerenciarJanelas.abreJanela(IfrGrupoPessoa.getInstancia());
    }//GEN-LAST:event_jimInfoGrupoActionPerformed

    private void jimFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jimFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_jimFecharActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        GerenciarJanelas.abreJanela(IfrCadVeiculo.getInstancia());
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        GerenciarJanelas.abreJanela(IfrCadCidade.getInstancia());
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        GerenciarJanelas.abreJanela(IfrCadEndereco.getInstancia());
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dktInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jimFechar;
    private javax.swing.JMenuItem jimGrupos;
    private javax.swing.JMenuItem jimInfoGrupo;
    private javax.swing.JMenuItem jimPessoas;
    private javax.swing.JMenuItem jimRelatorio1;
    private javax.swing.JMenuItem jimRelatorio2;
    private javax.swing.JMenuItem jimSobre;
    private javax.swing.JMenuItem jimUsuarios;
    private javax.swing.JMenu jmAjuda;
    private javax.swing.JMenu jmCadastros;
    private javax.swing.JMenu jmControles;
    // End of variables declaration//GEN-END:variables
}
