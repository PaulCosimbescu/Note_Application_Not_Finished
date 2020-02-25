
package sample;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author paul
 */
public class AllCourses extends CommonCode {

    private ArrayList<Course> allCourses = new ArrayList<>();
    private int maxID = 0;

    public AllCourses() {
        readAllCourses();
    }

    public final int getMaxID() {
        maxID++;
        return maxID;
    }

    public void addCourse(int maxID, String cs) {
        Course myCourse = new Course(maxID, cs);

        allCourses.add(myCourse);
        writeAllCourses();
    }

    private void readAllCourses() {
        ArrayList<String> readNotes = new ArrayList<>();

        readNotes = readTextFile(appDir + fileSeparator + "Courses.txt");
        System.out.println(readNotes.get(0));

        if ("File not found".equals(readNotes.get(0))) {
        } else {
            allCourses.clear();

            for (String str : readNotes) {
                String[] tmp = str.split("\t");

                int nid = Integer.parseInt(tmp[0]);
                Course n = new Course(nid, tmp[1]);

                allCourses.add(n);

                if (nid > maxID) {
                    maxID = nid;
                }
            }
        }

        maxID++;
    }

    public ArrayList<Course> getAllCourses() {
        return allCourses;
    }

    private void writeAllCourses() {
        String path = appDir + fileSeparator + "Courses.txt";
        ArrayList<String> writeCourse = new ArrayList<>();

        for (Course n : allCourses) {
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
