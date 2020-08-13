/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author roger
 */
@Entity
@Table(name = "viagens")

public class Viagem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_viagem")
    private int id_viagem;

    @Column(name = "data_viagem")
    private String data_viagem;

    @Column(name = "valor_viagem")
    private String valor_viagem;

    @Column(name = "km_viagem")
    private String km_viagem;

    @Column(name = "horas_viagem")
    private String horas_viagem;

    @Column(name = "id_veiculo")
    private String id_veiculo;

    @Column(name = "id_motorista")
    private String id_motorista;

    @Column(name = "id_grupo")
    private String id_grupo;

    public int getId_viagem() {
        return id_viagem;
    }

    public void setId_viagem(int id_viagem) {
        this.id_viagem = id_viagem;
    }

    public String getData_viagem() {
        return data_viagem;
    }

    public void setData_viagem(String data_viagem) {
        this.data_viagem = data_viagem;
    }

    public String getValor_viagem() {
        return valor_viagem;
    }

    public void setValor_viagem(String valor_viagem) {
        this.valor_viagem = valor_viagem;
    }

    public String getKm_viagem() {
        return km_viagem;
    }

    public void setKm_viagem(String km_viagem) {
        this.km_viagem = km_viagem;
    }

    public String getHoras_viagem() {
        return horas_viagem;
    }

    public void setHoras_viagem(String horas_viagem) {
        this.horas_viagem = horas_viagem;
    }

    public String getId_veiculo() {
        return id_veiculo;
    }

    public void setId_veiculo(String id_veiculo) {
        this.id_veiculo = id_veiculo;
    }

    public String getId_motorista() {
        return id_motorista;
    }

    public void setId_motorista(String id_motorista) {
        this.id_motorista = id_motorista;
    }

    public String getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(String id_grupo) {
        this.id_grupo = id_grupo;
    }

}
