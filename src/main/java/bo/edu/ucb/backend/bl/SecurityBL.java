package bo.edu.ucb.backend.bl;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import bo.edu.ucb.backend.dao.UsuarioDao;
import bo.edu.ucb.backend.entity.Usuario;

@Service
public class SecurityBL{
    private UsuarioDao usuarioDao;
    Logger logger;
    public SecurityBL(UsuarioDao usuarioDao){
        this.usuarioDao=usuarioDao;
        this.logger = LoggerFactory.getLogger(SecurityBL.class);
    }
    public Usuario login(String nombre, String contra) {
        logger.info("Intentando iniciar sesión con nombre de usuario: {}", nombre);
        Usuario usuario = usuarioDao.findByNombreAndContra(nombre, contra);
        if (usuario == null) {
            logger.warn("Usuario no encontrado en la base de datos.");
            throw new RuntimeException("Usuario no existe");
        }
        usuario.setContra(null);
        logger.info("Se ha iniciado sesión correctamente.");
        return usuario;
    }

    public void registrarUsuario(String nombre, String contrasena, String email, String pais,
        Date fechaNacimiento) {
        // Verificar si el nombre de usuario ya existe en la base de datos
        Usuario usuarioExistente = usuarioDao.findByNombre(nombre);
        if (usuarioExistente != null) {
            throw new RuntimeException("El nombre de usuario ya está en uso.");
        }
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre(nombre);
        nuevoUsuario.setEmail(email);
        nuevoUsuario.setContra(contrasena);
        nuevoUsuario.setFechaNacimiento(fechaNacimiento);
        nuevoUsuario.setFechaCreacion(new Date());
        nuevoUsuario.setPais(pais);
        nuevoUsuario.setEstado(true);
        nuevoUsuario.setAuth(0);
        usuarioDao.save(nuevoUsuario);
        logger.info("Se ha creado un usuario.");
    }
}