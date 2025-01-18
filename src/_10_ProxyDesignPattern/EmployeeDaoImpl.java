package _10_ProxyDesignPattern;

public class EmployeeDaoImpl implements EmployeeDao{
    @Override
    public void create() {
        System.out.println("create employeee");
    }

    @Override
    public void delete(String client) {
        System.out.println("delete employee");
    }

    @Override
    public void get() {
        System.out.println("get employee");
    }
}
