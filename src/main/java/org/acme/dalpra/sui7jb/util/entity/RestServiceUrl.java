package org.acme.dalpra.sui7jb.util.entity;

import org.acme.dalpra.sui7jb.entity.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RestServiceUrl extends BaseEntity{
    private String nomeServizio;
    private String url;
}
