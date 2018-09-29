package training_day1_homework.itOrganization;

public class Employee {
    private String facebookId;
    private String name;
    private String address;
    private String phoneNumber;
    private Integer yearsExperience;
    private Double salary;
    protected OracleSystem oracleSystem;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getYearsExperience() {
        return yearsExperience;
    }

    public void setYearsExperience(Integer yearsExperience) {
        this.yearsExperience = yearsExperience;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Employee(String facebookId, String name, String address, String phoneNumber, Integer yearsExperience, Double salary) {
        this.facebookId = facebookId;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.yearsExperience = yearsExperience;
        this.salary = salary;
        oracleSystem= () -> System.out.println("Oracle System log");
    }
}
