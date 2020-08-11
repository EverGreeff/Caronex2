/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Everton
 */
public class Veiculo {
    

    @Id
    private int id;
    
    private String data_viagem;
    private String valor_viagem;
    private String km_viagem;
    private String horas_viagem;
    private String id_veiculo;
    private String id_motorista;
    private String id_grupo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
