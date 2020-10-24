package io.github.wendergalan.hrpayroll.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Worker implements Serializable {
    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    private Long id;
    private String name;
    private Double dailyIncome;
}
