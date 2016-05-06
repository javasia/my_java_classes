package lesson4.checkpoint3.frame_4_3_8;


public class Person {
    
    public String name;
    public int age;
    public long salary;
    public Address address;
    
    public Person (String name, int age, long salary, Address address){
        this.name=name;
        this.age=age;
        this.salary=salary;
        this.address=address;
    }
    
    @Override
    public int hashCode(){
        int res = 25;
        
        Object[] fields = new Object[4];
        
        fields[0]= name;
        fields[1]= new Integer(age);
        fields[2]= new Long(salary);
        fields[3]= address;
        
        for (Object c:fields){
        res = 37*res + c.hashCode();
        }
        
        return res;
        
    }
    
    @Override
    public boolean equals(Object object){
        
        if (object instanceof Person){
            
        Person p = (Person) object;
        
        if (p.name!=null && p.address!=null && name.equals(p.name) && age==p.age 
        && salary == p.salary  && address.equals(p.address)){
            return true;
        }
        
        }
        return false;
    }
    
}
