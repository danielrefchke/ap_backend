package com.ap_backend.apirest.models;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "persona")
public class PersonaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
    private String nombre;
    private String titulo;
    private String descripcion;
    private String imgback;
    private String imgpersona;
    private String imgcred;
}
