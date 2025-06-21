package Junit5;

public class StudentValidator {
    // 校验ID格式（假设ID必须为3位数字）
    public static boolean isValidId(String id) {
        return id != null && id.matches("\\d{3}");
    }

    // 校验分数范围
    public static boolean isValidScore(double score) {
        return score >= 0 && score <= 100;
    }

    // 校验年龄范围
    public static boolean isValidAge(int age) {
        return age > 0 && age < 120;
    }

    // 在StudentValidator类中添加：
    public static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty();
    }
}