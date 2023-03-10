package com.ap_backend.apirest.models.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SectionResponse {
    private Long  id;

    private String nombre;

    @JsonProperty("className")
    private String  classname;

    @JsonProperty("displayMode")
    private String displaymode;

    private Integer orden;
}
