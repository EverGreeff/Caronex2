/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import apoio.Formatacao;
import apoio.TableSorter;
import apoio.Validacao;
///import dao.BairroDAO;
///import dao.CadLocaisDAO;
///import dao.CadPessoaDAO;
///import dao.CidadeDAO;
///import dao.EnderecoDAO;
///import dao.GrupoPessoaDAO;
///import dao.ViagemDAO;
import entidades.Endereco;
import entidades.Grupo_Pessoa;
import entidades.Viagem;
import java.awt.Color;
import java.sql.Date;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Rogério H. Klein <rhklein@universo.univates.br>
 */
public class IfrViagem extends javax.swing.JInternalFrame {

    private static IfrViagem tela;
    static Viagem viagem = new Viagem();

    TableSorter sorter;
    private int idGrupo;

    static JInternalFrame getInstancia() {
        if (tela == null) {
            tela = new IfrViagem();
        }
        return tela;
    }

    /**
     * Creates new form IfrViagem
     */
    public IfrViagem() {
        initComponents();

        //popula cabecalho da tabela
        /////new CadPessoaDAO().popularTabela(tblIntegrantes, null);

        //Formata
        Formatacao.formatarData(ftfDataSaida);
        Formatacao.formatarHora(ftfHoraSaida);
        Formatacao.formatarData(ftfDataRetorno);
        Formatacao.formatarHora(ftfHoraRetorno);
        Formatacao.formatarReal(ftfValorViagem);

    }

    private boolean camposObrigatorios(JTextField txfNomeGrupo, JTextField txfLocalEncontro, JTextField txfLocalDestino, JTextField txfValorViagem) {
        if (txfNomeGrupo.getText().equals("") || txfNomeGrupo.getText().equals(" ") || txfNomeGrupo.getText() == null) {
            JOptionPane.showMessageDialog(null, "Selecione Algum Grupo!");
            txfNomeGrupo.setBackground(Color.yellow);
            txfNomeGrupo.requestFocus();
            return false;
        }
        if (txfLocalEncontro.getText().equals("") || txfLocalEncontro.getText().equals(" ") || txfLocalEncontro.getText() == null) {
            JOptionPane.showMessageDialog(null, "Selecione Algum Local de Encontro!");
            txfLocalEncontro.setBackground(Color.yellow);
            txfLocalEncontro.requestFocus();
            return false;
        }
        if (txfLocalDestino.getText().equals("") || txfLocalDestino.getText().equals(" ") || txfLocalDestino.getText() == null) {
            JOptionPane.showMessageDialog(null, "Selecione Algum Local de Destino!");
            txfLocalDestino.setBackground(Color.yellow);
            txfLocalDestino.requestFocus();
            return false;
        }

        if (txfValorViagem.getText().equals("") || txfValorViagem.getText().equals(" ") || txfValorViagem.getText() == null) {
            JOptionPane.showMessageDialog(null, "Digite um Valor para a Viagem!");
            txfValorViagem.setBackground(Color.yellow);
            txfValorViagem.requestFocus();
            return false;
        }
        return true;
    }

    /*private boolean camposFormatados(JFormattedTextField ftfDataSaida, JFormattedTextField ftfHoraSaida, JFormattedTextField ftfDataRetorno) {
    if (Formatacao.removerFormatacao(ftfDataSaida.getText()).equals("") || Formatacao.removerFormatacao(ftfDataSaida.getText()).equals(" ") || Formatacao.removerFormatacao(ftfDataSaida.getText()) == null) {
    JOptionPane.showMessageDialog(null, "Digite uma Data para a Viagem!");
    ftfDataSaida.setBackground(Color.yellow);
    ftfDataSaida.requestFocus();
    return false;
    } else if (!Validacao.validarDataFormatada(ftfDataSaida.getText())) {
    JOptionPane.showMessageDialog(null, "Digite a Data Corretamente");
    ftfDataSaida.setBackground(Color.yellow);
    ftfDataSaida.requestFocus();
    return false;
    }
    
    if (ftfHoraSaida.getText().equals("") || ftfHoraSaida.getText().equals(" ") || ftfHoraSaida.getText() == null) {
    JOptionPane.showMessageDialog(null, "Digite uma Hora de Partida!");
    ftfHoraSaida.setBackground(Color.yellow);
    ftfHoraSaida.requestFocus();
    return false;
    } else if (!Validacao.validaHora(ftfHoraSaida.getText())) {
    JOptionPane.showMessageDialog(null, "Digite a Hora Corretamente");
    ftfHoraSaida.setBackground(Color.yellow);
    ftfHoraSaida.requestFocus();
    return false;
    }
    
    if (!Validacao.validarDataFormatada(ftfDataRetorno.getText())) {
    JOptionPane.showMessageDialog(null, "Digite a Data Corretamente");
    ftfDataRetorno.setBackground(Color.yellow);
    ftfDataRetorno.requestFocus();
    return false;
    }
    return true;
    }*/

    /*public void definirLocal(CadLocais idlocal, String local, String cidade, String endereco, String ed) {
    
    idGrupo = idlocal.getIdLocal();
    /////CadLocais i = new CadLocaisDAO().consultarId(idGrupo);
    if (i == null) {
    JOptionPane.showMessageDialog(null, "Registro não localizado!");
    } else {
    if (ed.equals("e")) {
    viagem.setIdLocalEncontro(idGrupo);
    txfLocalEncontro.setText(local);
    txfCidadeEncontro.setText(cidade);
    txfEnderecoEncontro.setText(endereco);
    } else {
    viagem.setIdLocalDestino(idGrupo);
    txfLocalDestino.setText(local);
    txfCidadeDestino.setText(cidade);
    txfEnderecoDestino.setText(endereco);
    }
    
    }
    }*/

    ///public void definirGrupo(GrupoPessoa gruposs) {
        ///idGrupo = gruposs.getIdGrupo();
        /////GrupoPessoa i = new GrupoPessoaDAO().consultarId(idGrupo);
        ///viagem.setIdGrupo(idGrupo);
        ///if (i == null) {
        ///    JOptionPane.showMessageDialog(null, "Registro não localizado!");
        ///} else {
            //Define nome do Grupo
            ///txfNomeGrupo.setText(i.getNomeGrupo());

            //Popula integrantes do Grupo
            /////new CadPessoaDAO().popularTabela(tblIntegrantes, "", idGrupo);

            //Popula Campos Locais
            ////CadLocais localE = new CadLocaisDAO().consultarId(i.getIdLocalEncontro());
            ////Endereco endE = new EnderecoDAO().consultarId(localE.getIdEnd());
            ////Bairro bairroE = new BairroDAO().consultarId(endE.getIdBairro());
            ////Cidade cidadeE = new CidadeDAO().consultarId(bairroE.getId_cid());
            ///txfCidadeEncontro.setText(cidadeE.getCidade());
            ///txfEnderecoEncontro.setText(endE.getLogradouro());
            ///txfLocalEncontro.setText(localE.getLocal());
            ///viagem.setIdLocalEncontro(i.getIdLocalEncontro());

            //Popula Campos Locais
            ////CadLocais localD = new CadLocaisDAO().consultarId(i.getIdLocalDestino());
            ////Endereco endD = new EnderecoDAO().consultarId(localD.getIdEnd());
            ////Bairro bairroD = new BairroDAO().consultarId(endD.getIdBairro());
            //// Cidade cidadeD = new CidadeDAO().consultarId(bairroD.getId_cid());
            ///txfCidadeDestino.setText(cidadeD.getCidade());
            ///txfEnderecoDestino.setText(endD.getLogradouro());
            ///txfLocalDestino.setText(localD.getLocal());
            ///viagem.setIdLocalDestino(i.getIdLocalDestino());

            //numero de pessoas no grupo
            ///txfNumPessoas.setText(String.valueOf(tblIntegrantes.getRowCount()));

         ///   System.out.println("Locais Carregados com sucesso");
        ///}
    ///}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblIntegrantes = new javax.swing.JTable();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnLocalEncontro = new javax.swing.JButton();
        btnLocalDestino = new javax.swing.JButton();
        btnGrupo = new javax.swing.JButton();
        btnBuscaIntegrante = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txfLocalEncontro = new javax.swing.JTextField();
        txfLocalDestino = new javax.swing.JTextField();
        txfCidadeEncontro = new javax.swing.JTextField();
        txfCidadeDestino = new javax.swing.JTextField();
        txfEnderecoEncontro = new javax.swing.JTextField();
        txfEnderecoDestino = new javax.swing.JTextField();
        txfNomeGrupo = new javax.swing.JTextField();
        txfIntegrante = new javax.swing.JTextField();
        txfValorPessoa = new javax.swing.JTextField();
        txfNumPessoas = new javax.swing.JTextField();
        ftfDataSaida = new javax.swing.JFormattedTextField();
        ftfHoraSaida = new javax.swing.JFormattedTextField();
        ftfValorViagem = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        ftfDataRetorno = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        ftfHoraRetorno = new javax.swing.JFormattedTextField();
        cbxStatusViagem = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();

        setTitle("Controle de Viagens");

        tblIntegrantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblIntegrantes);

        btnSalvar.setText("Salvar Viagem");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnLocalEncontro.setText("Local");
        btnLocalEncontro.setNextFocusableComponent(btnLocalDestino);
        btnLocalEncontro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalEncontroActionPerformed(evt);
            }
        });

        btnLocalDestino.setText("Local");
        btnLocalDestino.setNextFocusableComponent(ftfDataSaida);
        btnLocalDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalDestinoActionPerformed(evt);
            }
        });

        btnGrupo.setText("Local");
        btnGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrupoActionPerformed(evt);
            }
        });

        btnBuscaIntegrante.setText("Busca");
        btnBuscaIntegrante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaIntegranteActionPerformed(evt);
            }
        });

        jLabel1.setText("Local Encontro*");

        jLabel2.setText("Local Destino*");

        jLabel3.setText("Horário Saída*");

        jLabel4.setText("Data Saída*");

        jLabel6.setText("Valor Viagem*");

        jLabel7.setText("Procurar Integrante:");

        jLabel8.setText("Cidade");

        jLabel9.setText("Cidade");

        jLabel10.setText("Endereço");

        jLabel11.setText("Endereço");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Integrantes da Viagem:");

        jLabel13.setText("Nome do Grupo*");

        jLabel14.setText("Valor por Pessoas:");

        jLabel15.setText("Nº Pessoas:");

        txfLocalEncontro.setEditable(false);

        txfLocalDestino.setEditable(false);

        txfCidadeEncontro.setEditable(false);

        txfCidadeDestino.setEditable(false);

        txfEnderecoEncontro.setEditable(false);

        txfEnderecoDestino.setEditable(false);

        txfNomeGrupo.setEditable(false);
        txfNomeGrupo.setFocusCycleRoot(true);
        txfNomeGrupo.setNextFocusableComponent(btnLocalEncontro);

        txfIntegrante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfIntegranteKeyPressed(evt);
            }
        });

        txfValorPessoa.setEditable(false);

        txfNumPessoas.setEditable(false);

        ftfDataSaida.setNextFocusableComponent(ftfHoraSaida);
        ftfDataSaida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ftfDataSaidaKeyPressed(evt);
            }
        });

        ftfHoraSaida.setNextFocusableComponent(ftfValorViagem);
        ftfHoraSaida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ftfHoraSaidaKeyPressed(evt);
            }
        });

        ftfValorViagem.setNextFocusableComponent(btnSalvar);
        ftfValorViagem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ftfValorViagemKeyPressed(evt);
            }
        });

        jLabel5.setText("Data Retorno");

        ftfDataRetorno.setNextFocusableComponent(ftfHoraSaida);
        ftfDataRetorno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ftfDataRetornoKeyPressed(evt);
            }
        });

        jLabel16.setText("Horário Retorno");

        ftfHoraRetorno.setNextFocusableComponent(ftfValorViagem);
        ftfHoraRetorno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ftfHoraRetornoKeyPressed(evt);
            }
        });

        cbxStatusViagem.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Programada", "Em Andamento", "Retornando", "Finalizada", "Cancelada" }));
        cbxStatusViagem.setEnabled(false);
        cbxStatusViagem.setSelectedIndex(1);

        jLabel17.setText("Status Viagem:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(423, 423, 423)
                        .addComponent(btnSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(41, 41, 41)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfIntegrante)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscaIntegrante))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(jLabel3)
                                                            .addComponent(jLabel4))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(ftfHoraSaida)
                                                            .addComponent(ftfDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addComponent(jLabel6)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(ftfValorViagem, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addComponent(txfEnderecoEncontro, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(9, 9, 9)
                                                .addComponent(jLabel14)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txfValorPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addComponent(jLabel11)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(txfEnderecoDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(ftfDataRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(ftfHoraRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(58, 58, 58)
                                                .addComponent(jLabel17)
                                                .addGap(18, 18, 18)
                                                .addComponent(cbxStatusViagem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                    .addComponent(txfNomeGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txfLocalEncontro, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnLocalEncontro, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txfCidadeEncontro, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel8)
                                                .addGap(10, 10, 10)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txfCidadeDestino)
                                            .addComponent(txfLocalDestino, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(366, 366, 366)
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txfNumPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLocalDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txfNomeGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txfLocalEncontro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLocalEncontro, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfLocalDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnLocalDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txfCidadeEncontro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfCidadeDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfEnderecoEncontro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txfEnderecoDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ftfDataRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ftfHoraRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfNumPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ftfDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ftfHoraSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(ftfValorViagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfValorPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(cbxStatusViagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscaIntegrante, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfIntegrante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalvar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        //limpa tela
        limpaTela();
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnLocalEncontroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalEncontroActionPerformed
        ////JdlLocal busca = new JdlLocal(null, true, this, "e");
        ///busca.setLocationRelativeTo(this);
        ///busca.setVisible(true);
        ///txfLocalEncontro.setBackground(null);
    }//GEN-LAST:event_btnLocalEncontroActionPerformed

    private void btnLocalDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalDestinoActionPerformed
        ////JdlLocal busca = new JdlLocal(null, true, this, "d");
        ////busca.setLocationRelativeTo(this);
        ////busca.setVisible(true);
        ////txfLocalDestino.setBackground(null);
    }//GEN-LAST:event_btnLocalDestinoActionPerformed

    private void btnGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrupoActionPerformed
        ////JdlGrupo busca = new JdlGrupo(null, true, this, "d");
        ////busca.setLocationRelativeTo(this);
        ////busca.setVisible(true);
        ////txfNomeGrupo.setBackground(null);
    }//GEN-LAST:event_btnGrupoActionPerformed

    private void btnBuscaIntegranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaIntegranteActionPerformed
        /////new CadPessoaDAO().popularTabela(tblIntegrantes, txfIntegrante.getText(), idGrupo);
    }//GEN-LAST:event_btnBuscaIntegranteActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        /*if (camposObrigatorios(txfNomeGrupo, txfLocalEncontro, txfLocalDestino, ftfValorViagem) && camposFormatados(ftfDataSaida, ftfHoraSaida, ftfDataRetorno)) {
        Date dataNula = new Date(0);
        String horaNula = "00:00:00";
        //campo date vazio
        
        if (Formatacao.removerFormatacao(ftfDataRetorno.getText()).trim().isEmpty()) {
        ///viagem.setDataRetornoViagem(dataNula);
        } else {
        ///viagem.setDataRetornoViagem(Date.valueOf(Formatacao.ajustaDataAMD(ftfDataRetorno.getText())));
        }
        
        if (Formatacao.removerFormatacao(ftfHoraRetorno.getText()).trim().isEmpty()) {
        ////viagem.setHoraRetornoViagem(horaNula);
        } else {
        ////viagem.setHoraRetornoViagem(ftfHoraRetorno.getText());
        
        }
        ///viagem.setDataCriacaoViagem(Formatacao.getDataHoraAtualDate());
        ///viagem.setDataSaidaViagem(Date.valueOf(Formatacao.ajustaDataAMD(ftfDataSaida.getText())));
        ///viagem.setHoraSaidaViagem(ftfHoraSaida.getText());
        ///viagem.setNumPessoas(Integer.valueOf(txfNumPessoas.getText()));
        ///viagem.setValorViagem(Double.parseDouble(ftfValorViagem.getText().replace(",", ".")));
        ///viagem.setStatusViagem(cbxStatusViagem.getSelectedIndex());
        
        
        
        ////ViagemDAO viagemDAO = new ViagemDAO();
        //String retorno = viagemDAO.salvar(viagem);
        
        //if (retorno == null) {
        //    int idViagem = viagemDAO.consultarUltimoId();
        
        //teste fim
        //    JOptionPane.showMessageDialog(null, "Viagem de número " + idViagem + " registrada com sucesso!");
        
        //limpa tela
        //    limpaTela();
        
        //} else {
        //    JOptionPane.showMessageDialog(null, "Ops! Problemas ao salvar registro.");
        //}
        
        }*/
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void ftfDataSaidaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftfDataSaidaKeyPressed
        ftfDataSaida.setBackground(Color.white);
    }//GEN-LAST:event_ftfDataSaidaKeyPressed

    private void ftfHoraSaidaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftfHoraSaidaKeyPressed
        ftfHoraSaida.setBackground(Color.white);
    }//GEN-LAST:event_ftfHoraSaidaKeyPressed

    private void ftfValorViagemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftfValorViagemKeyPressed
        ftfValorViagem.setBackground(Color.white);
    }//GEN-LAST:event_ftfValorViagemKeyPressed

    private void txfIntegranteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfIntegranteKeyPressed
        txfIntegrante.setBackground(Color.white);
    }//GEN-LAST:event_txfIntegranteKeyPressed

    private void ftfDataRetornoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftfDataRetornoKeyPressed
        ftfDataRetorno.setBackground(Color.white);
    }//GEN-LAST:event_ftfDataRetornoKeyPressed

    private void ftfHoraRetornoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftfHoraRetornoKeyPressed
        ftfHoraRetorno.setBackground(Color.white);
    }//GEN-LAST:event_ftfHoraRetornoKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscaIntegrante;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGrupo;
    private javax.swing.JButton btnLocalDestino;
    private javax.swing.JButton btnLocalEncontro;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cbxStatusViagem;
    private javax.swing.JFormattedTextField ftfDataRetorno;
    private javax.swing.JFormattedTextField ftfDataSaida;
    private javax.swing.JFormattedTextField ftfHoraRetorno;
    private javax.swing.JFormattedTextField ftfHoraSaida;
    private javax.swing.JFormattedTextField ftfValorViagem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblIntegrantes;
    private javax.swing.JTextField txfCidadeDestino;
    private javax.swing.JTextField txfCidadeEncontro;
    private javax.swing.JTextField txfEnderecoDestino;
    private javax.swing.JTextField txfEnderecoEncontro;
    private javax.swing.JTextField txfIntegrante;
    private javax.swing.JTextField txfLocalDestino;
    private javax.swing.JTextField txfLocalEncontro;
    private javax.swing.JTextField txfNomeGrupo;
    private javax.swing.JTextField txfNumPessoas;
    private javax.swing.JTextField txfValorPessoa;
    // End of variables declaration//GEN-END:variables

    private void limpaTela() {
        txfCidadeDestino.setText("");
        txfNomeGrupo.setText("");
        ftfValorViagem.setText("0");
        ftfDataSaida.setText("");
        ftfHoraSaida.setText("");
        ftfDataRetorno.setText("");
        ftfHoraRetorno.setText("");
        txfCidadeEncontro.setText("");
        txfEnderecoEncontro.setText("");
        txfLocalEncontro.setText("");
        txfCidadeDestino.setText("");
        txfEnderecoDestino.setText("");
        txfLocalDestino.setText("");
        txfNumPessoas.setText("");
        txfIntegrante.setText("");

        txfCidadeDestino.setBackground(null);
        txfNomeGrupo.setBackground(null);
        ftfValorViagem.setBackground(Color.white);
        ftfDataSaida.setBackground(Color.white);
        ftfHoraSaida.setBackground(Color.white);
        ftfDataRetorno.setBackground(Color.white);
        ftfHoraRetorno.setBackground(Color.white);
        txfCidadeEncontro.setBackground(null);
        txfEnderecoEncontro.setBackground(null);
        txfLocalEncontro.setBackground(null);
        txfCidadeDestino.setBackground(null);
        txfEnderecoDestino.setBackground(null);
        txfLocalDestino.setBackground(null);
        txfNumPessoas.setBackground(null);
        txfIntegrante.setBackground(Color.white);

        /////new CadPessoaDAO().popularTabela(tblIntegrantes, null);
    }

}
