package br.com.danielwisky.gateways.inputs.http.handlers;

import br.com.danielwisky.domains.exceptions.ResourceNotFoundException;
import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;

@Produces
@Singleton
@Requires(classes = {ResourceNotFoundException.class, ExceptionHandler.class})
public class ResourceNotFoundExceptionHandler implements
    ExceptionHandler<ResourceNotFoundException, HttpResponse> {

  @Override
  public HttpResponse handle(HttpRequest request, ResourceNotFoundException exception) {
    return HttpResponse.notFound();
  }
}
