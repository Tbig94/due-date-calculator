import java.time.LocalDateTime;

public class DueDateCalculator {

    static DueDateCalculator calculator = new DueDateCalculator();

    public static final int WORKDAY_START_HOUR = 9;
    public static final int WORKDAY_END_HOUR = 17;
    public static final int HOURS_IN_A_DAY = 24;

    public static void main(String[] args) {
        LocalDateTime reportDate = LocalDateTime.now();
        int turnaroundTimeHours = (int)(Math.random() * 40) + 1;
        System.out.println("Report date: " + reportDate);
        System.out.println("Turnaround time: " + turnaroundTimeHours);
        System.out.println("Due date: " + calculator.calculateDueDate(reportDate, turnaroundTimeHours));
    }

    public LocalDateTime calculateDueDate(LocalDateTime date, int turnaroundTimeHours) {
        date = setSubmitDate(date);
        for (int i = 0; i < turnaroundTimeHours; i++) {
            date = date.plusHours(1);
            date = intervalCheck(date);
        }
        return date;
    }

    public static LocalDateTime intervalCheck(LocalDateTime date) {
        if (date.getHour() >= WORKDAY_END_HOUR) {                  // a munkanap vége után(17:00) átugrik a következő munkanap kezdetére(9:00)
            date = date.plusDays(1).withHour(WORKDAY_START_HOUR);
        }
        if (date.getDayOfWeek().toString().equals("SATURDAY")) {       // ha SZOMBAT van, akkor átugrik HÉTFŐ napra
            date = date.plusHours(HOURS_IN_A_DAY * 2);
        }
        if (date.getDayOfWeek().toString().equals("SUNDAY")) {       // ha SZOMBAT van, akkor átugrik HÉTFŐ napra
            date = date.plusHours(HOURS_IN_A_DAY);
        }
        return date;
    }

    // ha munkaidőn kívül jelentenek hibát, a következő munkanap kezdetére ugrik
    public static LocalDateTime setSubmitDate(LocalDateTime date) {
        if (date.getHour() >= WORKDAY_END_HOUR) {
            date = date.plusDays(1).withHour(WORKDAY_START_HOUR).withMinute(0).withNano(0);
        }
        if (date.getHour() < WORKDAY_START_HOUR) {
            date = date.withHour(WORKDAY_START_HOUR).withMinute(0).withNano(0);
        }
        if (date.getDayOfWeek().toString().equals("SATURDAY")) {       // ha SZOMBAT van, akkor átugrik HÉTFŐ napra
            date = date.plusHours(HOURS_IN_A_DAY * 2);
        }
        if (date.getDayOfWeek().toString().equals("SUNDAY")) {       // ha SZOMBAT van, akkor átugrik HÉTFŐ napra
            date = date.plusHours(HOURS_IN_A_DAY);
        }
        return date;
    }
}
