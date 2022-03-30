package br.com.danielwisky.gateways.inputs.http;

import br.com.danielwisky.domains.Dog;
import br.com.danielwisky.domains.exceptions.ResourceNotFoundException;
import br.com.danielwisky.gateways.DogDataGateway;
import br.com.danielwisky.gateways.inputs.http.resources.request.DogRequest;
import br.com.danielwisky.gateways.inputs.http.resources.response.DogResponse;
import br.com.danielwisky.gateways.inputs.http.resources.response.PageResponse;
import br.com.danielwisky.usecases.UpdateDog;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.model.Pageable;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.annotation.Status;
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
  public DogResponse update(final String id, @Body @Valid final DogRequest dogRequest) {
    final Dog dogUpdated = updateDog.execute(id, dogRequest.toDomain());
    return new DogResponse(dogUpdated);
  }

  @Delete("/{id}")
  @Status(HttpStatus.NO_CONTENT)
  public void delete(final String id) {
    dogDataGateway.deleteById(id);
  }

  @Get("/{id}")
  public DogResponse get(final String id) {
    return dogDataGateway.findById(id)
        .map(DogResponse::new)
        .orElseThrow(ResourceNotFoundException::new);
  }

  @Get
  public PageResponse<DogResponse> search(
      @Nullable @QueryValue(defaultValue = "0") final Integer page,
      @Nullable @QueryValue(defaultValue = "20") final Integer size) {
    return new PageResponse<>(
        dogDataGateway.search(Pageable.from(page, size)).map(DogResponse::new));
  }
}