package selenium_setup; // update this line based on where your test is

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver; // for chrome
import java.util.Date;

/**
 * It's always a good idea to document the versions you use. Software is updated
 * often. One major source of problems is incompatibility issue.
 * 
 * Note: (be sure to check for version compatibility - driver, selenium,
 * browser)
 * 
 * Test environment (used for this test file): Chrome version-you-use selenium
 * version-you-use Java version-you-use ChromeDriver version-you-use JUnit 5
 * 
 * To download chromedriver for selenium, visit
 * https://sites.google.com/a/chromium.org/chromedriver/downloads
 */

class final_project_test {

	private WebDriver driver;
	private String url = "http://localhost/calorie_counter/";

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\Student\\OneDrive\\Documents\\SEMESTER 7\\Software Testing\\edgedriver_win64\\msedgedriver.exe"); // configure
																																// path
																																// to
																																// the
																																// driver
		driver = new EdgeDriver(); // create an instance of the web browser and open it
		driver.get("http://localhost/calorie_counter/"); // making a test food for each
		driver.findElement(By.name("bFoodAdd")).sendKeys("test_breakfast");
		driver.findElement(By.name("bCalAdd")).sendKeys("100");
		driver.findElement(By.cssSelector("#breakfast input:nth-child(4)")).click();
		driver.get("http://localhost/calorie_counter/");
		driver.findElement(By.name("lFoodAdd")).sendKeys("test_lunch");
		driver.findElement(By.name("lCalAdd")).sendKeys("100");
		driver.findElement(By.cssSelector("#lunch input:nth-child(4)")).click();
		driver.get("http://localhost/calorie_counter/");
		driver.findElement(By.name("dFoodAdd")).sendKeys("test_dinner");
		driver.findElement(By.name("dCalAdd")).sendKeys("100");
		driver.findElement(By.cssSelector("#dinner input:nth-child(4)")).click();
		driver.get("http://localhost/calorie_counter/");
	}

	@AfterEach
	void tearDown() throws Exception { // this will delete all of the test food items each time
		driver.get("http://localhost/calorie_counter/");
		WebElement dropdown = driver.findElement(By.name("bFoodDe"));
		dropdown.findElement(By.xpath("//option[. = 'test_breakfast']")).click();
		driver.findElement(By.cssSelector("#breakfast > form:nth-child(3) > input")).click();
		driver.get("http://localhost/calorie_counter/");
		WebElement dropdown2 = driver.findElement(By.name("lFoodDe"));
		dropdown2.findElement(By.xpath("//option[. = 'test_lunch']")).click();
		driver.findElement(By.cssSelector("#lunch > form:nth-child(3) > input")).click();
		driver.get("http://localhost/calorie_counter/");
		WebElement dropdown3 = driver.findElement(By.name("dFoodDe"));
		dropdown3.findElement(By.xpath("//option[. = 'test_dinner']")).click();
		driver.findElement(By.cssSelector("#dinner > form:nth-child(3) > input")).click();
		driver.quit(); // close the browser
	}

//	This test is selects something for every meal, enters a quantity for every quantity, enters Holiday as a reason, and enters a normal weight
	@Test
	public void test_select_food_base1() { // IS SUPPOSED TO PASS
		driver.get("http://localhost/calorie_counter/selectPage.php");
		WebElement dropdown = driver.findElement(By.name("bFoodSelect"));
		dropdown.findElement(By.xpath("//option[. = 'test_breakfast']")).click();
		driver.findElement(By.name("bq")).sendKeys("1");
		WebElement dropdown2 = driver.findElement(By.name("lFoodSelect"));
		dropdown2.findElement(By.xpath("//option[. = 'test_lunch']")).click();
		driver.findElement(By.name("lq")).sendKeys("1");
		WebElement dropdown3 = driver.findElement(By.name("dFoodSelect"));
		dropdown3.findElement(By.xpath("//option[. = 'test_dinner']")).click();
		driver.findElement(By.name("dq")).sendKeys("1");
		WebElement dropdown4 = driver.findElement(By.name("reasons"));
		dropdown4.findElement(By.xpath("//option[. = 'Holiday']")).click();
		driver.findElement(By.name("weight")).sendKeys("190");
		driver.findElement(By.cssSelector("input:nth-child(25)")).click();
		assertTrue(driver.getPageSource().contains("Successfully inserted"));
	}

//	This test is selects something for every meal, enters a quantity for every quantity, enters Too much stress as a reason, and enters a normal weight
	@Test
	public void test_select_food_base2() { // IS SUPPOSED TO PASS
		driver.get("http://localhost/calorie_counter/selectPage.php");
		WebElement dropdown = driver.findElement(By.name("bFoodSelect"));
		dropdown.findElement(By.xpath("//option[. = 'test_breakfast']")).click();
		driver.findElement(By.name("bq")).sendKeys("1");
		WebElement dropdown2 = driver.findElement(By.name("lFoodSelect"));
		dropdown2.findElement(By.xpath("//option[. = 'test_lunch']")).click();
		driver.findElement(By.name("lq")).sendKeys("1");
		WebElement dropdown3 = driver.findElement(By.name("dFoodSelect"));
		dropdown3.findElement(By.xpath("//option[. = 'test_dinner']")).click();
		driver.findElement(By.name("dq")).sendKeys("1");
		WebElement dropdown4 = driver.findElement(By.name("reasons"));
		dropdown4.findElement(By.xpath("//option[. = 'Too much stress']")).click();
		driver.findElement(By.name("weight")).sendKeys("190");
		driver.findElement(By.cssSelector("input:nth-child(25)")).click();
		assertTrue(driver.getPageSource().contains("Successfully inserted"));
	}

//	This test is selects something for every meal, enters a quantity for every quantity, enters None as a reason, and enters a normal weight
	@Test
	public void test_select_food_base3() { // IS SUPPOSED TO PASS
		driver.get("http://localhost/calorie_counter/selectPage.php");
		WebElement dropdown = driver.findElement(By.name("bFoodSelect"));
		dropdown.findElement(By.xpath("//option[. = 'test_breakfast']")).click();
		driver.findElement(By.name("bq")).sendKeys("1");
		WebElement dropdown2 = driver.findElement(By.name("lFoodSelect"));
		dropdown2.findElement(By.xpath("//option[. = 'test_lunch']")).click();
		driver.findElement(By.name("lq")).sendKeys("1");
		WebElement dropdown3 = driver.findElement(By.name("dFoodSelect"));
		dropdown3.findElement(By.xpath("//option[. = 'test_dinner']")).click();
		driver.findElement(By.name("dq")).sendKeys("1");
		WebElement dropdown4 = driver.findElement(By.name("reasons"));
		dropdown4.findElement(By.xpath("//option[. = 'None']")).click();
		driver.findElement(By.name("weight")).sendKeys("190");
		driver.findElement(By.cssSelector("input:nth-child(25)")).click();
		assertTrue(driver.getPageSource().contains("Successfully inserted"));
	}

//	This test is selects something for every meal, enters a quantity for every quantity, does not enter a reason, and enters a normal weight
	@Test
	public void test_select_food_no_reason() { // IS SUPPOSED TO PASS
		driver.get("http://localhost/calorie_counter/selectPage.php");
		WebElement dropdown = driver.findElement(By.name("bFoodSelect"));
		dropdown.findElement(By.xpath("//option[. = 'test_breakfast']")).click();
		driver.findElement(By.name("bq")).sendKeys("1");
		WebElement dropdown2 = driver.findElement(By.name("lFoodSelect"));
		dropdown2.findElement(By.xpath("//option[. = 'test_lunch']")).click();
		driver.findElement(By.name("lq")).sendKeys("1");
		WebElement dropdown3 = driver.findElement(By.name("dFoodSelect"));
		dropdown3.findElement(By.xpath("//option[. = 'test_dinner']")).click();
		driver.findElement(By.name("dq")).sendKeys("1");
		driver.findElement(By.name("weight")).sendKeys("190");
		driver.findElement(By.cssSelector("input:nth-child(25)")).click();
		assertTrue(driver.getPageSource().contains("Successfully inserted"));
	}

	@Test
	public void test_select_food_all_empty() { // IS SUPPOSED TO PASS
		driver.get("http://localhost/calorie_counter/selectPage.php");
		driver.findElement(By.cssSelector("input:nth-child(25)")).click();
		assertFalse(driver.getPageSource().contains("Successfully inserted"));// This should probably give a multiply by
																				// 0 error but
	}

	@Test
	public void test_select_food_empty_dropdowns() {// FAIL
		driver.get("http://localhost/calorie_counter/selectPage.php");
		driver.findElement(By.name("bq")).sendKeys("1");
		driver.findElement(By.name("lq")).sendKeys("1");
		driver.findElement(By.name("dq")).sendKeys("1");
		WebElement dropdown4 = driver.findElement(By.name("reasons"));
		dropdown4.findElement(By.xpath("//option[. = 'Holiday']")).click();
		driver.findElement(By.name("weight")).sendKeys("190");
		driver.findElement(By.cssSelector("input:nth-child(25)")).click();
		assertFalse(driver.getPageSource().contains("Successfully inserted"));
	}

	@Test
	public void test_select_food_negative_values() {// FAIL
		driver.get("http://localhost/calorie_counter/selectPage.php");
		WebElement dropdown = driver.findElement(By.name("bFoodSelect"));
		dropdown.findElement(By.xpath("//option[. = 'test_breakfast']")).click();
		driver.findElement(By.name("bq")).sendKeys("-1");
		WebElement dropdown2 = driver.findElement(By.name("lFoodSelect"));
		dropdown2.findElement(By.xpath("//option[. = 'test_lunch']")).click();
		driver.findElement(By.name("lq")).sendKeys("-1");
		WebElement dropdown3 = driver.findElement(By.name("dFoodSelect"));
		dropdown3.findElement(By.xpath("//option[. = 'test_dinner']")).click();
		driver.findElement(By.name("dq")).sendKeys("-1");
		WebElement dropdown4 = driver.findElement(By.name("reasons"));
		dropdown4.findElement(By.xpath("//option[. = 'Holiday']")).click();
		driver.findElement(By.name("weight")).sendKeys("190");
		driver.findElement(By.cssSelector("input:nth-child(25)")).click();
		assertFalse(driver.getPageSource().contains("Successfully inserted")); // should really be false because it
																				// should check for negative values.
	}

	@Test
	public void test_select_food_zero() { // IS SUPPOSED TO PASS
		driver.get("http://localhost/calorie_counter/selectPage.php");
		WebElement dropdown = driver.findElement(By.name("bFoodSelect"));
		dropdown.findElement(By.xpath("//option[. = 'test_breakfast']")).click();
		driver.findElement(By.name("bq")).sendKeys("0");
		WebElement dropdown2 = driver.findElement(By.name("lFoodSelect"));
		dropdown2.findElement(By.xpath("//option[. = 'test_lunch']")).click();
		driver.findElement(By.name("lq")).sendKeys("0");
		WebElement dropdown3 = driver.findElement(By.name("dFoodSelect"));
		dropdown3.findElement(By.xpath("//option[. = 'test_dinner']")).click();
		driver.findElement(By.name("dq")).sendKeys("0");
		WebElement dropdown4 = driver.findElement(By.name("reasons"));
		dropdown4.findElement(By.xpath("//option[. = 'Holiday']")).click();
		driver.findElement(By.name("weight")).sendKeys("190");
		driver.findElement(By.cssSelector("input:nth-child(25)")).click();
		assertTrue(driver.getPageSource().contains("Successfully inserted")); // this should stay true because you
																				// should be able to have amount 0.
	}

	@Test
	public void test_select_food_zero_weight() { // FAIL
		driver.get("http://localhost/calorie_counter/selectPage.php");
		WebElement dropdown = driver.findElement(By.name("bFoodSelect"));
		dropdown.findElement(By.xpath("//option[. = 'test_breakfast']")).click();
		driver.findElement(By.name("bq")).sendKeys("1");
		WebElement dropdown2 = driver.findElement(By.name("lFoodSelect"));
		dropdown2.findElement(By.xpath("//option[. = 'test_lunch']")).click();
		driver.findElement(By.name("lq")).sendKeys("1");
		WebElement dropdown3 = driver.findElement(By.name("dFoodSelect"));
		dropdown3.findElement(By.xpath("//option[. = 'test_dinner']")).click();
		driver.findElement(By.name("dq")).sendKeys("1");
		WebElement dropdown4 = driver.findElement(By.name("reasons"));
		dropdown4.findElement(By.xpath("//option[. = 'Holiday']")).click();
		driver.findElement(By.name("weight")).sendKeys("0");
		driver.findElement(By.cssSelector("input:nth-child(25)")).click();
		assertFalse(driver.getPageSource().contains("Successfully inserted"));
	}

	@Test
	public void test_select_food_negative_weight() { // FAIL
		driver.get("http://localhost/calorie_counter/selectPage.php");
		WebElement dropdown = driver.findElement(By.name("bFoodSelect"));
		dropdown.findElement(By.xpath("//option[. = 'test_breakfast']")).click();
		driver.findElement(By.name("bq")).sendKeys("1");
		WebElement dropdown2 = driver.findElement(By.name("lFoodSelect"));
		dropdown2.findElement(By.xpath("//option[. = 'test_lunch']")).click();
		driver.findElement(By.name("lq")).sendKeys("1");
		WebElement dropdown3 = driver.findElement(By.name("dFoodSelect"));
		dropdown3.findElement(By.xpath("//option[. = 'test_dinner']")).click();
		driver.findElement(By.name("dq")).sendKeys("1");
		WebElement dropdown4 = driver.findElement(By.name("reasons"));
		dropdown4.findElement(By.xpath("//option[. = 'Holiday']")).click();
		driver.findElement(By.name("weight")).sendKeys("-1");
		driver.findElement(By.cssSelector("input:nth-child(25)")).click();
		assertFalse(driver.getPageSource().contains("Successfully inserted"));
	}

	@Test
	public void test_select_food_sqli() { // FAIL
		driver.get("http://localhost/calorie_counter/selectPage.php");
		WebElement dropdown = driver.findElement(By.name("bFoodSelect"));
		dropdown.findElement(By.xpath("//option[. = 'test_breakfast']")).click();
		driver.findElement(By.name("bq")).sendKeys("1");
		WebElement dropdown2 = driver.findElement(By.name("lFoodSelect"));
		dropdown2.findElement(By.xpath("//option[. = 'test_lunch']")).click();
		driver.findElement(By.name("lq")).sendKeys("1");
		WebElement dropdown3 = driver.findElement(By.name("dFoodSelect"));
		dropdown3.findElement(By.xpath("//option[. = 'test_dinner']")).click();
		driver.findElement(By.name("dq")).sendKeys("1");
		WebElement dropdown4 = driver.findElement(By.name("reasons"));
		dropdown4.findElement(By.xpath("//option[. = `I'm feeling unwell`]")).click();
		driver.findElement(By.name("weight")).sendKeys("0");
		driver.findElement(By.cssSelector("input:nth-child(25)")).click();
		assertTrue(driver.getPageSource().contains("Successfully inserted"));
	}

	@Test
	public void test_goal_negative() { // FAIL
		driver.get("http://localhost/calorie_counter/selectPage.php");
		WebElement dropdown = driver.findElement(By.name("bFoodSelect"));
		dropdown.findElement(By.xpath("//option[. = 'test_breakfast']")).click();
		driver.findElement(By.name("bq")).sendKeys("1");
		WebElement dropdown2 = driver.findElement(By.name("lFoodSelect"));
		dropdown2.findElement(By.xpath("//option[. = 'test_lunch']")).click();
		driver.findElement(By.name("lq")).sendKeys("1");
		WebElement dropdown3 = driver.findElement(By.name("dFoodSelect"));
		dropdown3.findElement(By.xpath("//option[. = 'test_dinner']")).click();
		driver.findElement(By.name("dq")).sendKeys("1");
		WebElement dropdown4 = driver.findElement(By.name("reasons"));
		dropdown4.findElement(By.xpath("//option[. = 'Holiday']")).click();
		driver.findElement(By.name("weight")).sendKeys("190");
		driver.findElement(By.cssSelector("input:nth-child(25)")).click();
		driver.get("http://localhost/calorie_counter/goalPage.php");
		driver.findElement(By.name("goal")).sendKeys("-5");
		driver.findElement(By.cssSelector("input:nth-child(3)")).click();
		assertFalse(driver.getPageSource().contains("calorie intake today"));
	}

	@Test
	public void test_goal_zero() { // FAIL
		driver.get("http://localhost/calorie_counter/selectPage.php");
		WebElement dropdown = driver.findElement(By.name("bFoodSelect"));
		dropdown.findElement(By.xpath("//option[. = 'test_breakfast']")).click();
		driver.findElement(By.name("bq")).sendKeys("1");
		WebElement dropdown2 = driver.findElement(By.name("lFoodSelect"));
		dropdown2.findElement(By.xpath("//option[. = 'test_lunch']")).click();
		driver.findElement(By.name("lq")).sendKeys("1");
		WebElement dropdown3 = driver.findElement(By.name("dFoodSelect"));
		dropdown3.findElement(By.xpath("//option[. = 'test_dinner']")).click();
		driver.findElement(By.name("dq")).sendKeys("1");
		WebElement dropdown4 = driver.findElement(By.name("reasons"));
		dropdown4.findElement(By.xpath("//option[. = 'Holiday']")).click();
		driver.findElement(By.name("weight")).sendKeys("190");
		driver.findElement(By.cssSelector("input:nth-child(25)")).click();
		driver.get("http://localhost/calorie_counter/goalPage.php");
		driver.findElement(By.name("goal")).sendKeys("0");
		driver.findElement(By.cssSelector("input:nth-child(3)")).click();
		assertFalse(driver.getPageSource().contains("calorie intake today"));
	}

	@Test
	public void test_goal_less_than() { // IS SUPPOSED TO PASS BUT WILL SOMETIMES NOT BECAUSE IT SELECTS BACKEND BY DATE
		driver.get("http://localhost/calorie_counter/selectPage.php");
		WebElement dropdown = driver.findElement(By.name("bFoodSelect"));
		dropdown.findElement(By.xpath("//option[. = 'test_breakfast']")).click();
		driver.findElement(By.name("bq")).sendKeys("1");
		WebElement dropdown2 = driver.findElement(By.name("lFoodSelect"));
		dropdown2.findElement(By.xpath("//option[. = 'test_lunch']")).click();
		driver.findElement(By.name("lq")).sendKeys("1");
		WebElement dropdown3 = driver.findElement(By.name("dFoodSelect"));
		dropdown3.findElement(By.xpath("//option[. = 'test_dinner']")).click();
		driver.findElement(By.name("dq")).sendKeys("1");
		WebElement dropdown4 = driver.findElement(By.name("reasons"));
		dropdown4.findElement(By.xpath("//option[. = 'Holiday']")).click();
		driver.findElement(By.name("weight")).sendKeys("190");
		driver.findElement(By.cssSelector("input:nth-child(25)")).click();
		driver.get("http://localhost/calorie_counter/goalPage.php");
		driver.findElement(By.name("goal")).sendKeys("20");
		driver.findElement(By.cssSelector("input:nth-child(3)")).click();
		assertTrue(driver.getPageSource().contains("try to eat less tomorrow"));
	}

	@Test
	public void test_goal_equal_to() { // IS SUPPOSED TO PASS BUT WILL SOMETIMES NOT BECAUSE IT SELECTS BACKEND BY DATE
		driver.get("http://localhost/calorie_counter/selectPage.php");
		WebElement dropdown = driver.findElement(By.name("bFoodSelect"));
		dropdown.findElement(By.xpath("//option[. = 'test_breakfast']")).click();
		driver.findElement(By.name("bq")).sendKeys("1");
		WebElement dropdown2 = driver.findElement(By.name("lFoodSelect"));
		dropdown2.findElement(By.xpath("//option[. = 'test_lunch']")).click();
		driver.findElement(By.name("lq")).sendKeys("1");
		WebElement dropdown3 = driver.findElement(By.name("dFoodSelect"));
		dropdown3.findElement(By.xpath("//option[. = 'test_dinner']")).click();
		driver.findElement(By.name("dq")).sendKeys("1");
		WebElement dropdown4 = driver.findElement(By.name("reasons"));
		dropdown4.findElement(By.xpath("//option[. = 'Holiday']")).click();
		driver.findElement(By.name("weight")).sendKeys("190");
		driver.findElement(By.cssSelector("input:nth-child(25)")).click();
		driver.get("http://localhost/calorie_counter/goalPage.php");
		driver.findElement(By.name("goal")).sendKeys("300");
		driver.findElement(By.cssSelector("input:nth-child(3)")).click();
		assertTrue(driver.getPageSource().contains("try to eat less tomorrow"));
	}

	@Test
	public void test_goal_greater_than() { // IS SUPPOSED TO PASS
		driver.get("http://localhost/calorie_counter/selectPage.php");
		WebElement dropdown = driver.findElement(By.name("bFoodSelect"));
		dropdown.findElement(By.xpath("//option[. = 'test_breakfast']")).click();
		driver.findElement(By.name("bq")).sendKeys("1");
		WebElement dropdown2 = driver.findElement(By.name("lFoodSelect"));
		dropdown2.findElement(By.xpath("//option[. = 'test_lunch']")).click();
		driver.findElement(By.name("lq")).sendKeys("1");
		WebElement dropdown3 = driver.findElement(By.name("dFoodSelect"));
		dropdown3.findElement(By.xpath("//option[. = 'test_dinner']")).click();
		driver.findElement(By.name("dq")).sendKeys("1");
		WebElement dropdown4 = driver.findElement(By.name("reasons"));
		dropdown4.findElement(By.xpath("//option[. = 'Holiday']")).click();
		driver.findElement(By.name("weight")).sendKeys("190");
		driver.findElement(By.cssSelector("input:nth-child(25)")).click();
		driver.get("http://localhost/calorie_counter/goalPage.php");
		driver.findElement(By.name("goal")).sendKeys("301");
		driver.findElement(By.cssSelector("input:nth-child(3)")).click();
		assertTrue(driver.getPageSource().contains("you've reached your goal!"));
	}

	@Test
	public void test_result_page_1() { // IS SUPPOSED TO PASS
		driver.get("http://localhost/calorie_counter/selectPage.php");
		WebElement dropdown = driver.findElement(By.name("bFoodSelect"));
		dropdown.findElement(By.xpath("//option[. = 'test_breakfast']")).click();
		driver.findElement(By.name("bq")).sendKeys("1");
		WebElement dropdown2 = driver.findElement(By.name("lFoodSelect"));
		dropdown2.findElement(By.xpath("//option[. = 'test_lunch']")).click();
		driver.findElement(By.name("lq")).sendKeys("1");
		WebElement dropdown3 = driver.findElement(By.name("dFoodSelect"));
		dropdown3.findElement(By.xpath("//option[. = 'test_dinner']")).click();
		driver.findElement(By.name("dq")).sendKeys("1");
		WebElement dropdown4 = driver.findElement(By.name("reasons"));
		dropdown4.findElement(By.xpath("//option[. = 'Holiday']")).click();
		driver.findElement(By.name("weight")).sendKeys("190");
		driver.findElement(By.cssSelector("input:nth-child(25)")).click();
		driver.get("http://localhost/calorie_counter/resultPage.php");
		WebElement dropdown5 = driver.findElement(By.name("days"));
		dropdown5.findElement(By.xpath("//option[. = '1']")).click();
		driver.findElement(By.cssSelector("input")).click();
		assertTrue(driver.getPageSource().contains("2022")); // could change this to pull the current date in that
																// format
	}

	@Test
	public void test_result_page_3() { // IS SUPPOSED TO PASS
		driver.get("http://localhost/calorie_counter/selectPage.php");
		WebElement dropdown = driver.findElement(By.name("bFoodSelect"));
		dropdown.findElement(By.xpath("//option[. = 'test_breakfast']")).click();
		driver.findElement(By.name("bq")).sendKeys("1");
		WebElement dropdown2 = driver.findElement(By.name("lFoodSelect"));
		dropdown2.findElement(By.xpath("//option[. = 'test_lunch']")).click();
		driver.findElement(By.name("lq")).sendKeys("1");
		WebElement dropdown3 = driver.findElement(By.name("dFoodSelect"));
		dropdown3.findElement(By.xpath("//option[. = 'test_dinner']")).click();
		driver.findElement(By.name("dq")).sendKeys("1");
		WebElement dropdown4 = driver.findElement(By.name("reasons"));
		dropdown4.findElement(By.xpath("//option[. = 'Holiday']")).click();
		driver.findElement(By.name("weight")).sendKeys("190");
		driver.findElement(By.cssSelector("input:nth-child(25)")).click();
		driver.get("http://localhost/calorie_counter/resultPage.php");
		WebElement dropdown5 = driver.findElement(By.name("days"));
		dropdown5.findElement(By.xpath("//option[. = '3']")).click();
		driver.findElement(By.cssSelector("input")).click();
		assertTrue(driver.getPageSource().contains("2022")); // could change this to pull the current date in that
																// format
	}

	@Test
	public void test_result_page_7() { // IS SUPPOSED TO PASS
		driver.get("http://localhost/calorie_counter/selectPage.php");
		WebElement dropdown = driver.findElement(By.name("bFoodSelect"));
		dropdown.findElement(By.xpath("//option[. = 'test_breakfast']")).click();
		driver.findElement(By.name("bq")).sendKeys("1");
		WebElement dropdown2 = driver.findElement(By.name("lFoodSelect"));
		dropdown2.findElement(By.xpath("//option[. = 'test_lunch']")).click();
		driver.findElement(By.name("lq")).sendKeys("1");
		WebElement dropdown3 = driver.findElement(By.name("dFoodSelect"));
		dropdown3.findElement(By.xpath("//option[. = 'test_dinner']")).click();
		driver.findElement(By.name("dq")).sendKeys("1");
		WebElement dropdown4 = driver.findElement(By.name("reasons"));
		dropdown4.findElement(By.xpath("//option[. = 'Holiday']")).click();
		driver.findElement(By.name("weight")).sendKeys("190");
		driver.findElement(By.cssSelector("input:nth-child(25)")).click();
		driver.get("http://localhost/calorie_counter/resultPage.php");
		WebElement dropdown5 = driver.findElement(By.name("days"));
		dropdown5.findElement(By.xpath("//option[. = '7']")).click();
		driver.findElement(By.cssSelector("input")).click();
		assertTrue(driver.getPageSource().contains("2022")); // could change this to pull the current date in that
																// format
	}

	@Test
	public void test_result_page_10() { // IS SUPPOSED TO PASS
		driver.get("http://localhost/calorie_counter/selectPage.php");
		WebElement dropdown = driver.findElement(By.name("bFoodSelect"));
		dropdown.findElement(By.xpath("//option[. = 'test_breakfast']")).click();
		driver.findElement(By.name("bq")).sendKeys("1");
		WebElement dropdown2 = driver.findElement(By.name("lFoodSelect"));
		dropdown2.findElement(By.xpath("//option[. = 'test_lunch']")).click();
		driver.findElement(By.name("lq")).sendKeys("1");
		WebElement dropdown3 = driver.findElement(By.name("dFoodSelect"));
		dropdown3.findElement(By.xpath("//option[. = 'test_dinner']")).click();
		driver.findElement(By.name("dq")).sendKeys("1");
		WebElement dropdown4 = driver.findElement(By.name("reasons"));
		dropdown4.findElement(By.xpath("//option[. = 'Holiday']")).click();
		driver.findElement(By.name("weight")).sendKeys("190");
		driver.findElement(By.cssSelector("input:nth-child(25)")).click();
		driver.get("http://localhost/calorie_counter/resultPage.php");
		WebElement dropdown5 = driver.findElement(By.name("days"));
		dropdown5.findElement(By.xpath("//option[. = '10']")).click();
		driver.findElement(By.cssSelector("input")).click();
		assertTrue(driver.getPageSource().contains("2022")); // could change this to pull the current date in that
																// format
	}

	@Test
	public void test_result_page_30() { // IS SUPPOSED TO PASS
		driver.get("http://localhost/calorie_counter/selectPage.php");
		WebElement dropdown = driver.findElement(By.name("bFoodSelect"));
		dropdown.findElement(By.xpath("//option[. = 'test_breakfast']")).click();
		driver.findElement(By.name("bq")).sendKeys("1");
		WebElement dropdown2 = driver.findElement(By.name("lFoodSelect"));
		dropdown2.findElement(By.xpath("//option[. = 'test_lunch']")).click();
		driver.findElement(By.name("lq")).sendKeys("1");
		WebElement dropdown3 = driver.findElement(By.name("dFoodSelect"));
		dropdown3.findElement(By.xpath("//option[. = 'test_dinner']")).click();
		driver.findElement(By.name("dq")).sendKeys("1");
		WebElement dropdown4 = driver.findElement(By.name("reasons"));
		dropdown4.findElement(By.xpath("//option[. = 'Holiday']")).click();
		driver.findElement(By.name("weight")).sendKeys("190");
		driver.findElement(By.cssSelector("input:nth-child(25)")).click();
		driver.get("http://localhost/calorie_counter/resultPage.php");
		WebElement dropdown5 = driver.findElement(By.name("days"));
		dropdown5.findElement(By.xpath("//option[. = '30']")).click();
		driver.findElement(By.cssSelector("input")).click();
		assertTrue(driver.getPageSource().contains("2022")); // could change this to pull the current date in that
																// format
	}

	/*
	 * This test submits a positive number in the calorie field for breakfast but
	 * not a food item with it. It should not be inserted without a food item.
	 */
	@Test
	public void test_emptyPositiveCaloriesBreakfast() {
		driver.findElement(By.name("bCalAdd")).click();
		driver.findElement(By.name("bCalAdd")).sendKeys("100");
		driver.findElement(By.cssSelector("#breakfast input:nth-child(4)")).click();
		String expected_output = "Successfully inserted";
		// should NOT be inserted
		assertFalse(driver.getPageSource().contains(expected_output));
	}

	/*
	 * This test submits a positive number in the calorie field for lunch but not a
	 * food item with it. It should not be inserted without a food item.
	 */
	@Test
	public void test_emptyPositiveCaloriesLunch() {
		driver.findElement(By.name("lFoodAdd")).click();
		driver.findElement(By.name("lCalAdd")).sendKeys("100");
		driver.findElement(By.cssSelector("#lunch input:nth-child(4)")).click();
		String expected_output = "Successfully inserted";
		// should NOT be inserted
		assertFalse(driver.getPageSource().contains(expected_output));
	}

	/*
	 * This test submits a positive number in the calorie field for dinner but not a
	 * food item with it. It should not be inserted without a food item.
	 */
	@Test
	public void test_emptyPositiveCaloriesDinner() {
		driver.findElement(By.name("dFoodAdd")).click();
		driver.findElement(By.name("dCalAdd")).sendKeys("100");
		driver.findElement(By.cssSelector("#dinner input:nth-child(4)")).click();
		String expected_output = "Successfully inserted";
		// should NOT be inserted
		assertFalse(driver.getPageSource().contains(expected_output));
	}

	/*
	 * This test submits a negative number in the calorie field for breakfast but
	 * not a food item with it. It should not be inserted without a food item.
	 */
	@Test
	public void test_emptyNegativeCaloriesBreakfast() {
		driver.findElement(By.name("bFoodAdd")).click();
		driver.findElement(By.name("bCalAdd")).sendKeys("-100");
		driver.findElement(By.cssSelector("#breakfast input:nth-child(4)")).click();
		String expected_output = "Successfully inserted";
		// should NOT be inserted
		assertFalse(driver.getPageSource().contains(expected_output));
	}

	/*
	 * This test submits a negative number in the calorie field for lunch but not a
	 * food item with it. It should not be inserted without a food item.
	 */
	@Test
	public void test_emptyNegativeCaloriesLunch() {
		driver.findElement(By.name("lFoodAdd")).click();
		driver.findElement(By.name("lCalAdd")).sendKeys("-100");
		driver.findElement(By.cssSelector("#lunch input:nth-child(4)")).click();
		String expected_output = "Successfully inserted";
		// should NOT be inserted
		assertFalse(driver.getPageSource().contains(expected_output));
	}

	/*
	 * This test submits a negative number in the calorie field for dinner but not a
	 * food item with it. It should not be inserted without a food item.
	 */
	@Test
	public void test_emptyNegativeCaloriesDinner() {
		driver.findElement(By.name("dFoodAdd")).click();
		driver.findElement(By.name("dCalAdd")).sendKeys("-100");
		driver.findElement(By.cssSelector("#dinner input:nth-child(4)")).click();
		String expected_output = "Successfully inserted";
		// should NOT be inserted
		assertFalse(driver.getPageSource().contains(expected_output));
	}

	/*
	 * This test submits a 0 in the calorie field for breakfast but not a food item
	 * with it. It should not be inserted without a food item.
	 */
	@Test
	public void test_emptyZeroCaloriesBreakfast() {
		driver.findElement(By.name("bFoodAdd")).click();
		driver.findElement(By.name("bCalAdd")).sendKeys("0");
		driver.findElement(By.cssSelector("#breakfast input:nth-child(4)")).click();
		String expected_output = "Successfully inserted";
		// should NOT be inserted
		assertFalse(driver.getPageSource().contains(expected_output));
	}

	/*
	 * This test submits a 0 in the calorie field for lunch but not a food item with
	 * it. It should not be inserted without a food item.
	 */
	@Test
	public void test_emptyZeroCaloriesLunch() {
		driver.findElement(By.name("lFoodAdd")).click();
		driver.findElement(By.name("lCalAdd")).sendKeys("0");
		driver.findElement(By.cssSelector("#lunch input:nth-child(4)")).click();
		String expected_output = "Successfully inserted";
		// should NOT be inserted
		assertFalse(driver.getPageSource().contains(expected_output));
	}

	/*
	 * This test submits a 0 in the calorie field for dinner but not a food item
	 * with it. It should not be inserted without a food item.
	 */
	@Test
	public void test_emptyZeroCaloriesDinner() {
		driver.findElement(By.name("dFoodAdd")).click();
		driver.findElement(By.name("dCalAdd")).sendKeys("0");
		driver.findElement(By.cssSelector("#dinner input:nth-child(4)")).click();
		String expected_output = "Successfully inserted";
		// should NOT be inserted
		assertFalse(driver.getPageSource().contains(expected_output));
	}

	/*
	 * This test submits a negative in the calorie field for breakfast and a food
	 * item with it. It should not be inserted with a negative calorie value.
	 */
	@Test
	public void test_foodNegativeCaloriesBreakfast() {
		driver.findElement(By.name("bFoodAdd")).click();
		driver.findElement(By.name("bFoodAdd")).sendKeys("bacon");
		driver.findElement(By.name("bCalAdd")).click();
		driver.findElement(By.name("bCalAdd")).sendKeys("-100");
		driver.findElement(By.cssSelector("#breakfast input:nth-child(4)")).click();
		String expected_output = "Successfully inserted";
		// should NOT be inserted
		assertFalse(driver.getPageSource().contains(expected_output));
	}

	/*
	 * This test submits a negative in the calorie field for lunch and a food item
	 * with it. It should not be inserted with a negative calorie value.
	 */
	@Test
	public void test_foodNegativeCaloriesLunch() {
		driver.findElement(By.name("lFoodAdd")).click();
		driver.findElement(By.name("lFoodAdd")).sendKeys("salad");
		driver.findElement(By.name("lCalAdd")).click();
		driver.findElement(By.name("lCalAdd")).sendKeys("-100");
		driver.findElement(By.cssSelector("#lunch input:nth-child(4)")).click();
		String expected_output = "Successfully inserted";
		// should NOT be inserted
		assertFalse(driver.getPageSource().contains(expected_output));
	}

	/*
	 * This test submits a negative in the calorie field for dinner and a food item
	 * with it. It should not be inserted with a negative calorie value.
	 */
	@Test
	public void test_foodNegativeCaloriesDinner() {
		driver.findElement(By.name("dFoodAdd")).click();
		driver.findElement(By.name("dFoodAdd")).sendKeys("sushi");
		driver.findElement(By.name("dCalAdd")).click();
		driver.findElement(By.name("dCalAdd")).sendKeys("-100");
		driver.findElement(By.cssSelector("#dinner input:nth-child(4)")).click();
		String expected_output = "Successfully inserted";
		// should NOT be inserted
		assertFalse(driver.getPageSource().contains(expected_output));
	}

	/*
	 * This test submits a positive number in the calorie field for breakfast and a
	 * food item with it. It should be inserted normally.
	 */
	@Test
	public void test_foodPositiveCaloriesBreakfast() {
		driver.findElement(By.name("bFoodAdd")).click();
		driver.findElement(By.name("bFoodAdd")).sendKeys("bacon");
		driver.findElement(By.name("bCalAdd")).click();
		driver.findElement(By.name("bCalAdd")).sendKeys("100");
		driver.findElement(By.cssSelector("#breakfast input:nth-child(4)")).click();
		String expected_output = "Successfully inserted";
		// should be inserted!!!!
		assertTrue(driver.getPageSource().contains(expected_output));
	}

	/*
	 * This test submits a positive number in the calorie field for lunch and a food
	 * item with it. It should be inserted normally.
	 */
	@Test
	public void test_foodPositiveCaloriesLunch() {
		driver.findElement(By.name("lFoodAdd")).click();
		driver.findElement(By.name("lFoodAdd")).sendKeys("salad");
		driver.findElement(By.name("lCalAdd")).click();
		driver.findElement(By.name("lCalAdd")).sendKeys("100");
		driver.findElement(By.cssSelector("#lunch input:nth-child(4)")).click();
		String expected_output = "Successfully inserted";
		// should be inserted!!!!
		assertTrue(driver.getPageSource().contains(expected_output));
	}

	/*
	 * This test submits a positive number in the calorie field for dinner and a
	 * food item with it. It should be inserted normally.
	 */
	@Test
	public void test_foodPositiveCaloriesDinner() {
		driver.findElement(By.name("dFoodAdd")).click();
		driver.findElement(By.name("dFoodAdd")).sendKeys("sushi");
		driver.findElement(By.name("dCalAdd")).click();
		driver.findElement(By.name("dCalAdd")).sendKeys("100");
		driver.findElement(By.cssSelector("#dinner input:nth-child(4)")).click();
		String expected_output = "Successfully inserted";
		// should be inserted!!!!
		assertTrue(driver.getPageSource().contains(expected_output));
	}

	/*
	 * This test submits a 0 in the calorie field for breakfast and a food item with
	 * it. It should be inserted normally.
	 */
	@Test
	public void test_foodZeroCaloriesBreakfast() {
		driver.findElement(By.name("bFoodAdd")).click();
		driver.findElement(By.name("bFoodAdd")).sendKeys("bacon");
		driver.findElement(By.name("bCalAdd")).click();
		driver.findElement(By.name("bCalAdd")).sendKeys("0");
		driver.findElement(By.cssSelector("#breakfast input:nth-child(4)")).click();
		String expected_output = "Successfully inserted";
		// should be inserted!!!!
		assertTrue(driver.getPageSource().contains(expected_output));
	}

	/*
	 * This test submits a 0 in the calorie field for lunch and a food item with it.
	 * It should be inserted normally.
	 */
	@Test
	public void test_foodZeroCaloriesLunch() {
		driver.findElement(By.name("lFoodAdd")).click();
		driver.findElement(By.name("lFoodAdd")).sendKeys("salad");
		driver.findElement(By.name("lCalAdd")).click();
		driver.findElement(By.name("lCalAdd")).sendKeys("0");
		driver.findElement(By.cssSelector("#lunch input:nth-child(4)")).click();
		String expected_output = "Successfully inserted";
		// should be inserted!!!!
		assertTrue(driver.getPageSource().contains(expected_output));
	}

	/*
	 * This test submits a 0 in the calorie field for dinner and a food item with
	 * it. It should be inserted normally.
	 */
	@Test
	public void test_foodZeroCaloriesDinner() {
		driver.findElement(By.name("dFoodAdd")).click();
		driver.findElement(By.name("dFoodAdd")).sendKeys("sushi");
		driver.findElement(By.name("dCalAdd")).click();
		driver.findElement(By.name("dCalAdd")).sendKeys("0");
		driver.findElement(By.cssSelector("#dinner input:nth-child(4)")).click();
		String expected_output = "Successfully inserted";
		// should be inserted!!!!
		assertTrue(driver.getPageSource().contains(expected_output));
	}

	// TESTING DELETE
	/*
	 * This test tries to delete something when there is nothing in the database.
	 * Nothing should be successfully deleted.
	 */
	@Test
	public void test_deleteEmptyBreakfast() {
		driver.findElement(By.name("bFoodDe")).click();
		driver.findElement(By.cssSelector("#breakfast > form:nth-child(3) > input")).click();
		String expected_output = "Successfully deleted";
		// should not say it was deleted
		assertFalse(driver.getPageSource().contains(expected_output));
	}

	/*
	 * This test tries to delete something when there is nothing in the database.
	 * Nothing should be successfully deleted.
	 */
	@Test
	public void test_deleteEmptyLunch() {
		driver.findElement(By.name("lFoodDe")).click();
		driver.findElement(By.cssSelector("#lunch > form:nth-child(3) > input")).click();
		String expected_output = "Successfully deleted";
		// should not say it was deleted
		assertFalse(driver.getPageSource().contains(expected_output));
	}

	/*
	 * This test tries to delete something when there is nothing in the database.
	 * Nothing should be successfully deleted.
	 */
	@Test
	public void test_deleteEmptyDinner() {
		driver.findElement(By.name("dFoodDe")).click();
		driver.findElement(By.cssSelector("#dinner > form:nth-child(3) > input")).click();
		String expected_output = "Successfully deleted";
		// should not say it was deleted
		assertFalse(driver.getPageSource().contains(expected_output));
	}

	/*
	 * This test tries to delete something from the breakfast database and it should
	 * be deleted successfully.
	 */
	@Test
	public void test_deleteBreakfast() {
		driver.findElement(By.name("bFoodDe")).click();
		{
			WebElement dropdown = driver.findElement(By.name("bFoodDe"));
			dropdown.findElement(By.xpath("//option[. = 'bacon']")).click();
		}
		driver.findElement(By.cssSelector("#breakfast > form:nth-child(3) > input")).click();
		String expected_output = "Successfully deleted";
		// should be deleted
		assertTrue(driver.getPageSource().contains(expected_output));
	}

	/*
	 * This test tries to delete something from the lunch database and it should be
	 * deleted successfully.
	 */
	@Test
	public void test_deleteLunch() {
		driver.findElement(By.name("lFoodDe")).click();
		{
			WebElement dropdown = driver.findElement(By.name("lFoodDe"));
			dropdown.findElement(By.xpath("//option[. = 'salad']")).click();
		}
		driver.findElement(By.cssSelector("#lunch > form:nth-child(3) > input")).click();
		String expected_output = "Successfully deleted";
		// should be deleted
		assertTrue(driver.getPageSource().contains(expected_output));
	}

	/*
	 * This test tries to delete something from the dinner database and it should be
	 * deleted successfully.
	 */
	@Test
	public void test_deleteDinner() {
		driver.findElement(By.name("dFoodDe")).click();
		{
			WebElement dropdown = driver.findElement(By.name("dFoodDe"));
			dropdown.findElement(By.xpath("//option[. = 'sushi']")).click();
		}
		driver.findElement(By.cssSelector("#dinner > form:nth-child(3) > input")).click();
		String expected_output = "Successfully deleted";
		// should be deleted
		assertTrue(driver.getPageSource().contains(expected_output));
	}

}