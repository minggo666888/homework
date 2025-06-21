package Junit5;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentStatistics {
    private List<Student> students;

    public StudentStatistics(List<Student> students) {
        if (students == null) throw new IllegalArgumentException("学生列表不能为null");
        this.students = students;
    }

    // 获取最高分学生
    public Student getHighestScoreStudent() {
        return students.stream()
                .max(Comparator.comparingDouble(Student::getScore))
                .orElse(null);
    }

    // 分数分布（如：90-100分人数）
    public long countStudentsInScoreRange(double min, double max) {
        return students.stream()
                .filter(s -> s.getScore() >= min && s.getScore() <= max)
                .count();
    }
}
