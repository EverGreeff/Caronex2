/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apoio;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import entidades.*;

/**
 *
 * @author roger
 */
public class Pesquisas {

    public static void PesquisaPessoa(JTable tabela, String nome) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Pessoa> resultado = new ArrayList();
        String sql = "FROM Pessoa "
                + "WHERE nome LIKE '%" + nome + "%' "
                + "AND status != 'X'"
                + "ORDER BY nome";
        //padroniza a JTable
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        
        //verificar o getColumn(não pode ter o numero maior do que o Num de Colunas
        tabela.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        tabela.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        tabela.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        tabela.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        
        tabela.getColumnModel().getColumn(0).setPreferredWidth(40);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(140);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(140);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(140);
        
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        //fim Jtable
        //começa IO
        try {
            org.hibernate.Query query = sessao.createQuery(sql);
            resultado = query.list();
            for (int i = 0; i < resultado.size(); i++) {
                Pessoa pessoa = resultado.get(i);
                modelo.addRow(new Object[]{
                    pessoa.getId_pessoa(),
                    pessoa.getIdentidade(),
                    pessoa.getNome(),
                    pessoa.getCpf(),
                    pessoa.getStatus(),
                    pessoa.getIdade(),
                    pessoa.getId_responsavel()});
            }
        } catch (HibernateException e) {

        } finally {
            sessao.close();
        }
    }

    public static void PesquisaGrupo(JTable tabela, String nomeGrupo) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Grupo> resultado = new ArrayList();
        String sql = "FROM Grupo "
                + "WHERE nome_grupo LIKE '%" + nomeGrupo + "%' "
                + "AND status != 'X'"
                + "ORDER BY nome_grupo";
        //padroniza a JTable
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        
        String[] headers = {"Id Grupo","Nome do Grupo","Stat","Adm"};
        int[] widths = {30,130,30,100}; 
        
        for (int i = 0; i < 4; i++) {
            //centraliza
            tabela.getColumnModel().getColumn(i).setCellRenderer(centralizado);
            //seta a largura
            tabela.getColumnModel().getColumn(i).setPreferredWidth(40);
            //seta o header
            tabela.getColumnModel().getColumn(i).setHeaderValue(headers[i]);
        }
        
        //verificar o getColumn(não pode ter o numero maior do que o Num de Colunas
        /*tabela.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        tabela.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        tabela.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        tabela.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        
        tabela.getColumnModel().getColumn(0).setPreferredWidth(40);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(140);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(40);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(40);
        //
        
        tabela.getColumnModel().getColumn(0).setHeaderValue(headers[0]);
        tabela.getColumnModel().getColumn(1).setHeaderValue(headers[1]);
        tabela.getColumnModel().getColumn(2).setHeaderValue(headers[2]);
        tabela.getColumnModel().getColumn(3).setHeaderValue(headers[3]);*/
        
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        //fim Jtable
        //começa IO
        try {
            org.hibernate.Query query = sessao.createQuery(sql);
            resultado = query.list();
            for (int i = 0; i < resultado.size(); i++) {
                Grupo grupo = resultado.get(i);
                modelo.addRow(new Object[]{
                    grupo.getId_grupo(),
                    grupo.getNome_grupo(),
                    grupo.getStatus(),
                    grupo.getId_admin()
                });
            }
        } catch (HibernateException e) {

        } finally {
            sessao.close();
        }
    }
public static void PesquisaVeiculo(JTable tabela, String placa) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Veiculo> resultado = new ArrayList();
        String sql = "FROM cad_veiculo "
                + "WHERE placa LIKE '%" + placa + "%' "
                + "AND status != 'X'"
                + "ORDER BY placa";
        //padroniza a JTable
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        tabela.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        tabela.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        tabela.getColumnModel().getColumn(5).setCellRenderer(centralizado);
        tabela.getColumnModel().getColumn(6).setCellRenderer(centralizado);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(40);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(140);
        tabela.getColumnModel().getColumn(4).setPreferredWidth(150);
        tabela.getColumnModel().getColumn(5).setPreferredWidth(150);
        tabela.getColumnModel().getColumn(6).setPreferredWidth(50);
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        //fim Jtable
        //começa IO
        try {
            org.hibernate.Query query = sessao.createQuery(sql);
            resultado = query.list();
            for (int i = 0; i < resultado.size(); i++) {
                Veiculo veiculo = resultado.get(i);
                modelo.addRow(new Object[]{
                    veiculo.getId_veiculo(),
                    veiculo.getPlaca(),
                    veiculo.getKml(),
                    veiculo.getValor_disp_km(),
                    veiculo.getMarca(),
                    veiculo.getModelo(),
                    veiculo.getCor()});
            }
        } catch (HibernateException e) {

        } finally {
            sessao.close();
        }
    }

    
}
