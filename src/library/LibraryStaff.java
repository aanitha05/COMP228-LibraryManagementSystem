
package library;

public abstract class LibraryStaff extends Person {

    private final String staffId;
    private String department;
    private double monthlySalary;

    private static int staffCount = 0;

    // Constructor
    public LibraryStaff(String personId, String name,
                        String phoneNumber, String staffId,
                        String department, double monthlySalary) {

        super(personId, name, phoneNumber);

        if (staffId == null || staffId.isBlank() ||
            department == null || department.isBlank() ||
            monthlySalary < 0) {
            throw new IllegalArgumentException("Invalid staff details.");
        }

        this.staffId = staffId;
        this.department = department;
        this.monthlySalary = monthlySalary;

    }

    // Getters
    public String getStaffId() {
        return staffId;
    }

    public String getDepartment() {
        return department;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public static int getStaffCount() {
        return staffCount;
    }

    // Abstract method
    public abstract double calculateMonthlyCompensation();

    // Display staff information
    public void displayStaffDetails() {
        displayBasicDetails();
        System.out.println("Staff ID: " + staffId);
        System.out.println("Department: " + department);
        System.out.println("Monthly Salary: $" + monthlySalary);
    }

    @Override
    public String getRoleDescription() {
        return "Library Staff";
    }
 // Count staff after successful creation
    protected static void incrementStaffCount() {
        staffCount++;
        incrementPersonCount();
    }
}
