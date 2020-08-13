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
        String sql = "FROM cad_pessoa "
                + "WHERE nome LIKE '%" + nome + "%' "
                + "ORDER BY nome";
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

    public static void PesquisaVeiculo(JTable tabela, String placa) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Veiculo> resultado = new ArrayList();
        String sql = "FROM cad_veiculo "
                + "WHERE placa LIKE '%" + placa + "%' "
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
