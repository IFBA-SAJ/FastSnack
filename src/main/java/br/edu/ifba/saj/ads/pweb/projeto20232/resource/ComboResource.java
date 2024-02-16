package br.edu.ifba.saj.ads.pweb.projeto20232.resource;

import br.edu.ifba.saj.ads.pweb.projeto20232.entity.Combo;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;

import java.util.UUID;

public interface ComboResource extends PanacheEntityResource<Combo, UUID> {

}
