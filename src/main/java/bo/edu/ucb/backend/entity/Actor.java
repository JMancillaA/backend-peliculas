package bo.edu.ucb.backend.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "actores")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "id_TMDB")
    private String idTMDB;

    // Constructor vacío
    public Actor() {
    }

    // Constructor con campos
    public Actor(String nombre, String idTMDB) {
        this.nombre = nombre;
        this.idTMDB = idTMDB;
    }

    // Getter y Setter para id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter y Setter para nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter y Setter para idTMDB
    public String getIdTMDB() {
        return idTMDB;
    }

    public void setIdTMDB(String idTMDB) {
        this.idTMDB = idTMDB;
    }

    @Override
    public String toString() {
        return "Actor [id=" + id + ", nombre=" + nombre + ", idTMDB=" + idTMDB + "]";
    }
}
