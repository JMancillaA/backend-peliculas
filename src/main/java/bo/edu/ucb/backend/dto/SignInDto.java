package bo.edu.ucb.backend.dto;

import java.util.Date;

public class SignInDto {
    private String nombre;
    private String email;
    private String contra;
    private Date fechaNacimiento;
    private Date fechaCreacion;
    private String pais;
    private boolean estado;
    private int auth;

    // Constructor, getters, setters, etc.
    
    // Constructor vacío
    public SignInDto() {
    }

    // Constructor con todos los campos
    public SignInDto(String nombre, String email, String contra, Date fechaNacimiento,
                       Date fechaCreacion, String pais, boolean estado, int auth) {
        this.nombre = nombre;
        this.email = email;
        this.contra = contra;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaCreacion = fechaCreacion;
        this.pais = pais;
        this.estado = estado;
        this.auth = auth;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter y Setter para email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter y Setter para contra
    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    // Getter y Setter para fechaNacimiento
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    // Getter y Setter para fechaCreacion
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    // Getter y Setter para pais
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    // Getter y Setter para estado
    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    // Getter y Setter para auth
    public int getAuth() {
        return auth;
    }

    public void setAuth(int auth) {
        this.auth = auth;
    }

    
}
