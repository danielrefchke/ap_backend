package com.ap_backend.apirest.models;

import com.ap_backend.apirest.views.View;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Data
@Table(name = "elemento")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElementoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({View.BasicData.class,View.WithCollections.class})
    private Long  id;

    @JsonView({View.BasicData.class,View.WithCollections.class})
    private String nombre;

    @JsonView({View.BasicData.class,View.WithCollections.class})
    private String titulo;

    @JsonView({View.BasicData.class,View.WithCollections.class})
    private String descripcion;

    @JsonView({View.BasicData.class,View.WithCollections.class})
    @JsonProperty("classType")
    private String classtype;

    @JsonView({View.BasicData.class,View.WithCollections.class})
    @JsonProperty("contDinamico")
    private String contdinamico;

    @JsonView({View.BasicData.class,View.WithCollections.class})
    private Integer orden;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seccionid")
    @JsonManagedReference
    //@JsonView(View.WithCollections.class)
    private SeccionModel seccion;
}
