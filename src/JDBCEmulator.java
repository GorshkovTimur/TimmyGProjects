import java.sql.SQLException;

public class JDBCEmulator {

    private final String DELETE_MESSAGE = "Employee was deleted from DB";



    public String getNameFromDb(){
        return "Vasya Ivanov";
    }

    public HeadOfGroup getHeadFromDb(){
        return new HeadOfGroup("Pichugina Evgeniya");
    }


    public void insert (Employee employee){
        System.out.println(employee.getId());
        System.out.println(employee.getName());
        System.out.println(employee.getName());
    }

    public void delete(Employee employee){
        System.out.println(DELETE_MESSAGE);
    }


}
