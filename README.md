# Programming Methodology I.
# *********************************************************************

# Project : CRUD Project ( Helathcare )

* Name : 😄 Chaimae Binjach 😄


## Project structure

* This program manages patients in the hospital.
* Using Xml as a database to manage and store element data in it.
* From Xml file we can read patients information
* In this program we can
   - see the list of patients
   - Add new patient
   - Find the patient
   - Update the patient information
   - Delete the patient information
   - everything is saved in xml file.
   - 
# ******************************************************************************

- >Patient (class):

    * I create a User class in register package.
    * The class has 5 attributes: name, age, Id, phoneNumber and  address.
    * Implement a setter and a getter to each attributes.
    * Implement a constructor.


# *******************************************************************************

- > Patients Xml file:

* in xml file we gonna see each patient has exactly "name", "age","Id", "phoneNumber" and "address"

# *********************************************************************************

- > XmlWriter (the main method:In this method read, store and print these data using standard input and output) :

* Xml writer prints out the options and asks the user to input the choice that he want to (List,add,search,update,delete patient and exit )


 - List all patients : it prints out all the information of patients that I have.
 - Add new patient : With this method we can add a new patient by input  his/her name following by the age ,Id ,phoneNumber and the address of the new patient
 - Update patient : This methode prints out all the patients and asks the user which student that he want to edit then the user needs to enter or edit the information of the patient that he wants to.
 - Search for the patient from his/her Id or name : This method ask the user to select the id or the name of the patient to see his/her information.
 - Delete the patient : This method asks the user to input the name of the patient that he wants to delete or remove.

# ***********************************************************************************

- > XmlReader  :

  - This class helps to read all the patients from Xml file .
  - Create a readPatientFromXml method to:
  - read a given file
  - create Patient objects from data, which is stored in the file
  - build a list of created Users
  - return with the list of created Users
    
  
  
  

      ( O \/ 0 )                                                                                     ( O \/ 0 )
      /(      )\                                                                                     /(      )\                                                                         
        "    "                                                                                         "     "



