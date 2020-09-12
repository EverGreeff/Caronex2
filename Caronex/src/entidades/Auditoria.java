/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author roger
 */
@Entity
@Table(name = "cidade")

public class Auditoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user")
    private int user;

    @Column(name = "action")
    private String action;

    @Column(name = "table")
    private String table;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Auditoria{" + "id=" + id + ", user=" + user + ", action=" + action + ", table=" + table + ", date=" + date + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Auditoria other = (Auditoria) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}