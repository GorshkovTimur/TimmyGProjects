import java.util.ArrayList;
import java.util.List;

public class HeadOfGroup implements Person, Manager,Subscriber {

    private int id;
    private String name;
    private List<Employee> subordinates;

    public HeadOfGroup(String name) {
        this.name = name;
        this.subordinates = new ArrayList<>();
    }

    @Override
    public List<Employee> getSubordinates() {
        return subordinates;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void update() {
        System.out.println(name + "Repositury changed");
    }
}
