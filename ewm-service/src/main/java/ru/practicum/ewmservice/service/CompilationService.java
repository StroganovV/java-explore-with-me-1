package ru.practicum.ewmservice.service;

import ru.practicum.ewmservice.dto.CompilationDto;
import ru.practicum.ewmservice.dto.newDto.NewCompilationDto;

import java.util.Collection;

public interface CompilationService {
    //***ADMIN METHOD'S*** ↓
    CompilationDto create(NewCompilationDto dto);

    void delete(long compId);

    void deleteEventFromComp(long compId, long eventId);

    CompilationDto addEventInComp(long compId, long eventId);

    CompilationDto installPin(long compId, boolean value);

    //***PUBLIC METHOD'S*** ↓
    Collection<CompilationDto> getAll(Boolean pinned, int from, int size);

    CompilationDto get(long compId);
}
