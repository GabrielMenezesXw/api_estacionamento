package com.fundatec.ti20.estacionamento.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Data
@Getter
@Setter
public class ConstraintErrorDTO {

    private LocalDateTime timestamp;
    private Integer status;
    private String message;
    private Map<String, String> errors = new HashMap<>();

    public ConstraintErrorDTO() {
        this.timestamp = LocalDateTime.now();
    }

    public void addError(String field, String message) {
        errors.put(field, message);
    }

    public Map<String, String> getErrors() {
        return this.errors;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

}
