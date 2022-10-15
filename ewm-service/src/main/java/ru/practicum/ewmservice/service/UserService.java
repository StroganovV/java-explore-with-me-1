package ru.practicum.ewmservice.service;

import ru.practicum.ewmservice.dto.EventShortDto;
import ru.practicum.ewmservice.dto.UserDto;
import ru.practicum.ewmservice.dto.UserShortDto;
import ru.practicum.ewmservice.dto.newDto.NewUserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAll(List<Long> ids, int from, int size);

    UserDto create(NewUserDto dto);

    void delete(long userId);

    List<UserShortDto> getUserSubscriptions(long userId);

    List<EventShortDto> getAllPublishEventsBySubscription(long userId, long otherId);

    UserDto addSubscription(long userId, long subscriptionId);

    void deleteSubscription(long userId, long subscriptionId);

    UserDto setSubscriptionOption(long userId, boolean option);
}
