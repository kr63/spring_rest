package com.wildbeancoffee.friends.controllers;

import com.wildbeancoffee.friends.model.Friend;
import com.wildbeancoffee.friends.repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class FriendController {

  private final FriendRepository friendRepository;

  @Autowired
  public FriendController(FriendRepository friendRepository) {
    this.friendRepository = friendRepository;
  }

  @GetMapping("/friend")
  Iterable<Friend> read() {
    return friendRepository.findAll();
  }

  @PostMapping("/friend")
  Friend create(@RequestBody Friend friend) {
    return friendRepository.save(friend);
  }

  @PutMapping("/friend")
  Friend update(@RequestBody Friend friend) {
    return friendRepository.save(friend);
  }

  @DeleteMapping("/friend/{id}")
  void delete(@PathVariable Integer id) {
    friendRepository.deleteById(id);
  }

  @GetMapping("/friend/{id}")
  Optional<Friend> findById(@PathVariable Integer id) {
    return friendRepository.findById(id);
  }

  @GetMapping("/friend/search")
  Iterable<Friend> findByQuery(
          @RequestParam(value = "first", required = false) String firstName,
          @RequestParam(value = "last", required = false) String lastName) {

    if (firstName != null && lastName != null) {
      return friendRepository.findByFirstNameAndLastName(firstName, lastName);
    } else if (firstName != null) {
      return friendRepository.findByFirstName(firstName);
    } else if (lastName != null) {
      return friendRepository.findByLastName(lastName);
    } else {
      return friendRepository.findAll();
    }
  }
}
