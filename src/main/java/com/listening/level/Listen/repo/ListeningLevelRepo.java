/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listening.level.Listen.repo;

import com.listening.level.Listen.entity.ListeningLevel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author NMSLAP415
 */
public interface ListeningLevelRepo extends JpaRepository<ListeningLevel, Long>{
    public List<ListeningLevel> findListeningLevelByUserId(String userId);
}
