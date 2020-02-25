
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
        int nid = n;
        // Any validation goes here.
        noteID = nid;
    }

    public int getCourseID() {
        return noteID;
    }

    public void setCourse(String n) {
        // Any validation goes here.
        course = n;

    }

    public String getCourse() {
        // Any checking goes here.
        return course;
    }

}