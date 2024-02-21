package org.example.controller;

import jakarta.validation.Valid;
import org.example.model.CreateShortLinkRequest;
import org.example.model.ShortLink;
import org.example.service.ShortLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShortLinkController {
    private ShortLinkService shortLinkService;

    @Autowired
    public ShortLinkController(ShortLinkService shortLinkService) {
        this.shortLinkService = shortLinkService;
    }
    @GetMapping("/links")
    public Iterable<ShortLink> findAllLinks(@RequestParam("user") Integer userId) {
        return shortLinkService.getAllLinksForUser(userId);
    }

    @PostMapping("/link")
    public ShortLink createShortLink(@Valid @RequestBody CreateShortLinkRequest createShortLinkRequest) {
        return shortLinkService.createShortLink(createShortLinkRequest);
    }
//
//    @PutMapping("/user/id")
//    public boolean updateUser(@PathVariable Integer id, @RequestBody User user) {
//        return userService.updateUser(id, user);
//    }
//
//    @DeleteMapping("/user/{id}")
//    public boolean deleteUser(@PathVariable Integer id) {
//        return userService.deleteUser(id);
//    }
}
