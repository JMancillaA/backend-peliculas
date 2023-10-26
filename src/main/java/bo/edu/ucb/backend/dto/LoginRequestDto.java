package bo.edu.ucb.backend.dto;

public class LoginRequestDto {
    private String usuario;
    private String contra;

    public LoginRequestDto() {
        // Constructor vacío
    }

    public LoginRequestDto(String usuario, String contra) {
        this.usuario = usuario;
        this.contra = contra;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contra;
    }

    public void setContra(String contrasena) {
        this.contra = contrasena;
    }

    @Override
    public String toString() {
        return "LoginRequestDto{" +
                "usuario='" + usuario + '\'' +
                ", contra='" + contra + '\'' +
                '}';
    }
}
