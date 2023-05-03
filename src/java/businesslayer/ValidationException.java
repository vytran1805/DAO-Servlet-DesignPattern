/* File: ValidationException.java
 * Author: Stanley Pieda
 * Date: 2015
 * Description: Demonstration of DAO Design Pattern with Servlet website
 */
package businesslayer;

/**
 * Validatioin exception class
 * @author VyTran
 */
public class ValidationException extends Exception {
	/**
         * constructor
         */
	public ValidationException(){
		super("Data not in valid format");
	}
	/**
         * one argument constructor
         * @param message message
         */
	public ValidationException(String message){
		super(message);
	}
	/**
         * two argument constructor
         * @param message message
         * @param throwable throwable 
         */
	public ValidationException(String message, Throwable throwable){
		super(message, throwable);
	}
	/**
         * one argument constructor
         * @param throwable throwable
         */
	public ValidationException(Throwable throwable){
		super(throwable);
	}
}
