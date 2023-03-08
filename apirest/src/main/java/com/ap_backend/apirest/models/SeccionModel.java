package com.ap_backend.apirest.models;

import com.ap_backend.apirest.views.View;
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
@Table(name = "seccion")
public class SeccionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({View.BasicData.class,View.WithCollections.class})
    private Long  id;

    @JsonView({View.BasicData.class,View.WithCollections.class})
    private String nombre;

    @JsonView({View.BasicData.class,View.WithCollections.class})
    @JsonProperty("className")
    private String  classname;

    @JsonView({View.BasicData.class,View.WithCollections.class})
    @JsonProperty("displayMode")
    private String displaymode;

    @JsonView({View.BasicData.class,View.WithCollections.class})
    private Integer orden;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "personaid")
    @JsonManagedReference
    @JsonView(View.WithCollections.class)
    private PersonaModel persona;

}
