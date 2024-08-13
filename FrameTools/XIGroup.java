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
            for (XInteractive icom : icomp) {
                if (selection.equals(icom)) {
                    continue;
                }
                icom.setClicked(false);
                icom.getCom().setBackground(icom.getNormal());
            }
        }
        if (com.getGroup() == null) {
            com.setGroup(this);
        }
    }

    public void remove(XInteractive com) {
        if (com == null) {
            return;
        }
        icomp.remove(com);
        if (com == selection) {
            selection = null;
        }
        com.setGroup(null);
    }

    public void clearSelection() {
        selection = null;
        for (XInteractive icom : icomp) {
            icom.setClicked(false);
            icom.getCom().setBackground(icom.getNormal());
        }
    }
}
