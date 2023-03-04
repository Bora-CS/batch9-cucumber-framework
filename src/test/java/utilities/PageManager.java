package utilities;

import org.openqa.selenium.WebDriver;

import pageObjects.*;

public class PageManager {

	private static PageManager pageManager;
	private WebDriver driver;

	private HomePage homePage;
	private LoginPage loginPage;
	private Navbar navbar;
	private DashboardPage dashboardPage;
	private PostPage postPage;

	private PageManager(WebDriver driver) {
		this.driver = driver;
	}

	public static PageManager getInstance() {
		if (pageManager == null) {
			pageManager = new PageManager(DriverManager.getInstance());
		}
		return pageManager;
	}

	public static void cleanup() {
		if (pageManager != null) {
			pageManager = null;
		}
	}

	public HomePage homePage() {
		if (homePage == null) {
			homePage = new HomePage(driver);
		}
		return homePage;
	}

	public LoginPage loginPage() {
		if (loginPage == null) {
			loginPage = new LoginPage(driver);
		}
		return loginPage;
	}

	public Navbar navbar() {
		if (navbar == null) {
			navbar = new Navbar(driver);
		}
		return navbar;
	}

	public DashboardPage dashboardPage() {
		if (dashboardPage == null) {
			dashboardPage = new DashboardPage(driver);
		}
		return dashboardPage;
	}

	public PostPage postPage() {
		if (postPage == null) {
			postPage = new PostPage(driver);
		}
		return postPage;
	}

}
