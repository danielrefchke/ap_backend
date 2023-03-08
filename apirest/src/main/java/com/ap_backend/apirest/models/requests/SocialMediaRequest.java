package com.ap_backend.apirest.models.requests;

import lombok.Data;

@Data
public class SocialMediaRequest {
    private Long  id;

    private String icon;

    private String url;

    private Integer orden;

    private Long personaid;

}
