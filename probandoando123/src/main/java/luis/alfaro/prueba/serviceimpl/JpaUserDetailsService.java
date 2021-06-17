package luis.alfaro.prueba.serviceimpl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import luis.alfaro.prueba.model.Role;
import luis.alfaro.prueba.model.Users;
import luis.alfaro.prueba.repository.iUserRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService {

	@Autowired
	private iUserRepository usuarioRepository;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users usuario = usuarioRepository.findByUsername(username);
		List<GrantedAuthority>authorities = new ArrayList<GrantedAuthority>();
		
		for(Role role : usuario.getRoles()) {
			
			authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
		}
		
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true, authorities);
	}
	
		
}
