package no.uib.info233.v2016.puz001.esj002.Oblig3.Gui;

import javax.swing.table.DefaultTableCellRenderer;
import java.text.DateFormat;

class DateRenderer extends DefaultTableCellRenderer {
    DateFormat formatter;
    public DateRenderer() { super(); }

    public void setValue(Object value) {
        if (formatter==null) {
            formatter = DateFormat.getDateInstance();
        }
        setText((value == null) ? "" : formatter.format(value));
    }
}
