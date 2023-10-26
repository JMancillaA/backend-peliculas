package bo.edu.ucb.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import bo.edu.ucb.backend.entity.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario,Integer>{
    public Usuario findByNombreUsuarioAndContra(String nombreusuario, String contra);
    Usuario findByNombreUsuario(String nombreusuario);
    public Usuario findById(int id);
}
