/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FrameTools;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;

/**
 *
 * @author ndhlt
 */
public class XInteractive {
    
    private Color normal;
    private boolean toggle;
    private boolean isClicked = false;
    private XIGroup group = null;

    public Color getNormal() {
        return normal;
    }

    public void setNormal(Color normal) {
        this.normal = normal;
    }

    public boolean isToggle() {
        return toggle;
    }

    public void setToggle(boolean toggle) {
        this.toggle = toggle;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked(boolean Clicked) {
        this.isClicked = Clicked;
    }

    public XIGroup getGroup() {
        return group;
    }

    public void setGroup(XIGroup group) {
        this.group = group;
    }

    public Component getCom() {
        return com;
    }

    public void setCom(Component com) {
        this.com = com;
    }
    private Component com;

    public XInteractive(Component com, Color hover, Color clicked, boolean isToggle, XIGroup group) {
        this.toggle = isToggle;
        this.normal = com.getBackground();
        com.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (!isClicked) {
                    com.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    com.setBackground(hover);
                }
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (!isClicked) {
                    com.setBackground(normal);
                }
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (isToggle && !isClicked) {
                    com.setBackground(clicked);
                    isClicked = true;
                    if(group!=null){
                        group.add(XInteractive.this);
                    }
                }
            }
            
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                if (!isToggle) {
                    com.setBackground(clicked);
                }
            }
            
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                if (!isToggle) {
                    com.setBackground(hover);
                }
            }
        });
        this.com = com;
    }
    
    public static XInteractive setInteract(Component com, Color hover, Color clicked, boolean isToggle, XIGroup group){
        return new XInteractive(com, hover, clicked, isToggle, group);
    }
}
