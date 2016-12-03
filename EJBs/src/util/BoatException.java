package util;

public class BoatException extends Exception {
	

	  public BoatException() { 
		  
		  super(); 
	  }
	  public BoatException(String message) {
		  super(message); 
	  }
	  public BoatException(String message, Throwable cause) { 
		  super(message, cause);
	  }
	  
	  public BoatException(Throwable cause) { super(cause); }
	  
  }
