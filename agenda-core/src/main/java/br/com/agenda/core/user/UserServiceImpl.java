package br.com.agenda.core.user;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.agenda.core.profile.Profile;
import br.com.agenda.core.profile.ProfileType;
import br.com.agenda.core.util.PasswordUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public void delete(long id) {
		userRepository.delete(id);
	}
	
	public User loadUserByUsername(String userId) throws UsernameNotFoundException {
		return Optional.ofNullable(userRepository.findByUsername(userId))
				.orElseThrow(() -> new UsernameNotFoundException("Usuario ou senha invalido"));
	}

	@Override
	public User save(User user) {
		Profile p = new Profile();
		p.setName(ProfileType.ROLE_USER);
		user.setPassword(PasswordUtils.encode(user.getPassword()));
		user.setProfiles(Arrays.asList(p));
		return userRepository.save(user);
	}

	public User findUserByUsername(String username) {
		return Optional.ofNullable(userRepository.findByUsername(username))
				.orElseThrow(() -> new UsernameNotFoundException("Usuario não localizado"));
	}

	public User findUserByUsernameAndContact(String username, Long id) {
		return Optional.ofNullable(userRepository.findUserByUsernameAndContact(username, id))
				.orElseThrow(() -> new RuntimeException("Contato não existe para usuario"));
	}

}