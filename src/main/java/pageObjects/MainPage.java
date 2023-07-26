package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

// Элементы главной страницы сайта
public class MainPage {
    private static WebDriver driver;
    // Локатор кнопки "да все привыкли" сообщения о кукисах
    private final By cookieButton = By.id("rcc-confirm-button");
    // Локатор Кнопки заказа в хэдере сайта
    private final By headerOrderButton = By.className("Button_Button__ra12g");
    // Локатор кнопки заказа в середине сайта
    private final By middleOrderButton = By.xpath("//*[@id='root']/div/div/div[4]/div[2]/div[5]/button");
    //By.cssSelector(".Button_UltraBig__UU3Lp");

    // Массив локаторов кнопок с вопросами
    private static final String[] dropDownQuestionsArray = new String[]{
            "accordion__heading-0",
            "accordion__heading-1",
            "accordion__heading-2",
            "accordion__heading-3",
            "accordion__heading-4",
            "accordion__heading-5",
            "accordion__heading-6",
            "accordion__heading-7"};
    // Массив локаторов панелей с текстом ответов
    private static final String[] dropDownAnswersArray = new String[]{
            "accordion__panel-0",
            "accordion__panel-1",
            "accordion__panel-2",
            "accordion__panel-3",
            "accordion__panel-4",
            "accordion__panel-5",
            "accordion__panel-6",
            "accordion__panel-7"};

    public MainPage(WebDriver driver) {
        MainPage.driver = driver;
    }

    // Открыть сайт
    public final MainPage openSite() {
        driver.get("https://qa-scooter.praktikum-services.ru");
        // System.out.println("Сайт открылся");
        return this;
    }

    // Кликнуть по кнопке "да все привыкли" в сообщении о кукисах
    public MainPage clickCookieButton() {
        driver.findElement(cookieButton).click();
        // System.out.println("Кликунли на кнопку куки");
        return this;
    }

    // Кликнуть по кнопке заказа в шапке сайта
    public MainPage clickHeaderOrderButton() {
        driver.findElement(headerOrderButton).click();
        return this;
    }

    // Кликнуть по кнопке заказа в середине сайта
    public MainPage clickMiddleOrderButton() {
        driver.findElement(middleOrderButton).click();
        return this;
    }

    // Прокрутка главной страницы до последнего элемента списка
    public MainPage scrollPageToEndOfList() {
        WebElement lastQuestionArrow = driver.findElement(By.id(dropDownQuestionsArray[7]));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", lastQuestionArrow);
        return this;
    }

    // Клик по стрелке выпадающего списка
    public static void clickQuestionArrow(int questionNumber) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.id(dropDownQuestionsArray[questionNumber])));
        driver.findElement(By.id(dropDownQuestionsArray[questionNumber])).click();
    }

    // Проверка текста в открытой панели
    public static void checkTextInOpenPanel(String expectedText, int answerNumber) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(dropDownAnswersArray[answerNumber])));
        String answerText = driver.findElement(By.id(dropDownAnswersArray[answerNumber])).getText();
        assertEquals("Текст в ответе не соответствует ожидаемому тексту.", expectedText, answerText);
    }

    // Клик по кнопке вопроса
    public MainPage clickQuestionButton(String questionButtonLocator) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.id(questionButtonLocator)));
        driver.findElement(By.id(questionButtonLocator)).click();
        return this;
    }
}
