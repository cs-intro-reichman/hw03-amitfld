import java.time.YearMonth;

/**
 * Prints the calendars of all the years in the 20th century.
 */
public class Calendar1 {
    // Starting the calendar on 1/1/1900
    static int dayOfMonth = 1;
    static int month = 1;
    static int year = 1900;
    static int dayOfWeek = 2;     // 1.1.1900 was a Monday
    static int nDaysInMonth = 31; // Number of days in January

    /**
     * Prints the calendars of all the years in the 20th century. Also prints the
     * number of Sundays that occured on the first day of the month during this period.
     */
    public static void main(String args[]) {
        // Advances the date and the day-of-the-week from 1/1/1900 till 31/12/1999, inclusive.
        // Prints each date dd/mm/yyyy in a separate line. If the day is a Sunday, prints "Sunday".
        // The following variable, used for debugging purposes, counts how many days were advanced so far.
        int sundayStartMonth = 0;
        //// Write the necessary initialization code, and replace the condition
        //// of the while loop with the necessary condition
        while (true) {
            //// Write the body of the while
            if (dayOfWeek == 1){
                System.out.printf("%d/%d/%d Sunday%n", dayOfMonth, month, year);
            } else {
                System.out.printf("%d/%d/%d%n", dayOfMonth, month, year);
            }
            if (dayOfWeek == 1 && dayOfMonth ==1){
                sundayStartMonth ++;
            }
            //// If you want to stop the loop after n days, replace the condition of the
            //// if statement with the condition (debugDaysCounter == n)
            if (dayOfMonth == 31 && month == 12 && year == 1999) {
                break;
            }
            advance();
        }
        System.out.printf("During the 20th century, %d Sundays fell on the first day of the month%n", sundayStartMonth);
        //// Write the necessary ending code here
    }

    // Advances the date (day, month, year) and the day-of-the-week.
    // If the month changes, sets the number of days in this month.
    // Side effects: changes the static variables dayOfMonth, month, year, dayOfWeek, nDaysInMonth.
    private static void advance() {
        if (dayOfMonth == nDaysInMonth(month, year)){
            dayOfMonth = 1;
            if (month == 12){
                month = 1;
                nDaysInMonth = nDaysInMonth(month, year);
                if (year != 1999){
                    year ++;
                }

            }else {
                month++;
                nDaysInMonth = nDaysInMonth(month, year);
            }
        } else {
            dayOfMonth ++;
        }
        if (dayOfWeek < 7){
            dayOfWeek ++;
        }else {
            dayOfWeek = 1;
        }
    }

    // Returns true if the given year is a leap year, false otherwise.
    private static boolean isLeapYear(int year) {
        // Check if the year is divisible by 4
        boolean isDivisibleBy4 = (year % 4 == 0);

        // Check if the year is a century year (divisible by 100)
        boolean isCenturyYear = (year % 100 == 0);

        // Check if the year is divisible by 400
        boolean isDivisibleBy400 = (year % 400 == 0);
        if (isDivisibleBy4 && (!isCenturyYear || isDivisibleBy400)){
            return true;
        }
        return false;
    }

    // Returns the number of days in the given month and year.
    // April, June, September, and November have 30 days each.
    // February has 28 days in a common year, and 29 days in a leap year.
    // All the other months have 31 days.
    private static int nDaysInMonth(int month, int year) {
        YearMonth yearMonth = YearMonth.of(year, month);
        return yearMonth.lengthOfMonth();
    }
}
