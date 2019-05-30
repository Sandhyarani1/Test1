package com.chameleon.utils.dataHelpers.creditCards;

import com.chameleon.AutomationException;

public enum CardType {

    DINERS_CLUB("dc", "dinersclub", "diners_club", "diners"),
    JCB("jcb"),
    AMEX("amex", "ae", "americanexpress", "american_express"),
    DISCOVER("disc", "dc", "discover"),
    MASTERCARD("mc", "mastercard", "master_card"),
    VISA("visa"),
    VISAEXPIRED("visaexpired", "visaexp");

    private final String[] cardType;

    CardType(String... type) {
        cardType = type;
    }

    public String[] getCardType() {
        return cardType;
    }

    public static CardType fromString(String type) {
        for (CardType cardType : values()) {
            if (cardType.toString().equalsIgnoreCase(type.replace("_", "").replace(" ", ""))) {
                return cardType;
            }
        }

        for (CardType card : CardType.values()) {
            for (String cardType : card.getCardType()) {
                if (cardType.equalsIgnoreCase(type.replace("_", "").replace(" ", ""))) {
                    return card;
                }
            }
        }

        throw new AutomationException("No card type defined found for requested value [ " + type + " ]");
    }
}
