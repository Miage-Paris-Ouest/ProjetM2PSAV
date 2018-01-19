package com.example.nviller.projetm2psav.Model;

import com.google.firebase.database.Exclude;

/**
 * Created by nviller on 11/12/2017.
 */

public class Evenement {
    private String idEvent;
    private String nameEvent;


    public Evenement(String nameEvent) {
        this.nameEvent = nameEvent;
    }

    public Evenement(String idEvent, String nameEvent) {
        this.idEvent = idEvent;
        this.nameEvent = nameEvent;
    }

    public String getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(String idEvent) {
        this.idEvent = idEvent;
    }

    public String getNameEvent() {
        return nameEvent;
    }

    public void setNameEvent(String nameEvent) {
        this.nameEvent = nameEvent;
    }
}
