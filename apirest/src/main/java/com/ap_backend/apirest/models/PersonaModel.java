package com.ap_backend.apirest.models;

import com.ap_backend.apirest.views.View;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "persona")
public class PersonaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({View.BasicData.class,View.WithCollections.class})
    private Long  id;
    @JsonView(View.BasicData.class)
    private String nombre;
    @JsonView(View.BasicData.class)
    private String titulo;
    @JsonView(View.BasicData.class)
    private String descripcion;
    @JsonView(View.BasicData.class)
    private String imgback;
    @JsonView(View.BasicData.class)
    private String imgpersona;
    @JsonView(View.BasicData.class)
    private String imgcred;
    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    @JsonView(View.WithCollections.class)
    @JsonProperty("redes")
    private List<SocialMediaModel> redesSociales ;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    @JsonView(View.WithCollections.class)
    @JsonProperty("secciones")
    private List<SeccionModel> secciones ;


}
