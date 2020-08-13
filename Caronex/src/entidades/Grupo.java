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
@Table(name = "grupo")

public class Grupo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grupo")
    private int id_grupo;

    @Column(name = "nome_grupo")
    private String nome_grupo;

    @Column(name = "admin")
    private int id_admin; //id_pessoa

    @Column(name = "status")
    private String status;

    public int getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }

    public String getNome_grupo() {
        return nome_grupo;
    }

    public void setNome_grupo(String nome_grupo) {
        this.nome_grupo = nome_grupo;
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
