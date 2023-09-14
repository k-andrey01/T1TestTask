import frequencyapi.FrequencyApp;
import frequencyapi.controller.FrequencyController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = FrequencyApp.class)
public class Tests {
    @Autowired
    private FrequencyController frequencyController;

    @Test
    public void testCalculateFrequency() {
        String inputString = "aaabbbccc";
        ResponseEntity<?> response = frequencyController.calculateFrequency(inputString);

        Map<Character, Integer> expectedMap = new HashMap<>();
        expectedMap.put('a', 3);
        expectedMap.put('b', 3);
        expectedMap.put('c', 3);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedMap, response.getBody());
    }

    @Test
    public void testEmptyString() {
        String inputString = "";
        ResponseEntity<?> response = frequencyController.calculateFrequency(inputString);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Input string is missing or empty.", response.getBody());
    }

    @Test
    public void testNullString() {
        ResponseEntity<?> response = frequencyController.calculateFrequency((String) null);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Input string is missing or empty.", response.getBody());
    }



    @Test
    public void testSpecialCharacters() {
        String inputString = "!@((";
        ResponseEntity<?> response = frequencyController.calculateFrequency(inputString);

        Map<Character, Integer> expectedMap = new HashMap<>();
        expectedMap.put('!', 1);
        expectedMap.put('@', 1);
        expectedMap.put('(', 2);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedMap, response.getBody());
    }
}
