package com.chameleon.selenium.web.chromeDevTool;

import com.chameleon.AutomationException;

public enum ChromeDevToolEmulator {
    BLACKBERRY_Z30("BlackBerry Z30"),
    BLACKBERRY_PLAYBOOK("Blackberry Playbook"),
    GALAXY_NOTE_3("Galaxy Note 3"),
    GALAXY_NOTE_2("Galaxy Note II"),
    GALAXY_S_3("Galaxy S III"),
    GALAXY_S5("Galaxy S5"),
    IPAD("iPad"),
    IPAD_MINI("iPad Mini"),
    IPAD_PRO("iPad Pro"),
    IPHONE_4("iPhone 4"),
    IPHONE_5_SE("iPhone 5/SE"),
    IPHONE_6_7_8("iPhone 6/7/8"),
    IPHONE_6_7_8_PLUS("iPhone 6/7/8 Plus"),
    IPHONE_X("iPhone X"),
    KINDLE_FIRE_HDX("Kindle Fire HDX"),
    LG_OPTIMUS_L70("LG Optimus L70"),
    LAPTOP_WITH_HIDPI_SCREEN("Laptop with HiDPI screen"),
    LAPTOP_WITH_MDPI_SCREEN("Laptop with MDPI screen"),
    LAPTOP_WITH_TOUCH("Laptop with touch"),
    MICROSOFT_LUMIA_550("Microsoft Lumia 550"),
    MICROSOFT_LUMIA_950("Microsoft Lumia 950"),
    NEXUS_10("Nexus 10"),
    NEXUS_4("Nexus 4"),
    NEXUS_5("Nexus 5"),
    NEXUS_5X("Nexus 5X"),
    NEXUS_6("Nexus 6"),
    NEXUS_6P("Nexus 6P"),
    NEXUS_7("Nexus 7"),
    NOKIA_LUMIA_520("Nokia Lumia 520"),
    NOKIA_N9("Nokia N9"),
    PIXEL_2("Pixel 2"),
    PIXEL_2XL("Pixel 2XL");

    public static final String DEVICE_NAME = "deviceName";
    public static final String MOBILE_EMULATION = "mobileEmulation";

    private final String name;

    ChromeDevToolEmulator(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static ChromeDevToolEmulator fromString(String name) {
        for (ChromeDevToolEmulator device : values()) {
            if (device.toString().equalsIgnoreCase(name)) {
                return device;
            }
        }

        for (ChromeDevToolEmulator device : values()) {
            if (device.getName().equalsIgnoreCase(name)) {
                return device;
            }
        }

        throw new AutomationException("No Emulator Device defined found for requested value [ " + name + " ]");
    }
}
