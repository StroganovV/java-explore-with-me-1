package ru.practicum.ewmservice.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import ru.practicum.ewmservice.model.Event;
import ru.practicum.ewmservice.model.enums.EventStatus;

import java.util.List;
import java.util.Optional;

@Component
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findAllByInitiatorId(long initiatorId, Pageable pageable);
    Optional<Event> findByIdAndInitiatorId(long id, long initiatorId);
    List<Event> findAllByEventStatusAndInitiatorId(EventStatus eventStatus, long initiatorId);
}
