package ru.practicum.ewmservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.practicum.ewmservice.model.Location;

import java.time.LocalDateTime;

import static ru.practicum.ewmservice.Constants.DATE_FORMAT;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminUpdateEventRequestDto {
    private String annotation;
    private String description;
    private String title;
    private Long category;
    private Integer participantLimit;

    @JsonFormat(pattern = DATE_FORMAT)
    private LocalDateTime eventDate;
    private Location location;
    private Boolean paid;
    private Boolean requestModeration;


}
