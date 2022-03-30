package br.com.danielwisky.gateways.inputs.http;

import br.com.danielwisky.domains.Dog;
import br.com.danielwisky.gateways.DogDataGateway;
import br.com.danielwisky.gateways.inputs.http.resources.request.DogRequest;
import br.com.danielwisky.gateways.inputs.http.resources.response.DogResponse;
import br.com.danielwisky.usecases.UpdateDog;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller("/api/v1/dogs")
@RequiredArgsConstructor
public class DogController {

  private final DogDataGateway dogDataGateway;
  private final UpdateDog updateDog;

  @Post
  public DogResponse create(@Body @Valid final DogRequest dogRequest) {
    final Dog dogCreated = dogDataGateway.save(dogRequest.toDomain());
    return new DogResponse(dogCreated);
  }

  @Put("/{id}")
  public DogResponse create(final String id, @Body @Valid final DogRequest dogRequest) {
    final Dog dogUpdated = updateDog.execute(id, dogRequest.toDomain());
    return new DogResponse(dogUpdated);
  }
}