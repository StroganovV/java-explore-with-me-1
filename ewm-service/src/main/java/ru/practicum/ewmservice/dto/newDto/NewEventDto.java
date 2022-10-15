package ru.practicum.ewmservice.dto.newDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Value;
import ru.practicum.ewmservice.model.Location;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

import static ru.practicum.ewmservice.Constants.DATE_FORMAT;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewEventDto {
    @NotNull
    @Length(min = 3, max = 120)
    private String title;
    @NotNull
    @Length(min = 20, max = 2000)
    private String annotation;
    @NotNull
    @Length(min = 20, max = 7000)
    private String description;
    @Positive
    private long category;
    @NotNull
    private Location location;
    @Value("0")
    private Integer participantLimit;
    @Value("false")
    private Boolean paid;
    @Value("true")
    private Boolean requestModeration;
    @NotNull
    @Future
    @JsonFormat(pattern = DATE_FORMAT)
    private LocalDateTime eventDate;
    @JsonFormat(pattern = DATE_FORMAT)
    private LocalDateTime createdOn = LocalDateTime.now();
}
