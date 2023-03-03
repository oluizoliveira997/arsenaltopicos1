package br.unitins.resource;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.unitins.topicos1.model.Arsenal;
import br.unitins.topicos1.repository.ArsenalRepository;

@Path("/Arsenal")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ArsenalResource {

    @Inject
    private ArsenalRepository repository;

    @GET
    @Path("/All")
    public List<Arsenal> getall() {

        return repository.findAll().list();
    }

    @POST
    @Transactional
    public Arsenal insert(Arsenal arsenal) {

        repository.persist(arsenal);

        return arsenal;
    }


    @GET
    @Path("/{id}")
    public Arsenal buscararsenalid(@PathParam("id") Long id) {
        return repository.findById(id);
    }


    // Atualizar todos
    @PUT
    @Path("/{id}")
    @Transactional
    public Arsenal updateall(@PathParam("id") Long id, Arsenal arsenal) {
        Arsenal arsenalid = repository.findById(id);
        arsenalid.setNomeArma(arsenal.getNomeArma());
        arsenalid.setPaisFabricacao(arsenal.getPaisFabricacao());
        arsenalid.setNumeroSerie(arsenal.getNumeroSerie());
        arsenalid.setAnoFabricacao(arsenal.getAnoFabricacao());

        return arsenalid;
    }

   
    // Atualizar parcialmente
    @PATCH
    @Path("/{id}")
    @Transactional
    public Arsenal updatePartial(@PathParam("id") Long id, Arsenal arsenal) {
        Arsenal arsenalid = repository.findById(id);
        arsenalid.setNomeArma(arsenal.getNomeArma());
        arsenalid.setPaisFabricacao(arsenal.getPaisFabricacao());
        arsenalid.setNumeroSerie(arsenal.getNumeroSerie());
        arsenalid.setAnoFabricacao(arsenal.getAnoFabricacao());

        return arsenalid;
    }

    // Deletar
    @DELETE
    @Path("/{nome}")
    @Transactional
    public Arsenal deletarArsenal(@PathParam("nome") String nome) {
        Arsenal arsenalid = repository.findByNome(nome);
        repository.delete(arsenalid);
        return arsenalid;
    }


}