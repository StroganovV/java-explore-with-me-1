package ru.practicum.ewmservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.practicum.ewmservice.model.Location;
import ru.practicum.ewmservice.model.enums.EventStatus;

import java.time.LocalDateTime;

import static ru.practicum.ewmservice.Constants.DATE_FORMAT;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventFullDto {
    private Long id;
    private String title;
    private Integer confirmedRequests;
    private String annotation;
    private String description;
    private CategoryDto category;
    private UserShortDto initiator;
    private Location location;
    private Integer participantLimit;
    private Boolean paid;
    private Boolean requestModeration;
    private EventStatus state;
    @JsonFormat(pattern = DATE_FORMAT)
    private LocalDateTime eventDate;
    @JsonFormat(pattern = DATE_FORMAT)
    private LocalDateTime publishedOn;
    @JsonFormat(pattern = DATE_FORMAT)
    private LocalDateTime createdOn;
    private Integer views;
}
