package br.com.danielwisky.gateways.outputs.mongodb.adapters;

import static java.util.Optional.ofNullable;

import br.com.danielwisky.domains.Dog;
import br.com.danielwisky.gateways.outputs.mongodb.documents.DogDocument;
import jakarta.inject.Singleton;
import org.bson.types.ObjectId;

@Singleton
public class DogDocumentAdapter {

  public DogDocument from(final Dog dog) {
    final DogDocument dogDocument = new DogDocument();
    dogDocument.setId(ofNullable(dog.getId()).map(ObjectId::new).orElse(null));
    dogDocument.setName(dog.getName());
    dogDocument.setWeight(dog.getWeight());
    dogDocument.setBreed(dog.getBreed());
    dogDocument.setBirthDate(dog.getBirthDate());
    return dogDocument;
  }

  public Dog to(final DogDocument dogDocument) {
    return Dog.builder()
        .id(ofNullable(dogDocument.getId())
            .map(ObjectId::toString)
            .orElse(null))
        .name(dogDocument.getName())
        .weight(dogDocument.getWeight())
        .breed(dogDocument.getBreed())
        .birthDate(dogDocument.getBirthDate())
        .build();
  }

}
