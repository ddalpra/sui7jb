package org.acme.dalpra.sui7jb.pers.bean;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.acme.dalpra.sui7jb.pers.entity.Person;
import org.acme.dalpra.sui7jb.pers.service.PeopleService;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.primefaces.PrimeFaces;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("dtPeopleView")
@RequestScoped
public class PeopleView implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Person> people;
    private Person person;
    private List<Person> selectedPeople;

    @RestClient
    PeopleService peopleService;

    @PostConstruct
    public void init(){
        people = peopleService.getPeople();
        selectedPeople = new ArrayList<Person>();
    }

    public List<Person> getPeople(){
        people = peopleService.getPeople();
        return people;
    }

    public void setPerson(Person person){
        this.person = person;
    }

    public Person getPerson(){
        return this.person;
    }

    public List<Person> getSelectedPeople(){
        return selectedPeople;
    }

    public void setSelectedPeople(List<Person> selectedPeople){
        this.selectedPeople = selectedPeople;
    }

    public void openNew() {
        this.person = new Person();
    }

    public void savePerson(){
        if(this.person.getId()==null){
            Person newPerson = peopleService.postPerson(this.person);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Person Added"));
        }else{
            Person newPerson = peopleService.putPerson(this.person.getId(),this.person);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Person Updated"));
        }
    }

    public void postPerson(){
        Person newPerson = peopleService.postPerson(person);
        System.out.println("GT - Salvataggio " + newPerson.getId());

    }

    public String getDeleteButtonMessage() {
        if (hasSelectedPeople()) {
            int size = this.selectedPeople.size();
            return size > 1 ? size + " people selected" : "1 person selected";
        }
        return "Delete";
    }

    public boolean hasSelectedPeople() {
        return this.selectedPeople != null && !this.selectedPeople.isEmpty();
    }

    public void deleteSelectedPeople() {
        this.people.removeAll(this.selectedPeople);
        this.selectedPeople = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Person Removed"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
        PrimeFaces.current().executeScript("PF('dtProducts').clearFilters()");
    }
}
