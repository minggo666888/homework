package Test;

import static org.junit.jupiter.api.Assertions.*;

import Junit5.StudentValidator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentValidatorTest {
    @Test
    void testValidId() {
        assertTrue(StudentValidator.isValidId("123"));
        assertFalse(StudentValidator.isValidId("12")); // 长度不足
        assertFalse(StudentValidator.isValidId("abc")); // 非数字
    }

    @Test
    void testValidScore() {
        assertTrue(StudentValidator.isValidScore(0));   // 边界值
        assertFalse(StudentValidator.isValidScore(-1));
    }

    @Test
    void testValidNameWithSpecialChars() {
        assertTrue(StudentValidator.isValidName("张三_John@123")); // 支持特殊字符
    }
}