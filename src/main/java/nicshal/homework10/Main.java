package nicshal.homework10;

public class Main {

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "111-222-444");
        phoneBook.add("Петров", "333-444");
        phoneBook.add("Сидоров", "345-6789");
        phoneBook.add("Иванов", "777-77-777");
        try {
            phoneBook.add(null, "111-222-444");
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            phoneBook.add("Васильев", "");
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(phoneBook.find("Иванов"));
        System.out.println(phoneBook.containsPhoneNumber("777-77-777"));
        System.out.println(phoneBook.containsPhoneNumber("343-565"));
    }

}