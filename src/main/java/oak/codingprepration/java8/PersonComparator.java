package oak.codingprepration.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PersonComparator 
{
	public String personId;
    public String name;
    public int age;
 

	public PersonComparator(String personId, String name, int age) {
		this.personId=personId;
		this.name=name;
		this.age=age;
	}



	public String getPersonId() {
		return personId;
	}


	public void setPersonId(String personId) {
		this.personId = personId;
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
	
	public static void main(String[] args)
	{
		List<PersonComparator> personComparator= new ArrayList<PersonComparator>();
		PersonComparator pcObj=new PersonComparator("s2810","sehaj",28);
		PersonComparator pcObj1=new PersonComparator("u2510","uplav",25);
		PersonComparator pcObj2=new PersonComparator("h2910","himanshi",29);
		personComparator.add(pcObj);
		personComparator.add(pcObj1);
		personComparator.add(pcObj2);
		System.out.println("Before Sorting:");
       personComparator.forEach(param->{
			
			System.out.println(param.getName());
		});
       System.out.println(Integer.MAX_VALUE-(-1));
		Comparator<PersonComparator> comparator = (PersonComparator p1,PersonComparator p2)-> Integer.compare(p1.getAge(),p2.getAge());
		personComparator.sort(comparator);
		System.out.println("After Sorting:");
		personComparator.forEach(param->{
			
			System.out.println(param.getName());
		});
	}

}
