package br.com.adrianomenezes.generalback.services;

import java.util.Optional;
import java.util.logging.Logger;

import br.com.adrianomenezes.generalback.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.adrianomenezes.generalback.repositories.UserRepository;


@Service
public class UserService implements UserDetailsService{
	private Logger logger =   Logger.getLogger(UserService.class.getName());
	
	@Autowired
	UserRepository repository;
	
	
	
	public UserService(UserRepository repository) {
		this.repository = repository;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("Finding one user by name " + username +" !");
		var user = repository.findByUsername(username);
		if (user != null) {
			return user;
		} else {
			throw new UsernameNotFoundException("Username " + username + " not found!");
		}
	}

	public User loadUserById(Long userId) throws UsernameNotFoundException {
		logger.info("Finding one user by Id " + userId +" !");
		var user = repository.findById(userId);
		if (user != null) {
			return user.orElseThrow(() -> {
				new UsernameNotFoundException("User ID  " + userId + " not found!");
				return null;
			});
		} else {
			throw new UsernameNotFoundException("User ID  " + userId + " not found!");
		}
	}

	
	
}
