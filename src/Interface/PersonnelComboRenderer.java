/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import projet.Mission;

/**
 *
 * @author Choutzi
 */
public class PersonnelComboRenderer extends AbstractCellEditor implements
        TableCellRenderer, TableCellEditor {

    private Mission m;
    private JComboBox j;

    public PersonnelComboRenderer(Mission m) {
        super();
        this.m = m;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return j;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        j = new jComboboxPersonnel(m,row);
        j.setEditable(true);
        return (j);
    }

    @Override
    public Object getCellEditorValue() {
        return j.getEditor().getItem();
    }
}
