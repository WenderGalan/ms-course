package io.github.wendergalan.hroauth.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {
    private final static long seriaVersionUID = 1L;

    @EqualsAndHashCode.Include
    private Long id;
    private String roleName;
}
