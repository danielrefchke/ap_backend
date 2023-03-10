package com.ap_backend.apirest.models.responses;

import com.ap_backend.apirest.models.ElementoModel;
import com.ap_backend.apirest.views.View;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class SeccionResponse {

    @JsonView(View.WithCollections.class)
    private Long  id;
    @JsonView(View.WithCollections.class)
    private String nombre;
    @JsonView(View.WithCollections.class)
    @JsonProperty("className")
    private String  classname;
    @JsonView(View.WithCollections.class)
    @JsonProperty("displayMode")
    private String displaymode;
    @JsonView(View.WithCollections.class)
    private Integer orden;
    @JsonView(View.WithCollections.class)
    @JsonProperty("elementos")
    private List<ElementoModel> elementos ;
}
