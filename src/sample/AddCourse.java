
package sample;

import org.jetbrains.annotations.NotNull;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Paul
 */
public class AddCourse extends JFrame implements ActionListener, KeyListener {

    JPanel pnl = new JPanel(new BorderLayout());
    JTextArea txtNewCourse = new JTextArea();
    CommonCode cc = new CommonCode();
    AllCourses allCourses = new AllCourses();

    // Using MVC
    public AddCourse() {
        model();
        view();
        controller();
    }

    private void view() {
        Font fnt = new Font("Georgia", Font.PLAIN, 20);
        setSize(300, 100);

        JPanel pnlWest = new JPanel();
        pnlWest.setLayout(new BoxLayout(pnlWest, BoxLayout.Y_AXIS));
        pnlWest.setBorder(BorderFactory.createLineBorder(Color.black));
        add(pnlWest, BorderLayout.CENTER);

        txtNewCourse.setFont(fnt);
        pnlWest.add(txtNewCourse);

        JPanel pnlEast = new JPanel();

        JButton button = null;
        button = makeButton("Create", "addCourse", "Create a new course.", "New");
        pnlEast.add(button);

        add(pnlEast, BorderLayout.EAST);

        setVisible(true);  // Needed to ensure that the items can be seen.
    }

    private void controller() {
        addAllCourses();
    }

    @Override
    public void actionPerformed(@NotNull ActionEvent ae) {
        if ("addCourse".equals(ae.getActionCommand())) {
            addCourse(txtNewCourse.getText());
            txtNewCourse.setText("");
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

    private void model() {
        System.out.println("model not coded yet.");
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

    private void addCourse(String txt) {

        allCourses.addCourse(allCourses.getMaxID(), txt);
        addAllCourses();

    }

    private void addAllCourses() {
        String txtCourses = "";

        for (Course n : allCourses.getAllCourses()) {
            txtCourses += n.getCourse() + "\n";
        }

    }
}
