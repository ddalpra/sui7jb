package org.acme.dalpra.sui7jb.pers.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.acme.dalpra.sui7jb.entity.BaseEntity;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Person extends BaseEntity {

    private String name;
    private LocalDate birthDate;
}
