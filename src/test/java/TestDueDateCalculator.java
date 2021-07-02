import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class TestDueDateCalculator {

    static DueDateCalculator calc = null;
    static LocalDateTime reportDate1 = null;
    static LocalDateTime reportDate2 = null;

    @BeforeAll
    public static void init() {
        calc = new DueDateCalculator();
        reportDate1 = LocalDateTime.of(2021,06,25, 22, 7);
        reportDate2 = LocalDateTime.of(2021,7,4, 2, 51);
    }

    @Test
    public void TestDueDateCalculator() {
        LocalDateTime rand = LocalDateTime.MAX;
        LocalDateTime expectedDate = LocalDateTime.of(2021,06,30, 13, 0);
        LocalDateTime resultDate = calc.calculateDueDate(reportDate1, 20);
        System.out.println("expected: " + expectedDate);
        System.out.println("result: " + resultDate + "\n");
        Assertions.assertTrue(resultDate.equals(expectedDate));
    }

    @Test
    public void TestDueDateCalculator2() {
        LocalDateTime expectedDate = LocalDateTime.of(2021,7,7, 16, 0);
        LocalDateTime resultDate = calc.calculateDueDate(reportDate1, 63);
        System.out.println("expected: " + expectedDate);
        System.out.println("result: " + resultDate + "\n");
        Assertions.assertTrue(resultDate.equals(expectedDate));
    }

    @Test
    public void TestDueDateCalculator3() {
        LocalDateTime expectedDate = LocalDateTime.of(2021,7,8, 12, 0);
        LocalDateTime resultDate = calc.calculateDueDate(reportDate2, 27);
        System.out.println("expected: " + expectedDate);
        System.out.println("result: " + resultDate + "\n");
        Assertions.assertTrue(resultDate.equals(expectedDate));
    }

    @Test
    public void TestDueDateCalculator4() {
        LocalDateTime expectedDate = LocalDateTime.of(2021,7,12, 16, 0);
        LocalDateTime resultDate = calc.calculateDueDate(reportDate2, 47);
        System.out.println("expected: " + expectedDate);
        System.out.println("result: " + resultDate + "\n");
        Assertions.assertTrue(resultDate.equals(expectedDate));
    }

}
