package br.unitins.topicos1.repository;

import javax.enterprise.context.ApplicationScoped;

import br.unitins.topicos1.model.Arsenal;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ArsenalRepository implements PanacheRepository<Arsenal> {
    
    public Arsenal findByNome(String nomeArma){
        return find("nome", nomeArma).firstResult();
    }

}
