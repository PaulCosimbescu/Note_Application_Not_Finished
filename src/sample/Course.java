
package sample;

/**
 *
 * @author Paul
 */
public class Course extends CommonCode{

    private int noteID = 0;
    private String course = "";

    public Course(int max, String cs) {
        setCourseID(max);
        setCourse(cs);
    }

    public void setCourseID(int n) {
        noteID = n;
    }

    public int getCourseID() {
        return noteID;
    }

    public void setCourse(String n) {
        course = n;

    }

    public String getCourse() {
        return course;
    }

}