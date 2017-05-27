package com.ashu.rms.api.common.exception;

public class DaoException extends Exception{

	private static final long serialVersionUID = -5862874525770307116L;

	public DaoException() {
		super();
	}

	public DaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public DaoException(String message) {
		super(message);
	}

	public DaoException(Throwable cause) {
		super(cause);
	}
	
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		String[] s = {"a","b","c","d","e","f"};
		String str = "";
		for(int i=0; i<s.length;i++){
			str = str + s[i];
		}
		System.out.println(str);
	}
	
	
}
