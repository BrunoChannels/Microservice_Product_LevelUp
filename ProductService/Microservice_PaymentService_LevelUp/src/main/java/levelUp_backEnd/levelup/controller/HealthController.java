package levelUp_backEnd.levelup.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
public class HealthController {

    @GetMapping("/health")
    @ApiResponse(responseCode = "200", description = "Servicio activo")
    public String healthCheck() {
        return "Payment Service is up and running!";
    }
    
    
    
}
