package com.mgr.narratif.game.liya.model;

import java.util.Date;

/**
 * Created by mblandin2016 on 10/04/2018.
 */

public class PassePartout {
    private String id;
    private Date dateAchat;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public Date getDateAchat() {
        return dateAchat;
    }
    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public PassePartout() {}
    public PassePartout(String id, Date dateAchat) {
        this.id = id;
        this.dateAchat = dateAchat;
    }
}
