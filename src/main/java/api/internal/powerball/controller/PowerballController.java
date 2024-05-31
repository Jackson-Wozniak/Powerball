package api.internal.powerball.controller;

import api.internal.powerball.model.Powerball;
import api.internal.powerball.payload.DrawingRequest;
import api.internal.powerball.payload.PowerballDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/powerball")
public class PowerballController {

    private static final String JSON = MediaType.APPLICATION_JSON_VALUE;

    @PutMapping(consumes = JSON, produces = JSON)
    public ResponseEntity<PowerballDTO> drawNumbers(@RequestBody DrawingRequest request){
        request.verifyNumbers();
        Powerball powerball = new Powerball(request);
        return ResponseEntity.ok(new PowerballDTO(powerball));
    }
}
