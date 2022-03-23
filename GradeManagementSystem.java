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

    private int i = 0;

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

        String[] personalData = { "No.", "Name"};
        String[] subjectData = {"Language", "Math", "Society", "Science"};
        String[] resultData = {"Total", "Average"};
        String[] tableTitle = new String[personalData.length + subjectData.length + resultData.length];
        // Set Function for adding elements(PersonalData, subjectData, resultData)
        // Modify Syntax simply (Use "for" syntax)

        int pd = personalData.length;
        int sd = subjectData.length;
        int psd = pd + sd;
        int variableForArray = 0;

        for (int variableForTableTitle = 0; variableForTableTitle < tableTitle.length; variableForTableTitle++) {
            if (variableForTableTitle == pd || variableForTableTitle == psd) {
                variableForArray = 0;
            }

            if (variableForTableTitle < pd) {
                tableTitle[variableForTableTitle] = personalData[variableForArray];
            } else if (pd <= variableForTableTitle && variableForTableTitle < psd) {
                tableTitle[variableForTableTitle] = subjectData[variableForArray];
            } else if (pd < variableForTableTitle) {
                tableTitle[variableForTableTitle] = resultData[variableForArray];
            }
            
            variableForArray++;
        }

        DefaultTableModel tableContent = new DefaultTableModel(tableTitle, 0);
        JTable mainTable = new JTable(tableContent);
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
                
                String[] array = new String[8];
                String where = "";
                
                try {
                    int languageGet;
                    int mathGet;
                    int societyGet;
                    int scienceGet;
                    int total = 0;

                    String numberGet = number.getText();
                    array[0] = numberGet;
                    // If user does not input their name or just input " ", Throw the exception
                    if (i == 0) {
                        String nameGet = name.getText();
                        array[1] = nameGet;
                        i++;
                    }
                    
                    if (i == 1) {
                        languageGet = Integer.parseInt(language.getText());
                        total += languageGet;
                        array[2] = Integer.toString(languageGet);
                        i++;
                    }
                    
                    if (i == 2) {
                        mathGet = Integer.parseInt(math.getText());
                        total += mathGet;
                        array[3] = Integer.toString(mathGet);
                        i++;
                    }
                    
                    if (i == 3) {
                        societyGet = Integer.parseInt(society.getText());
                        total += societyGet;
                        array[4] = Integer.toString(societyGet);
                        i++;
                    }
                    
                    if (i == 4) {
                        scienceGet = Integer.parseInt(science.getText());
                        total += scienceGet;
                        array[5] = Integer.toString(scienceGet);
                        i++;
                    }
                    
                    if (i == 5) {
                        array[6] = Integer.toString(total);
                        float average = total / (float)(subjectData.length);
                        array[7] = String.format("%.2f", average);
                    }
                } catch (NumberFormatException nfe) {
                    // When you push submit button, and if what you input is not integer
                    // Error will occur and you cannot input your score to Array
                    if (i == 1) {
                        language.setText(null);
                        where += "Language";
                    } else if (i == 2) {
                        math.setText(null);
                        where += "Math";
                    } else if (i == 3) {
                        society.setText(null);
                        where += "Society";
                    } else if (i == 4) {
                        science.setText(null);
                        where += "Language";
                    }
                    where += ": Please Input Correctly!";
                    JOptionPane.showMessageDialog(null, where);
                    i = 0;
                }
                
                if (i == 5) {
                    tableContent.addRow(array);
                    System.out.println(Arrays.toString(array));
                    array = new String[8];
                    number.setText(String.format("%04d", num + 1));
                    num++;
                    name.setText(null);
                    language.setText(null);
                    math.setText(null);
                    society.setText(null);
                    science.setText(null);
                    i = 0;
                    JOptionPane.showMessageDialog(null, "Input Success!");
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

// * Have to nullCheck for when user doesn't input name

// 1. Make TextField clear
// 2. Write "If Statements(For Submit)" more specifically
// 3. Write the code for NumberFormatException more specifically
// 4. Make user input only integer in Score Field
// 5. Make data be uploaded in JTable when user input correctly -> OK!
// 6. Set Table border-bottom and Text-align Center