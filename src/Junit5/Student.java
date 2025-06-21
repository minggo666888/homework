package Junit5;

public class Student {
    private String id;
    private String name;
    private int age;
    private double score;

    public Student(String id, String name, int age, double score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.score = score;
    }

    // Getters and Setters
    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getScore() { return score; }

    public void setScore(double score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("分数必须在0-100之间");
        }
        this.score = score;
    }
}
