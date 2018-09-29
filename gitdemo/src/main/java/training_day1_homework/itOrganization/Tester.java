package training_day1_homework.itOrganization;

public class Tester extends Employee implements Testing{
    public Tester(String name, String address, String phoneNumber, Integer yearsExperience, Double salary, String facebookId) {
        super(facebookId, name, address, phoneNumber, yearsExperience, salary);
    }

    @Override
    public void test() {

    }
}
