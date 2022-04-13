package br.com.erudio.controller.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StandardError {

    private Integer status;
    private LocalDateTime timestamp;
    private String error;
    private String message;
    private Throwable cause;
    private String path;
}
