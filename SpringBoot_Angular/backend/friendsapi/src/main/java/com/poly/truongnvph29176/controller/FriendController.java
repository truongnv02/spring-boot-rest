package com.poly.truongnvph29176.controller;

import com.poly.truongnvph29176.entity.Friend;
import com.poly.truongnvph29176.service.FriendService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/friends")
public class FriendController {
    private final FriendService friendService;

    @GetMapping("")
    public ResponseEntity<?> getFriends() {
        List<Friend> friends = friendService.getFriends();
        return ResponseEntity.ok(friends);
    }

    @PostMapping("")
    public ResponseEntity<?> createFriend(@Valid @RequestBody Friend friend,
                                          BindingResult result) {
        return ResponseEntity.ok(friendService.createFriend(friend));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFriend(@PathVariable("id") Integer id,
                                          @Valid @RequestBody Friend friend,
                                          BindingResult result) {
        return ResponseEntity.ok(friendService.updateFriend(id, friend));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFriend(@PathVariable("id") Integer id) {
        friendService.deleteFriend(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}
