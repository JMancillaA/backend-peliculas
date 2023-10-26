package bo.edu.ucb.backend.api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import bo.edu.ucb.backend.bl.SecurityBL;
import bo.edu.ucb.backend.dto.LoginRequestDto;
import bo.edu.ucb.backend.dto.ResponseDto;
import bo.edu.ucb.backend.entity.Usuario;

@RestController
public class LoginAPI {
    SecurityBL securityBL;
    Logger logger;
    public LoginAPI(SecurityBL securityBL){
        this.logger = LoggerFactory.getLogger(SecurityBL.class);
        this.securityBL = securityBL;
    }
    @PostMapping("api/v1/login")
    public ResponseDto login(@RequestBody LoginRequestDto loginRequestDto){
        Usuario usuario;
        logger.info("Se ha recibido una solicitud login.");
        try{
            usuario=securityBL.login(loginRequestDto.getUsuario(),loginRequestDto.getContrasena());
        }catch(RuntimeException ex){
            return new ResponseDto("TASK-1000",ex.getMessage());
        }
        return new ResponseDto(usuario);      
    }
    @PostMapping("api/v1/register")
    public ResponseDto register(@RequestBody LoginRequestDto loginRequestDto) {
        logger.info("Se ha recibido una solicitud register.");
        try {
            securityBL.registrarUsuario(loginRequestDto.getUsuario(), loginRequestDto.getContrasena());
            return new ResponseDto("Registro exitoso.");
        } catch (RuntimeException ex) {
            return new ResponseDto("TASK-1000", ex.getMessage());
        }
    }
}
