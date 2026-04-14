package org.example.sevanidhi.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class AuthResponse {

    private String token;
    private String role;
}
