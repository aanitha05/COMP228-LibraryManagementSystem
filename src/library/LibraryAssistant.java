
package library;

public class LibraryAssistant extends LibraryStaff {

    private final String shiftType;
    private final double shiftAllowance;

    // Constructor
    public LibraryAssistant(String personId, String name,
                            String phoneNumber, String staffId,
                            String department, double monthlySalary,
                            String shiftType, double shiftAllowance) {

        super(personId, name, phoneNumber, staffId,
              department, monthlySalary);

        if (shiftType == null || shiftType.isBlank() ||
            !Double.isFinite(shiftAllowance) ||
            shiftAllowance < 0) {
            throw new IllegalArgumentException("Invalid assistant details.");
        }

        this.shiftType = shiftType;
        this.shiftAllowance = shiftAllowance;
        
     // Count the library assistant
        incrementStaffCount();
    }

    // Getters
    public String getShiftType() {
        return shiftType;
    }

    public double getShiftAllowance() {
        return shiftAllowance;
    }

    // Calculate monthly compensation
    @Override
    public double calculateMonthlyCompensation() {
        return getMonthlySalary() + shiftAllowance;
    }

    @Override
    public String getRoleDescription() {
        return "Library Assistant";
    }

    // Display assistant details
    @Override
    public void displayStaffDetails() {
        super.displayStaffDetails();
        System.out.println("Role: " + getRoleDescription());
        System.out.println("Shift Type: " + shiftType);
        System.out.println("Shift Allowance: $" + shiftAllowance);
        System.out.println("Total Compensation: $"
                + calculateMonthlyCompensation());
    }
}
