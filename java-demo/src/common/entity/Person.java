package common.entity;




public class Person implements Comparable {
    private String name;
    private int age;
    private String gendar;

    public Person() {
    }

    public Person(String name, int age, String gendar) {
        this.name = name;
        this.age = age;
        this.gendar = gendar;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public int hashCode() {
        System.out.println("hashcode:" + this.name);
        return this.name.hashCode() + age * 37;
    }

    public String getGendar() {
        return gendar;
    }

    public void setGendar(String gendar) {
        this.gendar = gendar;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println(this+"---equal---"+obj);

        if (this == obj) {
            return true;
        }

        if (obj instanceof Person) {
            Person person = (Person) obj;
            return this.name.equals(person.name) && this.age == person.age;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Person@name "+this.name+" ,age:"+this.age;
    }


    @Override
    public int compareTo(Object o) {
        Person person = (Person) o;
        System.out.println(this + " Compare to " + person);
        if (this.age > person.age) {
            return 1;
        }

        if (this.age < person.age) {
            return -1;
        }
        return this.name.compareTo(person.name);
    }
}
