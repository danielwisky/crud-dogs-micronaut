package br.com.danielwisky.gateways.outputs.mongodb;

import br.com.danielwisky.domains.Dog;
import br.com.danielwisky.gateways.DogDataGateway;
import br.com.danielwisky.gateways.outputs.mongodb.adapters.DogDocumentAdapter;
import br.com.danielwisky.gateways.outputs.mongodb.documents.DogDocument;
import br.com.danielwisky.gateways.outputs.mongodb.repositories.DogDocumentRepository;
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
  public Optional<Dog> findById(String id) {
    return dogDocumentRepository.findById(new ObjectId(id)).map(dogDocumentAdapter::to);
  }
}
