import pageObjects.MainPage;
import pageObjects.OrderPage;
import pageObjects.RentPage;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class OrderSamokatTest extends CommonBaseTest {

    // Тест заказа через кнопку в хэдере
    @Test
    public void samokatOrderingByHeaderOrderButton() {
        new MainPage(driver)
                .openSite()
                .clickCookieButton()
                .clickHeaderOrderButton();

        new OrderPage(driver)
                .sendClientFirstName("Андрей")
                .sendClientLastName("Карлсон")
                .sendDeliveryAddress("Москва")
                .selectMetroStation("Марьина Роща")
                .sendDeliveryClientPhoneNumber("89998887766")
                .clickNextButton();

        boolean isDisplayed = new RentPage(driver)
                .sendRentalDate("28.03.2025")
                .setRentalTime()
                .clickCheckBoxColourBlackPearl()
                .sendComment("Если можно, то новый")
                .clickOrderButton()
                .clickOrderButtonYes()
                .isModalOrderWindowDisplayed();
        assertTrue("Окно заказа не появилось", isDisplayed);
    }

    // Тест заказа через кнопку в середине страницы
    @Test
    public void samokatOrderingByMiddleOrderButton() {
        new MainPage(driver)
                .openSite()
                .clickCookieButton()
                .clickMiddleOrderButton();

        new OrderPage(driver)
                .sendClientFirstName("Владимир")
                .sendClientLastName("Ленин")
                .sendDeliveryAddress("Москва, Красная площадь")
                .selectMetroStation("Охотный ряд")
                .sendDeliveryClientPhoneNumber("87776996969")
                .clickNextButton();

        boolean isDisplayed = new RentPage(driver)
                .sendRentalDate("07.01.2023")
                .setRentalTime()
                .clickCheckBoxColourGreyDespair()
                .sendComment("Серый")
                .clickOrderButton()
                .clickOrderButtonYes()
                .isModalOrderWindowDisplayed();
        assertTrue("Окно заказа не появилось", isDisplayed);
    }
}
