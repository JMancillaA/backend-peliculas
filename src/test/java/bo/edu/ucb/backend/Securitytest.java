package bo.edu.ucb.backend;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import bo.edu.ucb.backend.bl.SecurityBL;
import bo.edu.ucb.backend.entity.Usuario;

@SpringBootTest
class SecurityTest {

	@Autowired
	SecurityBL SecurityBL;

	@Test
	void testSuccesLogin() {
		Usuario usuario = SecurityBL.login("usuario1", "contraseña1"); // Corrección en la contraseña
		System.out.println(usuario);
		assertNotNull(usuario, "El usuario debería existir");
	}
	@Test
	void testErrorLogin() {
		try{
			Usuario usuario = SecurityBL.login("usuariooo", "contaseña1");
			assertNotNull(usuario,"El usuario deberia existir");
		}catch(RuntimeException ex){
			assertNotEquals("Autenticacion incorrecta",ex.getMessage());
		}
		
	}

}
