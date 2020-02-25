
package sample;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paul
 */
public class AllCourses extends CommonCode {

    private List<Course> allCourses = new ArrayList<>();
    private int maxID = 0;

    public AllCourses() {
        readAllCourses();
    }

    public final int getMaxID() {
        this.maxID++;
        return this.maxID;
    }

    public void addCourse(int maxID, String cs) {
        Course myCourse = new Course(maxID, cs);

        this.allCourses.add(myCourse);
        writeAllCourses();
    }

    private void readAllCourses() {
        List<String> readNotes = new ArrayList<>();

        readNotes = readTextFile(appDir + fileSeparator + "Courses.txt");
        System.out.println(readNotes.get(0));

        if ("File not found".equals(readNotes.get(0))) {
        } else {
            this.allCourses.clear();

            for (String str : readNotes) {
                String[] tmp = str.split("\t");

                int nid = Integer.parseInt(tmp[0]);
                Course n = new Course(nid, tmp[1]);

                this.allCourses.add(n);

                if (nid > this.maxID) {
                    this.maxID = nid;
                }
            }
        }

        this.maxID++;
    }

    public List<Course> getAllCourses() {
        return this.allCourses;
    }

    private void writeAllCourses() {
        String path = appDir + fileSeparator + "Courses.txt";
        List<String> writeCourse = new ArrayList<>();

        for (Course n : this.allCourses) {
            String tmp = n.getCourseID() + "\t";
            tmp += n.getCourse();
            writeCourse.add(tmp);
        }
        try {
            writeTextFile(path, writeCourse);
        } catch (IOException ex) {
            System.out.println("Problem! " + path);
        }
    }

}
