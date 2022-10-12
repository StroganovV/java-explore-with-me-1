package ru.practicum.ewmservice.controller.privateController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ewmservice.dto.EventShortDto;
import ru.practicum.ewmservice.dto.UserDto;
import ru.practicum.ewmservice.dto.UserShortDto;
import ru.practicum.ewmservice.service.UserService;

import javax.validation.constraints.Positive;
import java.util.List;

// The controller implements the functionality of subscriptions to other users

@RestController
@RequestMapping(path = "/users/{userId}/subscriptions")
@AllArgsConstructor
public class SubscriptionPrivateController {
    private UserService userService;

    @GetMapping
    public List<UserShortDto> getAllUserSubscriptions(@PathVariable @Positive long userId) {
        return userService.getUserSubscriptions(userId);
    }

    //получить опубликованные события человека из подписок
    @GetMapping("/events")
    public List<EventShortDto> getAllPublishEventsOtherUser(@PathVariable @Positive long userId,
                                                            @RequestParam @Positive long otherId) {
        return userService.getAllPublishEventsBySubscription(userId, otherId);
    }

    //подписаться на другого юзера
    @PostMapping
    public UserDto addSubscription(@PathVariable @Positive long userId,
                                   @RequestParam @Positive long subscriptionId) {
        return userService.addSubscription(userId, subscriptionId);
    }

    //отписаться от юзера
    @DeleteMapping
    public void deleteSubscription(@PathVariable @Positive long userId,
                                   @RequestParam @Positive long subscriptionId) {
        userService.deleteSubscription(userId, subscriptionId);
    }

    //закрыть возможность подписываться на себя
    @PatchMapping("/close")
    public UserDto closeSubscriptions(@PathVariable @Positive long userId) {
        return userService.setSubscriptionOption(userId, false);
    }

    //открыть возможность подписываться на себя
    @PatchMapping("/open")
    public UserDto openSubscriptions(@PathVariable @Positive long userId) {
        return userService.setSubscriptionOption(userId, true);
    }
}
