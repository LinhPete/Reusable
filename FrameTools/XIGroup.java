/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FrameTools;

import java.util.ArrayList;

/**
 *
 * @author ndhlt
 */
public final class XIGroup {
    ArrayList<XInteractive> icomp;
    XInteractive selection = null;

    public XIGroup() {
        icomp = new ArrayList();
    }
    
    public XIGroup(XInteractive... coms) {
        icomp = new ArrayList();
        add(coms);
    }
    
    public void add(XInteractive... coms){
        for(XInteractive com: coms){
            add(com);
        }
    }

    public void add(XInteractive com) {
        if (com == null || !com.isToggle()) {
            return;
        }
        icomp.add(com);
        if (com.isClicked()) {
            selection = com;
            for (XInteractive ipanel : icomp) {
                if (com.equals(ipanel)) {
                    continue;
                }
                ipanel.setClicked(false);
                ipanel.getCom().setBackground(ipanel.getNormal());
            }
        }
        if (com.getGroup() == null) {
            com.setGroup(this);
        }
    }

    public void remove(XInteractive panel) {
        if (panel == null) {
            return;
        }
        icomp.remove(panel);
        if (panel == selection) {
            selection = null;
        }
        panel.setGroup(null);
    }

    public void clearSelection() {
        selection = null;
        for (XInteractive ipanel : icomp) {
            ipanel.setClicked(false);
            ipanel.getCom().setBackground(ipanel.getNormal());
        }
    }
}
