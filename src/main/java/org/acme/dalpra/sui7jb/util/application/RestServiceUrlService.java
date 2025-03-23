package org.acme.dalpra.sui7jb.util.application;

import java.util.List;
import java.util.UUID;

import org.acme.dalpra.sui7jb.util.adapters.persistence.RestServiceUrlRepository;
import org.acme.dalpra.sui7jb.util.entity.RestServiceUrl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class RestServiceUrlService {

    @Inject
    RestServiceUrlRepository repository;

    @Transactional
    public void addUrl(String nomeServizio, String url) {
        RestServiceUrl rsu = new RestServiceUrl();
        rsu.setNomeServizio(nomeServizio);
        rsu.setUrl(url);
        rsu.setId(UUID.randomUUID());
        repository.persist(rsu);
    }

    public List<RestServiceUrl> getAllUrls(){
        return repository.listAll();
    }

    public RestServiceUrl getUrlByName(String nomeServizio){
        return repository.find("nomeServizio", nomeServizio).firstResult();
    }
}