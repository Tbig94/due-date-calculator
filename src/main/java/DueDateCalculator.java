import java.time.LocalDateTime;

public class DueDateCalculator {

    static DueDateCalculator calc = new DueDateCalculator();

    public static void main(String[] args) {
        LocalDateTime reportDate = LocalDateTime.now();
        int turnaroundTimeHours = (int)(Math.random() * 40) + 1;
        System.out.println("Report date: " + reportDate);
        System.out.println("Turnaround time: " + turnaroundTimeHours);
        System.out.println("Due date: " + calc.calculateDueDate(reportDate, turnaroundTimeHours));
    }

    public LocalDateTime calculateDueDate(LocalDateTime date, int turnaroundTimeHours) {
        // ha munkaidőn kívül jelentenek hibát, a következő munkanap kezdetére ugrik
        if (date.getHour() >= 17) {
            date = date.plusDays(1).withHour(9).withMinute(0).withNano(0);
        }
        if (date.getHour() < 9) {
            date = date.withHour(9).withMinute(0).withNano(0);
        }

        for (int i = 0; i < turnaroundTimeHours; i++) {
            //System.out.println("day of week: " + date.getDayOfWeek());
            //System.out.println("hour of day: " + date.getHour());
            //date = intervalCheck(date);
            date = date.plusHours(1);
            date = intervalCheck(date);
        }
        intervalCheck(date);
        return date;
    }

    public static LocalDateTime intervalCheck(LocalDateTime date) {
        if (date.getHour() >= 17) {                  // a munkanap vége után(17:00) átugrik a következő munkanap kezdetére(9:00)
            date = date.plusDays(1).withHour(9);
        }
        if (date.getDayOfWeek().toString().equals("SATURDAY")) {       // ha SZOMBAT van, akkor átugrik HÉTFŐ napra
            date = date.plusHours(48);
        }
        return date;
    }
}
