package SettingsBrowser;

public enum Browser {

    CHROME("Chrome", System.getenv("HOME") + "/WebDriver/bin/chromedriver_win32"),

    FIREFOX("Firefox", System.getenv("HOME") + "/WebDriver/bin/geckodriver-v0.33.0-win-aarch64");


    //Имя браузера

    private String name;


    //Путь к драйверу

    private String path;

    Browser(String name, String path) {
        this.name = name;
        this.path = path;
    }


    //Получить путь к драйверу по имени браузера
    //@param browserName имя браузера
    //@return путь к драйверу

    public static String getPath(String browserName) {
        for (Browser browser : Browser.values()) {
            if (browser.name.equals(browserName)) {
                return browser.path;
            }
        }
        return null;
    }
}