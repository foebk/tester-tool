package TesterTool.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TestMakerController {
    @PostMapping("/addTest")
    public ResponseEntity<String> addTest(@RequestBody String test) {
        System.out.println(test);
        return ResponseEntity.ok().body(null);
    }
}
