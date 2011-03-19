package net.zj.hz.yk.selenium;

import com.thoughtworks.selenium.SeleneseTestCase;

public class Untitled extends SeleneseTestCase {
	public void setUp() throws Exception {
		setUp("http://www.baidu.com", "*iexplore");
	}

	public void testUntitled() throws Exception {
		selenium.open("/");
		selenium.type("kw", "杨轲");
		selenium.click("su");
		selenium.waitForPageToLoad("30000");
		selenium.click("//table[@id='4']/tbody/tr/td/a/font");
		selenium.click("//table[@id='9']/tbody/tr/td/a/font");
	}
}
