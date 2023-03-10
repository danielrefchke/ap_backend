package com.ap_backend.apirest.models.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ElementoRequest {

    private Long  id;
    private String nombre;
    private String titulo;
    private String descripcion;
    @JsonProperty("classType")
    private String classtype;
    @JsonProperty("contDinamico")
    private String contdinamico;
    private Integer orden;
}
