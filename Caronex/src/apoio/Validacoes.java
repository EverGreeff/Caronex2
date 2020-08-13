/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apoio;

/**
 *
 * @author roger
 */

import entidades.Login;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;

public class Validacoes {

    public static boolean logar(String login, String senha) {
        boolean pas = false;
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Login> resultado = new ArrayList();
        String sql = "FROM login";
        try {
            org.hibernate.Query query = sessao.createQuery(sql);
            resultado = query.list();
            for (int i = 0; i < resultado.size(); i++) {
                Login loginDB = resultado.get(i);
                if (loginDB.getLogin().equals(login) && loginDB.getSenha().equals(senha)) {
                    if (loginDB.getStatus().equals("A")) {
                        pas = true;
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro não previsto!\n" + e, "Erro!", JOptionPane.ERROR_MESSAGE);
        } finally {
            sessao.close();
        }
        return pas;
    }

}
