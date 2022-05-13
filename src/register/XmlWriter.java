package register;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  This program manages patients in the hospital.
 *  Using Xml as a database to manage and store element data in it.
 *  From Xml file we can read patients information
 *  In this program we can
        -see the list of patients
        -Add new patient
        - Find the patient
        - Update the patient information
        - Delete the patient information
 everything is saved in an xml file.
 */

public class XmlWriter {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {



        /**
         * This is the main method
         */
        String filepath = "C:\\Programming\\Java_Project\\PMIHospital\\src\\resource\\patients.xml";
        ArrayList<Patient> patients = XmlReader.readPatientsFromXml(filepath);
        System.out.println("--------------****** Welcome ******------------\n");

        int choice = -1;
        while (choice != 0) {
            System.out.println("\n******************** Patients in hospital ************************** ");
            System.out.println("1 - List all patients");
            System.out.println("2 - Add a patient ");
            System.out.println("3 - Search patient name ");
            System.out.println("4 - Search patient Id ");
            System.out.println("5 - Update patient information ");
            System.out.println("6 - Delete patient ");
            System.out.println("0 - Exit ");
            System.out.print("\nEnter your choice : ");
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice < 0 || choice > 6) {
                    System.out.println("------Not a valid option. \nPlease try again------");
                }
            } catch (InputMismatchException e) {
                System.out.println("-----Unvalid option------");
                scanner.nextLine();
            }
            switch (choice) {
                case 1 -> System.out.println(patients);
                case 2 -> addNewPatient(patients);
                case 3 -> searchPatientName(patients);
                case 4 -> searchPatientId(patients);
                case 5 -> updatePatient(patients);
                case 6 -> deletePatient(patients);
                case 0 -> System.out.println("(: **---------------Good bye------------------** :) ");
            }
        }

        savePatientsToXml(patients, filepath);  /** We gonna save all the information that we want to Xml file
                                                by using savePatientToXml **/
    }

    /**
     *
     * @param patients we can add new patient by using this function(method)
     */
    private static void addNewPatient(ArrayList<Patient> patients) {
        System.out.print("Enter name of new patient: ");
        String name = scanner.nextLine();
        int age = readage();
        int Id = readId();
        int phoneNumber = readPhoneNumber() ;
        System.out.print("Enter address of new patient: ");
        String address = scanner.nextLine();
        patients.add(new Patient(name, age, Id, phoneNumber, address));
    }

    /**
     @param patients with this function we can update or modify the patient information :) .
     **/
    private static void updatePatient(ArrayList<Patient> patients) {
        Patient patient = searchPatientName(patients);
        int age = readage();
        int Id = readId();
        int phoneNumber = readPhoneNumber() ;
        System.out.print("Enter address of the patient :) : ");
        String address = scanner.nextLine();

        patients.set(patients.indexOf(patient),
                new Patient(patient.getName(), age, Id, phoneNumber, address));
        System.out.println("-----***** Great ! :) The patient is updated *****-----");
    }
    /**
     @param patients in this function we can delete the patient information :o .

     **/
    private static void deletePatient(ArrayList<Patient> patients) {
        patients.remove(searchPatientName(patients));
        System.out.println("-----Done! is deleted ------");
    }
    /**
     @param patients input the name of the patient that you are looking for and it's gonna give you all his /her
     information by inputing her/his name :) .

     **/
    private static Patient searchPatientName(ArrayList<Patient> patients) {
        Patient patient = new Patient();
        String name = "";
        while (name.isEmpty()) {
            System.out.print("Enter name of patient: ");
            name = scanner.nextLine();
            for (Patient patientElement : patients) {
                if (patientElement.getName().equals(name)) {
                    System.out.println("---The patient is found :) ----");
                    System.out.println(patientElement);
                    return patientElement;
                }
            }
            name = "";
        }
        return patient;
    }
    /**
     @param patients input the Id of the patient that you are looking for and it's gonna give you all his /her
     information by input her/his Id :) .

     **/
    private static Patient searchPatientId(ArrayList<Patient> patients) {
        Patient patient = new Patient();
        int Id = 0;
        while (Id == 0) {
            Id = readId();
            for (Patient patientElement : patients) {
                if (patientElement.getId()== Id) {
                    System.out.println("----The Id of the patient is found :) -----");
                    System.out.println(patientElement);
                    return patientElement;
                }
            }
            Id = 0;
        }
        return patient;
    }

    private static int readage() {
        int age = 0;
        while (age == 0) {
            try {
                System.out.print("Enter age of the patient: ");
                age = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(" Please enter an integer.");
                scanner.nextLine();
            }
        }
        return age;
    }
    private static int readId() {
        int Id = 0;
        while (Id == 0) {
            try {
                System.out.print("Enter Id of the patient: ");
                Id = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(" Please enter an integer.");
                scanner.nextLine();
            }
        }
        return Id;
    }

    private static int readPhoneNumber() {
        int phoneNumber = 0;
        while (phoneNumber== 0) {
            try {
                System.out.print("Enter phone number of the patient: ");
                phoneNumber= scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(" Please enter an integer.");
                scanner.nextLine();
            }
        }
        return phoneNumber;
    }
    /**
     * @param patients
     * @param filepath
     * here we will save all the patients to Xml file by storing their information
     */
    public static void savePatientsToXml(ArrayList<Patient> patients, String filepath) {
        try {
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

            Element rootElement = document.createElement("patients");
            document.appendChild(rootElement);

            for (Patient patient : patients) {
                Element patientElement = document.createElement("patient");
                rootElement.appendChild(patientElement);
                createChildElement(document, patientElement, "name", patient.getName());
                createChildElement(document, patientElement, "age", String.valueOf(patient.getAge()));
                createChildElement(document, patientElement, "Id", String.valueOf(patient.getId()));
                createChildElement(document, patientElement, "phoneNumber", String.valueOf(patient.getPhoneNumber()));
                createChildElement(document, patientElement, "address", patient.getAddress());
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            DOMSource source = new DOMSource(document);

            StreamResult result = new StreamResult(new FileOutputStream(filepath));

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
    here we  create a (first) child element in XML
    @param document
     @param parent
     @param tagName
     @param value
    **/
    private static void createChildElement(Document document, Element parent, String tagName, String value) {
        Element element = document.createElement(tagName);
        element.setTextContent(value);
        parent.appendChild(element);
    }



}

