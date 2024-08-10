/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FrameTools;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author ndhlt
 */
public class MsgBox {
    public static void alert(Component parent, String message){
        JOptionPane.showMessageDialog(parent, message, "Warning !!!", JOptionPane.WARNING_MESSAGE);
    }
    public static void inform(Component parent, String message){
        JOptionPane.showMessageDialog(parent, message, "Message !!", JOptionPane.INFORMATION_MESSAGE);
    }
    public static boolean confirm(Component parent, String message){
        int result = JOptionPane.showConfirmDialog(parent, message, "Please confirm !!", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        return result == JOptionPane.YES_OPTION;
    }
    public static String prompt(Component parent, String message){
        return JOptionPane.showInputDialog(parent, message, "Please fill in the blank !!", JOptionPane.INFORMATION_MESSAGE);
    }
    public static int choose(Component parent, String message, String...choices){
        return JOptionPane.showOptionDialog(parent, message, "Please make your choice", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, choices, 0);
    }
}
