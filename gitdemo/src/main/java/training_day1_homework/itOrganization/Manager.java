package training_day1_homework.itOrganization;

public class Manager extends Employee implements Leading,Interview {
    public Manager(String name, String address, String phoneNumber, Integer yearsExperience, Double salary, String facebookId) {
        super(facebookId, name, address, phoneNumber, yearsExperience, salary);
    }

    @Override
    public void conductInterview() {

    }

    @Override
    public void leadTeam() {

    }
}
