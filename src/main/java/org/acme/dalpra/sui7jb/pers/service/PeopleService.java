package org.acme.dalpra.sui7jb.pers.service;

import jakarta.inject.Named;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.acme.dalpra.sui7jb.pers.entity.Person;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;
import java.util.UUID;

@RegisterRestClient(baseUri = "http://localhost:9081")
public interface PeopleService {
    @GET
    @Path("/people")
    List<Person> getPeople();

    @POST
    @Path("/people/{id}")
    Person postPerson(Person person);
}
