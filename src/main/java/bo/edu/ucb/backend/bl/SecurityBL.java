package bo.edu.ucb.backend.bl;

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
    public Usuario login(String nombreusuario, String contra) {
        logger.info("Intentando iniciar sesión con nombre de usuario: {}", nombreusuario);
        Usuario usuario = usuarioDao.findByNombreUsuarioAndContra(nombreusuario, contra);
        if (usuario == null) {
            logger.warn("Usuario no encontrado en la base de datos.");
            throw new RuntimeException("Usuario no existe");
        }
        usuario.setContra(null);
        logger.info("Se ha iniciado sesión correctamente.");
        return usuario;
    }

    public void registrarUsuario(String nombreUsuario, String contrasena) {
        // Verificar si el nombre de usuario ya existe en la base de datos
        Usuario usuarioExistente = usuarioDao.findByNombreUsuario(nombreUsuario);
        if (usuarioExistente != null) {
            throw new RuntimeException("El nombre de usuario ya está en uso.");
        }
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre(nombreUsuario);
        nuevoUsuario.setContra(contrasena);
        usuarioDao.save(nuevoUsuario);
        logger.info("Se ha creado un usuario.");
    }
}