package ru.practicum.ewmservice.controller.admin;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ewmservice.dto.CompilationDto;
import ru.practicum.ewmservice.dto.newDto.NewCompilationDto;
import ru.practicum.ewmservice.service.CompilationService;

@RestController
@RequestMapping(path = "/admin/compilations")
@AllArgsConstructor
public class CompilationAdmController {
    CompilationService service;

    @PostMapping
    public CompilationDto createCompilation(@RequestBody NewCompilationDto dto) {
        return service.create(dto);
    }

    @DeleteMapping("/{compId}")
    public void deleteCompilation(@PathVariable long compId) {
        service.delete(compId);
    }

    @DeleteMapping("/{compId}/events/{eventId}")
    public void deleteEventFromCompilation(@PathVariable long compId,
                                           @PathVariable long eventId) {
        service.deleteEventFromComp(compId, eventId);
    }

    @PatchMapping("/{compId}/events/{eventId}")
    public CompilationDto addEventInCompilation(@PathVariable long compId,
                                                @PathVariable long eventId) {
        return service.addEventInComp(compId, eventId);
    }

    //закрепить подборку на главной странице
    @DeleteMapping("/{compId}/pin")
    public CompilationDto pinOff(@PathVariable long compId) {
        return service.installPin(compId, false);
    }

    //открепить подборку с главной страницы
    @PatchMapping("/{compId}/pin")
    public CompilationDto pinOn(@PathVariable long compId) {
        return service.installPin(compId, true);
    }
}
