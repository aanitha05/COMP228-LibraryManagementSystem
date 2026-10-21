
package library;

public class Librarian extends LibraryStaff implements Reportable {
	
    private final int dailyIssueLimit;
    private int booksProcessed;

    
    // Constructor
    public Librarian(String personId, String name,
                     String phoneNumber, String staffId,
                     String department, double monthlySalary,
                     int dailyIssueLimit, int booksProcessed) {

        super(personId, name, phoneNumber, staffId,
              department, monthlySalary);

        if (dailyIssueLimit < 0 || booksProcessed < 0) {
            throw new IllegalArgumentException("Invalid book details.");
        }

        this.dailyIssueLimit = dailyIssueLimit;
        this.booksProcessed = booksProcessed;
        
     // Count regular librarians only
        if (getClass() == Librarian.class) {
            incrementStaffCount();
        }
    }

    // Getters
    public int getDailyIssueLimit() {
        return dailyIssueLimit;
    }

    public int getBooksProcessed() {
        return booksProcessed;
    }

    // Calculate monthly compensation
    @Override
    public double calculateMonthlyCompensation() {
        return getMonthlySalary() + (booksProcessed * 2.00);
    }

    // Calculate late fee using default rate
    public double calculateLateFee(int daysOverdue) {
        return calculateLateFee(daysOverdue, 1.00);
    }

    // Calculate late fee using a custom rate
    public double calculateLateFee(int daysOverdue, double dailyRate) {

        if (daysOverdue < 0 || dailyRate <= 0 ||
            !Double.isFinite(dailyRate)) {
            throw new IllegalArgumentException("Invalid late fee details.");
        }

        return daysOverdue * dailyRate;
    }

    @Override
    public String getRoleDescription() {
        return "Librarian";
    }

    @Override
    public void displayStaffDetails() {
        super.displayStaffDetails();
        System.out.println("Role: " + getRoleDescription());
        System.out.println("Daily Issue Limit: " + dailyIssueLimit);
        System.out.println("Books Processed: " + booksProcessed);
    }

    // Generate a librarian report
    @Override
    public void generateReport() {
        System.out.println("=== Library Report ===");
        System.out.println("Librarian: " + getName());
        System.out.println("Books Processed: " + booksProcessed);
        System.out.println("Monthly Compensation: $"
                + calculateMonthlyCompensation());
    }

}
