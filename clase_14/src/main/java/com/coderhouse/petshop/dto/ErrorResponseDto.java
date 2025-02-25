package com.coderhouse.petshop.dto;

import lombok.Data;

@Data
public class ErrorResponseDto {
  String statusCode;

  String status;

  String msg;

  String field;

}
