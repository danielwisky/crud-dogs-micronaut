package br.com.danielwisky.gateways;

import br.com.danielwisky.domains.Dog;
import java.util.Optional;

public interface DogDataGateway {

  Dog save(Dog dog);

  Dog update(Dog dog);

  Optional<Dog> findById(String id);
}
