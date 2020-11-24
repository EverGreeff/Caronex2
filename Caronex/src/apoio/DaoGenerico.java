/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apoio;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import apoio.HibernateUtil;
import apoio.Log;
import org.hibernate.Query;

/**
 *
 * @author roger
 */
public class DaoGenerico {

    public static DaoGenerico daoGenerico = null;

    private static String userName;
    private SessionFactory factory;
    private Transaction transaction;

    public void setarNome(String username) {
        userName = username;
    }

    public String pegarNome() {
        return userName;
    }

    public DaoGenerico() {
        factory = HibernateUtil.getSessionFactory();
    }

    public static DaoGenerico getInstance() {
        if (daoGenerico == null) {
            daoGenerico = new DaoGenerico();
        }
        return daoGenerico;
    }

    public boolean inserir(Object o) {
        boolean retorno = false;
        Session sessao = factory.openSession();
        try {
            transaction = sessao.beginTransaction();
            Query query = sessao.createSQLQuery("SET SESSION \"myapp.user\" = '" + userName + "'");
            query.executeUpdate();
            sessao.save(o);
            transaction.commit();
            retorno = true;
            Audita.salvarAuditoria("Inserir", o.getClass().toString(), 1);
        } catch (Exception e) {
            transaction.rollback();
            retorno = false;
            e.printStackTrace();
            Log.geraLogBD(userName, "inserir", o.getClass(), e.toString());
        } finally {
            sessao.close();
        }
        return retorno;
    }

    public int inserirSerial(Object o) {

        int id = -1;
        Session sessao = factory.openSession();
        try {
            transaction = sessao.beginTransaction();
            Query query = sessao.createSQLQuery("SET SESSION \"myapp.user\" = '" + userName + "'");
            query.executeUpdate();
            id = (Integer) sessao.save(o);
            transaction.commit();

            Audita.salvarAuditoria("Inserir", o.getClass().toString(), 1);
        } catch (Exception e) {
            transaction.rollback();

            e.printStackTrace();
            Log.geraLogBD(userName, "Inserir", o.getClass(), e.toString());
        } finally {
            sessao.close();
        }

        return id;
    }

    public boolean atualizar(Object o) {
        boolean retorno = false;
        Session sessao = factory.openSession();
        try {
            transaction = sessao.beginTransaction();
            Query query = sessao.createSQLQuery("SET SESSION \"myapp.user\" = '" + userName + "'");
            query.executeUpdate();
            sessao.update(o);
            transaction.commit();
            retorno = true;
            Audita.salvarAuditoria("Atualizar", o.getClass().toString(), 1);
        } catch (Exception e) {
            transaction.rollback();
            retorno = false;
            e.printStackTrace();
            Log.geraLogBD(userName, "Atualizar", o.getClass(), e.toString());
        } finally {
            sessao.close();
        }
        return retorno;
    }

    public boolean excluir(Class classe, int id) {
        boolean retorno = false;
        Session sessao = factory.openSession();
        try {
            transaction = sessao.beginTransaction();

            Object entidade = sessao.load(classe, id);
            Query query = sessao.createSQLQuery("SET SESSION \"myapp.user\" = '" + userName + "'");
            query.executeUpdate();

            sessao.delete(entidade);

            transaction.commit();

            retorno = true;
            Audita.salvarAuditoria("Excluir", classe.toString(), 1);
        } catch (Exception e) {
            transaction.rollback();
            retorno = false;
            e.printStackTrace();
            Log.geraLogBD(userName, "Excluir", classe, e.toString());
        } finally {
            sessao.close();
        }

        return retorno;
    }

    public Object obterPorId(Class classe, int id) {

        Session sessao = factory.openSession();
        try {
            Object entidade = sessao.get(classe, id);

            return entidade;

        } catch (Exception e) {
            e.printStackTrace();
            Log.geraLogBD(userName, "obterPorId", classe, e.toString());
        } finally {
            sessao.close();
        }
        return null;
    }

}
//        List dogs = (List)session.createQuery("from Dog").list();
//        System.out.println("Dogs: " + Arrays.toString(dogs.toArray()));
