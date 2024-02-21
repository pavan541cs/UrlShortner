package org.example.model;

import lombok.Data;

@Data
public class CreateShortLinkRequest {
    Integer userId;
    String url;
}
