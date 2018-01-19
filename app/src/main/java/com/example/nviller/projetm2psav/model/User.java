package com.example.nviller.projetm2psav.model;

/**
 * Created by nviller on 19/01/2018.
 */

public class User {
    private int idUser;
    private String emailUser;
    private String mdpUser;
    private String loginUser;
    private String firstnameUser;
    private String lastnameUser;

    public User (int idUser, String emailUser, String mdpUser, String loginUser, String firstnameUser, String lastnameUser){
        this.idUser = idUser;
        this.emailUser = emailUser;
        this.mdpUser = mdpUser;
        this.loginUser = loginUser;
        this.firstnameUser = firstnameUser;
        this.lastnameUser = lastnameUser;
    }

    public User ( String emailUser, String mdpUser, String loginUser, String firstnameUser, String lastnameUser){
        this.emailUser = emailUser;
        this.mdpUser = mdpUser;
        this.loginUser = loginUser;
        this.firstnameUser = firstnameUser;
        this.lastnameUser = lastnameUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getMdpUser() {
        return mdpUser;
    }

    public void setMdpUser(String mdpUser) {
        this.mdpUser = mdpUser;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public String getFirstnameUser() {
        return firstnameUser;
    }

    public void setFirstnameUser(String firstnameUser) {
        this.firstnameUser = firstnameUser;
    }

    public String getLastnameUser() {
        return lastnameUser;
    }

    public void setLastnameUser(String lastnameUser) {
        this.lastnameUser = lastnameUser;
    }
}
