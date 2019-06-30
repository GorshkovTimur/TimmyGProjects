public class AbsenteeismCreator extends MissconductCreator {


    @Override
    public Missconduct create(Employee employee, String date) {
        return new Absenteeism(employee, date);
    }

}
