package com.fleb.evta.model;


import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class ClienteDTO {

    Integer clienteid;

    String nombre;

    String apellido;

    int dni;


    }

