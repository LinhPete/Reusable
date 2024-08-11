/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FrameTools;

import java.util.ArrayList;
//import java.util.Vector;

/**
 *
 * @author ndhlt
 */
public final class IPanelGroup {

    ArrayList<IPanel> ipanels;
    IPanel selection = null;

    public IPanelGroup() {
        ipanels = new ArrayList();
    }
    
    public IPanelGroup(IPanel... panels) {
        ipanels = new ArrayList();
        add(panels);
    }
    
    public void add(IPanel... panels){
        for(IPanel panel: panels){
            add(panel);
        }
    }

    public void add(IPanel panel) {
        if (panel == null || !panel.isToggle()) {
            return;
        }
        ipanels.add(panel);
        if (panel.isClicked()) {
            selection = panel;
            for (IPanel ipanel : ipanels) {
                if (panel.equals(ipanel)) {
                    continue;
                }
                ipanel.setClicked(false);
                ipanel.setBackground(ipanel.getNormal());
            }
        }
        if (panel.getGroup() == null) {
            panel.setGroup(this);
        }
    }

    public void remove(IPanel panel) {
        if (panel == null) {
            return;
        }
        ipanels.remove(panel);
        if (panel == selection) {
            selection = null;
        }
        panel.setGroup(null);
    }

    public void clearSelection() {
        selection = null;
        for (IPanel ipanel : ipanels) {
            ipanel.setClicked(false);
            ipanel.setBackground(ipanel.getNormal());
        }
    }
}
