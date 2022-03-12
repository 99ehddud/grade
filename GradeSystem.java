package grade;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRootPane;

public class GradeSystem extends JFrame {

    public GradeSystem() {
        this.setTitle("Grade System");
        this.setSize(1080, 720);

        createRoot();
        createPanel();

        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);
    }

    public void createRoot() {
        JRootPane root = super.getRootPane();

        JMenuBar menuBar = new JMenuBar();
        JMenu gradeSystem = new JMenu("GradeSystem");
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");

        gradeSystem.add( new JMenuItem("About") );
        gradeSystem.addSeparator();
        gradeSystem.add(new JMenuItem("Exit"));

        file.add( new JMenuItem("New") );
        file.add( new JMenuItem("Open") );

        edit.add( new JMenuItem("Edit") );
        edit.add( new JMenuItem("Delete") );

        menuBar.add(gradeSystem);
        menuBar.add(file);
        menuBar.add(edit);

        root.setJMenuBar(menuBar);
    }
    
    public void createPanel() {
        JPanel titlePanel = new JPanel();
        
    }

    public static void main(String[] args) {
        new GradeSystem();
    }
}
