package com.gamingCafe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "player", schema = "public")

public class UsrLogin {
    @Id
    public String p_email;
    public String p_name;
    private String p_pwd;
    public String sys_num_occupied;
    public String play_time;
    public String start_time;

    public UsrLogin() {

    }

    public UsrLogin(String p_email, String p_name, String p_pwd, String sys_num_occupied, String play_time, String start_time) {
        super();

        this.p_email = p_email;
        this.p_name = p_name;
        this.p_pwd = p_pwd;
        this.sys_num_occupied = sys_num_occupied;
        this.play_time = play_time;
        this.start_time = start_time;
    }

    @Column(name = "p_email")
    public String getEmail() {
        return p_email;
    }

    public void setEmail(String email) {
        this.p_email = email;
    }

    @Column(name = "p_name")
    public String getName() {
        return p_name;
    }

    public void setName(String name) {
        this.p_name = name;
    }
    
    @Column(name = "p_pwd")
    public String getPwd() {
        return p_pwd;
    }

    public void setPwd(String pwd) {
        this.p_pwd = pwd;
    }

    @Column(name = "sys_num_occupied")
    public String getSys() {
        return sys_num_occupied;
    }

    public void setSys(String sys) {
        this.sys_num_occupied = sys;
    }
    
    @Column(name = "play_time")
    public String getPlayTime() {
        return play_time;
    }

    public void setPlayTime(String playTime) {
        this.play_time = playTime;
    }

    @Column(name = "start_time")
    public String getStartTime() {
        return start_time;
    }

    public void setStartTime(String startTime) {
        this.start_time = startTime;
    }

}