package br.com.danielwisky.gateways;

import br.com.danielwisky.domains.Dog;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import java.util.Optional;

public interface DogDataGateway {

  Dog save(Dog dog);

  Dog update(Dog dog);

  void deleteById(String id);

  Optional<Dog> findById(String id);

  Page<Dog> search(Pageable pageable);
}
