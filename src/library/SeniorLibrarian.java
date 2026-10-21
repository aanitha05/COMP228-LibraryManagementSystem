
package library;

public class SeniorLibrarian extends Librarian {

    private final String specialization;
    private final double seniorityAllowance;

    // Constructor
    public SeniorLibrarian(String personId, String name,
                           String phoneNumber, String staffId,
                           String department, double monthlySalary,
                           int dailyIssueLimit, int booksProcessed,
                           String specialization, double seniorityAllowance) {

        super(personId, name, phoneNumber, staffId, department,
              monthlySalary, dailyIssueLimit, booksProcessed);

        if (specialization == null || specialization.isBlank() ||
            !Double.isFinite(seniorityAllowance) ||
            seniorityAllowance < 0) {
            throw new IllegalArgumentException("Invalid senior librarian details.");
        }

        this.specialization = specialization;
        this.seniorityAllowance = seniorityAllowance;
     // Count the senior librarian
        incrementStaffCount();
        
    }

    // Getters
    public String getSpecialization() {
        return specialization;
    }

    public double getSeniorityAllowance() {
        return seniorityAllowance;
    }

    // Calculate compensation with seniority allowance
    @Override
    public double calculateMonthlyCompensation() {
        return super.calculateMonthlyCompensation() + seniorityAllowance;
    }

    @Override
    public String getRoleDescription() {
        return "Senior Librarian";
    }

    // Display senior librarian details
    @Override
    public void displayStaffDetails() {
        super.displayStaffDetails();
        System.out.println("Specialization: " + specialization);
        System.out.println("Seniority Allowance: $" + seniorityAllowance);
        System.out.println("Total Compensation: $"
                + calculateMonthlyCompensation());
    }
}
