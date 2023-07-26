import pageObjects.MainPage;
import pageObjects.OrderPage;
import pageObjects.RentPage;
import org.junit.Test;

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

        new RentPage(driver)
                .sendRentalDate("28.03.2025")
                .setRentalTime()
                .clickCheckBoxColourBlackPearl()
                .sendComment("Если можно, то новый")
                .clickOrderButton()
                .clickOrderButtonYes()
                .checkModalOrderWindowIsDisplayed()
                .checkOrderConfirmation()
                .clickOnViewStatusButton();
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

        new RentPage(driver)
                .sendRentalDate("07.01.2023")
                .setRentalTime()
                .clickCheckBoxColourGreyDespair()
                .sendComment("Серый")
                .clickOrderButton()
                .clickOrderButtonYes()
                .checkModalOrderWindowIsDisplayed()
                .checkOrderConfirmation()
                .clickOnViewStatusButton();
    }
}
