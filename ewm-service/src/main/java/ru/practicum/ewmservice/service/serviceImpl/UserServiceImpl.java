package ru.practicum.ewmservice.service.serviceImpl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.practicum.ewmservice.dto.EventShortDto;
import ru.practicum.ewmservice.dto.UserDto;
import ru.practicum.ewmservice.dto.UserShortDto;
import ru.practicum.ewmservice.dto.newDto.NewUserDto;
import ru.practicum.ewmservice.exceptions.EwmObjNotFoundException;
import ru.practicum.ewmservice.model.User;
import ru.practicum.ewmservice.model.enums.EventStatus;
import ru.practicum.ewmservice.repository.EventRepository;
import ru.practicum.ewmservice.repository.UserRepository;
import ru.practicum.ewmservice.service.UserService;
import ru.practicum.ewmservice.service.mapper.EventMapper;
import ru.practicum.ewmservice.service.mapper.UserMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository repository;
    private EventRepository eventRepository;
    private EventMapper eventMapper;

    @Override
    public List<UserDto> getAll(List<Long> ids, int from, int size) {
        Pageable pageable = PageRequest.of(from, size);
        return repository.findByIdIn(ids, pageable).stream().map(UserMapper::toUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto create(NewUserDto dto) {
        return UserMapper.toUserDto(repository.save(UserMapper.toUserFromNewDto(dto)));
    }

    @Override
    public void delete(long userId) {
        repository.deleteById(userId);
    }

    @Override
    public List<UserShortDto> getUserSubscriptions(long userId) {
        User user = repository.findById(userId)
                .orElseThrow(() -> new EwmObjNotFoundException(String.format("User with id=%d was not found", userId)));

        if (user.getSubscriptions() != null) {
            return user.getSubscriptions().stream().map(UserMapper::toUserShortDto).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public List<EventShortDto> getAllPublishEventsBySubscription(long userId, long otherId) {
        User user = repository.findById(userId)
                .orElseThrow(() -> new EwmObjNotFoundException(String.format("User with id=%d was not found", userId)));

        User other = repository.findById(otherId)
                .orElseThrow(() -> new EwmObjNotFoundException(String.format("User with id=%d was not found", otherId)));

        if (!user.getSubscriptions().contains(other)) {
            throw new EwmObjNotFoundException(String.format("User with id=%d is not subscribed to the user with id=%d", userId, otherId));
        }

        return eventRepository.findAllByEventStatusAndInitiatorId(EventStatus.PUBLISHED, otherId)
                .stream()
                .map(eventMapper::toShortDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto addSubscription(long userId, long subscriptionId) {

        User user = repository.findById(userId)
                .orElseThrow(() -> new EwmObjNotFoundException(String.format("User with id=%d was not found", userId)));

        User sub = repository.findById(subscriptionId)
                .orElseThrow(() -> new EwmObjNotFoundException(String.format("User with id=%d was not found", subscriptionId)));

        if (!user.getSubscriptionOption()) {
            throw new IllegalArgumentException("Subscriptions are closed");
        }

        user.getSubscriptions().add(sub);

        return UserMapper.toUserDto(repository.save(user));
    }

    @Override
    public void deleteSubscription(long userId, long subscriptionId) {
        User user = repository.findById(userId)
                .orElseThrow(() -> new EwmObjNotFoundException(String.format("User with id=%d was not found", userId)));

        User sub = repository.findById(subscriptionId)
                .orElseThrow(() -> new EwmObjNotFoundException(String.format("User with id=%d was not found", subscriptionId)));

        user.getSubscriptions().remove(sub);
        repository.save(user);
    }

    @Override
    public UserDto setSubscriptionOption(long userId, boolean option) {
        User user = repository.findById(userId)
                .orElseThrow(() -> new EwmObjNotFoundException(String.format("User with id=%d was not found", userId)));

        user.setSubscriptionOption(option);

        return UserMapper.toUserDto(repository.save(user));
    }
}
