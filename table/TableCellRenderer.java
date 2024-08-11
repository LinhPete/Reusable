/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import utils.XImage;

/**
 * This class is used to render cells of a column in a JTable to JavaSwing
 * components
 *
 * @author ndhlt
 */
public class TableCellRenderer extends DefaultTableCellRenderer {

    public static final int IMAGE_RENDER = 0;
    public static final int FOREGROUND_RENDER = 1;
    public static final int BACKGROUND_RENDER = 2;

    private int RENDER_TYPE;
    private Color color;
    private Boolean condition;

    /**
     * This constructor is used for rendering an image to the cells
     *
     * @param RENDER_TYPE usually 0
     *
     */
    public TableCellRenderer(int RENDER_TYPE) {
        this.RENDER_TYPE = RENDER_TYPE;
    }

    /**
     * This constructor is used for rendering colored table cells
     * @param RENDER_TYPE usually 1 or 2
     * @param color a color for the rendered cells
     */
    public TableCellRenderer(int RENDER_TYPE, Color color) {
        this.RENDER_TYPE = RENDER_TYPE;
        this.color = color;
    }

    /**
     * 
     */
    public TableCellRenderer(int RENDER_TYPE, Color color, Boolean condition) {
        this.RENDER_TYPE = RENDER_TYPE;
        this.color = color;
        this.condition = condition;
    }

    /**
     * 
     */
    public TableCellRenderer(int RENDER_TYPE, Boolean condition) {
        this.RENDER_TYPE = RENDER_TYPE;
        this.condition = condition;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        // Gọi phương thức gốc để lấy thành phần hiển thị mặc định
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        try {
            switch (RENDER_TYPE) {
                case IMAGE_RENDER:
                    return setImage(table, value, row, column);
                case FOREGROUND_RENDER:
                    return setForeground(component, color);
                case BACKGROUND_RENDER:
                    return setBackground(component, color);
                default:
                    return component;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return component;
        }
    }

    private JLabel setImage(JTable table, Object path, int row, int column) {
        if (condition == null || condition == true) {
            int h = table.getRowHeight(row);
            int w = table.getColumnModel().getColumn(column).getWidth();
            try {
                JLabel label = new JLabel(XImage.getResized(XImage.read((String) path), w, h));
                label.setHorizontalAlignment(JLabel.CENTER);
                return label;
            } catch (Exception ex) {
                ex.printStackTrace();
                return new JLabel((String) path);
            }
        } else {
            return new JLabel((String) path);
        }
    }

    private JLabel setForeground(Component component, Color color) {
        if (condition == null || condition == true) {
            JLabel label = (JLabel) component;
            label.setForeground(color);
            return label;
        } else {
            return (JLabel) component;
        }
    }

    private JLabel setBackground(Component component, Color color) {
        if (condition == null || condition == true) {
            JLabel label = (JLabel) component;
            label.setBackground(color);
            return label;
        } else {
            return (JLabel) component;
        }
    }
}
