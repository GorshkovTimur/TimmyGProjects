public class LatenessCreator extends MissconductCreator {
    @Override
    public Missconduct create(Employee employee, String date) {
        return new Lateness(employee, date);
    }
}
