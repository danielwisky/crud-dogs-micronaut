package br.com.danielwisky.gateways.outputs.mongodb;

import br.com.danielwisky.domains.Dog;
import br.com.danielwisky.gateways.DogDataGateway;
import br.com.danielwisky.gateways.outputs.mongodb.adapters.DogDocumentAdapter;
import br.com.danielwisky.gateways.outputs.mongodb.documents.DogDocument;
import br.com.danielwisky.gateways.outputs.mongodb.repositories.DogDocumentRepository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.Optional;
import org.bson.types.ObjectId;

@Singleton
public class DogDataGatewayImpl implements DogDataGateway {

  @Inject
  private DogDocumentRepository dogDocumentRepository;

  @Inject
  private DogDocumentAdapter dogDocumentAdapter;

  @Override
  public Dog save(final Dog dog) {
    final DogDocument dogDocument = dogDocumentAdapter.from(dog);
    return dogDocumentAdapter.to(dogDocumentRepository.save(dogDocument));
  }

  @Override
  public Dog update(final Dog dog) {
    final DogDocument dogDocument = dogDocumentAdapter.from(dog);
    return dogDocumentAdapter.to(dogDocumentRepository.update(dogDocument));
  }

  @Override
  public void deleteById(final String id) {
    dogDocumentRepository.deleteById(new ObjectId(id));
  }

  @Override
  public Optional<Dog> findById(final String id) {
    return dogDocumentRepository.findById(new ObjectId(id)).map(dogDocumentAdapter::to);
  }

  @Override
  public Page<Dog> search(final Pageable pageable) {
    return dogDocumentRepository.findAll(pageable)
        .map(dogDocumentAdapter::to);
  }
}
