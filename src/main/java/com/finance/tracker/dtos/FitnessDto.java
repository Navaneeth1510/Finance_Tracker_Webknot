package com.finance.tracker.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FitnessDto {
    Double amount;
    String category;
    String date;
    String description;
}
