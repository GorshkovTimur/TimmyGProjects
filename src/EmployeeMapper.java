import java.util.InputMismatchException;
import java.util.zip.DataFormatException;

public class EmployeeMapper {

    private JDBCEmulator emulator;

    public EmployeeMapper(JDBCEmulator emulator) {
        this.emulator = emulator;
    }

    public Employee findById(int id){
        if (id>0){
            Employee employee = new Employee(emulator.getNameFromDb(),emulator.getHeadFromDb());
            return employee;
        } else {
            throw new InputMismatchException("Id должен быть больше 0");
        }
    }

    public void delete(Employee employee){
        emulator.delete(employee);
    }



}
