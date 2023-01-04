/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package filebrowser;

           
import java.io.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.event.KeyEvent;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileFilter;
import java.nio.file.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
/**
 *
 * @author dimit
 */
public class FileBrowser extends JFrame {
    String pathname= "C:\\Users"; 
    Container mainContainer= this.getContentPane();
    StringBuffer Button = new StringBuffer(pathname);
    FileList bt = new FileList();
    Component c2= null;
    JPanel gui = new JPanel(new BorderLayout());
    JPanel searchPanel= new JPanel();
    JPanel pathPanel= new JPanel();
    StringBuffer name= new StringBuffer("");
    
    public FileBrowser(){
    super();
    this.setSize(500,500);
    this.setLocation(100,100);
    this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
 
    
    mainContainer.setLayout(new BorderLayout(8,6));
    mainContainer.setBackground(Color.WHITE);
    this.getRootPane().setBorder(BorderFactory.createMatteBorder(4,4,4,4, Color.WHITE));
    
    JPanel biggerPanel = new JPanel();
    biggerPanel.setBorder(new LineBorder(Color.BLACK, 3));
    biggerPanel.setBackground(Color.BLUE);
    biggerPanel.setLayout(new GridLayout(2,0)); 
    
   // JPanel searchPanel= new JPanel();
    searchPanel.setLayout(new FlowLayout(FlowLayout.RIGHT)); 
    
    
    
    
    
    
    JButton SearchButton = new JButton("Search");
    searchPanel.add(SearchButton);
    
    /*Path path= GFG();
    Path path2= path;
    JButton pathButton= new JButton(+path);
    pathPanel.add(pathButton);
    */
    
    
    
    
    
    
    
    biggerPanel.add(searchPanel, BorderLayout.NORTH);
    mainContainer.add(biggerPanel, BorderLayout.NORTH);
    
    
    JPanel favourite= new JPanel();
    favourite.setBorder(new LineBorder(Color.BLACK, 3));
    favourite.setBackground(Color.WHITE);
    mainContainer.add(favourite, BorderLayout.WEST);
    
    
    
    JLabel label= new JLabel("Center Box", SwingConstants.CENTER);
    label.setOpaque(true);
    label.setBorder(new LineBorder(Color.BLACK, 3));
    mainContainer.add(label);
    
    
    
    ButtonListener listener = new ButtonListener();
    
    
    
    
    /*JFileChooser chooser = new JFileChooser();
    DefaultListModel model = new DefaultListModel();
    JList list = new JList(model);
    int pos = list.getModel().getSize();
    model.add(pos, chooser.getSelectedFile());

    favourite.add(list);
    JScrollPane listScroller = new JScrollPane(list);
    listScroller.setPreferredSize(new Dimension(250, 80));*/
    
  
    
    
    JMenu FileButton = new JMenu("File");
    FileButton.setMnemonic(KeyEvent.VK_C);
 
    JMenuItem exitMenuItem = new JMenuItem("Exit");
    exitMenuItem.addActionListener( listener);    
    exitMenuItem.setMnemonic(KeyEvent.VK_X);
    FileButton.add(exitMenuItem);
    
    JMenu editButton = new JMenu("Edit");
    editButton.setMnemonic(KeyEvent.VK_E);
 
    JMenuItem cutMenuItem = new JMenuItem("Cut");
    cutMenuItem.addActionListener( listener);    
    cutMenuItem.setMnemonic(KeyEvent.VK_U);
    editButton.add(cutMenuItem);
    
    JMenuItem copyMenuItem = new JMenuItem("Copy");
    copyMenuItem.addActionListener( listener);    
    copyMenuItem.setMnemonic(KeyEvent.VK_O);
    editButton.add(copyMenuItem);
    
    JMenuItem pasteMenuItem = new JMenuItem("Paste");
    pasteMenuItem.addActionListener( listener);    
    pasteMenuItem.setMnemonic(KeyEvent.VK_P);
    editButton.add(pasteMenuItem);
    
    JMenuItem renameMenuItem = new JMenuItem("Rename");
    renameMenuItem.addActionListener( listener);    
    renameMenuItem.setMnemonic(KeyEvent.VK_R);
    editButton.add(renameMenuItem);
    
    JMenuItem deleteMenuItem = new JMenuItem("Delete");
    deleteMenuItem.addActionListener( listener);    
    deleteMenuItem.setMnemonic(KeyEvent.VK_D);
    editButton.add(deleteMenuItem);
    
    JMenuItem addMenuItem = new JMenuItem("Add to Favourites");
    addMenuItem.addActionListener( listener);    
    addMenuItem.setMnemonic(KeyEvent.VK_F);
    editButton.add(addMenuItem);
    
    JMenuItem propertiesMenuItem = new JMenuItem("Properties");
    propertiesMenuItem.addActionListener( listener);    
    propertiesMenuItem.setMnemonic(KeyEvent.VK_P);
    editButton.add(propertiesMenuItem);
    
    JMenu viewButton = new JMenu("View");
    viewButton.setMnemonic(KeyEvent.VK_V);
 
    JMenuItem searchMenuItem = new JMenuItem("Search");
    searchMenuItem.addActionListener( listener);    
    searchMenuItem.setMnemonic(KeyEvent.VK_S);
    viewButton.add(searchMenuItem);
    
    JMenuItem hiddenMenuItem = new JMenuItem("Hidden Files & Folders");
    hiddenMenuItem.addActionListener( listener);    
    hiddenMenuItem.setMnemonic(KeyEvent.VK_H);
    viewButton.add(hiddenMenuItem);
    

    JMenuBar bar = new JMenuBar();
    bar.add(FileButton);
    bar.add(editButton);
    bar.add(viewButton);
    setJMenuBar(bar);  
 
    
    //searchPanel(this);
    c2= bt.run(mainContainer, pathname);
    
    gui.add(c2,BorderLayout.CENTER);
    c2.setPreferredSize(new Dimension(375,100));
    gui.setBorder(new EmptyBorder(3,3,3,3));
    mainContainer.add(gui,  BorderLayout.CENTER);
    
    
    
   // JPanel pathPanel= new JPanel();
    pathPanel.setLayout(new FlowLayout());
    biggerPanel.add(pathPanel);
    Breadcrumb();
        

    
    }
    private void Breadcrumb() {
        int counter=0;
        int start=0;
        
        pathPanel.removeAll();
        for(int i=0; i< pathname.length(); i++ ){
                if(pathname.charAt(i)!= '\\' && i!= pathname.length()-1 ){
                    counter++;
                    //System.out.print("\n[ERROR] "+pathname);
                }
                else{
                    if(i== pathname.length()-1){
                        counter++;
                    }
                    Button.delete(0, Button.length());
                    Button.append(pathname.substring(start, counter+ start));

                    JButton pathButton = new JButton(Button.substring(0)); 
                    pathPanel.add(pathButton);
                    ButtonListener2 listener2 = new ButtonListener2();
                    pathButton.addActionListener( listener2);
                    counter= 0;
                    start= i+1;
                }
        }
    }
       
    
    private void searchPanel(Container container) {
    JPanel southPanel = new JPanel();
    southPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    container.add(southPanel,  BorderLayout.NORTH);
 
    JButton cancelButton = new JButton("Cancel");    
    southPanel.add(cancelButton);
    }
    /*
    private Path GFG() {
        // create an object of Path
        Path path
            = Paths.get("drive\\temp\\Spring");
  
        // create a string object
        String passedPath = "drive";
  
        // call resolve() to create resolved Path
        Path resolvedPath
            = path.resolve(passedPath);
  
        return (resolvedPath);
    }
    */
    
  public class ButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      System.out.println(e);
      System.exit(1);
    }
  }
  
  
  public class ButtonListener2 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        int counter=0;
        int start=0;
        int j=0;
        
        String menuString = e.getActionCommand();
        for(int i=0; i< pathname.length(); i++ ){
            if(pathname.charAt(i)!= '\\' && i!= pathname.length()-1 ){
                counter++;
                if(pathname.substring(start, start+counter).equals(menuString)){
                    j= start+counter;
                }
                
            }
            else{
                counter=0;
                start= i+1;
                if(i== pathname.length()-1){
                    //counter++;
                }
            }
        }
        if(j==0){
            j=pathname.length();
        }
        gui.remove(c2);
        c2= bt.run(mainContainer, pathname.substring(0, j));
        gui.add(c2,BorderLayout.CENTER);
        pathname= pathname.substring(0, j);
        Breadcrumb();
    }
  }

 
  public static void main(String[] args) {
    FileBrowser w = new FileBrowser();
    w.setVisible(true);
  }
class FileList {

    public Component getGui(File[] all, boolean vertical, String pathname) {
        // put File objects in the list..
        File files[] = new File(pathname).listFiles();
        int i=0;
        int stop =1;
        for(File f : files) {
            if(f.isFile()){
                while(files[i].isFile() && stop==1){
                    stop=0;
                    File test= files[i];
                    for(int j=i; j< files.length-1; j++){
                        files[j]= files[j+1];
                    }
                    files[files.length- 1]= test;
                    
                    if(f.isFile()){
                        for(int j=i; j< files.length-1; j++){
                            if(!files[j].isFile()){
                                stop =1;
                            }
                        }
                    }
                }
            }
            i++;
        }
        
        JList fileList = new JList(files);
        
        MouseListener3 listener3 = new MouseListener3();
        fileList.addMouseListener( listener3);
        
        // ..then use a renderer
        
        fileList.setCellRenderer(new FileRenderer(!vertical));
         
        if (!vertical) {
            fileList.setLayoutOrientation(javax.swing.JList.HORIZONTAL_WRAP);
            fileList.setVisibleRowCount(-1);
        } else {
            fileList.setVisibleRowCount(9);
        }
        return new JScrollPane(fileList);
    }
    
    
    public Component run(Container container, String pathname) {
        File f = new File(System.getProperty("user.home"));
        FileList fl = new FileList();
        //f = new File(System.getProperty("user.home"));
        if(pathname== "0"){
            pathname= "C:\\Users"; 
        }
        
        Component c2 = fl.getGui(f.listFiles(new TextFileFilter()),false, pathname);
        
        return(c2);
    }
}

class TextFileFilter implements FileFilter {

    @Override
    public boolean accept(File file) {
        // implement the logic to select files here..
        String name = file.getName().toLowerCase();
        //return name.endsWith(".java") || name.endsWith(".class");
        return name.length()<20;
    }
}


class FileRenderer extends DefaultListCellRenderer {

    private boolean pad;
    private Border padBorder = new EmptyBorder(3,3,3,3);

    FileRenderer(boolean pad) {
        this.pad = pad;
    }

    @Override
    public Component getListCellRendererComponent (
        JList list,
        Object value,
        int index,
        boolean isSelected,
        boolean cellHasFocus) {
        
        StringBuffer extension = new StringBuffer("");
        
        Component c = super.getListCellRendererComponent(list,value,index,isSelected,cellHasFocus);
        
        File f = (File)value;
        setText(f.getName());
        setToolTipText(f.getName());
        
        ImageIcon audio = new ImageIcon("C:\\icons\\audio.png");
        ImageIcon bmp = new ImageIcon("C:\\icons\\bmp.png");
        ImageIcon doc = new ImageIcon("C:\\icons\\doc.png");
        ImageIcon folder = new ImageIcon("C:\\icons\\folder.png");
        ImageIcon zip = new ImageIcon("C:\\icons\\zip.png");
        ImageIcon html = new ImageIcon("C:\\icons\\html.png");
        ImageIcon ods = new ImageIcon("C:\\icons\\ods.png");
        ImageIcon pdf = new ImageIcon("C:\\icons\\pdf.png");
        ImageIcon txt = new ImageIcon("C:\\icons\\txt.png");
        ImageIcon question = new ImageIcon("C:\\icons\\question.png");
        ImageIcon video = new ImageIcon("C:\\icons\\video.png");
        
        int i = f.getAbsolutePath().lastIndexOf('.');
        //Mouse m = new Mouse();
        if (i > 0) {
            extension.append(f.getAbsolutePath().substring(i+1));
        }
        String x = extension.substring(0, extension.length());
        if("audio".equals(x) || "mp3".equals(x) || "ogg".equals(x) || "wav".equals(x)){
            setIcon(audio);
        }
        else if("bmp".equals(x) || "giff".equals(x) || "image".equals(x) || "jpeg".equals(x) || "jpg".equals(x) || "png".equals(x)){
            setIcon(bmp);
        }
        else if("doc".equals(x) || "docx".equals(x) ||"odt".equals(x)){
            setIcon(doc);
        }
        else if("gz".equals(x) || "tar".equals(x) || "tgz".equals(x) || "zip".equals(x)){
            setIcon(zip);
        }
        else if("folder".equals(x) || f.isDirectory()){
            
            setIcon(folder);
            name.delete(0, name.length());
            name.append(f.getAbsolutePath());
            
        }
        else if("htm".equals(x) || "html".equals(x) || "xml".equals(x)){
            setIcon(html);
        }
        else if("ods".equals(x) || "xlx".equals(x) || "xlsx".equals(x)){
            setIcon(ods);
        }
        else if("pdf".equals(x)){
            setIcon(pdf);
        }
        else if("txt".equals(x)){
            setIcon(txt);
        }
        else if("video".equals(x)){
            setIcon(video);
        }
        else{
            //System.out.print("\n[ERROR] ");
            setIcon(question);
        }
        //l.setIcon(FileSystemView.getFileSystemView().getSystemIcon(f));
        if (pad) {
            setBorder(padBorder);
        }

        return this;
    }
}



 class MouseListener3 extends MouseAdapter {
     @Override
    public void mouseClicked(MouseEvent e){
        System.out.print("\n[ERROR] ");
        if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {
            System.out.print("\n[ERROR] ");
            gui.remove(c2);
            c2= bt.run(mainContainer, name.substring(0, name.length()));
            gui.add(c2,BorderLayout.CENTER);
            pathname= name.substring(0, name.length());
            Breadcrumb();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
      // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 }
}