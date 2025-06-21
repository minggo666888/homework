package Test;

import static org.junit.jupiter.api.Assertions.*;

import Junit5.Student;
import Junit5.StudentManager;
import Junit5.StudentRepository;
import Junit5.StudentValidator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentRepositoryTest {
    private StudentRepository repository;
    private Student student;

    @BeforeEach
    void setUp() {
        repository = new StudentRepository();
        student = new Student("001", "张三", 18, 90);
    }

    @Test
    void testSaveAndLoad() {
        repository.saveToDatabase(student);
        assertEquals(1, repository.loadAllStudents().size());
    }

    @Test
    void testSaveNullStudent() {
        // 1. 准备测试数据
        StudentManager manager = new StudentManager();

        // 2. 执行并验证：添加null学生时应抛出异常
        assertThrows(IllegalArgumentException.class,
                () -> manager.addStudent(null),
                "addStudent(null) 应抛出 IllegalArgumentException");

        // 3. 可选：验证学生列表未被污染
        assertEquals(0, manager.getStudents().size()); // 需确保StudentManager有getStudents()方法    }


}
}