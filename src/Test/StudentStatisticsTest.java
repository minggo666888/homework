package Test;

import static org.junit.jupiter.api.Assertions.*;

import Junit5.Student;
import Junit5.StudentStatistics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentStatisticsTest {
    private StudentStatistics statistics;

    @BeforeEach
    void setUp() {
        List<Student> students = Arrays.asList(
                new Student("001", "张三", 18, 80),
                new Student("002", "李四", 19, 90)
        );
        statistics = new StudentStatistics(students);
    }

    @Test
    void testHighestScore() {
        assertEquals(90, statistics.getHighestScoreStudent().getScore());
    }

    @Test
    void testEmptyList() {
        assertThrows(IllegalArgumentException.class,
                () -> new StudentStatistics(null));
    }
}