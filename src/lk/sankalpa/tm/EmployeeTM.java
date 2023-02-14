package lk.sankalpa.tm;

public class EmployeeTM {

    private String name;
    private String NIC;
    private String Address;
    private String Number;
    private String Age;
    private String Salary;
    private String JoinDate;
    private String WorkSection;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String salary) {
        Salary = salary;
    }

    public String getJoinDate() {
        return JoinDate;
    }

    public void setJoinDate(String joinDate) {
        JoinDate = joinDate;
    }

    public String getWorkSection() {
        return WorkSection;
    }

    public void setWorkSection(String workSection) {
        WorkSection = workSection;
    }

    public EmployeeTM() {
    }

    public EmployeeTM(String name, String NIC, String address, String number, String age, String salary, String joinDate, String workSection) {
        this.name = name;
        this.NIC = NIC;
        Address = address;
        Number = number;
        Age = age;
        Salary = salary;
        JoinDate = joinDate;
        WorkSection = workSection;
    }
}
