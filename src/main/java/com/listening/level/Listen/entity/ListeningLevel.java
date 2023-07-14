/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listening.level.Listen.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

/**
 *
 * @author NMSLAP415
 */
@Entity
@lombok.Data
public class ListeningLevel implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long listeningId;
    
    private String userId;
    private String listeningLevel;
    private Date createdOn;
    
    @PrePersist
    public void onPrePersist(){
        createdOn = new Date();
    }
}
