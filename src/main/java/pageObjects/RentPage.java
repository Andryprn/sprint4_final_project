package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.hamcrest.MatcherAssert;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertTrue;

// Элементы данных страницы "Про аренду"
public class RentPage {
    WebDriver driver;
    // Локатор поля даты начала аренды
    private final By rentalDateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // Локатор поля срока аренды
    private final By rentalTimeField = By.className("Dropdown-placeholder");
    // Локатор списка срока аренды
    private final By rentalTime = By.xpath(".//*[(@role ='option' and text()='трое суток')]");
    // Локатор цвета самоката "Черный жемчуг"
    private final By checkBoxColourBlackPearl = By.xpath(".//input[@id='black']");
    // Локатор цвета самоката "Серая безысходность"
    private final By checkBoxColourGreyDespair = By.xpath(".//input[@id='grey']");
    // Локатор поля комментария для курьера
    private final By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // Локатор кнопки "Заказать"
    private final By orderButton = By.xpath(".//button[(@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать')]");
    // Локатор кнопки "Да" оформления заказа
    private final By orderButtonYes = By.xpath(".//button[(@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да')]");
    // Локатор модального окна
    private final By modalOrderWindow = By.xpath(".//div[contains(@class, 'Order_ModalHeader')]");
    // Локатор кнопки посмотреть статус
    private final By viewStatusButton = By.xpath(".//button[contains(text(),'Посмотреть статус')]");


    // Конструктор класса
    public RentPage(WebDriver driver) {
        this.driver = driver;
    }

    // Ввод даты доставки
    public RentPage sendRentalDate(String date) {
        driver.findElement(rentalDateField).sendKeys(date);
        driver.findElement(rentalDateField).sendKeys(Keys.ENTER);
        return this;
    }

    // Ввод срока аренды
    public RentPage setRentalTime() {
        driver.findElement(rentalTimeField).click();
        driver.findElement(rentalTime).click();
        return this;
    }

    // Выбор цвета самоката "Черный жемчуг"
    public RentPage clickCheckBoxColourBlackPearl() {
        driver.findElement(checkBoxColourBlackPearl).click();
        return this;
    }

    // Выбор цвета самоката "Серая безысходность"
    public RentPage clickCheckBoxColourGreyDespair() {
        driver.findElement(checkBoxColourGreyDespair).click();
        return this;
    }

    // Ввод комментария для курьера
    public RentPage sendComment(String userComment) {
        driver.findElement(commentField).sendKeys(userComment);
        return this;
    }

    // Клик по Кнопке "Заказать"
    public RentPage clickOrderButton() {
        driver.findElement(orderButton).click();
        return this;
    }

    // Клик по кнопке "Да" оформления заказа
    public RentPage clickOrderButtonYes() {
        //new WebDriverWait(driver, 5)
        //        .until(ExpectedConditions.elementToBeClickable(orderButtonYes));
        driver.findElement(orderButtonYes).click();
        return this;
    }

    // Модальное окно "Заказ Оформлен"
    public RentPage checkModalOrderWindowIsDisplayed() {
        assertTrue("Окно оформления заказа не появилось", driver.findElement(modalOrderWindow).isDisplayed());
        return this;
    }

    // Подтверждение оформления заказа
    public RentPage checkOrderConfirmation() {
        String orderConfirmationText = driver.findElement(modalOrderWindow).getText();
        MatcherAssert.assertThat(orderConfirmationText, containsString("Заказ оформлен"));
        return this;
    }

    public RentPage clickOnViewStatusButton() {
        driver.findElement(viewStatusButton).click();
        return this;
    }
}
