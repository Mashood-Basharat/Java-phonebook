
import java.util.*;
import javax.swing.*;

class PersonInfo {
    private String name;
    private String address;
    private String phoneNum;

    // Setters and Getters
    public void setName(String nameP) {
        this.name = nameP;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String addressP) {
        this.address = addressP;
    }

    public String getAddress() {
        return address;
    }

    public void setPhoneNum(String phoneNumP) {
        this.phoneNum = phoneNumP;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    // parameterized constructor
    public PersonInfo(String n, String a, String p) {
        name = n;
        address = a;
        phoneNum = p;
    }

    // Printing info of person
    public void printInfo() {
        JOptionPane.showMessageDialog(null, "Name:" + name + "\nAddress: " + address + "\nPhoneNo: " + phoneNum);
    }

}

// The class for storing the data, By assistance of string data structure
class MyArrayList {

    ArrayList<PersonInfo> personsList = new ArrayList<>();

    // Add to arrayList [PhoneBook]
    public void addperson() {

        String tempName = JOptionPane.showInputDialog(null, "Enter Name");
        String tempAddress = JOptionPane.showInputDialog(null, "Enter Address");
        String tempPhoneNum = JOptionPane.showInputDialog(null, "Enter Phone Number");

        PersonInfo person = new PersonInfo(tempName, tempAddress, tempPhoneNum);

        personsList.add(person); // addition in arrayList is done inside a public environmnent; doubtful note
    }

    // Search person by name from arrayList [Phone Book]
    public void searchperson(String searchName) {
        if (searchName.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter valid data to search a person");
        } else if (personsList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "The phone Book is empty, Nothing to search");
        } else {
            for (int i = 0; i < personsList.size(); i++) {
                PersonInfo objectForPrint = (PersonInfo) personsList.get(i);
                if (searchName.equals(objectForPrint.getName())) {
                    objectForPrint.printInfo();
                } else {
                    JOptionPane.showMessageDialog(null, "The person is not found");
                }
            }
        }
    }

    // Delete person by name from arrayList [phone Book]
    public void deletePerson(String deleteName) {
        if (deleteName.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter valid data to delete a person");
        } else if (personsList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "The phone Book is empty, Nothing to delete");
        } else {
            for (int i = 0; i < personsList.size(); i++) {
                PersonInfo objectForDelete = personsList.get(i);
                if (deleteName.equals(objectForDelete.getName())) {
                    personsList.remove(i);

                    // printing the deleted person's data
                    JOptionPane.showMessageDialog(null,
                            "The deleted person is \nName: " + objectForDelete.getName() + "\nAddress: "
                                    + objectForDelete.getAddress() + "\nPhoneNo: " + objectForDelete.getPhoneNum());
                }
            }
        }
    }

}

public class MiniPhoneBook {
    public static void main(String[] args) {

        MyArrayList mArrList = new MyArrayList();

        String doOnUserDemand;

        while (true) {
            String userInput = JOptionPane.showInputDialog(null,
                    "Enter 1 to add a new Person \nEnter 2 to search an existing Person \nEnter 3 to delete an existing Person \nEnter 4 to exit the program");

            int choice = Integer.parseInt(userInput);

            switch (choice) {
                case 1:
                    mArrList.addperson();
                    break;

                case 2:
                    doOnUserDemand = JOptionPane.showInputDialog(null, "Enter name to search the Person");
                    mArrList.searchperson(doOnUserDemand);
                    break;
                case 3:
                    doOnUserDemand = JOptionPane.showInputDialog(null, "Enter name to delete the Person");
                    mArrList.deletePerson(doOnUserDemand);
                    break;
                case 4:
                    System.exit(0);

            }// end of switch
        } // end of while
    }// end of psvm
}// end of main class