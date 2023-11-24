package com.poly.truongnvph29176.service.impl;

import com.poly.truongnvph29176.entity.Friend;
import com.poly.truongnvph29176.repository.FriendRepository;
import com.poly.truongnvph29176.service.FriendService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FriendServiceImpl implements FriendService {
    private final FriendRepository friendRepository;

    @Override
    public List<Friend> getFriends() {
        return friendRepository.findAll();
    }

    @Override
    public Friend createFriend(Friend friend) {
        return friendRepository.save(friend);
    }

    @Override
    public Friend updateFriend(Integer id, Friend friend) {
        return friendRepository.save(friend);
    }

    @Override
    public void deleteFriend(Integer id) {
        friendRepository.deleteById(id);
    }
}
