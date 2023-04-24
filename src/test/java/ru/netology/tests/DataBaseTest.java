package ru.netology.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.data.APIHelper;
import ru.netology.data.DataGenerator;
import ru.netology.data.SQLHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataBaseTest {
    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    @DisplayName("Add payment details to database with APPROVAL")
    void shouldSuccessTransactionWithApprovedPayment() {
        var cardInfo = DataGenerator.dataWithApprovedCard();
        APIHelper.payment(cardInfo);
        var paymentCardData = SQLHelper.getPaymentCardData();
        assertEquals("APPROVED", paymentCardData.getStatus());

    }

    @Test
    @DisplayName("Add the credit data to the database with APPROVAL")
    void shouldSuccessTransactionWithApprovedCreditCard() {
        var cardInfo = DataGenerator.dataWithApprovedCard();
        APIHelper.credit(cardInfo);
        var creditCardData = SQLHelper.getCreditCardData();
        assertEquals("APPROVED", creditCardData.getStatus());

    }

    @Test
    @DisplayName("Add the payment data to the database with a DECLINED")
    void transactionWithDeclinedPaymentCardViaAPI() {
        var cardInfo = DataGenerator.dataWithDeclineCard();
        APIHelper.payment(cardInfo);
        var paymentCardData = SQLHelper.getPaymentCardData();
        assertEquals("DECLINED", paymentCardData.getStatus());

    }

    @Test
    @DisplayName("Add the credit data to the database with a DECLINED")
    void transactionWithDeclinedCreditCard() {
        var cardInfo = DataGenerator.dataWithDeclineCard();
        APIHelper.credit(cardInfo);
        var creditCardData = SQLHelper.getCreditCardData();
        assertEquals("DECLINED", creditCardData.getStatus());

    }

    @Test
    @DisplayName("Add the correct created date to the payment table with the APPROVED card")
    void addCorrectDateInPaymentTableWithApprovedCard() {
        var cardInfo = DataGenerator.dataWithApprovedCard();
        APIHelper.payment(cardInfo);
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        var paymentCardData = SQLHelper.getPaymentCardData();
        String dateFromDB = paymentCardData.getCreated();
        var dateDB = dateFromDB.substring(0, dateFromDB.length() - 10);
        assertEquals(formatForDateNow.format(dateNow), dateDB);
    }

    @Test
    @DisplayName("Add the correct created date to the credit table with the APPROVED card")
    void addCorrectDateInCreditTableWithApprovedCard() {
        var cardInfo = DataGenerator.dataWithApprovedCard();
        APIHelper.credit(cardInfo);
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        var creditCardData = SQLHelper.getCreditCardData();
        String dateFromDB = creditCardData.getCreated();
        var dateDB = dateFromDB.substring(0, dateFromDB.length() - 10);
        assertEquals(formatForDateNow.format(dateNow), dateDB);
    }

    @Test
    @DisplayName("Add the correct created date to the payment table with the DECLINED card")
    void addCorrectDateInPaymentTableWithDeclinedCard() {
        var cardInfo = DataGenerator.dataWithDeclineCard();
        APIHelper.payment(cardInfo);
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        var paymentCardData = SQLHelper.getPaymentCardData();
        String dateFromDB = paymentCardData.getCreated();
        var dateDB = dateFromDB.substring(0, dateFromDB.length() - 10);
        assertEquals(formatForDateNow.format(dateNow), dateDB);
    }

    @Test
    @DisplayName("Add the correct created date to the credit table with the DECLINED card")
    void addCorrectDateInCreditTableWithDeclinedCard() {
        var cardInfo = DataGenerator.dataWithDeclineCard();
        APIHelper.credit(cardInfo);
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        var creditCardData = SQLHelper.getCreditCardData();
        String dateFromDB = creditCardData.getCreated();
        var dateDB = dateFromDB.substring(0, dateFromDB.length() - 10);
        assertEquals(formatForDateNow.format(dateNow), dateDB);
    }

    @Test
    @DisplayName("Add the correct payment data in order_entity table")
    void addCorrectPaymentDataInOrderTable() {
        var cardInfo = DataGenerator.dataWithApprovedCard();
        APIHelper.payment(cardInfo);
        var cardDataFromPaymentTable = SQLHelper.getPaymentCardData();
        var cardDataFromOrderTable = SQLHelper.getTableOrderEntity();
        assertEquals(cardDataFromPaymentTable.getTransaction_id(), cardDataFromOrderTable.getPayment_id());
    }

    @Test
    @DisplayName("Add the correct credit data in order_entity table")
    void addCorrectCreditDataInOrderTable() {
        var cardInfo = DataGenerator.dataWithApprovedCard();
        APIHelper.credit(cardInfo);
        var cardDataFromCreditTable = SQLHelper.getCreditCardData();
        var cardDataFromOrderTable = SQLHelper.getTableOrderEntity();
        assertEquals(cardDataFromCreditTable.getBank_id(), cardDataFromOrderTable.getCredit_id());
    }
}
