package com.gamingCafe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;

@Entity
@Table(name = "buys", schema = "public")

public class Buys {
    @Id
    public String p_email;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pkg_id", nullable = true, updatable = false, insertable = false)
    private Package pkg;
    public String pkg_id;

    public Buys() {

    }

    public Buys(String p_email, String pkg_id) {
        super();

        this.p_email = p_email;
        this.pkg_id = pkg_id;
    }

    @Column(name = "p_email")
    public String getEmail() {
        return p_email;
    }

    public void setEmail(String email) {
        this.p_email = email;
    }

    @Column(name = "pkg_id")
    public String getPkg() {
        return pkg_id;
    }

    public void setPkg(String name) {
        this.pkg_id = name;
    }

}