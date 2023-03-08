package com.ap_backend.apirest.models.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SeccionRequest {
    private Long  id;

   private String nombre;

    @JsonProperty("className")
    private String  classname;

    @JsonProperty("displayMode")
    private String displaymode;

    private Integer orden;
}
