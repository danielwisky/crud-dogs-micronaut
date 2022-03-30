package br.com.danielwisky.domains;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dog {

  private String id;
  private String name;
  private String breed;
  private Double weight;
  private LocalDate birthDate;
}
