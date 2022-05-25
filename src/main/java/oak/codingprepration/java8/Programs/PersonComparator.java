package oak.codingprepration.java8.Programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonComparator implements Comparator<PersonComparator>
{
	public String personId;
    public String name;
    public int age;
 

	public PersonComparator(String personId, String name, int age) {
		this.personId=personId;
		this.name=name;
		this.age=age;
	}


	@Override
	public int compare(PersonComparator o1, PersonComparator o2) {

		return Integer.compare(o1.getAge(), o2.getAge());
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
		personComparator.sort(pcObj);
		personComparator.forEach(param->{
			
			System.out.println(param.getName());
		});
	}

}
