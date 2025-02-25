package com.coderhouse.petshop.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "USERS")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "ID")
  @Schema(description = "User ID", requiredMode = Schema.RequiredMode.AUTO, example = "0124529f-81b7-4924-952e-8d3fe108ab8f")
  private UUID id;

  @Column(name = "NAME", nullable = false)
  @Schema(description = "User Name", requiredMode = Schema.RequiredMode.REQUIRED, example = "John Doe")
  private String name;

  @Column(name = "EMAIL", nullable = false, unique = true)
  @Schema(description = "User Email", requiredMode = Schema.RequiredMode.REQUIRED, example = "johndoe@email.com")
  private String email;

  @OneToMany(mappedBy = "adoptedBy", cascade = CascadeType.ALL)
  @JsonIgnoreProperties("adoptedBy")
  private List<Pet> adoptedPets;
}
