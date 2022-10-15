package ru.practicum.ewmservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

import static ru.practicum.ewmservice.Constants.DATE_FORMAT;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private List<String> errors;
    private String message;
    private String reason;
    private HttpStatus status;
    @JsonFormat(pattern = DATE_FORMAT)
    private LocalDateTime timestamp;

}
