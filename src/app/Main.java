
package app;

import library.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== MAPLE LEAF PUBLIC LIBRARY ===");

        // Register two members
        System.out.println("\n=== MEMBER REGISTRATION ===");

        Member member1 = new Member("P001", "Amira",
                "416-555-1111", "M001", 20);

        Member member2 = new Member("P002", "Noah",
                "416-555-2222", "M002", 25);

        member1.registerMember();
        member2.registerMember("Premium");

        // Test invalid registration
        try {
            new Member("P003", "Alex", "416-555-3333",
                    "", -2);
        } catch (IllegalArgumentException e) {
            System.out.println("Registration failed: " + e.getMessage());
        }

        // Create staff
        Librarian librarian = new Librarian(
                "P004", "Sarah", "416-555-4444",
                "S001", "Circulation", 3000, 20, 40);

        SeniorLibrarian senior = new SeniorLibrarian(
                "P005", "David", "416-555-5555",
                "S002", "Management", 4000, 30, 60,
                "Research", 500);

        LibraryAssistant assistant = new LibraryAssistant(
                "P006", "Emily", "416-555-6666",
                "S003", "Customer Service", 2500,
                "Evening", 200);

        // Display member details
        System.out.println("\n=== MEMBER DETAILS ===");
        member1.displayMemberDetails();
        System.out.println();
        member2.displayMemberDetails();

        // Display staff details
        System.out.println("\n=== STAFF DETAILS ===");
        librarian.displayStaffDetails();
        System.out.println();
        senior.displayStaffDetails();
        System.out.println();
        assistant.displayStaffDetails();

        // Method overloading
        System.out.println("\n=== LATE FEES ===");
        System.out.println("Default rate (3 days): $"
                + librarian.calculateLateFee(3));
        System.out.println("Custom rate (3 days at $1.50): $"
                + librarian.calculateLateFee(3, 1.50));

        // Runtime polymorphism
        System.out.println("\n=== MONTHLY COMPENSATION ===");

        LibraryStaff[] staffMembers = {
                librarian, senior, assistant
        };

        for (LibraryStaff staff : staffMembers) {
            System.out.println(staff.getRoleDescription()
                    + ": $" + staff.calculateMonthlyCompensation());
        }

        // Demonstrate both interfaces
        System.out.println("\n=== INTERFACES ===");

        Reservable reservation = member1;
        reservation.reserveBook("B101");
        reservation.reserveBook("");

        Reportable report = librarian;
        report.generateReport();

        // Static counters
        System.out.println("\n=== TOTAL COUNTS ===");
        System.out.println("Total People: " + Person.getPersonCount());
        System.out.println("Total Members: " + Member.getMemberCount());
        System.out.println("Total Staff: " + LibraryStaff.getStaffCount());

        System.out.println("\n=== PROGRAM FINISHED ===");
    }
}
