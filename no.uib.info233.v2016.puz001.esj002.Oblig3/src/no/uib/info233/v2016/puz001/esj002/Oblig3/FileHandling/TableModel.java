package no.uib.info233.v2016.puz001.esj002.Oblig3.FileHandling;

import javax.swing.table.DefaultTableModel;
import java.util.Date;

/**
 * This method changes the defaultSettings of the DefaultTableModel
 * so that it treats the different columns accordingly.
 * Created by marius on 01.04.2016.
 */
public class TableModel extends DefaultTableModel{

    final Class<?>[] columnClasses = new Class<?>[] {Integer.class, String.class, Date.class, String.class, String.class, String.class};
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnClasses[columnIndex];

    }


}
