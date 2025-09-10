package com.jwat.jwat_assgiment.jwat_assgiment.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class MessageResponse {
    private HttpStatus status;
    private String message;
    private Object data;
}
