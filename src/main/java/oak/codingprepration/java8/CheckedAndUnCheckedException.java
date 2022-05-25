package oak.codingprepration.java8;

public class CheckedAndUnCheckedException {
	
	public void storeDataFromUrl(String url,boolean flag){
        try {
            readDataFromUrl(url,flag);
        } catch (BadUrlException e) {
            e.printStackTrace();
        }
        readDataFromUrlWithRuntimeException(url,flag);
    }
	

    public String readDataFromUrl(String url,boolean flag)
    throws BadUrlException{
        if(flag){
            throw new BadUrlException("Bad URL: " + url);
        }

        String data = null;
        //read lots of data over HTTP and return
        //it as a String instance.

        return data;
    }
    public String readDataFromUrlWithRuntimeException(String url,boolean flag)
    	   {
    	        if(flag){
    	            throw new BadUrlRuntimeException("Bad URL: " + url);
    	        }

    	        String data = null;
    	        //read lots of data over HTTP and return
    	        //it as a String instance.

    	        return data;
    	    }
   

}
