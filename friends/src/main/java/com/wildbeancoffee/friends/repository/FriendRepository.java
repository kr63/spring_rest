package com.wildbeancoffee.friends.repository;

import com.wildbeancoffee.friends.model.Friend;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRepository extends CrudRepository<Friend, Integer> {

    Iterable<Friend> findByFirstNameAndLastName(String firstName, String lastName);

    Iterable<Friend> findByFirstName(String firstName);

    Iterable<Friend> findByLastName(String lastName);

}
