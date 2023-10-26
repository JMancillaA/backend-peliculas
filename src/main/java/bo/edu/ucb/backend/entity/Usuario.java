package bo.edu.ucb.backend.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "usuarios ")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombreusuario",unique = true,nullable = false)
    private String nombreUsuario;

    @Column(name = "contra")
    private String contra;

    // Constructor vacío
    public Usuario() {
    }

    // Constructor con campos
    public Usuario(String nombreUsuario, String contra) {
        this.nombreUsuario = nombreUsuario;
        this.contra = contra;
    }

    // Getter y Setter para id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter y Setter para nombreUsuario
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    // Getter y Setter para contraseña
    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nombreUsuario=" + nombreUsuario + ", contra=" + contra + "]";
    }
}
