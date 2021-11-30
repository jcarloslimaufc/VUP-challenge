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
        user.setNome("João");
        user.setEmail("analista.jcarloslima@gmail.com");
        user.setCpf("000.000.000.00");
        user.setDataNAscimento("16/02/1993");




        return user;

    }

}
