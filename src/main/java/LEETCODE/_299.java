package LEETCODE;

import java.util.HashMap;
import java.util.Map;

public class _299 {
	private static class Solution {
		public String getHint(String secret, String guess) {
			int bulls = 0;
			int cows = 0;

			Map<Character, Integer> secretMap = new HashMap<>();
			Map<Character, Integer> guessMap = new HashMap<>();
			int length = secret.length();
			for (int i = 0; i < length; i++) {
				if (secret.charAt(i) == guess.charAt(i)) {
					bulls++;
				} else {
					if (secretMap.containsKey(secret.charAt(i))) {
						secretMap.put(secret.charAt(i), secretMap.get(secret.charAt(i)) + 1);
					} else {
						secretMap.put(secret.charAt(i), 1);
					}

					if (guessMap.containsKey(guess.charAt(i))) {
						guessMap.put(guess.charAt(i), guessMap.get(guess.charAt(i)) + 1);
					} else {
						guessMap.put(guess.charAt(i), 1);
					}
				}
			}

			for (Map.Entry<Character, Integer> curGuess : guessMap.entrySet()) {
				if (secretMap.containsKey(curGuess.getKey())) {
					cows += Math.min(guessMap.get(curGuess.getKey()), secretMap.get(curGuess.getKey()));
				}
			}

			return bulls + "A" + cows + "B";
		}
	}
}
