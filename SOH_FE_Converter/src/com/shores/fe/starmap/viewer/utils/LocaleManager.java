package com.shores.fe.starmap.viewer.utils;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class LocaleManager {

    private static Locale defaultLocale = Locale.ENGLISH;
    private Locale locale;

    // Non static use
    public LocaleManager() {
        locale = Locale.getDefault();
    }

    public LocaleManager(String language, String country) {
        locale = new Locale(language, country);
    }

    public Locale getLocale() {
        return locale;
    }

    public ResourceBundle getBundle(String resourceFile) {
        ResourceBundle res;
        try {
            res = java.util.ResourceBundle.getBundle(resourceFile, locale);
        } catch (MissingResourceException e) {
            res = java.util.ResourceBundle.getBundle(resourceFile);
        }
        return res;
    }

    //STATIC CASE
    public static void SetStaticLocale(String localeCode) {
        if (localeCode == null) {
            return;
        }
        String[] codes = localeCode.split("-");
        if (codes.length > 1) {
            defaultLocale = new Locale(codes[0], codes[1]);
        } else {
            defaultLocale = new Locale(localeCode);
        }
    }

    public static ResourceBundle getStaticBundle(String resourceFile) {
        ResourceBundle res;
        try {
            res = java.util.ResourceBundle.getBundle(resourceFile, defaultLocale);
        } catch (MissingResourceException e) {
            try {
                res = java.util.ResourceBundle.getBundle(resourceFile);
            } catch (MissingResourceException ex) {
                res = java.util.ResourceBundle.getBundle(resourceFile, new Locale(defaultLocale.getLanguage()));
            }
        }
        return res;
    }

    public static Locale getStaticLocale() {
        return defaultLocale;
    }

    public static void SetStaticLocale(String pLanguage, String pCountry) {
        defaultLocale = new Locale(pLanguage, pCountry);
    }

}
