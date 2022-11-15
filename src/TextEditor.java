import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class TextEditor implements ActionListener {

    JFrame myFrame;

    JMenuBar menuBar;
    JMenu file,edit;
    JMenuItem newFile,openFile,saveFile;
    JMenuItem cut,copy,selectAll,paste,close;
    JTextArea textArea;

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
        openFile = new JMenuItem("Open");
        saveFile = new JMenuItem("Save");

        newFile.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);

        file.add(newFile);
        file.add(openFile);
        file.add(saveFile);



        //initialize edit option;

        cut = new JMenuItem("Cut");
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");
        selectAll = new JMenuItem("Select All");
        close = new JMenuItem("Close");

        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);
        close.addActionListener(this);

        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        edit.add(close);



        //initialize textArea;
        textArea = new JTextArea();


        // add panel and scrollbar

        JScrollPane scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(5,5,5,5));
        panel.setLayout(new BorderLayout(0,0));
        panel.add(scrollPane);


        myFrame.add(panel);
        myFrame.setJMenuBar(menuBar);
        myFrame.setBounds(100,100,400,400);
        myFrame.setVisible(true);
        myFrame.setTitle("Text Editor");
    }

    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == newFile){
            TextEditor  newTextEditor = new TextEditor();
        }

        if(e.getSource() == openFile){
            JFileChooser fileChooser = new JFileChooser("C:");
            int chooseOption = fileChooser.showOpenDialog(null);

            if(chooseOption == JFileChooser.APPROVE_OPTION){
                File file = fileChooser.getSelectedFile();
                String filePath = file.getPath();
                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
                    String intermidiate = "",output = "";
                    while((intermidiate = bufferedReader.readLine())!= null){
                        output += intermidiate + "\n";
                    }

                    textArea.setText(output);
                    myFrame.setTitle(filePath);

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

                try {
                    BufferedWriter outfile = null;
                    outfile = new BufferedWriter(new FileWriter(file));
                    textArea.write(outfile);
                    outfile.close();

                }catch (Exception exception){
                    System.out.println(exception);
                }
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