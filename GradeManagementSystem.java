package grade;

import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class GradeManagementSystem {

    public static void main(String[] args) {
        // JFrame Main Setting
        JFrame mainFrame = new JFrame("Grade Management System");
        mainFrame.setSize(1080, 720);
        mainFrame.setBackground(Color.BLACK);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setResizable(false);

        // JRootPane & JMenuBar Setting
        JRootPane root = mainFrame.getRootPane();
        JMenuBar menuBar = new JMenuBar();
        JMenu gradeSystem = new JMenu("GradeSystem");
        gradeSystem.add(new JMenuItem("About"));
        gradeSystem.addSeparator();
        gradeSystem.add(new JMenuItem("Exit"));
        JMenu file = new JMenu("File");
        file.add(new JMenuItem("New"));
        file.add(new JMenuItem("Open"));
        JMenu edit = new JMenu("Edit");
        edit.add(new JMenuItem("Edit"));
        edit.add(new JMenuItem("Delete"));
        
        menuBar.add(gradeSystem);
        menuBar.add(file);
        menuBar.add(edit);
        root.setJMenuBar(menuBar);

        // JPanel(For Title) Setting
        JPanel titlePanel = new JPanel();
        titlePanel.setSize(1080, 50);
        titlePanel.setBackground(new Color(86, 105, 255));
        titlePanel.setLayout(new BorderLayout());
        
        JLabel title = new JLabel("Grade Management System");
        title.setFont(new Font("Gothic", Font.BOLD, 30));
        title.setForeground(Color.white);
        title.setBorder(new EmptyBorder(0, 30, 0, 0));
        titlePanel.add(title, BorderLayout.WEST);

        // JPanel(For Main) Setting
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(129, 144, 255));
        mainPanel.setBounds(0, 50, 1080, 620);

        mainFrame.add(titlePanel);
        mainFrame.add(mainPanel);

        // Floating JFrame on Display
        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }
}
