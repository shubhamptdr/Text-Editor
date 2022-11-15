import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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



        myFrame.add(textArea);
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

        }
        if(e.getSource() == openFile){

        }
        if(e.getSource() == saveFile){

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