package training_day1_homework.itOrganization;

public interface Interview {

    void conductInterview();
    default void makeOffer()
    {
        System.out.println("Offer");
    }
}
