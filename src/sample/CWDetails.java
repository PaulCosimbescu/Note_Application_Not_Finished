
package sample;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;

/**
 *
 * @author paul
 */
public class CWDetails extends JFrame implements ActionListener, KeyListener {

    JPanel pnl = new JPanel(new BorderLayout());

    // Using MVC
    public CWDetails() {
        model();
        view();
        controller();
    }

    private void model() {
        System.out.println("model not coded yet.");
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

        menuBar.add(note);
        menuBar.add(makeMenuItem("Exit", "Exit", "Close this program.", fnt));

        this.setJMenuBar(menuBar);


        setTitle("Coursework - Paul Iulian Cosimbescu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel cen = new JPanel();
        cen.setLayout(new FlowLayout());

        String html = "<html><body>Hello <b>Paul</b></body></html>";
        JLabel cenLbl = new JLabel(html);
        cenLbl.setFont(fnt);
        cen.add(cenLbl);
        add(BorderLayout.CENTER, cen);

        JToolBar toolBar = new JToolBar();

        //Setting up a ButtonBar
        JButton button = null;
        button = makeButton("Create", "Return2Notes",
                "Return to the Notes window", "Notes");
        toolBar.add(button);

        button = makeButton("exit", "Exit",
                "Exit from this program.",
                "Exit");
        toolBar.add(button);

        add(toolBar, BorderLayout.NORTH);

        setVisible(true);  // Needed to ensure that the items can be seen.
    }

    private void controller() {
        System.out.println("controller not coded yet.");
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

    @Override
    public void actionPerformed(ActionEvent ae) {
        if ("Return2Notes".equals(ae.getActionCommand())) {
            Main cw = new Main();
        }
        if ("Exit".equals(ae.getActionCommand())) {
            System.exit(0);
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
}
