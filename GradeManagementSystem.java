package grade;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.InputMismatchException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
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
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class GradeManagementSystem extends JFrame {

    public class JTableColoredBorder extends Box {

        public JTableColoredBorder(int axis) {
            super(BoxLayout.Y_AXIS);
        }

    }

    private int i = 0;
    private int num = 1;

    public GradeManagementSystem() {
        // JFrame Main Setting
        setTitle("Grade Management System");
        setSize(1080, 720);
        getContentPane().setBackground(new Color(125, 125, 125));
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
        file.add(new JMenuItem("Save"));
        file.addSeparator();
        file.add(new JMenuItem("Delete"));
        menuBar.add(file);
        root.setJMenuBar(menuBar);

        // JPanel(For Title) Setting
        JPanel titlePanel = new JPanel();
        titlePanel.setSize(1080, 50);
        titlePanel.setBackground(new Color(125, 125, 125));
        titlePanel.setLayout(new BorderLayout());

        JLabel title = new JLabel("Grade Management System");
        title.setFont(new Font("Gothic", Font.BOLD, 30));
        title.setForeground(Color.white);
        title.setBorder(new EmptyBorder(0, 30, 0, 0));
        titlePanel.add(title, BorderLayout.WEST);
        this.add(titlePanel);

        // JPanel(For Table) Setting
        JPanel tablePanel = new JPanel();
        tablePanel.setBounds(50, 70, 980, 450);
        tablePanel.setLayout(new BorderLayout());

        // For Setting Table Title
        String[] personalData = { "No.", "Name"};
        String[] subjectData = {"Language", "Math", "Society", "Science"};
        String[] resultData = {"Total", "Average"};
        String[] tableTitle = new String[personalData.length + subjectData.length + resultData.length];

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
        mainTable.getTableHeader().setFont(new Font("Gothic", Font.BOLD, 13));

        // Set Table Header Center Align (https://itjbg.wordpress.com/2012/05/28/set-center-alignment-of-jtable-header-in-java/)
        TableCellRenderer rendererFromHeader = mainTable.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);

        mainTable.setRowHeight(30);
        mainTable.getColumnModel().getColumn(0).setPreferredWidth(10);

        this.add(tablePanel);

        // JPanel(For Input) Setting
        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(new Color(180, 180, 255));
        inputPanel.setBounds(50, 520, 980, 65); // 40 205 20 175 20 135 20 150 20 155 40
        inputPanel.setLayout(null);

        JLabel nameLabel = new JLabel();
        nameLabel.setText("Name : ");
        nameLabel.setFont(new Font("Gothic", 100, 18));
        nameLabel.setBounds(40, 15, 75, 35);
        inputPanel.add(nameLabel);
        JTextField name = new JTextField();
        name.setBounds(115, 15, 130, 35);
        name.setFont(new Font("Helvetica", 0, 18));
        name.setHorizontalAlignment(JTextField.CENTER);
        inputPanel.add(name);

        JLabel languageLabel = new JLabel();
        languageLabel.setText("Language : ");
        languageLabel.setFont(new Font("Gothic", 100, 18));
        languageLabel.setBounds(265, 15, 110, 35);
        inputPanel.add(languageLabel);
        JTextField language = new JTextField();
        language.setBounds(375, 15, 65, 35);
        language.setFont(new Font("Helvetica", 0, 18));
        language.setHorizontalAlignment(JTextField.CENTER);
        inputPanel.add(language);

        JLabel mathLabel = new JLabel();
        mathLabel.setText("Math : ");
        mathLabel.setFont(new Font("Gothic", 100, 18));
        mathLabel.setBounds(460, 15, 70, 35);
        inputPanel.add(mathLabel);
        JTextField math = new JTextField();
        math.setBounds(530, 15, 65, 35);
        math.setFont(new Font("Helvetica", 0, 18));
        math.setHorizontalAlignment(JTextField.CENTER);
        inputPanel.add(math);

        JLabel societyLabel = new JLabel();
        societyLabel.setText("Society : ");
        societyLabel.setFont(new Font("Gothic", 100, 18));
        societyLabel.setBounds(615, 15, 85, 35);
        inputPanel.add(societyLabel);
        JTextField society = new JTextField();
        society.setBounds(700, 15, 65, 35);
        society.setFont(new Font("Helvetica", 0, 18));
        society.setHorizontalAlignment(JTextField.CENTER);
        inputPanel.add(society);

        JLabel scienceLabel = new JLabel();
        scienceLabel.setText("Science : ");
        scienceLabel.setFont(new Font("Gothic", 100, 18));
        scienceLabel.setBounds(785, 15, 90, 35);
        inputPanel.add(scienceLabel);
        JTextField science = new JTextField();
        science.setBounds(875, 15, 65, 35);
        science.setFont(new Font("Helvetica", 0, 18));
        science.setHorizontalAlignment(JTextField.CENTER);
        inputPanel.add(science);

        this.add(inputPanel);

        // JPanel(For Button Setting
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(180, 180, 255));
        buttonPanel.setBounds(50, 585, 980, 65);
        buttonPanel.setLayout(null);

        JButton cancel = new JButton("Cancel");
        cancel.setFont(new Font("Gothic", Font.BOLD, 16));
        cancel.setBounds(325, 15, 150, 35);
        buttonPanel.add(cancel);

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
        submit.setFont(new Font("Gothic", Font.BOLD, 16));
        submit.setBounds(505, 15, 150, 35);
        buttonPanel.add(submit);


        ActionListener btnSubmit = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                String[] array = new String[8];
                String where = "";

                DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
                dtcr.setHorizontalAlignment(SwingConstants.CENTER);
                TableColumnModel tcm = mainTable.getColumnModel();

                try {
                    int languageGet;
                    int mathGet;
                    int societyGet;
                    int scienceGet;
                    int total = 0;

                    String numberGet = String.format("%04d", num);
                    array[0] = numberGet;
                    // If user does not input their name or just input " ", Throw the exception
                    if (i == 0) {
                        String nameGet = name.getText();
                        array[1] = nameGet;
                        i++;
                    }
                    
                    if (i == 1) {
                        languageGet = Integer.parseInt(language.getText());
                        if (0 <= languageGet && languageGet <= 100) {
                            total += languageGet;
                            array[2] = Integer.toString(languageGet);
                            i++;
                        } else {
                            throw new InputMismatchException();
                        }
                    }
                    
                    if (i == 2) {
                        mathGet = Integer.parseInt(math.getText());
                        if (0 <= mathGet && mathGet <= 100) {
                            total += mathGet;
                            array[3] = Integer.toString(mathGet);
                            i++;
                        } else {
                            throw new InputMismatchException();
                        }
                    }
                    
                    if (i == 3) {
                        societyGet = Integer.parseInt(society.getText());
                        if (0 <= societyGet && societyGet <= 100) {
                            total += societyGet;
                            array[4] = Integer.toString(societyGet);
                            i++;
                        } else {
                            throw new InputMismatchException();
                        }
                    }
                    
                    if (i == 4) {
                        scienceGet = Integer.parseInt(science.getText());
                        if (0 <= scienceGet && scienceGet <= 100) {
                            total += scienceGet;
                            array[5] = Integer.toString(scienceGet);
                            i++;
                        } else {
                            throw new InputMismatchException();
                        }
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
                } catch (InputMismatchException ime) {
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
                    where += ": Please Input score between 0 and 100";
                    JOptionPane.showMessageDialog(null, where);
                    i = 0;
                }
                
                if (i == 5) {
                    tableContent.addRow(array);
                    for (int columnNum = 0; columnNum < array.length; columnNum++) {
                        tcm.getColumn(columnNum).setCellRenderer(dtcr);
                    }
                    System.out.println(Arrays.toString(array));
                    array = new String[8];
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

        this.add(buttonPanel);
        
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
// 4. Make user input only integer in inputPanel
// 5. Make data be uploaded in JTable when user input correctly -> OK!
// 6. Set Table border-bottom and Text-align Center
// 7. Make cell not editable