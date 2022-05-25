package oak.codingprepration.java8.designPattern.CreationalDesignPattern;

public class EagerWayStnDesign 
{
	private static EagerWayStnDesign singleObject = new EagerWayStnDesign();
	
	private EagerWayStnDesign() {
		
	}
	
	public EagerWayStnDesign getSingletonDesignInstance()
	{
		return singleObject;
	}

}
