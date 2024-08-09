package com.cpa.idms.backend.dao.exception.entities;

public class IdmsBaseException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public IdmsBaseException() {
	}

	/**
	 * @param arg0
	 * 			Argument of String
	 */
	public IdmsBaseException(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 * 			Argument of Throwable
	 */
	public IdmsBaseException(Throwable arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 * 			Argument of String
	 * @param arg1
	 * 			Argument of Throwable
	 */
	public IdmsBaseException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * @param arg0
	 * 			Argument of String
	 * @param arg1
	 * 			Argument of Throwable
	 * @param arg2
	 * 			Argument of boolean
	 * @param arg3
	 * 			Argument of boolean
	 */
	public IdmsBaseException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	/**
	 * @param args
	 * 			Arguments of String array
	 */
	public static void main(String[] args) {

	}

}
