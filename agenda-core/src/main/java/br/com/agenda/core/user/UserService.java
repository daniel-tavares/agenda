package br.com.agenda.core.user;

import java.util.List;


public interface UserService {
    User save(User user);
    List<User> findAll();
    void delete(long id);
	User findUserByUsername(String username);
	User findUserByUsernameAndContact(String username, Long id);
}