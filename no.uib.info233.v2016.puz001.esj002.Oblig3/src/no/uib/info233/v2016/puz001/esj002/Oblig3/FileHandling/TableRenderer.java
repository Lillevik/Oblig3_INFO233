package no.uib.info233.v2016.puz001.esj002.Oblig3.FileHandling;

import javax.swing.table.DefaultTableCellRenderer;
import java.text.Format;
import java.text.SimpleDateFormat;

/**
 * Created by marius on 01.04.2016.
 */
public class TableRenderer extends DefaultTableCellRenderer
{
    private Format formatter = new SimpleDateFormat("MM/dd/yy");

    public void setValue(Object value) {
        //  Format the Object before setting its value in the renderer
        try
        {
            if (value != null)
                value = formatter.format(value);
        }
        catch(IllegalArgumentException e) {}

        super.setValue(value);
    }
}