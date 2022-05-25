package oak.codingprepration.java8;

import java.util.HashMap;

public final class ImmutableClass 
{
	private final String name;
	private final Integer number;
	private final HashMap<String,String> map;
	public ImmutableClass(String name, Integer number, HashMap<String,String> map) {
		this.name = name;
		this.number = number;
		this.map = new HashMap<String, String>(map);
	}
	public String getName() {
		return name;
	}
	public Integer getNumber() {
		return number;
	}
	public HashMap<String,String> getMap() {
		return (HashMap<String,String>) map.clone();
	}
	
	public static void main(String[] args)
	{
		String name="sehaj";
		Integer number=10;
		HashMap<String,String> map= new HashMap<String, String>();
		map.put("k1", "data1");
		ImmutableClass immutableClass=new ImmutableClass(name, number, map);
		map.put("k2", "data2");
		System.out.println(immutableClass.getMap());
	}
	
	

}
