
package library;

public abstract class Person {

    private final String personId;
    private String name;
    private String phoneNumber;
    private static int personCount = 0;

    // Constructor
    public Person(String personId, String name, String phoneNumber) {
        if (personId == null || personId.isBlank() ||
            name == null || name.isBlank() ||
            phoneNumber == null || phoneNumber.isBlank()) {
            throw new IllegalArgumentException("Person details cannot be empty.");
        }

        this.personId = personId;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // Getters
    public String getPersonId() {
        return personId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static int getPersonCount() {
        return personCount;
    }

    // Display basic information
    public void displayBasicDetails() {
        System.out.println("Person ID: " + personId);
        System.out.println("Name: " + name);
        System.out.println("Phone Number: " + phoneNumber);
    }

    // Abstract method
    public abstract String getRoleDescription();

    // Convert object details to a String
    @Override
    public String toString() {
        return "ID: " + personId + ", Name: " + name
                + ", Phone: " + phoneNumber;
    }
 // Count successfully created people
    protected static void incrementPersonCount() {
        personCount++;
    }
}
