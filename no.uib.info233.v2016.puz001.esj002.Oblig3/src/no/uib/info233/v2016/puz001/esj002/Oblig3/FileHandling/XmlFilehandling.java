package no.uib.info233.v2016.puz001.esj002.Oblig3.FileHandling;

import no.uib.info233.v2016.puz001.esj002.Oblig3.Gui.Gui;
import no.uib.info233.v2016.puz001.esj002.Oblig3.Gui.IssueFrame;
import no.uib.info233.v2016.puz001.esj002.Oblig3.Issue.Issues;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.Date;

/**
 * Created by mariuslillevik on 13.04.16.
 * This class handles everything that has
 * to do with the xml files,
 * both reading and writing the the files.
 * @Author Marius
 */
public class XmlFilehandling {

    private File file = new File(System.getProperty("user.dir") + "/Files/old_issues.xml");
    private File newFile = new File(System.getProperty("user.dir") + "/Files/new_issues.xml");
    private File userFile = new File(System.getProperty("user.dir") + "/Files/users.xml");

    /**
     * This method writes all the objects and string in issueList
     * into a single xml file containing all their info.
     */
    public void writeXmlFile(IssueTable it) {

        try {
            DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
            DocumentBuilder build = dFact.newDocumentBuilder();
            Document doc = build.newDocument();

            Element root = doc.createElement("Dataset");
            doc.appendChild(root);


            for (Issues i : it.getIssueList()) {
                Element details = doc.createElement("ISSUES");

                root.appendChild(details);

                details.setAttribute("id", Integer.toString(i.getId()));
                details.setAttribute("assigned_user", i.getAssigned());
                details.setAttribute("created", it.dateToString(i.getCreated()));
                details.setAttribute("text", i.getIssue());
                details.setAttribute("priority", Integer.toString(i.getPriority()));
                details.setAttribute("location", i.getLocation());
                details.setAttribute("status", i.getStatus());
                details.setAttribute("created_by", i.getCreatedBy());
                details.setAttribute("last_updated_by", i.getLastUpdatedBy());


                for(String s : i.getBeenUpdatedBy()){
                    Element updater = doc.createElement("UPDATER");
                    updater.setTextContent(s);
                    details.appendChild(updater);
                }
            }

            // Save the document to the disk file
            TransformerFactory tranFactory = TransformerFactory.newInstance();
            Transformer aTransformer = tranFactory.newTransformer();

            // format the XML nicely
            aTransformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            aTransformer.setOutputProperty(
                    "{http://xml.apache.org/xslt}indent-amount", "4");
            aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(doc);
            try {
                OutputStream os = new FileOutputStream(newFile);
                OutputStreamWriter bufferedWriter = new OutputStreamWriter(os, "UTF8");
                //FileWriter fos = new FileWriter(newFile);
                StreamResult result = new StreamResult(bufferedWriter);
                aTransformer.transform(source, result);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(it.errorFrame, "Could not write the file.", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }

        } catch (TransformerException ex) {
            JOptionPane.showMessageDialog(it.errorFrame, "Error outputting document", "Error", JOptionPane.ERROR_MESSAGE);


        } catch (ParserConfigurationException ex) {
            JOptionPane.showMessageDialog(it.errorFrame, "Error building document", "Error", JOptionPane.ERROR_MESSAGE);

        } finally {
            it.tableForIssues();
        }
    }



    /**
     * This method creates writes the users ArrayList to an xml file
     * so that it can later be read into the system again the next time it
     * is started again.
     */
    public void writeUsersToXml(IssueTable it){
        try {

            DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
            DocumentBuilder build = dFact.newDocumentBuilder();
            Document doc = build.newDocument();

            Element root = doc.createElement("Users");
            doc.appendChild(root);

            for (String i : it.getUsers()) {
                Element user = doc.createElement("USER");
                root.appendChild(user);
                user.setAttribute("name", i);
            }

            // Save the document to the disk file
            TransformerFactory tranFactory = TransformerFactory.newInstance();
            Transformer aTransformer = tranFactory.newTransformer();

            // format the XML nicely
            aTransformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            aTransformer.setOutputProperty(
                    "{http://xml.apache.org/xslt}indent-amount", "4");
            aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(doc);
            try {
                FileWriter fos = new FileWriter(userFile);
                StreamResult result = new StreamResult(fos);
                aTransformer.transform(source, result);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(it.errorFrame, "Error writing the document. Contact administration.", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }

        } catch (TransformerException ex) {
            JOptionPane.showMessageDialog(it.errorFrame, "Error outputting document", "Error", JOptionPane.ERROR_MESSAGE);


        } catch (ParserConfigurationException ex) {
            JOptionPane.showMessageDialog(it.errorFrame, "Error building document", "Error", JOptionPane.ERROR_MESSAGE);

        }

    }

    /**
     * This method takes all the assigned users from the
     * xml document "old_issues.xml" or the new "users.xml"
     * and places them into the ArrayList users.
     */
    public void fillUsers(IssueTable it) {
        if (!userFile.exists()) {
            try {
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(file);
                doc.getDocumentElement().normalize();

                NodeList nodelist = doc.getElementsByTagName("ISSUES");
                for (int i = 0; i < nodelist.getLength(); i++) {
                    Node node = nodelist.item(i);
                    Element eElement = (Element) node;
                    if (!it.getUsers().contains(eElement.getAttribute("assigned_user")))
                        it.getUsers().add(eElement.getAttribute("assigned_user"));
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(it.errorFrame, "We were unable to locate the file, old_issues.xml.", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();

            }
        } else {
            try {
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(userFile);
                doc.getDocumentElement().normalize();

                NodeList nodelist = doc.getElementsByTagName("USER");
                for (int i = 0; i < nodelist.getLength(); i++) {
                    Node node = nodelist.item(i);
                    Element eElement = (Element) node;
                    if (!it.getUsers().contains(eElement.getAttribute("name")))
                        it.getUsers().add(eElement.getAttribute("name"));
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(it.errorFrame, "We were unable to locate the file, issuetracker_users.xml.", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();

            }
        }
    }

    /**
     * This method clears the list of issues and fetches the new
     * issues from the xml file and puts them into the list.
     * @param it an instance is the IssueTable class.
     */
    public void fillIssues(IssueTable it){

        if(newFile.exists()) {
            try {
                it.getIssueList().clear();
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(newFile);
                doc.getDocumentElement().normalize();
                NodeList nodelist = doc.getElementsByTagName("ISSUES");
                for (int i = 0; i < nodelist.getLength(); i++) {

                    Node node = nodelist.item(i);
                    Element eElement = (Element) node;
                    Issues issue = new Issues(Integer.parseInt(eElement.getAttribute("id")),
                            eElement.getAttribute("assigned_user"),
                            it.stringToDate(eElement.getAttribute("created")),
                            eElement.getAttribute("text"),
                            Integer.parseInt(eElement.getAttribute("priority").trim()),
                            eElement.getAttribute("location"),
                            eElement.getAttribute("status"));
                    issue.setCreatedBy(eElement.getAttribute(("created_by")));
                    issue.setLastUpdatedBy(eElement.getAttribute("last_updated_by"));


                    NodeList updateList = nodelist.item(i).getChildNodes();
                    for (int j = 0; j < updateList.getLength(); j++) {
                        Node updateNode = updateList.item(j);
                        if ("UPDATER".equals(updateNode.getNodeName())) {
                            issue.getBeenUpdatedBy().add(updateNode.getTextContent());
                        }
                    }
                    it.getIssueList().add(issue);


                }
                it.changePrio();
            } catch (ParserConfigurationException e) {
                JOptionPane.showMessageDialog(it.errorFrame, "Parser config error.", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            } catch (FileNotFoundException f){
                JOptionPane.showMessageDialog(it.errorFrame, "We were unable to locate the file, new_issues.xml. ", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (SAXException s) {
                JOptionPane.showMessageDialog(it.errorFrame, "SAX parser error.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IOException s) {
                JOptionPane.showMessageDialog(it.errorFrame, "Something went wrong while parsing new_issues.xml", "Error", JOptionPane.ERROR_MESSAGE);
                s.printStackTrace();
            }

        } else if (!newFile.exists()){
            try {
                it.getIssueList().clear();
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(file);
                doc.getDocumentElement().normalize();
                NodeList nodelist = doc.getElementsByTagName("ISSUES");
                for (int i = 0; i < nodelist.getLength(); i++) {

                    Node node = nodelist.item(i);
                    Element eElement = (Element) node;
                    Issues issue = new Issues(Integer.parseInt(eElement.getAttribute("id")),
                            eElement.getAttribute("assigned_user"),
                            it.stringToDate(eElement.getAttribute("created")),
                            eElement.getAttribute("text"),
                            Integer.parseInt(eElement.getAttribute("priority").trim()),
                            eElement.getAttribute("location"),
                            "Closed");
                    issue.setCreatedBy(eElement.getAttribute(("assigned_user")));
                    issue.setLastUpdatedBy(eElement.getAttribute("assigned_user"));
                    issue.getBeenUpdatedBy().add(eElement.getAttribute("assigned_user"));

                    it.getIssueList().add(issue);
                }
                it.changePrio();
            } catch (ParserConfigurationException e) {
                JOptionPane.showMessageDialog(it.errorFrame, "Parser config error.", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            } catch (SAXException s) {
                JOptionPane.showMessageDialog(it.errorFrame, "SAX parser error.", "Error", JOptionPane.ERROR_MESSAGE);

            } catch (FileNotFoundException f){
                System.out.println(f.getMessage());
                JOptionPane.showMessageDialog(it.errorFrame, "We were unable to locate the file, old_issues.xml. PC", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IOException s) {
                s.printStackTrace();
                JOptionPane.showMessageDialog(it.errorFrame, "Something went wrong during parsing the file old_issues.xml.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else {
            JOptionPane.showMessageDialog(it.errorFrame, "We were unable to locate the file, old_issues.xml or new_issues.xml. ", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    /**
     * This method looks through the xml documents and fetches the
     * highest id number in order to use this when creating new issues.
     * @return String of the highest id + 1
     */
    public String getHighest() {
        String currentResult = null;
        File f = null;
        if(newFile.exists()){
            f = newFile;
        } else {
            f = file;
        }
            try {
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(f);

                NodeList list = doc.getElementsByTagName("ISSUES");
                int highestId = 0;
                for (int i = 0; i < list.getLength(); i++) {
                    int id = Integer.parseInt(((Element) list.item(i)).getAttribute("id"));
                    if (id > highestId) {
                        highestId = id;
                    }
                }
                currentResult = Integer.toString(highestId + 1);

            } catch (Exception e) {

            }
        return currentResult;
    }


    /**
     * This method writes all the objects and strings in issueList and users list
     * into a single xml file containing all their info. This method is used in newProgram.
     * @param issueFrame to fetch data from.
     */
    public void writeXmlFileNewProgram(IssueFrame i) {
         IssueTable it = new IssueTable(new XmlFilehandling());
        File f = null;
       if(newFile.exists()) {
       f = newFile;
       } else {
        f = file;
       }
           try {
               DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
               DocumentBuilder build = dFact.newDocumentBuilder();
               Document doc = build.parse(f);

               Element root = doc.getDocumentElement();

               Element details = doc.createElement("ISSUES");

               root.appendChild(details);

               details.setAttribute("id", getHighest());
               details.setAttribute("assigned_user", "");
               details.setAttribute("created", it.dateToString(new Date()));
               details.setAttribute("text", i.getIssueText().getText());
               details.setAttribute("priority", Integer.toString(Gui.convertChoosePriority(i.getChoosePrio())));
               details.setAttribute("location", i.getLocationText().getText());
               details.setAttribute("status", "Open");
               details.setAttribute("created_by", "");
               details.setAttribute("last_updated_by", "");


               Element updater = doc.createElement("UPDATER");
               updater.setTextContent("");
               details.appendChild(updater);


               // Save the document to the disk file
               TransformerFactory tranFactory = TransformerFactory.newInstance();
               Transformer aTransformer = tranFactory.newTransformer();

               // format the XML nicely
               aTransformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

               aTransformer.setOutputProperty(
                       "{http://xml.apache.org/xslt}indent-amount", "4");
               aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");

               DOMSource source = new DOMSource(doc);
               try {


                   OutputStream os = new FileOutputStream(newFile);
                   OutputStreamWriter bufferedWriter = new OutputStreamWriter(os, "UTF8");

                   //FileWriter fos = new FileWriter(newFile);
                   StreamResult result = new StreamResult(bufferedWriter);
                   aTransformer.transform(source, result);
               } catch (IOException e) {
                   JOptionPane.showMessageDialog(it.errorFrame, "Could not write the file.", "Error", JOptionPane.ERROR_MESSAGE);
                   e.printStackTrace();
               }

           } catch (TransformerException ex) {
               JOptionPane.showMessageDialog(it.errorFrame, "Error outputting document", "Error", JOptionPane.ERROR_MESSAGE);


           } catch (ParserConfigurationException ex) {
               JOptionPane.showMessageDialog(it.errorFrame, "Error building document", "Error", JOptionPane.ERROR_MESSAGE);

           } catch (SAXException e) {

           } catch (IOException e) {

           }
       }


    /**
     * Getter for the newFile that is created
     * when the application adds or updates any issues.
     * @return the newFile
     */
    public File getNewFile() {
        return newFile;
    }
}
