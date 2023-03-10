package com.ap_backend.apirest.models.requests;

import lombok.Data;

@Data
public class UserRequest {
    private Long  id;
    private String nombre;

    private String password;

}
