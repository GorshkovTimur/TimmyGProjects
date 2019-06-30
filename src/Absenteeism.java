public class Absenteeism implements Missconduct {

    private final int penalty = 7500;
    private Employee employee;
    private String date;

    public Absenteeism(Employee employee, String date) {
        this.employee = employee;
        this.date = date;
    }

    @Override
    public int getPenalty() {
        return penalty;
    }

    @Override
    public String getDate() {
        return date;
    }

    @Override
    public Employee gerEmployee() {
        return employee;
    }
}
