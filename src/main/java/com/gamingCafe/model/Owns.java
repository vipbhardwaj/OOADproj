package com.gamingCafe.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@IdClass(OwnsComposite.class)
@Table(name = "owns", schema = "public")

public class Owns {
    @Id
    @Column(name = "p_email")
    public String pEmail;
    // @ManyToMany
    // Set<Game> games;
    @Id
    @Column(name = "g_id")
    public String gid;

    public Owns() {

    }

    public Owns(String p_email, String gid) {
        super();

        this.pEmail = p_email;
        this.gid = gid;
    }

    public String getP_email() {
        return pEmail;
    }

    public void setP_email(String p_email) {
        this.pEmail = p_email;
    }

    public String getG_id() {
        return gid;
    }

    public void setG_id(String gid) {
        this.gid = gid;
    }
    
}