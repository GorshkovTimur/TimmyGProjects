import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.zip.DataFormatException;

public class EmployeeMapper {

    private JDBCEmulator emulator;
    private Map<Integer,Employee> employeeMap;

    public EmployeeMapper(JDBCEmulator emulator) {
        this.emulator = emulator;
        this.employeeMap = new HashMap<>();

    }

    public Employee findById(int id){
            checkId(id);
            if (employeeMap.containsKey(id)) {
                return employeeMap.get(id);
            } else {
                Employee employee = new Employee(emulator.getNameFromDb(), emulator.getHeadFromDb());
                employeeMap.put(id, employee);
                return employee;
            }

    }

    private void checkId(int id) {
        if (id<0) throw new InputMismatchException("Id must bee positive number");
    }

    public void delete(Employee employee){
        emulator.delete(employee);
    }



}
