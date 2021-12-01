package br.com.jcarlos.restcomics.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jcarlos.restcomics.exception.ResourceNotFoundException;
import br.com.jcarlos.restcomics.model.User;
import br.com.jcarlos.restcomics.repository.UserRepository;

@Service
public class UserServices {
	
	@Autowired
	UserRepository repository;
		
	public User create(User user) {
		return repository.save(user);
	}
	
	public List<User> findAll() {
		return repository.findAll();
	}	
	
	public User findById(Long id) {

		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
	}
		
	public User update(User user) {
		User entity = repository.findById(user.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		entity.setNome(user.getNome());
		entity.setCpf(user.getCpf());
		entity.setEmail(user.getEmail());
	
		return repository.save(entity);
	}	
	
	public void delete(Long id) {
		User entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		repository.delete(entity);
	}

}