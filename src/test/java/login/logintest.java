package login;

import org.testng.annotations.Test;

import demo.Base.BaseClass;

public class logintest extends BaseClass{


	
	@Test
	public void gettital() {
		String tital=driver.getTitle();
		System.out.println(tital);
	}

}
