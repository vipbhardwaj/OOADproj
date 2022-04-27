package com.gamingCafe.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee", schema = "public")

public class EmpLogin implements Serializable {
    @Id
    private String emp_id;
    public String emp_name;
    public String emp_phno;
    public String emp_address;
    public String mgr_id;

    public EmpLogin() {

    }

    public EmpLogin(String emp_id, String emp_name, String emp_phno, String emp_address, String mgr_id) {
        super();

        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_phno = emp_phno;
        this.emp_address = emp_address;
        this.mgr_id = mgr_id;
    }

    @Column(name = "emp_id")
    public String getId() {
        return emp_id;
    }

    public void setId(String id) {
        this.emp_id = id;
    }

    @Column(name = "emp_name")
    public String getName() {
        return emp_name;
    }

    public void setName(String name) {
        this.emp_name = name;
    }
    
    @Column(name = "emp_phno")
    public String getPh() {
        return emp_phno;
    }

    public void setPh(String ph) {
        this.emp_phno = ph;
    }

    @Column(name = "emp_address")
    public String getAddr() {
        return emp_address;
    }

    public void setAddr(String sys) {
        this.emp_address = sys;
    }
    
    @Column(name = "mgr_id")
    public String getMgrId() {
        return mgr_id;
    }

    public void setMgrId(String mgrId) {
        this.mgr_id = mgrId;
    }

}