
package sample;

/**
 *
 * @author Paul
 */
public class Note extends CommonCode {

    private int noteID = 0;
    private String course = "";
    private String dayte = "";
    private String note = "";

    public Note(int max, String crs, String nt) {
        setNoteID(max);
        setCourse(crs);
        setDayte();
        setNote(nt);
    }

    public Note(int nid, String crs, String dt, String nt) {
        setNoteID(nid);
        setCourse(crs);
        setDayte(dt);
        setNote(nt);
    }

    public void setNoteID(int n) {
        int nid = n;
        // Any validation goes here.
        noteID = nid;
    }

    public String setCourse(String c) {
        String crse = c;
        // Any checking goes here
        course = crse;
        return course;
    }

    public int getNoteID() {
        return noteID;
    }

    public String getCourse() {
        // Any checking goes here.
        return course;
    }

    public void setDayte() {
        dayte = orderedDate;
    }

    public void setDayte(String d) {
        dayte = d;
    }

    public String getDayte() {
        return dayte;
    }

    public void setNote(String n) {
        // Any validation goes here.
        note = n;

    }

    public String getNote() {
        // Any checking goes here.
        return note;
    }

}
