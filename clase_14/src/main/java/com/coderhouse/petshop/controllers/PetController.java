package com.coderhouse.petshop.controllers;

import com.coderhouse.petshop.dto.ErrorResponseDto;
import com.coderhouse.petshop.entities.Pet;
import com.coderhouse.petshop.services.PetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/pets")
public class PetController {

  @Autowired
  private PetService petService;

  @GetMapping
  @Operation(summary = "Get all pets", description = "Returns a list of all pets")
  @ApiResponses({
          @ApiResponse(responseCode = "200", description = "Get all pets successfully"),
          @ApiResponse(responseCode = "400", description = "Bad request"),
          @ApiResponse(responseCode = "500", description = "Internal server error")
  })
  public ResponseEntity<List<Pet>> getAllPets() {
    return ResponseEntity.ok(petService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Pet> getPetById(@PathVariable UUID id) {
    return ResponseEntity.ok(petService.findById(id));
  }

  @PostMapping()
  @Operation(summary = "Create a new pet", description = "Creates a new pet")
  @ApiResponses({
          @ApiResponse(responseCode = "201", description = "Created pet successfully"),
          @ApiResponse(responseCode = "400", description = "Bad request",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponseDto.class)
            )
          )
  })
  public ResponseEntity<Pet> createPet(@RequestBody Pet pet) {
    return ResponseEntity.ok(petService.save(pet));
  }

  @PostMapping("/{userId}/adopt/{petId}")
  @Operation(summary = "Adopt a pet", description = "Adopt a pet", parameters = {
          @Parameter(name = "userId", in = ParameterIn.PATH, required = true, description = "User ID"),
          @Parameter(name = "petId", in = ParameterIn.PATH, required = true, description = "Pet ID")
  })
  @ApiResponses({
          @ApiResponse(responseCode = "200", description = "Adopted pet successfully"),
          @ApiResponse(responseCode = "400", description = "Bad request")
  })
  public ResponseEntity<Pet> adoptPet(@PathVariable UUID userId, @PathVariable UUID petId) {
    return ResponseEntity.ok(petService.adoptPet(petId, userId));
  }

}
