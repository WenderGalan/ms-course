package io.github.wendergalan.hrpayroll.entities;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private Double dailyIncome;
    private Integer days;

    public double getTotal() {
        return days * dailyIncome;
    }
}
