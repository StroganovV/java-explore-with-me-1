package ru.practicum.ewmservice.service.mapper;

import org.springframework.stereotype.Component;
import ru.practicum.ewmservice.dto.ParticipationRequestDto;
import ru.practicum.ewmservice.model.ParticipationRequest;
@Component
public class ParticipationRequestMapper {

    public static ParticipationRequestDto toPartDto(ParticipationRequest part) {
        ParticipationRequestDto dto = new ParticipationRequestDto();
        dto.setId(part.getId());
        dto.setEvent(part.getEvent().getId());
        dto.setRequester(part.getRequestor().getId());
        dto.setStatus(part.getStatus());
        dto.setCreated(part.getCreated());
        return dto;
    }
}
