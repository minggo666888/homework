package Junit5;

import Junit5.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentManager {
    private List<Student> students = new ArrayList<>();

    // 添加学生
    public boolean addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("学生不能为null");
        }
        if (findStudent(student.getId()) != null) {
            return false; // 重复ID返回false
        }
        students.add(student);
        return true;
    }

    // 删除学生
    public boolean removeStudent(String id) {
        return students.removeIf(s -> s.getId().equals(id));
    }

    // 根据ID查询学生
    public Student findStudent(String id) {
        return students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // 计算平均分
    public double calculateAverageScore() {
        if (students.isEmpty()) {
            throw new IllegalStateException("学生列表为空");
        }
        return students.stream()
                .mapToDouble(Student::getScore)
                .average()
                .orElse(0);
    }

    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }
}
