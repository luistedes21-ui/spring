package upc.edu.pe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class PsicoUnidosApplication implements CommandLineRunner {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
	

	public static void main(String[] args) {
		SpringApplication.run(PsicoUnidosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		String password = "SECRETO";
		String contra = "DIOSITO";
		
		for(int i=0; i<2;i++) {
			String bcryptPassword = passwordEncoder.encode(password); // passwordEncoder se encargara de encriptar las contraseñas
			System.out.println(bcryptPassword);// de forma encriptada se mostrara en pantalla
		}
		
		
		for(int i=0; i<2;i++) {
			String bcryptPassword = passwordEncoder.encode(contra);
			System.out.println(bcryptPassword);
		}
		
		
	}
	
	
	
}
