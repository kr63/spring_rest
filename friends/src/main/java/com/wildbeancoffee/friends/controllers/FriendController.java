package com.wildbeancoffee.friends.controllers;

import com.wildbeancoffee.friends.model.Friend;
import com.wildbeancoffee.friends.repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
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
  Friend create(@RequestBody Friend friend) throws ValidationException {
    if (friend.getId() == 0 && friend.getFirstName() != null && friend.getLastName() != null) {
      return friendRepository.save(friend);
    } else {
      throw new ValidationException("friend cannot be created");
    }
  }

  @PutMapping("/friend")
  ResponseEntity<Friend> update(@RequestBody Friend friend) {
    if (friendRepository.findById(friend.getId()).isPresent()) {
      return new ResponseEntity<>(friendRepository.save(friend), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(friend, HttpStatus.BAD_REQUEST);
    }
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
