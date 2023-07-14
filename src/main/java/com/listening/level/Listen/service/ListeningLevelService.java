/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listening.level.Listen.service;

import com.listening.level.Listen.entity.ListeningLevel;
import com.listening.level.Listen.repo.ListeningLevelRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author NMSLAP415
 */
@Service
public class ListeningLevelService{
    
    @Autowired ListeningLevelRepo listeningLevelRepo;
    
    public List<ListeningLevel> getListeningLevelByUserId(String userId){
        return listeningLevelRepo.findListeningLevelByUserId(userId);
    }
    
    public ListeningLevel saveListeningLevel(ListeningLevel listeningLevel){
        return listeningLevelRepo.save(listeningLevel);
    }
    
    public void deleteListeningLevel(Long listeningLevelId){
        ListeningLevel listeningLevel = listeningLevelRepo.getById(listeningLevelId);
        if(listeningLevelId != null){
            listeningLevelRepo.delete(listeningLevel);
        }
    }
}
