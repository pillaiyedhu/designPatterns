package _10_ProxyDesignPattern;

public class EmployeeDaoProxy implements EmployeeDao{

    EmployeeDao employeeDao;

    public EmployeeDaoProxy(){
        employeeDao = new EmployeeDaoImpl();
    }

    @Override
    public void create() {
        employeeDao.create();
    }

    @Override
    public void delete(String client) {
        if(client.equals("ADMIN")){
            employeeDao.delete(client);
        }else{
            System.out.println("delete request failed");
        }
    }

    @Override
    public void get() {
        employeeDao.get();
    }
}
