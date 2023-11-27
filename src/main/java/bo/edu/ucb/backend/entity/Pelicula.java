package bo.edu.ucb.backend.entity;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "peliculasTMDB")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "actores_id", nullable = false)
    private Actor actor;

    @ManyToOne
    @JoinColumn(name = "directores_id", nullable = false)
    private Director director;

    @ManyToOne
    @JoinColumn(name = "generos_id", nullable = false)
    private Genero genero;

    @Column(name = "fecha_lanzamiento")
    private Date fechaLanzamiento;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "sinopsis")
    private String sinopsis;

    @Column(name = "poster")
    private String poster;

    @Column(name = "valoracion")
    private String valoracion;

    @Column(name = "id_TMDB")
    private String idTMDB;

    @Column(name = "recomendada")
    private boolean recomendada;

    // Constructor vacío
    public Pelicula() {
    }

    // Constructor con campos
    public Pelicula(Actor actor, Director director, Genero genero, Date fechaLanzamiento, String titulo, String sinopsis,
                    String poster, String valoracion, String idTMDB, boolean recomendada) {
        this.actor = actor;
        this.director = director;
        this.genero = genero;
        this.fechaLanzamiento = fechaLanzamiento;
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.poster = poster;
        this.valoracion = valoracion;
        this.idTMDB = idTMDB;
        this.recomendada = recomendada;
    }

    // Getter y Setter para id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter y Setter para actor
    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    // Getter y Setter para director
    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    // Getter y Setter para genero
    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    // Getter y Setter para fecha de lanzamiento
    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    // Getter y Setter para titulo
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // Getter y Setter para sinopsis
    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    // Getter y Setter para poster
    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    // Getter y Setter para valoracion
    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }

    // Getter y Setter para idTMDB
    public String getIdTMDB() {
        return idTMDB;
    }

    public void setIdTMDB(String idTMDB) {
        this.idTMDB = idTMDB;
    }

    // Getter y Setter para recomendada
    public boolean isRecomendada() {
        return recomendada;
    }

    public void setRecomendada(boolean recomendada) {
        this.recomendada = recomendada;
    }

    @Override
    public String toString() {
        return "Pelicula [id=" + id + ", actor=" + actor + ", director=" + director + ", genero=" + genero +
                ", fechaLanzamiento=" + fechaLanzamiento + ", titulo=" + titulo + ", sinopsis=" + sinopsis +
                ", poster=" + poster + ", valoracion=" + valoracion + ", idTMDB=" + idTMDB +
                ", recomendada=" + recomendada + "]";
    }
}
