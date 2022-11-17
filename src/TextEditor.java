import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class TextEditor implements ActionListener {

    // Frame
    JFrame myFrame;

    JMenuBar menuBar;
    JMenu file,edit;
    JMenuItem newFile,newWindowFile,openFile,saveFile,printFile,close;
    JMenuItem cut,copy,selectAll,paste;
    JTextArea textArea;

    // Constructor
    TextEditor(){
        //initialize frame;
        myFrame = new JFrame();

        //initialize menuBar;
        menuBar = new JMenuBar();

        file = new JMenu("File");
        edit = new JMenu("Edit");

        menuBar.add(file);
        menuBar.add(edit);



        //initialize file option;

        newFile = new JMenuItem("New");
        newWindowFile = new JMenuItem("New window");
        openFile = new JMenuItem("Open");
        saveFile = new JMenuItem("Save");
        printFile = new JMenuItem("Print");
        close = new JMenuItem("Exit");


        newFile.addActionListener(this);
        newWindowFile.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);
        printFile.addActionListener(this);
        close.addActionListener(this);

        file.add(newFile);
        file.add(newWindowFile);
        file.add(openFile);
        file.add(saveFile);
        file.add(printFile);
        file.add(close);

        //initialize edit option;

        cut = new JMenuItem("Cut");
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");
        selectAll = new JMenuItem("Select All");


        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);


        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);




        //initialize textArea;
        textArea = new JTextArea();


        // add panel and scrollbar

        JScrollPane scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(2,2,2,2));
        panel.setLayout(new BorderLayout(0,0));
        panel.add(scrollPane);

        //Icon
        Image img = Toolkit.getDefaultToolkit().getImage("resource\\Notepad.png");
        myFrame.setIconImage(img);


        myFrame.add(panel);
        myFrame.setJMenuBar(menuBar);
        myFrame.setBounds(90,60,900,600);
        myFrame.setVisible(true);
        myFrame.setTitle("Untitle - Text Editor");
    }

    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == newFile){
            textArea.setText("");
        }

        if(e.getSource() == newWindowFile){
            TextEditor  newWindow = new TextEditor();
        }

        if(e.getSource() == openFile){
            JFileChooser fileChooser = new JFileChooser("C:");
            int chooseOption = fileChooser.showOpenDialog(null);

            if(chooseOption == JFileChooser.APPROVE_OPTION){
                File file = fileChooser.getSelectedFile();
                String filePath = file.getPath();
                String fileNameToShow = file.getName();
                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
                    String intermidiate = "",output = "";
                    while((intermidiate = bufferedReader.readLine())!= null){
                        output += intermidiate + "\n";
                    }


                    textArea.setText(output);
                    myFrame.setTitle(fileNameToShow);

                }catch (Exception exception){
                    System.out.println(exception);
                }
            }

        }

        if(e.getSource() == saveFile){
            JFileChooser fileChooser = new JFileChooser("C:");
            fileChooser.setApproveButtonText("Save");
            int chooseOption = fileChooser.showSaveDialog(null);

            if(chooseOption == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsoluteFile()+".txt");
                String fileNameToShow = file.getName();
                try {
                    BufferedWriter outfile = null;
                    outfile = new BufferedWriter(new FileWriter(file));
                    textArea.write(outfile);
                    myFrame.setTitle(fileNameToShow);
                    outfile.close();

                }catch (Exception exception){
                    System.out.println(exception);
                }
            }
        }

        if(e.getSource() == printFile){
            try {
                // print the file
                textArea.print();
            }
            catch (Exception evt) {
                JOptionPane.showMessageDialog(myFrame, evt.getMessage());
            }
        }

        //edit menu
        if(e.getSource() == cut){
            textArea.cut();
        }

        if(e.getSource() == copy){
            textArea.copy();
        }

        if(e.getSource() == paste){
            textArea.paste();
        }

        if(e.getSource() == selectAll){
            textArea.selectAll();
        }

        if(e.getSource() == close){
            System.exit(0);
        }
    }
}