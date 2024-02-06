package LEETCODE;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class _1360 {
    private static class Solution {
        public int daysBetweenDates(String date1, String date2) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate first = LocalDate.parse(date1, formatter);
            LocalDate second = LocalDate.parse(date2, formatter);

            return (int) Duration.between(first.atStartOfDay(), second.atStartOfDay()).abs().toDays();
        }
    }
}
