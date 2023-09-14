package frequencyapi.controller;

import frequencyapi.calculator.MyFrequencyCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class FrequencyController {

    @Autowired
    private MyFrequencyCalculator stringFrequencyCalculator;

    @GetMapping("/calculate")
    public ResponseEntity<?> calculateFrequency(@RequestParam(required = false) String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return ResponseEntity.badRequest().body("Input string is missing or empty.");
        }

        return ResponseEntity.ok(stringFrequencyCalculator.calculateFrequency(inputString));
    }

}
