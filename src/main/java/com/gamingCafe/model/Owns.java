package com.gamingCafe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(OwnsComposite.class)
@Table(name = "owns", schema = "public")

public class Owns {
    @Id
    public String p_email;
    @Id
    public String g_id;

    public Owns() {

    }

    public Owns(String p_email, String g_id) {
        super();

        this.p_email = p_email;
        this.g_id = g_id;
    }

    @Column(name = "p_email", nullable = false)
    public String getP_email() {
        return p_email;
    }

    public void setP_email(String p_email) {
        this.p_email = p_email;
    }

    @Column(name = "g_id", nullable = false)
    public String getG_id() {
        return g_id;
    }

    public void setG_id(String g_id) {
        this.g_id = g_id;
    }
    
}