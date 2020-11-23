/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import apoio.*;
import java.awt.BorderLayout;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

/**
 *
 * @author roger
 */
public class Main extends javax.swing.JFrame {

    GerenciarJanelas gerenciarJanelas;
    String tipoUser;

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon.jpg")).getImage());
        this.setTitle("Caronex");
        this.gerenciarJanelas = new GerenciarJanelas(dktInicial);
        this.setExtendedState(MAXIMIZED_BOTH);
        GraficoDeBarra graficoDeBarra = new GraficoDeBarra();
        jPanelGrafico.setLayout(new BorderLayout());

        jPanelGrafico.add(graficoDeBarra.criarGrafico(graficoDeBarra.getResumoViagens(1, 2020, 1)));

        pack();
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel.class");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void user(String tu) {
        tipoUser = tu;
        jLabel2.setText("Tipo User: " + tu);
        if (tu == "Administrador") {
            //acesso a tudo
        } else if (tu.equals("Organizador")) {
            jimCidade.setEnabled(false);
            jimEndereco.setEnabled(false);
            jimRelatorio1.setEnabled(false);
            jimUsuarios.setEnabled(false);
            jimVeiculo.setEnabled(false);
            jimViagem.setEnabled(false);
            
        } else if (tu.equals("Passageiro")) {
            jimCidade.setEnabled(false);
            jimEndereco.setEnabled(false);
            jimGrupos.setEnabled(false);
            jimPessoas.setEnabled(false);
            jimRelatorio1.setEnabled(false);
            jimUsuarios.setEnabled(false);
            jimVeiculo.setEnabled(false);
            jimViagem.setEnabled(false);
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

        jMenuItem2 = new javax.swing.JMenuItem();
        dktInicial = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanelGrafico = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmCadastros = new javax.swing.JMenu();
        jimPessoas = new javax.swing.JMenuItem();
        jimGrupos = new javax.swing.JMenuItem();
        jimUsuarios = new javax.swing.JMenuItem();
        jimVeiculo = new javax.swing.JMenuItem();
        jimCidade = new javax.swing.JMenuItem();
        jimEndereco = new javax.swing.JMenuItem();
        jimFechar = new javax.swing.JMenuItem();
        jmControles = new javax.swing.JMenu();
        jimInfoGrupo = new javax.swing.JMenuItem();
        jimViagem = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jmRelatorios = new javax.swing.JMenu();
        jimRelatorio1 = new javax.swing.JMenuItem();
        jimRelatorio2 = new javax.swing.JMenuItem();
        jmAjuda = new javax.swing.JMenu();
        jimAuditoria = new javax.swing.JMenuItem();
        jimSobre = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(getIconImage());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/CaronexLogo.png"))); // NOI18N

        jLabel2.setText("User: AcessoRapido");

        javax.swing.GroupLayout jPanelGraficoLayout = new javax.swing.GroupLayout(jPanelGrafico);
        jPanelGrafico.setLayout(jPanelGraficoLayout);
        jPanelGraficoLayout.setHorizontalGroup(
            jPanelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 291, Short.MAX_VALUE)
        );
        jPanelGraficoLayout.setVerticalGroup(
            jPanelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 194, Short.MAX_VALUE)
        );

        dktInicial.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dktInicial.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dktInicial.setLayer(jPanelGrafico, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout dktInicialLayout = new javax.swing.GroupLayout(dktInicial);
        dktInicial.setLayout(dktInicialLayout);
        dktInicialLayout.setHorizontalGroup(
            dktInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dktInicialLayout.createSequentialGroup()
                .addGroup(dktInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dktInicialLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(dktInicialLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        dktInicialLayout.setVerticalGroup(
            dktInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dktInicialLayout.createSequentialGroup()
                .addGroup(dktInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dktInicialLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(dktInicialLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        jimVeiculo.setText("Veiculo");
        jimVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jimVeiculoActionPerformed(evt);
            }
        });
        jmCadastros.add(jimVeiculo);

        jimCidade.setText("Cidade");
        jimCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jimCidadeActionPerformed(evt);
            }
        });
        jmCadastros.add(jimCidade);

        jimEndereco.setText("Endereço");
        jimEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jimEnderecoActionPerformed(evt);
            }
        });
        jmCadastros.add(jimEndereco);

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

        jimViagem.setText("Viagem");
        jimViagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jimViagemActionPerformed(evt);
            }
        });
        jmControles.add(jimViagem);

        jMenuItem6.setText("Next");
        jmControles.add(jMenuItem6);

        jMenuBar1.add(jmControles);

        jmRelatorios.setText("Relatorios");

        jimRelatorio1.setText("Viagens");
        jimRelatorio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jimRelatorio1ActionPerformed(evt);
            }
        });
        jmRelatorios.add(jimRelatorio1);

        jimRelatorio2.setText("Relatorio 2");
        jimRelatorio2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jimRelatorio2ActionPerformed(evt);
            }
        });
        jmRelatorios.add(jimRelatorio2);

        jMenuBar1.add(jmRelatorios);

        jmAjuda.setText("Ajuda");

        jimAuditoria.setText("Auditoria");
        jimAuditoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jimAuditoriaActionPerformed(evt);
            }
        });
        jmAjuda.add(jimAuditoria);

        jimSobre.setText("Sobre");
        jimSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jimSobreActionPerformed(evt);
            }
        });
        jmAjuda.add(jimSobre);

        jMenuItem1.setText("teste envio email");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jmAjuda.add(jMenuItem1);

        jMenuItem3.setText("teste grafico");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jmAjuda.add(jMenuItem3);

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
        GerenciarJanelas.abreJanela(IfrGrupoPessoa.getInstancia(tipoUser));
    }//GEN-LAST:event_jimInfoGrupoActionPerformed

    private void jimFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jimFecharActionPerformed
        this.dispose();
        System.exit(EXIT_ON_CLOSE);
    }//GEN-LAST:event_jimFecharActionPerformed

    private void jimVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jimVeiculoActionPerformed
        GerenciarJanelas.abreJanela(IfrCadVeiculo.getInstancia());
    }//GEN-LAST:event_jimVeiculoActionPerformed

    private void jimCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jimCidadeActionPerformed
        GerenciarJanelas.abreJanela(IfrCadCidade.getInstancia());
    }//GEN-LAST:event_jimCidadeActionPerformed

    private void jimEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jimEnderecoActionPerformed
        GerenciarJanelas.abreJanela(IfrCadEndereco.getInstancia());
    }//GEN-LAST:event_jimEnderecoActionPerformed

    private void jimSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jimSobreActionPerformed
        GerenciarJanelas.abreJanela(IfrAjuda.getInstancia());
    }//GEN-LAST:event_jimSobreActionPerformed

    private void jimViagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jimViagemActionPerformed
        GerenciarJanelas.abreJanela(IfrViagem.getInstancia());
    }//GEN-LAST:event_jimViagemActionPerformed

    private void jimAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jimAuditoriaActionPerformed
        GerenciarJanelas.abreJanela(IfrAuditoria.getInstancia());
    }//GEN-LAST:event_jimAuditoriaActionPerformed

    private void jimRelatorio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jimRelatorio1ActionPerformed

        GerenciarJanelas.abreJanela(FrmPesquisaViagem.getInstancia());
//        FrmPesquisaViagem pesquisa = new FrmPesquisaViagem();
//        
//        pesquisa.setVisible(true);
    }//GEN-LAST:event_jimRelatorio1ActionPerformed

    private void jimRelatorio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jimRelatorio2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jimRelatorio2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        GerenciarJanelas.abreJanela(Tela_Email.getInstancia());
//        try {
//            Email.enviar();
//        } catch (IOException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        GerenciarJanelas.abreJanela(JanelaDoGrafico2.getInstancia());
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanelGrafico;
    private javax.swing.JMenuItem jimAuditoria;
    private javax.swing.JMenuItem jimCidade;
    private javax.swing.JMenuItem jimEndereco;
    private javax.swing.JMenuItem jimFechar;
    private javax.swing.JMenuItem jimGrupos;
    private javax.swing.JMenuItem jimInfoGrupo;
    private javax.swing.JMenuItem jimPessoas;
    private javax.swing.JMenuItem jimRelatorio1;
    private javax.swing.JMenuItem jimRelatorio2;
    private javax.swing.JMenuItem jimSobre;
    private javax.swing.JMenuItem jimUsuarios;
    private javax.swing.JMenuItem jimVeiculo;
    private javax.swing.JMenuItem jimViagem;
    private javax.swing.JMenu jmAjuda;
    private javax.swing.JMenu jmCadastros;
    private javax.swing.JMenu jmControles;
    private javax.swing.JMenu jmRelatorios;
    // End of variables declaration//GEN-END:variables

}
