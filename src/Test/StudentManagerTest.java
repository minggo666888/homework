package Test;

import static org.junit.jupiter.api.Assertions.*;

import Junit5.Student;
import Junit5.StudentManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentManagerTest {
    private StudentManager manager;

    @BeforeEach
    public void setUp() {
        manager = new StudentManager();
        manager.addStudent(new Student("001", "张三", 18, 80));
        manager.addStudent(new Student("002", "李四", 19, 90));
    }

    @Test
    public void testAddStudent() {
        assertEquals(2, manager.getStudents().size()); // 假设添加了getStudents()方法
        assertThrows(IllegalArgumentException.class, () -> manager.addStudent(null));
    }

    @Test
    public void testRemoveStudent() {
        assertTrue(manager.removeStudent("001"));
        assertNull(manager.findStudent("001"));
    }

    @Test
    public void testCalculateAverageScore() {
        assertEquals(85.0, manager.calculateAverageScore(), 0.001);
    }

    @Test
    public void testEmptyListAverage() {
        StudentManager emptyManager = new StudentManager();
        assertThrows(IllegalStateException.class, () -> emptyManager.calculateAverageScore());
    }

    @Test
    void testAddStudentWithDuplicateId() {
        Student student1 = new Student("101", "重复ID测试", 18, 85);
        Student student2 = new Student("101", "重复ID测试", 19, 90);

        manager.addStudent(student1);
        // 根据需求选择以下断言之一：
        assertFalse(manager.addStudent(student2)); // 预期拒绝重复（正确）
        // 或 assertTrue(manager.addStudent(student2)); // 当前允许重复（错误）
    }
}