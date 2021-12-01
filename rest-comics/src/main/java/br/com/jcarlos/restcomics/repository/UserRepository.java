package br.com.jcarlos.restcomics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jcarlos.restcomics.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
