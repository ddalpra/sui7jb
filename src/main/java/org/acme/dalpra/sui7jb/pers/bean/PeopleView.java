package org.acme.dalpra.sui7jb.pers.bean;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.acme.dalpra.sui7jb.pers.entity.Person;
import org.acme.dalpra.sui7jb.pers.service.PeopleService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.io.Serializable;
import java.util.List;

@Named("dtPeopleView")
@RequestScoped
public class PeopleView implements Serializable {
    private List<Person> people;

    @RestClient
    PeopleService peopleService;

    @PostConstruct
    public void init(){
        people = peopleService.getPeople();
    }

    public List<Person> getPeople(){
        return people;
    }
}
