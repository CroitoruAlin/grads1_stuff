package training_day1_homework.itOrganization;

public class Programmer extends Employee implements Coding {
    public Programmer(String name, String address, String phoneNumber, Integer yearsExperience, Double salary, String facebookId) {
        super(facebookId, name, address, phoneNumber, yearsExperience, salary);
    }

    @Override
    public void writeCode() {

    }
}
