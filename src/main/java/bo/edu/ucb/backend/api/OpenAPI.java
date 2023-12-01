package bo.edu.ucb.backend.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.edu.ucb.backend.dto.ResponseDto;

@RestController
public class OpenAPI {
    private final Logger logger = LoggerFactory.getLogger(OpenAPI.class);

    @GetMapping("api/v1/open")
    public ResponseDto openApi() {
        logger.info("Se ha recibido una solicitud para usar gpt.");
        return new ResponseDto("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");
    }
}
