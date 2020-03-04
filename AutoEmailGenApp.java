package com.emailgen;

public class AutoEmailGenApp {

	/**
	 * This is the start of AutoEmailGenerator application
	 * @param args
	 */
	public static void main(String[] args) {
		Email em1 = new Email("Dhananjay", "Rout");
		System.out.println(em1.showInfo());
	}

}
