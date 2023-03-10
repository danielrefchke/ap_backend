package com.ap_backend.apirest.models.responses;

import com.ap_backend.apirest.models.SeccionModel;
import com.ap_backend.apirest.models.SocialMediaModel;
import com.ap_backend.apirest.views.View;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class PersonaResponse {
    @JsonProperty("id")
    @JsonView(View.WithCollections.class)
    private Long  id;
    @JsonProperty("nombre")
    @JsonView(View.WithCollections.class)
    private String nombre;

    @JsonProperty("titulo")
    @JsonView(View.WithCollections.class)
    private String titulo;
    @JsonView(View.WithCollections.class)
    private String descripcion;
    @JsonView(View.WithCollections.class)
    private String imgback;
    @JsonView(View.WithCollections.class)
    private String imgpersona;
    @JsonView(View.WithCollections.class)
    private String imgcred;
    @JsonView(View.WithCollections.class)
    @JsonProperty("redes")
    private List<SocialMediaModel> redesSociales ;

    @JsonView(View.WithCollections.class)
    //@JsonProperty("secciones")
    private List<SeccionModel>  secciones = new ArrayList<SeccionModel>();


}
