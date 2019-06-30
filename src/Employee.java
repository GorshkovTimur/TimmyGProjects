public class Employee implements Person {

    private int id;
    private String name;
    private HeadOfGroup leader;


    public Employee(String name, HeadOfGroup leader) {
        this.name = name;
        this.leader = leader;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public HeadOfGroup getLeader() {
        return leader;
    }




}
