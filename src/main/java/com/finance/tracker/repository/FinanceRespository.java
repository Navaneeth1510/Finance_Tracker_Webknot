package com.finance.tracker.repository;


import com.finance.tracker.entity.FinanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinanceRespository extends JpaRepository<FinanceEntity, Long> {


}
