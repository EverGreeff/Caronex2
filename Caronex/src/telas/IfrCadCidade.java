/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import apoio.*;
import entidades.Cidade;
import entidades.Grupo;
import entidades.Pessoa;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author everton
 */
public class IfrCadCidade extends javax.swing.JInternalFrame {

    private static IfrCadCidade tela;
    String errors;
    public static int id_organizador;

    public int id = -1;

    /**
     * Creates new form IfrCadCidade
     */
    public IfrCadCidade() {
        initComponents();
        this.setTitle("Cadastrar Cidade");
        Pesquisas.PesquisaCidade(tblBuscaCidade, "");
        // aplica mascaras
        // btnBuscaResp.setVisible(false);
    }

    public static IfrCadCidade getInstancia() {
        if (tela == null) {
            tela = new IfrCadCidade();
        }
        return tela;
    }

    private void fechaTela() {
        GerenciarJanelas.fecharJanela(tela);
        tela = null;
    }

    public void salvar(Cidade u) {

        Session sessao = null;
        sessao = apoio.HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();

        try {
            sessao = apoio.HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            int id = (int) sessao.save(u);
            transacao.commit();
            u.setId_cid(id);
            //Audita.salvarAuditoria("SalvarCidade", "Cidade", 1);

            JOptionPane.showMessageDialog(null, "Cidade criada com sucesso!");
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
            Log.geraLogBD("admin", "salvar", "dao", hibEx.toString());
        } finally {
            sessao.close();
        }
    }

    public void atualizar(Cidade u) {
        Session sessao = null;
        sessao = apoio.HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();
        try {
            sessao.update(u);
            transacao.commit();
            //Audita.salvarAuditoria("AtualizarCidade", "Cidade", 1);
            JOptionPane.showMessageDialog(null, "Cidade editada com sucesso!");
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
            Log.geraLogBD("admin", "atualizar", "dao", hibEx.toString());
        } finally {
            sessao.close();
        }
    }

    public void inativar(Cidade u) {
        if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja inativar esta Cidade?") == 0) {
            Session sessao = null;
            List resultado = null;
            sessao = apoio.HibernateUtil.getSessionFactory().openSession();
            Transaction transacao = sessao.beginTransaction();
            org.hibernate.Query query = sessao.createQuery("FROM Cidade WHERE id = " + u.getId_cid());

            try {

                resultado = query.list();
                for (Object obj : resultado) {
                    Cidade cidade = (Cidade) obj;
                    cidade.setStatus(u.getStatus());
                    sessao.update(cidade);
                    transacao.commit();
                    //Audita.salvarAuditoria("InativarCidade", "Cidade", 1);
                }

            } catch (HibernateException hibEx) {
                hibEx.printStackTrace();
                Log.geraLogBD("admin", "inativar", "dao", hibEx.toString());
            } finally {
                JOptionPane.showMessageDialog(null, "Cidade Desativada");
                sessao.close();
            }
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNomeCidade = new javax.swing.JTextField();
        txtUf = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        BtnFechar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBuscaCidade = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtCidadeBusca = new javax.swing.JTextField();
        btnPesquisaGrupo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnInativar = new javax.swing.JButton();

        jLabel1.setText("Nome Cidade:");

        jLabel2.setText("UF:");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        BtnFechar.setText("Fechar");
        BtnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(txtNomeCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtUf, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(BtnFechar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNomeCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 240, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnFechar)
                    .addComponent(btnSalvar))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Cadastra", jPanel1);

        tblBuscaCidade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(tblBuscaCidade);

        jLabel4.setText("Grupo:");

        btnPesquisaGrupo.setText("Busca");
        btnPesquisaGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaGrupoActionPerformed(evt);
            }
        });

        btnAlterar.setText("Editar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnInativar.setText("Inativar");
        btnInativar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInativarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtCidadeBusca)
                        .addGap(18, 18, 18)
                        .addComponent(btnPesquisaGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnInativar)
                        .addGap(18, 18, 18)
                        .addComponent(btnAlterar)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCidadeBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisaGrupo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlterar)
                    .addComponent(btnInativar))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Pesquisa", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnFecharActionPerformed
        fechaTela();
    }//GEN-LAST:event_BtnFecharActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (validaInsert()) {

            Cidade cidade = new Cidade();

            cidade.setCidade(txtNomeCidade.getText());
            cidade.setUf(txtUf.getText());
            cidade.setStatus("A");

            if (id > -1) {
                cidade.setId_cid(id);
                atualizar(cidade);
            } else {
                salvar(cidade);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Favor, verifique os dados");
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnPesquisaGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaGrupoActionPerformed
        Pesquisas.PesquisaCidade(tblBuscaCidade, txtCidadeBusca.getText());
    }//GEN-LAST:event_btnPesquisaGrupoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        id = Integer.parseInt(String.valueOf(tblBuscaCidade.getValueAt(tblBuscaCidade.getSelectedRow(), 0)));
        jTabbedPane1.setSelectedIndex(0);
        Session sessao = null;
        try {
            sessao = apoio.HibernateUtil.getSessionFactory().openSession();

            Cidade cidade = (Cidade) sessao.get(Cidade.class,
                    id);

            txtNomeCidade.setText(cidade.getCidade());
            txtUf.setText(cidade.getUf());

        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
            Log.geraLog("admin", "IfrCadCidade", "Alterar", hibEx.toString());
        } finally {
            sessao.close();
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnInativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInativarActionPerformed
        int id = Integer.parseInt(String.valueOf(tblBuscaCidade.getValueAt(tblBuscaCidade.getSelectedRow(), 0)));
        Cidade cidade = new Cidade();
        cidade.setId_cid(id);
        cidade.setStatus("X");
        inativar(cidade);
    }//GEN-LAST:event_btnInativarActionPerformed

    public boolean validaInsert() {

        String replaced = "";
        errors = "";

        //NomeGrupo
        if (txtNomeCidade.getText().length() == 0) {
            errors += "Preencha o Nome do Grupo - ";
        }

        //Selecione um Organizador
        if (txtNomeCidade.getText().length() == 0) {
            errors += "Preencha o Organizador - ";
        }

        return errors.equals("");

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnFechar;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnInativar;
    private javax.swing.JButton btnPesquisaGrupo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblBuscaCidade;
    private javax.swing.JTextField txtCidadeBusca;
    private javax.swing.JTextField txtNomeCidade;
    private javax.swing.JTextField txtUf;
    // End of variables declaration//GEN-END:variables
}
