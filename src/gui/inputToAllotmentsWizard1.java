package gui;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class inputToAllotmentsWizard1 extends JFrame {
    public JPanel jPanelWizard1;
    public JLabel defaultDirectoryTexFieldLabelWizard1;
    public JTextField defaultDirectoryTextFieldWizard1;
    public JButton defaultDirectoryBrowseButtonWizard1;
    public JLabel titleFieldWizard1;
    public JLabel jLabelToSelectOptionsWizard1;
    public JRadioButton useDefaultSetOfRadioButtonWizard1;
    public JButton defaultDirCheckButtonWizard1;
    public JRadioButton selectAllRequiredFilesRadioButton;
    public JButton nextButtonWizard1;
    private JLabel jLabelToAnalyseTheAllotmentsWizard1;
    private JLabel analyseDirectoryLabelWizard1;
    private JTextField analyseDirectoryTextFieldWizard1;
    private JButton analyseDirectoryCheckButtonWizard1;
    private JButton analyseDirectoryBrowseButtonWizard1;
    private JTextField ORTextField;

    String selectedDefaultDirectory, selectedOutputDirectory;
    JButton checkButton;
    formValues fV = formValues.getInstance();

    public void enableFileDirectoryExistenceCheckButton(JButton currentCheckButton, File file1) {
        if (file1.exists()) {
            checkButton = currentCheckButton;
            checkButton.setVisible(true);
            try {
                Image img = ImageIO.read(getClass().getResource("greenYes.png"));
                checkButton.setIcon(new ImageIcon(img));
                nextButtonWizard1.setEnabled(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            checkButton.setVisible(true);
            try {
                Image img = ImageIO.read(getClass().getResource("redCross.png"));
                checkButton.setIcon(new ImageIcon(img));
                nextButtonWizard1.setEnabled(false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        inputToAllotmentsWizard1 jPanelWizard1 = new inputToAllotmentsWizard1();
    }

    public inputToAllotmentsWizard1() {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        super();
        $$$setupUI$$$();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 4 - this.getSize().width / 2, dim.height / 4 - this.getSize().height / 2);
        setSize(1150, 700);

        JScrollPane scrPaneWizard1 = new JScrollPane(jPanelWizard1);
        add(scrPaneWizard1);

        jPanelWizard1.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
            }
        });

        defaultDirectoryBrowseButtonWizard1.setEnabled(true);
        defaultDirectoryTextFieldWizard1.setEnabled(true);
        defaultDirCheckButtonWizard1.setVisible(false);
        analyseDirectoryBrowseButtonWizard1.setEnabled(true);
        analyseDirectoryTextFieldWizard1.setEnabled(true);
        analyseDirectoryCheckButtonWizard1.setVisible(false);
        nextButtonWizard1.setEnabled(false);

        // Row 2: Selecting directory with default set of files
        defaultDirectoryBrowseButtonWizard1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                defaultDirectoryBrowseButtonWizard1.setEnabled(true);
                nextButtonWizard1.setEnabled(true);
                JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int defaultFilesDir = jfc.showOpenDialog(null);
                if (defaultFilesDir == JFileChooser.APPROVE_OPTION) {
                    File defaultFilesDirName = jfc.getSelectedFile();
                    defaultDirectoryTextFieldWizard1.setText(defaultFilesDirName.getAbsolutePath());
                    selectedDefaultDirectory = defaultDirectoryTextFieldWizard1.getText();
                    File directoryName = new File(selectedDefaultDirectory);
                    enableFileDirectoryExistenceCheckButton(defaultDirCheckButtonWizard1, directoryName);
                }
                nextButtonWizard1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //defaultSetOfFilesWizard2 wizard2 = new defaultSetOfFilesWizard2 (inputToAllotmentsWizard1.this);
                        formValues.setDefaultDirPath(defaultDirectoryTextFieldWizard1.getText());
                        defaultSetOfFilesWizard2 wizard2 = new defaultSetOfFilesWizard2();
                        wizard2.setVisible(true);
                        dispose();
                    }
                });
            }
        });

        nextButtonWizard1.setEnabled(true);
        // Row 3: Selecting directory with allotment output files
        analyseDirectoryBrowseButtonWizard1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                analyseDirectoryBrowseButtonWizard1.setEnabled(true);
                nextButtonWizard1.setEnabled(true);
                JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int outputFilesDir = jfc.showOpenDialog(null);
                if (outputFilesDir == JFileChooser.APPROVE_OPTION) {
                    File outputFilesDirName = jfc.getSelectedFile();
                    analyseDirectoryTextFieldWizard1.setText(outputFilesDirName.getAbsolutePath());
                    selectedOutputDirectory = analyseDirectoryTextFieldWizard1.getText();
                    formValues.setAnalyseAllotmentDirPath(selectedOutputDirectory);
                    File directoryName = new File(selectedOutputDirectory);
                    enableFileDirectoryExistenceCheckButton(analyseDirectoryCheckButtonWizard1, directoryName);
                }
                nextButtonWizard1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        formValues.setAnalyseAllotmentDirPath(analyseDirectoryTextFieldWizard1.getText());
                        analyzeAllotmentsWizard4 wizard4 = new analyzeAllotmentsWizard4();
                        wizard4.setVisible(true);
                        dispose();
                    }
                });
            }
        });

        getContentPane().add(jPanelWizard1);
        setVisible(true);
        setTitle("IITM-SEAT");

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        jPanelWizard1 = new JPanel();
        jPanelWizard1.setLayout(new FormLayout("fill:318px:grow,left:48dlu:noGrow,left:8dlu:noGrow,fill:39px:noGrow,fill:233px:grow,left:4dlu:noGrow,fill:69px:noGrow,left:4dlu:noGrow,fill:max(d;4px):noGrow,fill:49px:noGrow", "center:113px:noGrow,top:15dlu:noGrow,top:28dlu:noGrow,center:22px:noGrow,center:45px:grow,top:18dlu:noGrow,top:11dlu:noGrow,center:31px:noGrow,center:78px:noGrow,top:4dlu:noGrow,center:47px:noGrow,top:4dlu:noGrow,top:14dlu:noGrow,top:16dlu:noGrow,center:75px:noGrow"));
        jPanelWizard1.setBackground(new Color(-14793908));
        jPanelWizard1.setDoubleBuffered(false);
        jPanelWizard1.setForeground(new Color(-131585));
        defaultDirectoryTexFieldLabelWizard1 = new JLabel();
        Font defaultDirectoryTexFieldLabelWizard1Font = this.$$$getFont$$$("Century Schoolbook L", -1, 20, defaultDirectoryTexFieldLabelWizard1.getFont());
        if (defaultDirectoryTexFieldLabelWizard1Font != null)
            defaultDirectoryTexFieldLabelWizard1.setFont(defaultDirectoryTexFieldLabelWizard1Font);
        defaultDirectoryTexFieldLabelWizard1.setForeground(new Color(-131585));
        defaultDirectoryTexFieldLabelWizard1.setText("<html><center>Select directory with default <br>set of files : <center><html>");
        CellConstraints cc = new CellConstraints();
        jPanelWizard1.add(defaultDirectoryTexFieldLabelWizard1, cc.xyw(1, 5, 2, CellConstraints.RIGHT, CellConstraints.DEFAULT));
        defaultDirectoryTextFieldWizard1 = new JTextField();
        defaultDirectoryTextFieldWizard1.setEditable(false);
        defaultDirectoryTextFieldWizard1.setEnabled(false);
        Font defaultDirectoryTextFieldWizard1Font = this.$$$getFont$$$("Century Schoolbook L", -1, 20, defaultDirectoryTextFieldWizard1.getFont());
        if (defaultDirectoryTextFieldWizard1Font != null)
            defaultDirectoryTextFieldWizard1.setFont(defaultDirectoryTextFieldWizard1Font);
        defaultDirectoryTextFieldWizard1.setText("");
        jPanelWizard1.add(defaultDirectoryTextFieldWizard1, cc.xy(5, 5, CellConstraints.FILL, CellConstraints.CENTER));
        defaultDirectoryBrowseButtonWizard1 = new JButton();
        defaultDirectoryBrowseButtonWizard1.setBorderPainted(false);
        defaultDirectoryBrowseButtonWizard1.setDefaultCapable(false);
        defaultDirectoryBrowseButtonWizard1.setEnabled(false);
        Font defaultDirectoryBrowseButtonWizard1Font = this.$$$getFont$$$("Century Schoolbook L", -1, 16, defaultDirectoryBrowseButtonWizard1.getFont());
        if (defaultDirectoryBrowseButtonWizard1Font != null)
            defaultDirectoryBrowseButtonWizard1.setFont(defaultDirectoryBrowseButtonWizard1Font);
        defaultDirectoryBrowseButtonWizard1.setIcon(new ImageIcon(getClass().getResource("/gui/dir1-small.png")));
        defaultDirectoryBrowseButtonWizard1.setText("Browse");
        jPanelWizard1.add(defaultDirectoryBrowseButtonWizard1, cc.xy(9, 5, CellConstraints.LEFT, CellConstraints.DEFAULT));
        titleFieldWizard1 = new JLabel();
        Font titleFieldWizard1Font = this.$$$getFont$$$("Lobster Two", Font.BOLD, 64, titleFieldWizard1.getFont());
        if (titleFieldWizard1Font != null) titleFieldWizard1.setFont(titleFieldWizard1Font);
        titleFieldWizard1.setForeground(new Color(-301758));
        titleFieldWizard1.setText("Welcome to SEAT");
        jPanelWizard1.add(titleFieldWizard1, cc.xyw(1, 1, 10, CellConstraints.CENTER, CellConstraints.DEFAULT));
        jLabelToSelectOptionsWizard1 = new JLabel();
        Font jLabelToSelectOptionsWizard1Font = this.$$$getFont$$$("Gentium Book Basic", -1, 32, jLabelToSelectOptionsWizard1.getFont());
        if (jLabelToSelectOptionsWizard1Font != null)
            jLabelToSelectOptionsWizard1.setFont(jLabelToSelectOptionsWizard1Font);
        jLabelToSelectOptionsWizard1.setForeground(new Color(-1774964));
        jLabelToSelectOptionsWizard1.setText("To generate student elective allotments....");
        jPanelWizard1.add(jLabelToSelectOptionsWizard1, cc.xyw(1, 3, 10, CellConstraints.CENTER, CellConstraints.FILL));
        defaultDirCheckButtonWizard1 = new JButton();
        defaultDirCheckButtonWizard1.setBorderPainted(false);
        defaultDirCheckButtonWizard1.setContentAreaFilled(false);
        defaultDirCheckButtonWizard1.setText("");
        jPanelWizard1.add(defaultDirCheckButtonWizard1, cc.xy(7, 5, CellConstraints.CENTER, CellConstraints.DEFAULT));
        jLabelToAnalyseTheAllotmentsWizard1 = new JLabel();
        Font jLabelToAnalyseTheAllotmentsWizard1Font = this.$$$getFont$$$("Gentium Book Basic", -1, 32, jLabelToAnalyseTheAllotmentsWizard1.getFont());
        if (jLabelToAnalyseTheAllotmentsWizard1Font != null)
            jLabelToAnalyseTheAllotmentsWizard1.setFont(jLabelToAnalyseTheAllotmentsWizard1Font);
        jLabelToAnalyseTheAllotmentsWizard1.setForeground(new Color(-1774964));
        jLabelToAnalyseTheAllotmentsWizard1.setText("To analyse already generated allotments ....");
        jPanelWizard1.add(jLabelToAnalyseTheAllotmentsWizard1, cc.xyw(1, 9, 10, CellConstraints.CENTER, CellConstraints.FILL));
        analyseDirectoryLabelWizard1 = new JLabel();
        Font analyseDirectoryLabelWizard1Font = this.$$$getFont$$$("Century Schoolbook L", -1, 20, analyseDirectoryLabelWizard1.getFont());
        if (analyseDirectoryLabelWizard1Font != null)
            analyseDirectoryLabelWizard1.setFont(analyseDirectoryLabelWizard1Font);
        analyseDirectoryLabelWizard1.setForeground(new Color(-131585));
        analyseDirectoryLabelWizard1.setText("<html><center>Select directory with generated <br>allotment files : <center><html>");
        jPanelWizard1.add(analyseDirectoryLabelWizard1, cc.xyw(1, 11, 2, CellConstraints.RIGHT, CellConstraints.DEFAULT));
        analyseDirectoryTextFieldWizard1 = new JTextField();
        analyseDirectoryTextFieldWizard1.setEditable(false);
        analyseDirectoryTextFieldWizard1.setEnabled(false);
        Font analyseDirectoryTextFieldWizard1Font = this.$$$getFont$$$("Century Schoolbook L", -1, 20, analyseDirectoryTextFieldWizard1.getFont());
        if (analyseDirectoryTextFieldWizard1Font != null)
            analyseDirectoryTextFieldWizard1.setFont(analyseDirectoryTextFieldWizard1Font);
        analyseDirectoryTextFieldWizard1.setText("");
        jPanelWizard1.add(analyseDirectoryTextFieldWizard1, cc.xy(5, 11, CellConstraints.FILL, CellConstraints.CENTER));
        analyseDirectoryCheckButtonWizard1 = new JButton();
        analyseDirectoryCheckButtonWizard1.setBorderPainted(false);
        analyseDirectoryCheckButtonWizard1.setContentAreaFilled(false);
        analyseDirectoryCheckButtonWizard1.setText("");
        jPanelWizard1.add(analyseDirectoryCheckButtonWizard1, cc.xy(7, 11, CellConstraints.CENTER, CellConstraints.DEFAULT));
        analyseDirectoryBrowseButtonWizard1 = new JButton();
        analyseDirectoryBrowseButtonWizard1.setBorderPainted(false);
        analyseDirectoryBrowseButtonWizard1.setContentAreaFilled(true);
        analyseDirectoryBrowseButtonWizard1.setEnabled(false);
        Font analyseDirectoryBrowseButtonWizard1Font = this.$$$getFont$$$("Century Schoolbook L", -1, 16, analyseDirectoryBrowseButtonWizard1.getFont());
        if (analyseDirectoryBrowseButtonWizard1Font != null)
            analyseDirectoryBrowseButtonWizard1.setFont(analyseDirectoryBrowseButtonWizard1Font);
        analyseDirectoryBrowseButtonWizard1.setIcon(new ImageIcon(getClass().getResource("/gui/dir1-small.png")));
        analyseDirectoryBrowseButtonWizard1.setText("Browse");
        jPanelWizard1.add(analyseDirectoryBrowseButtonWizard1, cc.xy(9, 11, CellConstraints.CENTER, CellConstraints.DEFAULT));
        final JSeparator separator1 = new JSeparator();
        jPanelWizard1.add(separator1, cc.xyw(1, 7, 2, CellConstraints.FILL, CellConstraints.CENTER));
        ORTextField = new JTextField();
        ORTextField.setBackground(new Color(-14793908));
        Font ORTextFieldFont = this.$$$getFont$$$("Lobster Two", Font.BOLD, 36, ORTextField.getFont());
        if (ORTextFieldFont != null) ORTextField.setFont(ORTextFieldFont);
        ORTextField.setForeground(new Color(-367294));
        ORTextField.setText("OR");
        jPanelWizard1.add(ORTextField, cc.xywh(3, 6, 2, 3, CellConstraints.FILL, CellConstraints.CENTER));
        final JSeparator separator2 = new JSeparator();
        jPanelWizard1.add(separator2, cc.xyw(5, 7, 6, CellConstraints.FILL, CellConstraints.CENTER));
        nextButtonWizard1 = new JButton();
        nextButtonWizard1.setActionCommand("Proceed >>");
        nextButtonWizard1.setAutoscrolls(false);
        nextButtonWizard1.setBorderPainted(false);
        nextButtonWizard1.setContentAreaFilled(true);
        nextButtonWizard1.setDefaultCapable(true);
        nextButtonWizard1.setFocusCycleRoot(false);
        nextButtonWizard1.setFocusPainted(true);
        nextButtonWizard1.setFocusTraversalPolicyProvider(false);
        nextButtonWizard1.setFocusable(true);
        Font nextButtonWizard1Font = this.$$$getFont$$$("Century Schoolbook L", -1, 16, nextButtonWizard1.getFont());
        if (nextButtonWizard1Font != null) nextButtonWizard1.setFont(nextButtonWizard1Font);
        nextButtonWizard1.setHorizontalTextPosition(0);
        nextButtonWizard1.setLabel("Proceed >>");
        nextButtonWizard1.setRequestFocusEnabled(true);
        nextButtonWizard1.setRolloverEnabled(true);
        nextButtonWizard1.setText("Proceed >>");
        nextButtonWizard1.setVerifyInputWhenFocusTarget(true);
        nextButtonWizard1.putClientProperty("html.disable", Boolean.FALSE);
        jPanelWizard1.add(nextButtonWizard1, cc.xy(5, 14, CellConstraints.CENTER, CellConstraints.DEFAULT));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return jPanelWizard1;
    }

    /**
     * @noinspection ALL
     */
}
