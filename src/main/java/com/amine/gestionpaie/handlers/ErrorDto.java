package com.amine.gestionpaie.handlers;
import java.util.ArrayList;
import java.util.List;

import com.amine.gestionpaie.exception.ErrorCodes;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ErrorDto {
	private Integer httpCode;
	private ErrorCodes code;
	String message;

	private List<String> errors = new ArrayList<>();

}
