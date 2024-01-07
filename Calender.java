import java.time.YearMonth;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;
/*This program gets a
given year, like 2021, and prints the calendar of that year*/
public class Calender {
    static int dayOfMonth = 1;
    static int month = 1;
    static int dayOfWeek;     // 1.1.1900 was a Monday
    static int nDaysInMonth = 31; // Number of days in January
    public static void main(String args[]) {
        int year = Integer.parseInt(args[0]);
        int daysInMonth = nDaysInMonth(month, year);
        String dateStr = String.format("%d-01-01", year);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            LocalDate date = LocalDate.parse(dateStr, formatter);
            String dayOfWeekStr = date.getDayOfWeek().toString();
            switch (dayOfWeekStr) {
                case "SUNDAY":
                    dayOfWeek = 1;
                    break;
                case "MONDAY":
                    dayOfWeek = 2;
                    break;
                case "TUESDAY":
                    dayOfWeek = 3;
                    break;
                case "WEDNESDAY":
                    dayOfWeek = 4;
                    break;
                case "THURSDAY":
                    dayOfWeek = 5;
                    break;
                case "FRIDAY":
                    dayOfWeek = 6;
                    break;
                case "SATURDAY":
                    dayOfWeek = 7;
                    break;
                default:
                    System.out.println("Invalid day");
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        while (true) {
            if (dayOfWeek == 1){
                System.out.printf("%d/%d/%d Sunday%n", dayOfMonth, month, year);
            } else {
                System.out.printf("%d/%d/%d%n", dayOfMonth, month, year);
            }
            if (dayOfMonth == 31 && month == 12) {
                break;
            }
            advance();
        }

    }

    private static void advance() {
        if (dayOfMonth == nDaysInMonth){
            dayOfMonth = 1;
            if (month != 12){
                month ++;
            }
        } else {
            dayOfMonth ++;
        }
        if (dayOfWeek == 7){
            dayOfWeek = 1;
        } else {
            dayOfWeek ++;
        }
    }


    private static int nDaysInMonth(int month, int year) {
        YearMonth yearMonth = YearMonth.of(year, month);
        return yearMonth.lengthOfMonth();
    }
}
