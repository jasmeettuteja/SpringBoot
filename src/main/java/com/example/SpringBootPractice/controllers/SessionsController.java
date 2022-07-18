package com.example.SpringBootPractice.controllers;

import com.example.SpringBootPractice.models.Sessions;
import com.example.SpringBootPractice.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {
    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping
    public List<Sessions> list(){
        return sessionRepository.findAll();
    }
    @GetMapping
    @RequestMapping("{id}")
    public Sessions get(@PathVariable Long id){
        return sessionRepository.getOne(id);
    }
    @PostMapping
    public Sessions create(@RequestBody  final Sessions session){
        return sessionRepository.saveAndFlush(session);
    }
    @RequestMapping(value="{id}",method=RequestMethod.DELETE)
        public void delete(@PathVariable Long id){
        sessionRepository.deleteById(id);}
    @RequestMapping(value="{id}",method=RequestMethod.PUT)
    public Sessions update(@PathVariable Long id,@RequestBody Sessions session){
        if(id==null || session==null){
            throw new ResourceNotFoundException();
        }
        else{
            Sessions existingSession=sessionRepository.getOne(id);
            BeanUtils.copyProperties(session,existingSession,"session_id");
            return sessionRepository.saveAndFlush(existingSession);
        }


    }
}
