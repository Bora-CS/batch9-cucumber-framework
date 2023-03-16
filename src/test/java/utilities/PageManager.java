package utilities;

import org.openqa.selenium.WebDriver;

import pageObjects.*;

public class PageManager {

	private static ThreadLocal<PageManager> threadLocalPageManager;
	private WebDriver driver;

	private HomePage homePage;
	private LoginPage loginPage;
	private Navbar navbar;
	private DashboardPage dashboardPage;
	private PostPage postPage;
	private CommonPage commonPage;
	private AddExperiencePage addExperiencePage;
	private AddEducationPage addEducationPage;

	private PageManager(WebDriver driver) {
		this.driver = driver;
	}

	public static PageManager getInstance() {
		if (threadLocalPageManager == null) {
			threadLocalPageManager = new ThreadLocal<PageManager>();
		}

		if (threadLocalPageManager.get() == null) {
			PageManager pageManager = new PageManager(DriverManager.getInstance());
			threadLocalPageManager.set(pageManager);
		}

		return threadLocalPageManager.get();
	}

	public static void cleanup() {
		if (threadLocalPageManager.get() != null) {
			threadLocalPageManager.set(null);
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

	public CommonPage commonPage() {
		if (commonPage == null) {
			commonPage = new CommonPage(driver);
		}
		return commonPage;
	}

	public AddExperiencePage addExperiencePage() {
		if (addExperiencePage == null) {
			addExperiencePage = new AddExperiencePage(driver);
		}
		return addExperiencePage;
	}

	public AddEducationPage addEducationPage() {
		if (addEducationPage == null) {
			addEducationPage = new AddEducationPage(driver);
		}
		return addEducationPage;
	}

}
