package com.alvaro.libreria.entity.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alvaro.libreria.entity.models.User;
import com.alvaro.libreria.entity.dao.UserDAO;

@Service
public class IUserServiceImpl implements IUserService{
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public Optional<User> getOne(int id) {
		return userDAO.findById(id);
	}

	@Override
	public List<User> getAll() {
		return (List<User>) userDAO.findAll();
	}

	@Override
	public void add(User user) {
		userDAO.save(user);
	}

	@Override
	public void update(int id, User user) {
		Optional<User> c = userDAO.findById(id);
		
		if (c.isPresent()) {
			user.setId(id);
			userDAO.save(user);
		}
	}

	@Override
	public void delete(int id) {
		userDAO.deleteById(id);
	}

}
