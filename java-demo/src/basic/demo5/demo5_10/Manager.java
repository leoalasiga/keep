package basic.demo5.demo5_10;


import basic.demo5.demo5_9.Employee;

/**
 * @author ljj
 * @description
 * @date 2020-08-10
 */
public class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        this.bonus = 0;
    }


    @Override
    public double getSalary() {
        return super.getSalary()+bonus;
    }


    public void setBonus(double bonus) {
        this.bonus = bonus;
    }


    @Override
    public int hashCode() {
        return super.hashCode()+17*new Double(bonus).hashCode();
    }

    @Override
    public boolean equals(Object otherObj) {

        if (!super.equals(otherObj)) {
            return false;
        }
        Manager manager = (Manager) otherObj;
        //super.equals checked that this and other belong to the same class
        return Double.compare(manager.bonus, bonus) == 0;
    }

    @Override
    public String toString() {
        return super.toString()+ "[" +
                "bonus=" + bonus +
                ']';
    }
}
