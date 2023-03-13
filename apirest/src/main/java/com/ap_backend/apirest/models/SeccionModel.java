package com.ap_backend.apirest.models;

import com.ap_backend.apirest.views.View;
import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Data
@Table(name = "seccion")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SeccionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({View.BasicData.class,View.WithCollections.class,View.Nested.class})
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
    //@JsonView(View.WithCollections.class)
    private PersonaModel persona;


    @OneToMany(mappedBy = "seccion",fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    @JsonView(View.WithCollections.class)
    @OrderBy("orden")
    @JsonProperty("elementos")
    private List<ElementoModel> elementos ;


}
