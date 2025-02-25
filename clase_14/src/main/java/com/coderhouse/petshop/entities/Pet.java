package com.coderhouse.petshop.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "PETS")
public class Pet {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "ID")
  @Schema(description = "Pet ID", requiredMode = Schema.RequiredMode.AUTO, example = "0124529f-81b7-4924-952e-8d3fe108ab8f")
  private UUID id;

  @Column(name = "NAME", nullable = false)
  @Schema(description = "Pet Name", requiredMode = Schema.RequiredMode.REQUIRED, example = "Firulais")
  private String name;

  @Column(name = "AGE", nullable = false)
  @Schema(description = "Pet Age", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
  private int age;

  @Column(name = "TYPE", nullable = false)
  @Schema(description = "Pet Type", requiredMode = Schema.RequiredMode.REQUIRED, example = "Dog")
  private String type;

  @Column(name = "ADOPTED", nullable = false)
  @Schema(description = "Pet Adopted", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
  private boolean adopted;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "USER_ID")
  private User adoptedBy;
}
