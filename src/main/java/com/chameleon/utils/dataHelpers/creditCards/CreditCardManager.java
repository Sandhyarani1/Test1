package com.chameleon.utils.dataHelpers.creditCards;

import com.chameleon.AutomationException;
import com.chameleon.utils.dataHelpers.personFactory.Person;

/**
 * Container class to store credit cards and easily retrieve them
 * The credit cards in this class are considered test cards for PayPal
 * as listed below, but cardnumber info still not plaintext to
 * encourage data masking and safety
 *
 * @author justin.phlegar@orasi.com
 * @see https://www.paypalobjects.com/en_US/vhelp/paypalmanager_help/credit_card_numbers.htm
 *
 */
public class CreditCardManager {
    /*
     * Expected storage pattern is as follows
     * return new CreditCard(
     * cardType,
     * nameOnCard,
     * encodedCardNumber,
     * encodedSecurityCode,
     * expirationMonth,
     * expirationYear,
     * billingAddress,
     * billingAddress2,
     * billingCity,
     * billingState,
     * billingCountry,
     * billingZipCode
     * );
     */

    private static final CreditCard amex(Person person) {
        return new CreditCard(
                CardType.AMEX,
                person.getFullName(),
                "Mzc4MjgyMjQ2MzEwMDA1",
                "MzI2NQ==",
                "12",
                "20",
                person.primaryAddress().getAddress1(),
                person.primaryAddress().getAddress2(),
                person.primaryAddress().getCity(),
                person.primaryAddress().getStateAbbv(),
                person.primaryAddress().getCountryAbbv(),
                person.primaryAddress().getZipCode());
    }

    private static final CreditCard dinersClub(Person person) {
        return new CreditCard(
                CardType.DINERS_CLUB,
                person.getFullName(),
                "MzA1NjkzMDkwMjU5MDQ=",
                "NzE4",
                "12",
                "20",
                person.primaryAddress().getAddress1(),
                person.primaryAddress().getAddress2(),
                person.primaryAddress().getCity(),
                person.primaryAddress().getStateAbbv(),
                person.primaryAddress().getCountryAbbv(),
                person.primaryAddress().getZipCode());
    }

    private static final CreditCard discover(Person person) {
        return new CreditCard(
                CardType.DISCOVER,
                person.getFullName(),
                "NjAxMTExMTExMTExMTExNw==",
                "NzE4",
                "12",
                "20",
                person.primaryAddress().getAddress1(),
                person.primaryAddress().getAddress2(),
                person.primaryAddress().getCity(),
                person.primaryAddress().getStateAbbv(),
                person.primaryAddress().getCountryAbbv(),
                person.primaryAddress().getZipCode());
    }

    private static final CreditCard jcb(Person person) {
        return new CreditCard(
                CardType.JCB,
                person.getFullName(),
                "MzUzMDExMTMzMzMwMDAwMA==",
                "MDM2",
                "12",
                "20",
                person.primaryAddress().getAddress1(),
                person.primaryAddress().getAddress2(),
                person.primaryAddress().getCity(),
                person.primaryAddress().getStateAbbv(),
                person.primaryAddress().getCountryAbbv(),
                person.primaryAddress().getZipCode());
    }

    private static final CreditCard mastercard(Person person) {
        return new CreditCard(
                CardType.MASTERCARD,
                person.getFullName(),
                "NTEwNTEwNTEwNTEwNTEwMA==",
                "MDM2",
                "12",
                "20",
                person.primaryAddress().getAddress1(),
                person.primaryAddress().getAddress2(),
                person.primaryAddress().getCity(),
                person.primaryAddress().getStateAbbv(),
                person.primaryAddress().getCountryAbbv(),
                person.primaryAddress().getZipCode());
    }

    private static final CreditCard visa(Person person) {
        return new CreditCard(
                CardType.VISA,
                person.getFullName(),
                "NDAxMjg4ODg4ODg4MTg4MQ==",
                "OTgw",
                "12",
                "20",
                person.primaryAddress().getAddress1(),
                person.primaryAddress().getAddress2(),
                person.primaryAddress().getCity(),
                person.primaryAddress().getStateAbbv(),
                person.primaryAddress().getCountryAbbv(),
                person.primaryAddress().getZipCode());
    }

    private static final CreditCard visaExpired(Person person) {
        return new CreditCard(
                CardType.VISAEXPIRED,
                person.getFullName(),
                "NDAxMjg4ODg4ODg4MTg4MQ==",
                "OTgw",
                "12",
                "12",
                person.primaryAddress().getAddress1(),
                person.primaryAddress().getAddress2(),
                person.primaryAddress().getCity(),
                person.primaryAddress().getStateAbbv(),
                person.primaryAddress().getCountryAbbv(),
                person.primaryAddress().getZipCode());
    }

    /**
     * This method allows you to enter the type of card you want by string
     *
     * @param type
     * @return
     */
    public static CreditCard getCreditCardByType(String type) {
        return getCreditCardByType(CardType.fromString(type), new Person());
    }

    /**
     * This method allows you to enter the type of card you want by string
     *
     * @param type
     * @return
     */
    public static CreditCard getCreditCardByType(String type, Person person) {
        return getCreditCardByType(CardType.fromString(type), person);
    }

    /**
     * This method allows you to enter the type of card you want by enum
     *
     * @param type
     *
     * @return
     */
    public static CreditCard getCreditCardByType(CardType type) {
        return getCreditCardByType(type, new Person());
    }

    /**
     * This method allows you to enter the type of card you want by enum
     *
     * @param type
     * @return
     */
    public static CreditCard getCreditCardByType(CardType type, Person person) {

        switch (type) {
            case AMEX:
                return amex(person);
            case DINERS_CLUB:
                return dinersClub(person);
            case DISCOVER:
                return discover(person);
            case JCB:
                return jcb(person);
            case MASTERCARD:
                return mastercard(person);
            case VISA:
                return visa(person);
            case VISAEXPIRED:
                return visaExpired(person);
        }

        // Should not be at this point unless card was not found above
        throw new AutomationException("Credit Card type of [ " + type + " ] was not valid or availible");
    }
}
