package grade;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class GradeManagementSystem extends JFrame {

    public GradeManagementSystem() {
        // JFrame Main Setting
        setTitle("Grade Management System");
        setSize(1080, 720);
        getContentPane().setBackground(new Color(129, 144, 255));
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // JRootPane & JMenuBar Setting
        JRootPane root = this.getRootPane();
        JMenuBar menuBar = new JMenuBar();
        JMenu system = new JMenu("System");
        system.add(new JMenuItem("About"));
        system.addSeparator();
        system.add(new JMenuItem("Exit"));
        menuBar.add(system);
        JMenu file = new JMenu("File");
        file.add(new JMenuItem("New"));
        file.add(new JMenuItem("Open"));
        menuBar.add(file);
        JMenu edit = new JMenu("Edit");
        edit.add(new JMenuItem("Edit"));
        edit.add(new JMenuItem("Delete"));
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
        this.add(titlePanel);

        // JPanel(For Table) Setting
        JPanel tablePanel = new JPanel();
        tablePanel.setBackground(new Color(129, 144, 255));
        tablePanel.setBounds(50, 70, 980, 450);
        tablePanel.setLayout(new BorderLayout());

        String[] colNames = {"No.", "Name", "Language", "Math", "Society", "Science", "Total", "Average"};
        DefaultTableModel tableTitle = new DefaultTableModel(colNames, 1);
        JTable mainTable = new JTable(tableTitle);
        JScrollPane scroll = new JScrollPane(mainTable);
        scroll.setBorder(BorderFactory.createEmptyBorder());
        tablePanel.add(scroll);
        mainTable.getTableHeader().setReorderingAllowed(false);
        mainTable.getTableHeader().setResizingAllowed(false);
        mainTable.getTableHeader().setPreferredSize(new Dimension(0, 30));

        // Set Table Header Center Align (https://itjbg.wordpress.com/2012/05/28/set-center-alignment-of-jtable-header-in-java/)
        TableCellRenderer rendererFromHeader = mainTable.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);

        mainTable.setRowHeight(30);
        mainTable.getColumnModel().getColumn(0).setPreferredWidth(49);
        mainTable.getColumnModel().getColumn(1).setPreferredWidth(131);
        mainTable.getColumnModel().getColumn(2).setPreferredWidth(131);
        mainTable.getColumnModel().getColumn(3).setPreferredWidth(131);
        mainTable.getColumnModel().getColumn(4).setPreferredWidth(131);
        mainTable.getColumnModel().getColumn(5).setPreferredWidth(131);
        mainTable.getColumnModel().getColumn(6).setPreferredWidth(131);
        mainTable.getColumnModel().getColumn(7).setPreferredWidth(131);

        this.add(tablePanel);

        // JPanel(For Input) Setting
        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(new Color(215, 215, 255));
        inputPanel.setBounds(50, 520, 980, 130);

        JLabel nameLabel = new JLabel();
        nameLabel.setText("Name : ");
        inputPanel.add(nameLabel);
        JTextField name = new JTextField(10);
        inputPanel.add(name);

        JTextField language = new JTextField(5);
        inputPanel.add(language);

        JTextField math = new JTextField(5);
        inputPanel.add(math);

        JTextField society = new JTextField(5);
        inputPanel.add(society);

        JTextField science = new JTextField(5);
        inputPanel.add(science);

        this.add(inputPanel);

        // Floating JFrame on Display
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new GradeManagementSystem();
    }
}


// Add Button for add grade
// Add TextArea for input name & grade
// 129, 144, 255