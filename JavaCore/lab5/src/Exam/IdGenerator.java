package Exam;

public class IdGenerator {
    private static int currentId = 0;

    public static int getNextId() {
        currentId++;
        return currentId;
    }
}
