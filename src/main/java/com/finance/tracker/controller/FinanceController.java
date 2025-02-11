package com.finance.tracker.controller;


import com.finance.tracker.dtos.FitnessDto;
import com.finance.tracker.entity.FinanceEntity;
import com.finance.tracker.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/entries")
public class FinanceController {

    @Autowired
    FinanceService fitnessService;


    @GetMapping
    public List<FinanceEntity> getAllEntries(){
        return fitnessService.getAllEntries();
    }

    @GetMapping("/{id}")
    public FinanceEntity getEntries(@PathVariable Long id){
        return fitnessService.getEntries(id);
    }

    @PostMapping
    public Long addEntry(@RequestBody FitnessDto fitness){
        return fitnessService.addEntry(fitness);
    }

    @PutMapping("/{id}")
    public FinanceEntity updateEntry(@PathVariable Long id, @RequestBody FitnessDto update){
        return fitnessService.updateEntry(id, update);
    }

    @DeleteMapping("/{id}")
    public boolean deleteEntry(@PathVariable Long id){
        return fitnessService.deleteEntry(id);
    }


}
