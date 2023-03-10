package com.ap_backend.apirest.models;

import com.ap_backend.apirest.views.View;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Data
@Table(name="usuario")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.BasicData.class)
    private Long  id;
    @Column
    @JsonView(View.BasicData.class)
    private String nombre;
    @Column
    @JsonView(View.NoData.class)
    private String password;

}
