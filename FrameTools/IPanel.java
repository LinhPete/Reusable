/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FrameTools;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import javax.swing.JPanel;

/**
 *
 * @author ndhlt
 */
public class IPanel extends JPanel {

    private Color normal;
    private Color hover;
    private Color clicked;
    private boolean isToggle;
    private boolean isClicked = false;
    private IPanelGroup group = null;

    public IPanel(Color normal, Color hover, Color clicked, boolean isToggle) {
        this.setBackground(normal);
        this.normal = normal;
        this.hover = hover;
        this.clicked = clicked;
        this.isToggle = isToggle;
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (!isClicked) {
                    IPanel.this.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    IPanel.this.setBackground(hover);
                }
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (!isClicked) {
                    IPanel.this.setBackground(normal);
                }
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (isToggle && !isClicked) {
                    IPanel.this.setBackground(clicked);
                    isClicked = true;
                    if(group!=null){
                        group.add(IPanel.this);
                    }
                }
            }
            
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                if (!isToggle) {
                    IPanel.this.setBackground(clicked);
                }
            }
            
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                if (!isToggle) {
                    IPanel.this.setBackground(hover);
                }
            }
        });
    }

    public boolean isToggle() {
        return isToggle;
    }

    public void setToggle(boolean isToggle) {
        this.isToggle = isToggle;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked(boolean isClicked) {
        this.isClicked = isClicked;
    }

    public IPanelGroup getGroup() {
        return group;
    }

    public void setGroup(IPanelGroup group) {
        this.group = group;
    }

    public Color getNormal() {
        return normal;
    }

    public Color getHover() {
        return hover;
    }

    public Color getClicked() {
        return clicked;
    }
    
    
    public static void parseIPanel(JPanel panel, Color normal, Color hover, Color clicked, boolean isToggle) {
        IPanel ipanel = new IPanel(normal, hover, clicked, isToggle);
        ipanel.setBounds(panel.getBounds());
        panel.getParent().add(ipanel);
        panel.getParent().remove(panel);
    }
    
    public static IPanel parseIPanel(JPanel panel, Color hover, Color clicked, boolean isToggle) {
        IPanel ipanel = new IPanel(panel.getBackground(), hover, clicked, isToggle);
        ipanel.setBounds(panel.getBounds());
        panel.getParent().add(ipanel);
        panel.getParent().remove(panel);
        return ipanel;
    }
    
}
