/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author roger
 */
@Entity
@Table(name = "grupo")
public class Grupo implements Serializable {

    private int id_grupo;

    private Set<Pessoa> pessoas;

    private String nome_grupo;

    private int id_admin; //id_pessoa

    private String status;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grupo")
    public int getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }

    @Column(name = "nome_grupo")
    public String getNome_grupo() {
        return nome_grupo;
    }

    public void setNome_grupo(String nome_grupo) {
        this.nome_grupo = nome_grupo;
    }

    @Column(name = "admin")
    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @ManyToMany
    @JoinTable(name = "grupo_pessoa",
            joinColumns = {
                @JoinColumn(name = "id_grupo")},
            inverseJoinColumns = {
                @JoinColumn(name = "id_pessoa")})
    public Set<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(Set<Pessoa> grupoPessoa) {
        this.pessoas = grupoPessoa;
    }
}
