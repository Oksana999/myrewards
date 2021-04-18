package com.example.myrewards.data;


import com.example.myrewards.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    public User getUserByName(String name);
}
