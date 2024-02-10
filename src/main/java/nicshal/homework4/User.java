package nicshal.homework4;

public class User {

    private String lastName;
    private String firstName;
    private String patronymic;
    private int birthYear;
    private String email;

    public User(String lastName, String firstName, String patronymic, int birthYear, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.birthYear = birthYear;
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void printUser() {
        System.out.println("ФИО: " + getLastName() + getFirstName() + getPatronymic());
        System.out.println("Год рождения: " + getBirthYear());
        System.out.println("e-mail: " + getEmail());
    }

}