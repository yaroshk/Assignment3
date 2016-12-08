package core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class External {
	Properties p = new Properties();

	String getPropertyOut(String prop_file, String property) throws IOException {

		p.load(new FileInputStream(prop_file));
		// p.load(ClassLoader.getSystemResourceAsStream(prop_file));

		return p.getProperty(property);

	}

	public static void main(String[] args) throws IOException {

		if (args.length == 0) {
			System.err.println("Please enter a path as an argument");
			System.exit(1);
		}

		if (!args[0].contains(".properties")) {
			System.err.println("Argument must be an properties file");
			System.exit(1);
		}

		String pf_out = args[0];
		// String pf_out = "./src/main/resources/inside.properties";

		External p = new External();

		System.out.println("Title: \t\t\t\t" + p.getPropertyOut(pf_out, "Department"));

		System.out.println("First Name: \t\t\t" + p.getPropertyOut(pf_out, "Manager_name"));

		System.out.println("Last Name: \t\t\t" + p.getPropertyOut(pf_out, "Last_name"));

		System.out.println("Current directory: \t\t" + System.getProperty("user.dir"));

		System.out.println("Properties file location: \t" + new java.io.File(pf_out).getCanonicalPath());
	}
}
