package Developer.View;

import Developer.Controller.DeveloperController;
import Developer.DAO.DeveloperDAO;
import Developer.Model.Developer;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DeveloperView {
    Scanner scanner = new Scanner(System.in);
    private DeveloperController controller = new DeveloperController();
    Developer developer;
    private int scanner() {
        int num = 0;
        try {
            num = scanner.nextInt();
            if (num <= 0) {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
            System.err.println("enter the positive integer");
            scanner.next();
            num = scanner();
        }
        return num;
    }

    public void switches() {
        while (true) {
            operation();
            int operation = scanner();
            if (operation == 1) {
                List<Developer> developer = controller.readDeveloper();
                System.out.println(developer);
            } else if (operation == 2) {
                System.out.println("Enter the developers data");
                controller.saveDeveloper(developersData());
            } else if (operation == 3) {
                System.out.println("Enter developer Id");
                developer = new DeveloperDAO().getById(scanner());
                if ((developer.getId())==0){
                    System.out.println("Developer is not found.");
                }else {
                controller.upDataDeveloper(newData(developer));}
            } else if (operation == 4) {
                System.out.println("Enter Id");
                controller.getById(scanner());
            } else if (operation == 5) {
                System.out.println("Enter Id");
                controller.deleteDeveloper(scanner());
            } else break;
        }
    }

    private static void operation() {
        System.out.println("select operation");
        System.out.println("1. show oll developers");
        System.out.println("2. add developer");
        System.out.println("3. updata developer");
        System.out.println("4. find developer by ID");
        System.out.println("5. delete developer");
        System.out.println("exit. different meaning");
    }

    private Developer developersData() {
        developer= new Developer();
        System.out.println("Enter Id");
        developer.setId(scanner());
        System.out.println("Enter FirstName");
        developer.setFirstName(scanner.next());
        System.out.println("Enter LastName");
        developer.setLastName(scanner.next());
        System.out.println("Enter Specialty");
        developer.setSpecialty(scanner.next());
        System.out.println("Enter Experience");
        developer.setExperience(scanner());
        System.out.println("Enter Salary");
        developer.setSalary(new BigDecimal(scanner()));
        return developer;
    }
    private Developer newData(Developer developer){
        while (true) {
            System.out.println("what you want to updata?");
            System.out.println("1. FirstName");
            System.out.println("2. LastName");
            System.out.println("3. Specialty");
            System.out.println("4. Experience");
            System.out.println("5. Salary");
            System.out.println("exit. different meaning");
            int operation = scanner();
            if (operationsForUpData(operation)) break;
        }
        return developer;
    }

    private boolean operationsForUpData(int operation) {
        if (operation ==1 ) {
             System.out.println("Enter FirstName");
             developer.setFirstName(scanner.next());
         } else if (operation == 2) {
             System.out.println("Enter LastName");
             developer.setLastName(scanner.next());
         } else if (operation == 3) {
             System.out.println("Enter Specialty");
             developer.setSpecialty(scanner.next());
         } else if (operation ==4) {
             System.out.println("Enter Experience");
             developer.setExperience(scanner());
         } else if (operation == 5) {
             System.out.println("Enter Salary");
             developer.setSalary(new BigDecimal(scanner()));
         }
          else return true;
        return false;
    }
}