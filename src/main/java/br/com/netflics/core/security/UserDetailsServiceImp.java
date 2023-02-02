/**generated by JSetup v0.95 :  at 1 de fev de 2023 23:43:21**/
package br.com.netflics.core.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import br.com.netflics.model.User;
import br.com.netflics.persistence.UserRepository;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
public class UserDetailsServiceImp implements UserDetailsService {
	private final UserRepository userRepository;

	@Autowired
	SpringSecurityUserContext context;

	@Autowired
	public UserDetailsServiceImp(UserRepository userRepository) {
		if (userRepository == null) {
			throw new IllegalArgumentException("userRepository cannot be null");
		}
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> appUser = userRepository.findByUsername(username);
		if (appUser.isPresent()) {
			return appUser.get();
		}
		throw new UsernameNotFoundException("Invalid username...");
	}
}