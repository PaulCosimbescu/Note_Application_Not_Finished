
package sample;

/**
 *
 * @author Paul
 */
public class Note extends CommonCode {

    private int noteID;
    private String course;
    private String dayte;
    private String note;

    public Note(int max, String course, String note) {
        this.noteID = max;
        this.course = course;
        this.dayte = orderedDate;
        this.note = note;
    }

    public Note(int noteID, String course, String dayte, String note) {
        this.noteID = noteID;
        this.course = course;
        this.dayte = dayte;
        this.note = note;
    }

    public int getNoteID() {
        return noteID;
    }

    public String getCourse() {
        return course;
    }

    public String getDayte() {
        return dayte;
    }

    public String getNote() {
        return note;
    }

}
