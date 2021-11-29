package br.com.jcarlos.restcomics.services;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.jcarlos.restcomics.model.User;

@Service
public class UserService {

    //Id generator
    private final AtomicLong counter = new AtomicLong();

    public User findById(String id){
        User user = new User();
        user.setId(counter.incrementAndGet());
        return user;

    }

}
