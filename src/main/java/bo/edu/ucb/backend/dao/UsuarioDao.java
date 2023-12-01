package bo.edu.ucb.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import bo.edu.ucb.backend.entity.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario,Integer>{
    public Usuario findByNombreAndContra(String nombre, String contra);
    Usuario findByNombre(String nombre);
    public Usuario findById(int id);
}
