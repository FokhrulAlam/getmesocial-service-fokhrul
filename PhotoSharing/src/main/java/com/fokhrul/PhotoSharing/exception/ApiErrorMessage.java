package com.fokhrul.PhotoSharing.exception;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiErrorMessage {

    private HttpStatus httpStatus;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-YYYY hh:mm:ss")
    private LocalDateTime timestamp;

    private String userMessage;

    private Map<?,?> defaultMessage;

    public ApiErrorMessage(HttpStatus httpStatus, LocalDateTime timestamp, String userMessage){
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
        this.userMessage = userMessage;
    }

}
