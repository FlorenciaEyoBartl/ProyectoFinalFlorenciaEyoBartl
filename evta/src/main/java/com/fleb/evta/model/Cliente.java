package com.fleb.evta.model;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

@Valid
@Data
@ToString
@Entity
@Table(name = "cliente")
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")


public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Positive(message = "El ID debe ser un número positivo")
    Integer clienteid;

    @NotEmpty
    @NotBlank(message = "El nombre no puede estar en blanco")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    String nombre;


    @NotEmpty
    @NotBlank(message = "El apellido no puede estar en blanco")
    @Size(min = 2, max = 50, message = "El apellido debe tener entre 2 y 50 caracteres")
    String apellido;

    @NotNull
    @Min(value = 1000000, message = "El DNI debe tener al menos 7 dígitos")
    @Max(value = 99999999, message = "El DNI no puede tener más de 8 dígitos")
    int dni;




}