package bo.edu.ucb.backend;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import bo.edu.ucb.backend.dao.UsuarioDao;
import bo.edu.ucb.backend.entity.Usuario;

@SpringBootTest
class BackendApplicationTests {

	@Autowired
	UsuarioDao usuarioDao;
	
	@Test
	void testUsuarioJPA() {
		List<Usuario> usuariolist=usuarioDao.findAll();
		for (Usuario u:usuariolist){
			System.out.println(u.getNombre());
		}
		assertNotEquals(0, usuariolist.size(),"La base de datos deberia tener registros");
	}
}
