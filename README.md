Library Management System

Project Description:

This Java program is a simple Library Management System for Maple Leaf Public Library. It allows members to register and reserve books, calculates overdue fees, displays library staff information, and calculates monthly compensation.

Object-Oriented Programming Concepts

Inheritance: Classes such as Member, Librarian, and LibraryAssistant inherit properties and methods from parent classes.

Abstraction: Person and LibraryStaff are abstract classes.

Encapsulation: Private variables are accessed using getters.

Method Overloading: Late fees can be calculated using a default rate or a custom rate.

Method Overriding: Different staff classes calculate compensation differently.

Polymorphism: LibraryStaff references are used to calculate compensation for different staff types

Interfaces: Reportable and Reservable provide reporting and reservation functionality.

Static Variables: Counters track the number of people, members, and staff.

Java does not support extending multiple classes, but classes can implement multiple interfaces. Combining inheritance with interfaces demonstrates hybrid inheritance.

How to Run:

1. Open the project in Eclipse using Java 21 or higher.
2. Open `Main.java` in the `app` package.
3. Right-click and select Run As → Java Application.
4. View the results in the Console.

Testing: The program was tested using valid and invalid member registrations, late-fee calculations, staff compensation, reservations, and static counters.
