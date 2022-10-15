package ru.practicum.ewmservice.dto.newDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

import static ru.practicum.ewmservice.Constants.DATE_FORMAT;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewCompilationDto {
    private Set<Long> events;
    private Boolean pinned;

    @NotNull
    @Length(min = 3, max = 120)
    private String title;
    @JsonFormat(pattern = DATE_FORMAT)
    private LocalDateTime created = LocalDateTime.now();

}
