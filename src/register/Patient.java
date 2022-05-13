package register;

/**

This class has a name, age , Id, Phone number and address of Patient.

 **/

public class Patient {

    private String name;
    private int age;
    private int Id;
    private int phoneNumber;
    private String address;

    public Patient() {
        this("John",20,123,3456,"Janos");
    }

    public Patient(String name, int age, int Id, int phoneNumber, String address) {
        this.name = name;
        this.age = age;
        this.Id = Id;
        this.phoneNumber = phoneNumber;
        this.address = address;

    }

    /**
     * @return Name
     */

    public String getName() {
        return name;
    }

    /**
     * @param name  sets name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age  sets age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return Id
     */
    public int getId() {
        return Id;
    }
    /**
     * @param Id  sets Id
     */

    public void setId(int Id) {
        this.Id = Id;
    }
    /**
     * @return phoneNumber
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }
    /**
     * @param phoneNumber sets phone number
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address sets address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return variables as a string
     */
    @Override
    public String toString() {
        String output = "Name: " + name + "\nId: "+ Id +"\nage: "+age +"\nphone number: "+ phoneNumber+"\naddress: "+address + "\n"+ "\n"+"\n";
        return output;
    }
}

