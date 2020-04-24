package TesterTool.Controllers;

import TesterTool.Models.TestModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TestMakerController {
    @PostMapping("/addTest")
    public ResponseEntity<String> addTest(@RequestBody TestModel test) {
        System.out.println(test);
        System.out.println();
        return ResponseEntity.ok().body(null);
    }
}
