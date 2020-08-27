/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apoio;

import entidades.Auditoria;
import java.util.Date;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author roger
 */
public class Audita {

    private static Auditoria audita;

    public Audita(Auditoria audita) {
        this.audita = audita;
    }

    public static boolean salvarAuditoria(String acao, String tabela, int user) {

        audita.setAction(acao);
        audita.setDate(new Date());
        audita.setTable(tabela);
        audita.setUser(user);

        Session sessao = null;
        sessao = apoio.HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();

        try {
            sessao = apoio.HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            int id = (int) sessao.save(audita);
            transacao.commit();

            audita.setId(id);

        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
            Log.geraLog("auditar", "Auditoria", "auditar", hibEx.toString());
        } finally {
            sessao.close();
        }
        return true;
    }
}
