package com.ap_backend.apirest.models;

import com.ap_backend.apirest.views.View;
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
//import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "lenguaje")
public class LenguajeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({ View.BasicData.class, View.WithCollections.class })
    private Long id;

    @JsonView(View.BasicData.class)
    private String nombre;

    @JsonView(View.BasicData.class)
    private String abrev;
}
