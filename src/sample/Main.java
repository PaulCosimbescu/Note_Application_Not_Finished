/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;

/**
 *
 * @author Paul
 */
public class Main extends JFrame implements ActionListener, KeyListener {

    JPanel pnl = new JPanel(new BorderLayout());
    JTextArea txtNewNote = new JTextArea();
    JTextArea txtDisplayNotes = new JTextArea();
    List<String> note = new ArrayList<>();
    List<String> course = new ArrayList<>();
    JComboBox courseList = new JComboBox();
    String crse = "";
    AllNotes allNotes = new AllNotes();
    CommonCode cc = new CommonCode();
    JTextField search = new JTextField();

    public static void main(String[] args) {

//        JOptionPane.showMessageDialog(null, "x-x\u00b2");

        Main prg = new Main();

    }

    // Using MVC
    public Main() {
        model();
        view();
        controller();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if ("NewNote".equals(ae.getActionCommand())) {
            addNote(txtNewNote.getText());
            txtNewNote.setText("");
        }
        if ("Close".equals(ae.getActionCommand())) {
            txtNewNote.setText("");
        }
        if ("ShowAllCourses".equals(ae.getActionCommand())) {
            allCourses(txtNewNote.getText());
        }
        if ("Exit".equals(ae.getActionCommand())) {
            System.exit(0);
        }
        if ("Course".equals(ae.getActionCommand())) {
            crse = courseList.getSelectedItem().toString();
            System.out.println(crse);
        }
        if ("addCourse".equals(ae.getActionCommand())) {
            AddCourse ca = new AddCourse();
        }
        if ("amendCourse".equals(ae.getActionCommand())) {

        }
        if ("deleteCourse".equals(ae.getActionCommand())) {

        }
        if ("SearchKeyword".equals(ae.getActionCommand())) {
            String lyst = allNotes.searchAllNotesByKeyword("", 0, search.getText());
            txtDisplayNotes.setText(lyst);
        }
        if ("Coursework".equals(ae.getActionCommand())) {
            CWDetails cw = new CWDetails();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("keyTyped not coded yet.");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("keyPressed not coded yet.");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("keyReleased not coded yet.");
    }

    private void view() {
        Font fnt = new Font("Georgia", Font.PLAIN, 24);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        JMenuBar menuBar = new JMenuBar();
        JMenu note = new JMenu();

        note = new JMenu("Note");
        note.setToolTipText("Note Tasks");
        note.setFont(fnt);

        note.add(makeMenuItem("New", "NewNote", "Create a new note.", fnt));
        note.addSeparator();
        note.add(makeMenuItem("Close", "Close", "Clear the current note.", fnt));

        JMenu courseDD = new JMenu();

        courseDD = new JMenu("Course");
        courseDD.setToolTipText("Course Tasks.");
        courseDD.setFont(fnt);

        courseDD.add(makeMenuItem("Add Course", "addCourse", "Create new Course.", fnt));
        courseDD.addSeparator();
        courseDD.add(makeMenuItem("Amend Course", "amendCourse", "Amend a Course.", fnt));
        courseDD.addSeparator();
        courseDD.add(makeMenuItem("Delete Course", "deleteCourse", "Delete a Course.", fnt));

        menuBar.add(courseDD);
        menuBar.add(note);
        menuBar.add(makeMenuItem("Exit", "Exit", "Close this program.", fnt));

        this.setJMenuBar(menuBar);

        JToolBar toolBar = new JToolBar();
        // Setting up the ButtonBar
        JButton button = null;
        button = makeButton("Document", "Coursework",
                "Open the coursework window.",
                "Coursewok");
        toolBar.add(button);
        button = makeButton("Create", "NewNote",
                "Create a new note.",
                "New");
        toolBar.add(button);
        button = makeButton("closed door", "Close",
                "Close this note.",
                "Close");
        toolBar.add(button);
        button = makeButton("Card File", "ShowAllCourses",
                "Show all courses.",
                "Show All Courses");
        toolBar.add(button);
        toolBar.addSeparator();
        button = makeButton("exit", "Exit",
                "Exit from this program.",
                "Exit");
        toolBar.add(button);

        toolBar.addSeparator();
        // This forces anything after it to the right.
        toolBar.add(Box.createHorizontalGlue());

        search.setMaximumSize(new Dimension(6900, 50));
        search.setFont(fnt);
        toolBar.add(search);
        toolBar.addSeparator();
        button = makeButton("search", "SearchKeyword",
                "Search for this text.",
                "Search");
        toolBar.add(button);

        add(toolBar, BorderLayout.NORTH);

        JPanel pnlWest = new JPanel();
        pnlWest.setLayout(new BoxLayout(pnlWest, BoxLayout.Y_AXIS));
        pnlWest.setBorder(BorderFactory.createLineBorder(Color.black));

        txtNewNote.setFont(fnt);
        pnlWest.add(txtNewNote);

        JButton btnAddNote = new JButton("Add note");
        btnAddNote.setActionCommand("NewNote");
        btnAddNote.addActionListener(this);
        pnlWest.add(btnAddNote);

        add(pnlWest, BorderLayout.WEST);

        JPanel cen = new JPanel();
        cen.setLayout(new BoxLayout(cen, BoxLayout.Y_AXIS));
        cen.setBorder(BorderFactory.createLineBorder(Color.black));
        txtDisplayNotes.setFont(fnt);
        cen.add(txtDisplayNotes);

        add(cen, BorderLayout.CENTER);

        setTitle("Coursework - Paul Cosimbescu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //This will add each course to the combobox
        for (String crse : course) {
            courseList.addItem(crse);
        }
        courseList.setFont(fnt);
        courseList.setMaximumSize(courseList.getPreferredSize());
        courseList.addActionListener(this);
        courseList.setActionCommand("Course");
        menuBar.add(courseList);

        this.setJMenuBar(menuBar);

        setVisible(true); // Needed to ensure that the items can be seen.
    }

    private void model() {
        course.add("COMP1753");
        course.add("COMP1752");
        course.add("COMP1715");
        course.add("COMP1713");
        course.add("COMP1588");
        course.add("COMP1587");
        course.add("MATH1110");
        course.add("MATH1111");

        crse = course.get(0);
    }

    private void controller() {
        addAllNotes();
    }

    protected JMenuItem makeMenuItem(
            String txt,
            String actionCommand,
            String toolTipText,
            Font fnt1) {

        JMenuItem mnuItem = new JMenuItem();
        mnuItem.setText(txt);
        mnuItem.setActionCommand(actionCommand);
        mnuItem.setToolTipText(toolTipText);
        mnuItem.setFont(fnt1);
        mnuItem.addActionListener(this);

        return mnuItem;
    }

    protected JButton makeButton(
            String imageName,
            String actionCommand,
            String toolTipText,
            String altText) {

        //Create and initialize the button.
        JButton button = new JButton();
        button.setToolTipText(toolTipText);
        button.setActionCommand(actionCommand);
        button.addActionListener(this);

        //Look for the image.
        String imgLocation = System.getProperty("user.dir")
                + "//icons//"
                + imageName
                + ".png";

        File fyle = new File(imgLocation);
        if (fyle.exists() && !fyle.isDirectory()) {
            // image found
            Icon img;
            img = new ImageIcon(imgLocation);
            button.setIcon(img);
        } else {
            // image not found
            button.setText(altText);
            System.err.println("Resource not found: " + imgLocation);
        }

        return button;
    }

    private void addAllNotes() {
        String txtNotes = "";

        for (Note n : allNotes.getAllNotes()) {
            txtNotes += n.getNote() + "\n";
        }

        txtDisplayNotes.setText(txtNotes);
    }

    private void addNote(String txt) {

        allNotes.addNote(allNotes.getMaxID(), crse, txt);
        addAllNotes();

    }

    private void allCourses(String txt) {
        String allCourses = "";

        for (String n : course) {
            allCourses += n + " ";
        }

        addNote(allCourses);
        addAllNotes();
    }

}
