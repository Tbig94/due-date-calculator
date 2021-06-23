import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class TestDueDateCalculator {

    static DueDateCalculator calc = null;
    static LocalDateTime reportDate = null;

    @BeforeAll
    public static void init() {
        calc = new DueDateCalculator();
        reportDate = LocalDateTime.of(2021,06,22, 12, 0);
    }

    @Test
    public void TestDueDateCalculator() {
        LocalDateTime expectedDate = LocalDateTime.of(2021,06,24, 16, 0);
        LocalDateTime resultDate = calc.calculateDueDate(reportDate, 20);
        System.out.println("expected: " + expectedDate);
        System.out.println("result: " + resultDate + "\n");
        Assertions.assertTrue(resultDate.equals(expectedDate));
    }

    @Test
    public void TestDueDateCalculator2() {
        LocalDateTime expectedDate = LocalDateTime.of(2021,7,2, 11, 0);
        LocalDateTime resultDate = calc.calculateDueDate(reportDate, 63);
        System.out.println("expected: " + expectedDate);
        System.out.println("result: " + resultDate + "\n");
        Assertions.assertTrue(resultDate.equals(expectedDate));
    }

}
