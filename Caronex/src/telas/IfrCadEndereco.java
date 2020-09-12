/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import apoio.*;
import entidades.Cidade;
import entidades.Endereco;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author everton
 */
public class IfrCadEndereco extends javax.swing.JInternalFrame {

    private static IfrCadEndereco tela;
    String errors;
    public static int id_cidade;

    public int id = -1;
    
    Cidade c;

    /**
     * Creates new form IfrCadEndereco
     */
    public IfrCadEndereco() {
        initComponents();
        this.setTitle("Cadastrar Endereço");
        Pesquisas.PesquisaEndereco(tblBuscaEndereco, "");
        // aplica mascaras
        // btnBuscaResp.setVisible(false);
    }

    public static IfrCadEndereco getInstancia() {
        if (tela == null) {
            tela = new IfrCadEndereco();
        }
        return tela;
    }
    
    public void trazerCidade(Cidade cidade) {
        id_cidade = cidade.getId_cid();
        txtCidade.setText(cidade.getCidade());
    }
    

    private void fechaTela() {
        GerenciarJanelas.fecharJanela(tela);
        tela = null;
    }

    public void salvar(Endereco u) {

        Session sessao = null;
        sessao = apoio.HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();

        try {
            sessao = apoio.HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            int id = (int) sessao.save(u);
            transacao.commit();
            u.setId_end(id);
            //Audita.salvarAuditoria("SalvarEndereco", "Endereco", 1);

            JOptionPane.showMessageDialog(null, "Endereço criado com sucesso!");
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
            Log.geraLogBD("admin", "salvar", "dao", hibEx.toString());
        } finally {
            sessao.close();
        }
    }

    public void atualizar(Endereco u) {
        Session sessao = null;
        sessao = apoio.HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();
        try {
            sessao.update(u);
            transacao.commit();
            //Audita.salvarAuditoria("AtualizarEndereco", "Endereco", 1);
            
            JOptionPane.showMessageDialog(null, "Endereço editado com sucesso!");

        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
            Log.geraLogBD("admin", "atualizar", "dao", hibEx.toString());
        } finally {
            sessao.close();
        }
    }

    public void inativar(Endereco u) {
        if (JOptionPane.showConfirmDialog(null, "Tem Certeza que deseja Inativar este Endereço?") == 0) {
            Session sessao = null;
            List resultado = null;
            sessao = apoio.HibernateUtil.getSessionFactory().openSession();
            Transaction transacao = sessao.beginTransaction();
            org.hibernate.Query query = sessao.createQuery("FROM Endereco WHERE id = " + u.getId_end());

            try {

                resultado = query.list();
                for (Object obj : resultado) {
                    Endereco endereco = (Endereco) obj;
                    endereco.setStatus(u.getStatus());
                    sessao.update(endereco);
                    transacao.commit();
                    //Audita.salvarAuditoria("InativarEndereco", "Endereco", 1);
                }

            } catch (HibernateException hibEx) {
                hibEx.printStackTrace();
                Log.geraLogBD("admin", "inativar", "dao", hibEx.toString());
            } finally {
                JOptionPane.showMessageDialog(null, "Endereço Desativado");
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
        txtLogradouro = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        BtnFechar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        txtComplemento = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBuscaEndereco = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtEnderecoBusca = new javax.swing.JTextField();
        btnPesquisaEndereco = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnInativar = new javax.swing.JButton();

        jLabel1.setText("Logradouro:");

        jLabel2.setText("Número:");

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

        jLabel3.setText("Bairro:");

        jLabel5.setText("Complemento:");

        jLabel6.setText("Cidade:");

        jButton1.setText("Buscar Cidade");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(BtnFechar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtLogradouro)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCidade, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))
                            .addComponent(txtComplemento, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtBairro, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNumero))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnFechar)
                    .addComponent(btnSalvar))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Cadastra", jPanel1);

        tblBuscaEndereco.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jScrollPane1.setViewportView(tblBuscaEndereco);

        jLabel4.setText("Grupo:");

        btnPesquisaEndereco.setText("Busca");
        btnPesquisaEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaEnderecoActionPerformed(evt);
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
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtEnderecoBusca, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPesquisaEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(txtEnderecoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisaEndereco))
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

            Endereco endereco = new Endereco();

            endereco.setLogradouro(txtLogradouro.getText());
            endereco.setBairro(txtBairro.getText());
            endereco.setComplemento(txtComplemento.getText());
            endereco.setNumero(Integer.parseInt(txtNumero.getText()));
            endereco.setCidade_id_cid(id_cidade);
            endereco.setStatus("A");

            if (id > -1) {
                endereco.setId_end(id);
                atualizar(endereco);
            } else {
                salvar(endereco);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Favor, verifique os dados");
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnPesquisaEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaEnderecoActionPerformed
        Pesquisas.PesquisaEndereco(tblBuscaEndereco, txtEnderecoBusca.getText());
    }//GEN-LAST:event_btnPesquisaEnderecoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        id = Integer.parseInt(String.valueOf(tblBuscaEndereco.getValueAt(tblBuscaEndereco.getSelectedRow(), 0)));
        jTabbedPane1.setSelectedIndex(0);
        Session sessao = null;
        try {
            sessao = apoio.HibernateUtil.getSessionFactory().openSession();

            Endereco endereco = (Endereco) sessao.get(Endereco.class, id);
            Cidade cidade = (Cidade) sessao.get(Cidade.class, endereco.getCidade_id_cid());
            
            txtLogradouro.setText(endereco.getLogradouro());
            txtNumero.setText(String.valueOf(endereco.getNumero()));
            txtBairro.setText(endereco.getBairro());
            txtComplemento.setText(endereco.getComplemento());
            txtCidade.setText(cidade.getCidade());
            
            id_cidade = cidade.getId_cid();


        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
            Log.geraLog("admin", "IfrCadEndereco", "Alterar", hibEx.toString());
        } finally {
            sessao.close();
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    
    private void btnInativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInativarActionPerformed
        int id = Integer.parseInt(String.valueOf(tblBuscaEndereco.getValueAt(tblBuscaEndereco.getSelectedRow(), 0)));
        Endereco endereco = new Endereco();
        endereco.setId_end(id);
        endereco.setStatus("X");
        inativar(endereco);
    }//GEN-LAST:event_btnInativarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DlgCidade dlgCidade = new DlgCidade(null, true, txtCidade.getText(), this);
        dlgCidade.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    public boolean validaInsert() {

        String replaced = "";
        errors = "";

        //NomeGrupo
        if (txtLogradouro.getText().length() == 0) {
            errors += "Preencha o Nome do Grupo - ";
        }

        //Selecione um Organizador
        if (txtLogradouro.getText().length() == 0) {
            errors += "Preencha o Organizador - ";
        }

        return errors.equals("");

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnFechar;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnInativar;
    private javax.swing.JButton btnPesquisaEndereco;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblBuscaEndereco;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JTextField txtEnderecoBusca;
    private javax.swing.JTextField txtLogradouro;
    private javax.swing.JTextField txtNumero;
    // End of variables declaration//GEN-END:variables
}