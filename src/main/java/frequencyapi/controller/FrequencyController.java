package frequencyapi.controller;

import frequencyapi.calculator.StringFrequencyCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class FrequencyController {

    @Autowired
    private StringFrequencyCalculator stringFrequencyCalculator;

    @GetMapping("/calculate")
    public ResponseEntity<?> calculateFrequency(@RequestParam(required = false) String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return ResponseEntity.badRequest().body("Input string is missing or empty.");
        }

        return ResponseEntity.ok(stringFrequencyCalculator.calculateFrequency(inputString));
    }

}
