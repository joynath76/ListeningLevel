/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listening.level.Listen.rest;

import com.listening.level.Listen.entity.ListeningLevel;
import com.listening.level.Listen.service.ListeningLevelService;
import com.listening.level.Listen.util.Response;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author NMSLAP415
 */
@RestController
@RequestMapping(value = "/listen", produces = MediaType.APPLICATION_JSON_VALUE)
public class ListeningLevelRest extends AbstractRest{
    
    @Autowired ListeningLevelService listeningLevelService;
    
    @GetMapping("{userId}")
    public Response getListeningLevel(@PathVariable("userId") String userId) {
        List<ListeningLevel> listeningLevels = listeningLevelService.getListeningLevelByUserId(userId);
        Response.Builder response = successResponseBuilder().data(listeningLevels);
        return response.build();
    }

    @PostMapping
    public Response create(@RequestBody ListeningLevel listeningLevel) {
        listeningLevel = listeningLevelService.saveListeningLevel(listeningLevel);
        Response.Builder response = successResponseBuilder().data(listeningLevel);
        return response.build();
    }
    
    @DeleteMapping("{listeningLevelId}")
    public Response delete(@PathVariable("listeningLevelId") Long listeningLevelId) {
        listeningLevelService.deleteListeningLevel(listeningLevelId);
        Response.Builder response = successResponseBuilder();
        return response.build();
    }
}
