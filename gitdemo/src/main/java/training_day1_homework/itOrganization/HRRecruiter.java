package training_day1_homework.itOrganization;

public class HRRecruiter extends Employee implements Interview{
    public HRRecruiter(String name, String address, String phoneNumber, Integer yearsExperience, Double salary, String facebookId) {
        super(facebookId, name, address, phoneNumber, yearsExperience, salary);
        oracleSystem=()-> System.out.println("CustomOracleSystem");
    }

    @Override
    public void conductInterview() {

    }
}
