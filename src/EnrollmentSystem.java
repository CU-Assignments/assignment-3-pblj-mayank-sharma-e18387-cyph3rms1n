class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}

public class EnrollmentSystem {
    static boolean isCourseFull = false;
    static boolean prerequisiteCompleted = false;

    public static void enroll(String courseName, String prerequisite) throws CourseFullException, PrerequisiteNotMetException {
        if (isCourseFull) {
            throw new CourseFullException("CourseFullException - The course " + courseName + " is already full.");
        }
        if (!prerequisiteCompleted) {
            throw new PrerequisiteNotMetException("PrerequisiteNotMetException - Complete " + prerequisite + " first.");
        }
        System.out.println("Enrollment successful in " + courseName);
    }

    public static void main(String[] args) {
        try {
            enroll("Advanced Java", "Core Java");
        } catch (CourseFullException | PrerequisiteNotMetException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
