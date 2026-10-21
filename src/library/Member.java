
package library;

public class Member extends Person implements Reservable {
	
    private final String memberNumber;
    private int age;
    private String membershipType;
    private double outstandingFees;

    private static int memberCount = 0;

    // Constructor
    public Member(String personId, String name, String phoneNumber,
                  String memberNumber, int age) {

        super(personId, name, phoneNumber);

        if (memberNumber == null || memberNumber.isBlank() || age < 1) {
            throw new IllegalArgumentException("Invalid member details.");
        }

        this.memberNumber = memberNumber;
        this.age = age;
        this.membershipType = "Standard";
        this.outstandingFees = 0;

        incrementPersonCount();
        memberCount++;
}

    // Basic registration
    public void registerMember() {
        System.out.println(getName() + " registered as a Standard member.");
    }

    // Registration with membership type
    public void registerMember(String membershipType) {
        if (membershipType == null || membershipType.isBlank()) {
            throw new IllegalArgumentException("Invalid membership type.");
        }

        this.membershipType = membershipType;
        System.out.println(getName() + " registered as a "
                + membershipType + " member.");
    }

    // Getters
    public String getMemberNumber() {
        return memberNumber;
    }

    public int getAge() {
        return age;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public double getOutstandingFees() {
        return outstandingFees;
    }

    public static int getMemberCount() {
        return memberCount;
    }

    @Override
    public String getRoleDescription() {
        return "Library Member";
    }

    public void displayMemberDetails() {
        displayBasicDetails();
        System.out.println("Member Number: " + memberNumber);
        System.out.println("Age: " + age);
        System.out.println("Membership Type: " + membershipType);
        System.out.println("Outstanding Fees: $" + outstandingFees);
    }
 // Reserve a library book
    @Override
    public void reserveBook(String bookId) {
        if (bookId == null || bookId.isBlank()) {
            System.out.println("Reservation failed: Invalid book ID.");
        } else {
            System.out.println(getName()
                    + " successfully reserved book: " + bookId);
        }
    }
}
