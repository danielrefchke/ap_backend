package com.ap_backend.apirest.models.requests;

import lombok.Data;

@Data
public class PersonaRequest {

    private Long  id;

    private String nombre;

    private String titulo;

    private String descripcion;

    private String imgback;

    private String imgpersona;

    private String imgcred;
}
