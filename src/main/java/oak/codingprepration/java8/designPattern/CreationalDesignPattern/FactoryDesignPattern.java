package oak.codingprepration.java8.designPattern.CreationalDesignPattern;


//Calendar.getInstance();
public class FactoryDesignPattern {
	    public Polygon getPolygon(int numberOfSides) {
	        if(numberOfSides == 0) {
	            return new Square();
	        }
	        return null;
	    }
	    
	    public static void main(String[] args)
	    {
	    	
	    	System.out.println(new FactoryDesignPattern().getPolygon(0) );
	    }

}
