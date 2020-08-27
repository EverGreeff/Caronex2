/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apoio;

import entidades.Auditoria;
import java.util.Date;

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
        
        return true;
    }
}
