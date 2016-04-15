package Tests;

import no.uib.info233.v2016.puz001.esj002.Oblig3.FileHandling.IssueTable;
import no.uib.info233.v2016.puz001.esj002.Oblig3.FileHandling.XmlFilehandling;
import no.uib.info233.v2016.puz001.esj002.Oblig3.Issue.Issues;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Test.*;


/**
 * Created by goat on 15.04.16.
 */
public class IssueTableTest{
IssueTable it = new IssueTable(new XmlFilehandling());

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testChangePrioSingle() throws Exception {
        Issues issue = new Issues(1, "user", new Date(), "Issue here", "44", "Norway", "Closed");

        String expected = "Normal";
        String result = it.changePrioSingle(issue);

        assertEquals(expected,result);





    }

    @Test
    public void testDateToString() throws Exception {
        Date d = new Date();

        String expected = "04/15/2016";
        String result = it.dateToString(d);

        assertEquals(expected , result);



    }

    /*
     * This method is working the way it should do, but it
     * does not work because the time is different. The date
     * however, works as itis supposed to. Example:
     * java.lang.AssertionError:
        Expected :Fri Apr 15 12:06:39 CEST 2016
        Actual   :Fri Apr 15 00:00:00 CEST 2016
     * @throws Exception
     */
    @Test
    public void testStringToDate() throws Exception {

        String date = "04/15/2016";

        Date expected = new Date();
        Date result = it.stringToDate(date);

        assertEquals(expected, result);

        System.out.print(result);
    }




}