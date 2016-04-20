package no.uib.info233.v2016.puz001.esj002.Oblig3.FileHandling;

import javax.swing.table.DefaultTableCellRenderer;

/**
 * Created by goat on 20.04.16.
 */
public class PriorityRenderer extends DefaultTableCellRenderer {

    @Override
    public void setValue(Object value) {
        if (value instanceof Integer) {
               int value1 = ((Integer) value).intValue();
                if(value1 == 1) {
                    setText("Kritisk");
                } else if(value1 == 2) {
                    setText("Høy");
                } else if(value1 == 3) {
                    setText("Normal");
                } else if(value1 == 4) {
                    setText("Lav");
                } else if(value1 == 5) {
                    setText("Ikke prioritert");
                }
            }

            //setText((value == null) ? "" : formatter.format(value));
        }
    }

