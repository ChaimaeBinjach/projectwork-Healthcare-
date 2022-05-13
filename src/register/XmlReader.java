package register;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;
import java.util.ArrayList;


public class XmlReader {
    /**
     * @param filepath
     * @return
     */
    public static ArrayList<Patient> readPatientsFromXml(String filepath) {
        ArrayList<Patient> patients = new ArrayList<>();
        try {

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(new FileInputStream(filepath));

            Element rootElement = document.getDocumentElement();


            NodeList childsOfRootElement = rootElement.getChildNodes();
            for (int i = 0; i < childsOfRootElement.getLength(); i++) {
                Node childNode = childsOfRootElement.item(i);
                if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                    NodeList childsOfPatientTag = childNode.getChildNodes();  // get all child nodes of a patient tag
                    String name = "";
                    int age = 0;
                    int Id=0;
                    int phoneNumber=0;
                    String address = "";
                    for (int j = 0; j < childsOfPatientTag.getLength(); j++) {
                        Node childNodeOfPatientTag = childsOfPatientTag.item(j);
                        if (childNodeOfPatientTag.getNodeType() == Node.ELEMENT_NODE) {
                            switch (childNodeOfPatientTag.getNodeName()) {
                                case "name" -> name = childNodeOfPatientTag.getTextContent();
                                case "age" -> age = Integer.parseInt(childNodeOfPatientTag.getTextContent());
                                case "Id" -> Id = Integer.parseInt(childNodeOfPatientTag.getTextContent());
                                case "phoneNumber" -> phoneNumber = Integer.parseInt(childNodeOfPatientTag.getTextContent());
                                case "address" -> address = childNodeOfPatientTag.getTextContent();
                            }
                        }
                    }
                    patients.add(new Patient(name, age, Id, phoneNumber, address));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patients;
    }
}
