package ru.practicum.ewmservice.service.mapper;

import ru.practicum.ewmservice.dto.UserDto;
import ru.practicum.ewmservice.dto.UserShortDto;
import ru.practicum.ewmservice.dto.newDto.NewUserDto;
import ru.practicum.ewmservice.model.User;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class UserMapper {
    public static UserShortDto toUserShortDto(User initiator) {
        UserShortDto dto = new UserShortDto();
        dto.setId(initiator.getId());
        dto.setName(initiator.getName());
        return dto;
    }

    public static UserDto toUserDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());

        if (user.getSubscriptions() != null && user.getSubscriptions().size() > 0) {
            dto.setSubscriptions(user.getSubscriptions()
                    .stream()
                    .map(UserMapper::toUserShortDto)
                    .collect(Collectors.toList()));
        }

        dto.setSubscription(user.getSubscription());

        return dto;
    }

    public static User toUserFromNewDto(NewUserDto dto) {
        User user = new User();
        user.setCreated(LocalDateTime.now());
        user.setEmail(dto.getEmail());
        user.setName(dto.getName());
        return user;
    }
}
