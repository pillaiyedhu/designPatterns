package _10_ProxyDesignPattern;

public class ProxyMain {
    public static void main(String[] args) {
        EmployeeDao employeeDao = new EmployeeDaoProxy();
        employeeDao.create();
        employeeDao.delete("ADMIN");
        employeeDao.get();
    }
}
