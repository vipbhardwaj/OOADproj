package com.gamingCafe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "maintains", schema = "public")

public class Maintains {
    @Id
    public String emp_id;
    public String sys_num;

    public Maintains() {

    }

    public Maintains(String emp_id, String sys_num) {
        super();

        this.emp_id = emp_id;
        this.sys_num = sys_num;
    }

    @Column(name = "emp_id", nullable = false)
    public String getId() {
        return emp_id;
    }

    public void setId(String emp_id) {
        this.emp_id = emp_id;
    }

    @Column(name = "sys_num", nullable = false)
    public String getName() {
        return sys_num;
    }

    public void setName(String sys_num) {
        this.sys_num = sys_num;
    }

}