package Junit5;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private List<Student> students = new ArrayList<>();

    // 保存到"数据库"
    public void saveToDatabase(Student student) {
        if (student == null) throw new IllegalArgumentException("学生不能为null");
        students.add(student);
    }

    // 从"数据库"加载所有学生
    public List<Student> loadAllStudents() {
        return new ArrayList<>(students); // 返回副本保证数据安全
    }

    // 清空数据库（测试专用）
    public void clearDatabase() {
        students.clear();
    }
}