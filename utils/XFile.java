/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.JFileChooser;

/**
 *
 * @author ndhlt
 */
public class XFile {

    public static void menu(String... a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println((i + 1) + ". " + a[i]);
        }
        System.out.println((a.length + 1) + ". Thoat chuong trinh");
        System.out.println("===================================");
        System.out.print("Moi chon chuc nang: ");
    }

    public static <Thing> void writeObject(Thing o, String filePath) throws FileNotFoundException, IOException {
        FileOutputStream fileOut;
        fileOut = new FileOutputStream(filePath);
        try (ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(o);
        }
        fileOut.close();
    }

    public static <Thing> Thing readObject(String filePath) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fileIn;
        Thing thing;
        fileIn = new FileInputStream(filePath);
        try (ObjectInputStream in = new ObjectInputStream(fileIn)) {
            thing = (Thing) in.readObject();
        }
        fileIn.close();
        return thing;
    }

    public static <Thing> void saveFile(Thing o) throws IOException {
        JFileChooser save = new JFileChooser();
        save.setCurrentDirectory(new File("."));
        int rep = save.showSaveDialog(null);
        if (rep == JFileChooser.APPROVE_OPTION) {
            writeObject(o, save.getSelectedFile().getAbsolutePath());
        }
    }

    public static <Thing> Thing openFile() throws IOException, FileNotFoundException, ClassNotFoundException {
        Thing o = null;
        JFileChooser open = new JFileChooser();

        open.setCurrentDirectory(new File("."));
        int rep = open.showOpenDialog(null);
        if (rep == JFileChooser.APPROVE_OPTION) {
            o = readObject(open.getSelectedFile().getAbsolutePath());
        }
        return o;
    }
    
    public static String getFilePath() throws IOException, FileNotFoundException, ClassNotFoundException {
        JFileChooser open = new JFileChooser();
        open.setCurrentDirectory(new File("."));
        int rep = open.showOpenDialog(null);
        if (rep == JFileChooser.APPROVE_OPTION) {
            return open.getSelectedFile().getAbsolutePath();
        }
        return "";
    }

    public static void copyPaste(File src, String destination) {
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(destination);
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
