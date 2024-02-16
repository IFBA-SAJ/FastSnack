package br.edu.ifba.saj.ads.pweb.projeto20232.resource;

import br.edu.ifba.saj.ads.pweb.projeto20232.entity.Produto;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;
import io.quarkus.panache.common.Page;
import io.quarkus.rest.data.panache.ResourceProperties;
import jakarta.ws.rs.*;

import java.util.List;
import java.util.UUID;


public interface ProdutoResource extends PanacheEntityResource<Produto, UUID> {
    @GET
    @Path("/ByEstabelecimento/{estabelecimentoId}")
    @Produces("application/json")
    public default List<Produto> findByEstabelecimento(
            @PathParam("estabelecimentoId") UUID estabelecimentoId,
            @QueryParam("pagina") @DefaultValue("0") int pageIndex,
            @QueryParam("quantidade") @DefaultValue("20") int pageSize
    ){
        Page page = Page.of(pageIndex, pageSize);
        return Produto.find("estabelecimento.id", estabelecimentoId).page(page).list();
    }


    @GET
    @Path("/ByNomeProduto")
    @Produces("application/json")
    public default List<Produto> findByNome(
            @QueryParam("nome") @DefaultValue("") String nome,
            @QueryParam("pagina") @DefaultValue("0") int pageIndex,
            @QueryParam("quantidade") @DefaultValue("20") int pageSize
    ){
        Page page = Page.of(pageIndex, pageSize);
        return Produto.find("nome like ?1", "%"+nome+"%").page(page).list();
    }
}
