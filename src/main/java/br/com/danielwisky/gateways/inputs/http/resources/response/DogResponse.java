package br.com.danielwisky.gateways.inputs.http.resources.response;

import br.com.danielwisky.domains.Dog;
import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DogResponse {

  private String id;
  private String name;
  private String breed;
  private Double weight;
  private LocalDate birthDate;

  public DogResponse(final Dog dog) {
    this.id = dog.getId();
    this.name = dog.getName();
    this.breed = dog.getBreed();
    this.weight = dog.getWeight();
    this.birthDate = dog.getBirthDate();
  }
}
