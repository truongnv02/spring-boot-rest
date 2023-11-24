package com.poly.truongnvph29176.service;

import com.poly.truongnvph29176.entity.Friend;

import java.util.List;

public interface FriendService {
    List<Friend> getFriends();
    Friend createFriend(Friend friend);
    Friend updateFriend(Integer id, Friend friend);
    void deleteFriend(Integer id);
}
