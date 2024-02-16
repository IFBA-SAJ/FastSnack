package br.edu.ifba.saj.ads.pweb.projeto20232.resource;

import java.util.UUID;
import br.edu.ifba.saj.ads.pweb.projeto20232.entity.Cliente;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;

public interface ClienteResource extends PanacheEntityResource<Cliente, UUID> {
}