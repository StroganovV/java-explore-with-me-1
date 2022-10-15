package ru.practicum.ewmservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static ru.practicum.ewmservice.Constants.DATE_FORMAT;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEventRequestDto {
    private Long eventId;
    private String annotation;
    private String description;
    private String title;
    private Long category;
    private Integer participantLimit;
    private Boolean paid;

    @JsonFormat(pattern = DATE_FORMAT)
    private LocalDateTime eventDate;
}
