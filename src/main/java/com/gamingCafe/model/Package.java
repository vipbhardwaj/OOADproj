package com.gamingCafe.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "package", schema = "public")

public class Package {
    @Id
    private String pkg_id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pkg")
    public List<Buys> buys;
    public String pkg_name;
    public int pkg_price;
    public int pkg_hours;

    public Package() {

    }

    public Package(String pkg_id, String pkg_name, int pkg_price, int pkg_hours) {
        super();

        this.pkg_id = pkg_id;
        this.pkg_name = pkg_name;
        this.pkg_price = pkg_price;
        this.pkg_hours = pkg_hours;
    }

    @Column(name = "pkg_id", nullable = false)
    public String getId() {
        return pkg_id;
    }

    public void setId(String pkg_id) {
        this.pkg_id = pkg_id;
    }

    @Column(name = "pkg_name", nullable = false)
    public String getName() {
        return pkg_name;
    }

    public void setName(String pkg_name) {
        this.pkg_name = pkg_name;
    }

    @Column(name = "pkg_price", nullable = false)
    public int getPrice() {
        return pkg_price;
    }

    public void setPrice(int pkg_price) {
        this.pkg_price = pkg_price;
    }

    @Column(name = "pkg_hours", nullable = false)
    public int getHours() {
        return pkg_hours;
    }

    public void setHours(int pkg_hours) {
        this.pkg_hours = pkg_hours;
    }

}
