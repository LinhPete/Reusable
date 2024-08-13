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
public final class XInteractive {

    private Color normal;
    private Color hover;
    private Color clicked;
    private Boolean isToggle;
    private boolean isClicked = false;
    private XIGroup group = null;
    private Component com;

    public XInteractive() {
    }

    public XInteractive(Component com) {
        this.com = com;
    }

    public XInteractive(Component com, Color hover, Color clicked, boolean isToggle, XIGroup group) throws Exception {
        this.isToggle = isToggle;
        this.normal = com.getBackground();
        this.hover = hover;
        this.clicked = clicked;
        this.com = com;
        this.group = group;
        this.setInteractive();
    }

    public Color getNormal() {
        return normal;
    }

    public void setNormal(Color normal) {
        this.normal = normal;
    }

    public Color getHover() {
        return hover;
    }

    public void setHover(Color hover) {
        this.hover = hover;
    }

    public Color getClicked() {
        return clicked;
    }

    public void setClicked(Color clicked) {
        this.clicked = clicked;
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
        this.normal = com.getBackground();
    }

    public void setInteractive() throws Exception {
        if (this.com == null) {
            throw new Exception("No component set");
        }
        if (this.hover == null) {
            throw new Exception("No hover color set");
        }
        if (this.clicked == null) {
            throw new Exception("No clicked color set");
        }
        if (this.isToggle == null) {
            throw new Exception("Must be declared as toggle or click only");
        }
        this.com.addMouseListener(new MouseAdapter() {
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
                if (isToggle) {
                    if (!isClicked) {
                        com.setBackground(clicked);
                        isClicked = true;
                        if (group != null) {
                            group.add(XInteractive.this);
                        }
                    }
                    else if(isClicked && group == null){
                        com.setBackground(hover);
                        isClicked = false;
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
    }

    public boolean equals(XInteractive icom) {
        return this.normal.equals(icom.getNormal())
                && this.hover.equals(icom.getHover())
                && this.clicked.equals(icom.getClicked())
                && this.isToggle.equals(icom.isToggle())
                && this.isClicked == icom.isClicked()
                && this.com.equals(icom.getCom());
    }
}
