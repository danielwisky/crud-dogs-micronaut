package br.com.danielwisky.gateways.outputs.mongodb.documents;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import java.time.LocalDate;
import lombok.Data;
import org.bson.types.ObjectId;

@Data
@MappedEntity("dogs")
public class DogDocument {

  @Id
  @GeneratedValue
  private ObjectId id;
  private String name;
  private String breed;
  private Double weight;
  private LocalDate birthDate;
}
