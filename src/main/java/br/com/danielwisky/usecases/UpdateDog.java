package br.com.danielwisky.usecases;

import br.com.danielwisky.domains.Dog;
import br.com.danielwisky.domains.exceptions.ResourceNotFoundException;
import br.com.danielwisky.gateways.DogDataGateway;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
public class UpdateDog {

  private final DogDataGateway dogDataGateway;

  public Dog execute(final String id, final Dog dog) {

    final Dog dogOnData = dogDataGateway.findById(id)
        .orElseThrow(ResourceNotFoundException::new);

    dog.setId(dogOnData.getId());
    return dogDataGateway.update(dog);
  }
}
