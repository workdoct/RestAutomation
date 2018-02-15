package bdd;

import net.serenitybdd.jbehave.SerenityStories;



public class RestApiMyRunner extends SerenityStories{

	@Override
	protected String getRootPackage() {
		return "step";
	}

}
