package br.com.danielwisky.gateways.inputs.http.resources.request;

import br.com.danielwisky.domains.Dog;
import io.micronaut.core.annotation.Introspected;
import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Introspected
@NoArgsConstructor
@AllArgsConstructor
public class DogRequest {

  @NotBlank
  private String name;
  private String breed;
  private Double weight;
  private LocalDate birthDate;

  public Dog toDomain() {
    return Dog.builder()
        .name(this.name)
        .breed(this.breed)
        .weight(this.weight)
        .birthDate(this.birthDate)
        .build();
  }
}
