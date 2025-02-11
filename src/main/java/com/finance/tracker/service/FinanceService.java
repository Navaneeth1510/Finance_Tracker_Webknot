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

    public FinanceEntity updateEntry(Long id, FitnessDto fitness){
        FinanceEntity record = financeRepo.findById(id).orElse(null);
        record.setAmount(fitness.getAmount());
        record.setDescription(fitness.getDescription());
        record.setDate(fitness.getDate());
        record.setCategory(fitness.getCategory());
        financeRepo.save(record);
        return record;
    }

    public boolean deleteEntry(Long id){
        if(financeRepo.existsById(id)){
           financeRepo.deleteById(id);
           return true;
        }
        return false;
    }
}
