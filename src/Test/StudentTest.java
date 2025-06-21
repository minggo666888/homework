package Test;

import static org.junit.jupiter.api.Assertions.*;

import Junit5.Student;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    @Test
    public void testStudentCreation() {
        Student student = new Student("001", "张三", 18, 90.5);
        assertEquals("001", student.getId());
        assertEquals(90.5, student.getScore(), 0.001);
    }

    @Test
    public void testInvalidScore() {
        Student student = new Student("001", "张三", 18, 90);
        assertThrows(IllegalArgumentException.class, () -> student.setScore(-10));
    }

    // 新增4个测试方法（原2个 → 总计6个）
    @Test
    void testSetMaxScore() {
        Student student = new Student("001", "张三", 18, 99);
        student.setScore(100); // 测试满分边界
        assertEquals(100, student.getScore());
    }

    @Test
    void testSetZeroScore() {
        Student student = new Student("002", "李四", 19, 10);
        student.setScore(0); // 测试零分边界
        assertEquals(0, student.getScore());
    }

    @Test
    void testNullName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Student("003", null, 20, 80));
    }

    @Test
    void testAgeUpperBound() {
        assertThrows(IllegalArgumentException.class,
                () -> new Student("004", "王五", 150, 90));
    }

    @Test
    void testEmptyId() {
        assertThrows(IllegalArgumentException.class,
                () -> new Student("", "空ID学生", 20, 90)); // 空ID应触发异常
    }
}