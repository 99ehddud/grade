package grade;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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

        // JPanel(For Input Score) Setting
        JPanel inputScorePanel = new JPanel();
        inputScorePanel.setBackground(new Color(215, 215, 255));
        inputScorePanel.setBounds(50, 570, 980, 80);

        JLabel languageLabel = new JLabel();
        languageLabel.setText("Language : ");
        inputScorePanel.add(languageLabel);
        JTextField language = new JTextField(5);
        inputScorePanel.add(language);

        JLabel mathLabel = new JLabel();
        mathLabel.setText("Math : ");
        inputScorePanel.add(mathLabel);
        JTextField math = new JTextField(5);
        inputScorePanel.add(math);

        JLabel societyLabel = new JLabel();
        societyLabel.setText("Society : ");
        inputScorePanel.add(societyLabel);
        JTextField society = new JTextField(5);
        inputScorePanel.add(society);

        JLabel scienceLabel = new JLabel();
        scienceLabel.setText("Science : ");
        inputScorePanel.add(scienceLabel);
        JTextField science = new JTextField(5);
        inputScorePanel.add(science);

        this.add(inputScorePanel);

        // JPanel(For Input Name & Number) Setting
        JPanel inputPersonalPanel = new JPanel();
        inputPersonalPanel.setBackground(new Color(215, 215, 255));
        inputPersonalPanel.setBounds(50, 520, 980, 50);

        JLabel numberLabel = new JLabel();
        numberLabel.setText("No. ");
        inputPersonalPanel.add(numberLabel);
        JTextField number = new JTextField(4);
        number.setText(String.format("%04d", 1));
        inputPersonalPanel.add(number);

        JLabel nameLabel = new JLabel();
        nameLabel.setText("Name : ");
        inputPersonalPanel.add(nameLabel);
        JTextField name = new JTextField(10);
        inputPersonalPanel.add(name);

        JButton cancel = new JButton("Cancel");
        inputPersonalPanel.add(cancel);

        ActionListener btnCancel = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name.setText(null);
                language.setText(null);
                math.setText(null);
                society.setText(null);
                science.setText(null);
            }
        };
        cancel.addActionListener(btnCancel);

        JButton submit = new JButton("Submit");
        inputPersonalPanel.add(submit);

        ActionListener btnSubmit = new ActionListener() {
            int num = 1;

            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0;
                String[] array = new String[8];
                try {
                    String numberGet = number.getText();
                    array[0] = numberGet;
                    String nameGet = name.getText();
                    array[1] = nameGet;
                    int languageGet = Integer.parseInt(language.getText());
                    array[2] = Integer.toString(languageGet);
                    i++;
                    int mathGet = Integer.parseInt(math.getText());
                    array[3] = Integer.toString(mathGet);
                    i++;
                    int societyGet = Integer.parseInt(society.getText());
                    array[4] = Integer.toString(societyGet);
                    i++;
                    int scienceGet = Integer.parseInt(science.getText());
                    array[5] = Integer.toString(scienceGet);
                    i++;
                    int total = languageGet + mathGet + societyGet + scienceGet;
                    array[6] = Integer.toString(total);
                    double average = total / 4;
                    array[7] = Double.toString(average);
                } catch (NumberFormatException nfe) {
                    // When you push submit button, and if what you input is not integer
                    // Error will occur and you cannot input your score to Array
                    System.out.println("Error! : " + nfe.getMessage());
                }
                
                if (i == 4) {
                    System.out.println(Arrays.toString(array));
                    array = new String[8];
                    number.setText(String.format("%04d", num + 1));
                    num++;
                    i = 0;
                    JOptionPane.showMessageDialog(null, "Input Success!");
                } else {
                    if (i == 0) {
                        language.setText(null);
                    } else if (i == 1) {
                        math.setText(null);
                    } else if (i == 2) {
                        society.setText(null);
                    } else if (i == 3) {
                        science.setText(null);
                    }

                    JOptionPane.showMessageDialog(null, "Please check the Textfield or input number correctly");
                }
            }
        };
        submit.addActionListener(btnSubmit);

        this.add(inputPersonalPanel);

        // Floating JFrame on Display
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new GradeManagementSystem();
    }
}

// 1. Make TextField clear
// 2. Write "If Statements(For Submit)" more specifically
// 3. Write the code for NumberFormatException more specifically
// 4. Make user input only integer in Score Field
// 5. Make data be uploaded in JTable when user input correctly