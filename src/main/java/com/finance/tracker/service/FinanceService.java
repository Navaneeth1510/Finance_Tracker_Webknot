package com.finance.tracker.service;

import com.finance.tracker.dtos.FitnessDto;
import com.finance.tracker.entity.FinanceEntity;
import com.finance.tracker.repository.FinanceRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinanceService {

    @Autowired
    FinanceRespository financeRepo;


    public List<FinanceEntity> getAllEntries(){
        return financeRepo.findAll();
    }

    public FinanceEntity getEntries(Long id){
        return financeRepo.findById(id).orElse(null);
    }

    public Long addEntry(FitnessDto fitness){
        FinanceEntity entry = FinanceEntity.builder()
                .amount(fitness.getAmount())
                .category(fitness.getCategory())
                .date(fitness.getDate())
                .description(fitness.getDescription())
                .build();
        financeRepo.save(entry);
        return entry.getId();
    }

    public FinanceEntity updateEntry(Long id, double amount){
        FinanceEntity fitness = financeRepo.findById(id).orElse(null);
        assert fitness != null;
        fitness.setDate(fitness.getDate());
        fitness.setCategory(fitness.getCategory());
        fitness.setDescription(fitness.getDescription());
        fitness.setAmount(amount);
        FinanceEntity fund =financeRepo.save(fitness);
        return fund;
    }
}
