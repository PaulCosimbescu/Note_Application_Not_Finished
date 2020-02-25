
package sample;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paul
 */
public class AllNotes extends CommonCode {

    private List<Note> allNotes = new ArrayList<>();
    private String crse = "";
    private int maxID = 0;

    public AllNotes() {
        readAllNotes();
    }

    public final int getMaxID() {
        this.maxID++;
        return this.maxID;
    }

    public void addNote(int maxID, String course, String note) {
        Note myNote = new Note(maxID, course, note);

        this.allNotes.add(myNote);
        writeAllNotes();
    }

    private void readAllNotes() {
        List<String> readNotes = new ArrayList<>();

        readNotes = readTextFile(appDir + fileSeparator + "Notes.txt");
        System.out.println(readNotes.get(0));

        if ("File not found".equals(readNotes.get(0))) {
        } else {
            this.allNotes.clear();

            for (String str : readNotes) {
                String[] tmp = str.split("\t");

                int nid = Integer.parseInt(tmp[0]);
                Note n = new Note(nid, tmp[1], tmp[2], tmp[3]);

                this.allNotes.add(n);

                if (nid > this.maxID) {
                    this.maxID = nid;
                }
            }
        }

        this.maxID++;
    }

    public List<Note> getAllNotes() {
        return this.allNotes;
    }

    private void writeAllNotes() {
        String path = appDir + fileSeparator + "Notes.txt";
        ArrayList<String> writeNote = new ArrayList<>();

        for (Note n : this.allNotes) {
            String tmp = n.getNoteID() + "\t";
            tmp += n.getCourse() + "\t";
            tmp += n.getDayte() + "\t";
            tmp += n.getNote();
            writeNote.add(tmp);
        }
        try {
            writeTextFile(path, writeNote);
        } catch (IOException ex) {
            System.out.println("Problem! " + path);
        }
    }

    public String searchAllNotesByKeyword(String noteList, int i, String s) {
        if (i == this.allNotes.size()) {
            return noteList;
        }

        if (this.allNotes.get(i).getNote().contains(s)) {
            noteList += this.allNotes.get(i).getNote() + "\n";
        }

        return searchAllNotesByKeyword(noteList, i + 1, s);
    }

}
