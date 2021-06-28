package luis.alfaro.prueba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import luis.alfaro.prueba.auth.handler.LoginSuccessHandler;
import luis.alfaro.prueba.serviceimpl.JpaUserDetailsService;


@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private JpaUserDetailsService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired 
	private LoginSuccessHandler successHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{		
		try {
			http.authorizeRequests()
				.antMatchers("/paciente/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
				.antMatchers("/psicologo/**").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/reserva/**").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/especialidad/**").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/servicio/**").access("hasRole('ROLE_ADMIN')").and()
				.formLogin().successHandler(successHandler).loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/welcome/bienvenido")
				.permitAll().and().logout().logoutSuccessUrl("/login").permitAll().and().exceptionHandling().accessDeniedPage("/error_403");
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}		
	}
	
	public void configurerGlobal (AuthenticationManagerBuilder build) throws Exception{
		build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}
}
