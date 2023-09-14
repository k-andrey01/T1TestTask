package frequencyapi.calculator;

import java.util.Map;

public interface FrequencyCalculator {
    Map<Character, Integer> calculateFrequency(String inputText);
}
