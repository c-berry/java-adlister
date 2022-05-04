package com.codeup.adlister.dao;

public class DaoFactory {
    private static Ads adsDao;
    private static Authors authorsDao;
    private static Config config = new Config();

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;
    }

    public static Authors getAuthorsDao(){
        if (authorsDao == null) {
            authorsDao = new AuthorsDao(config);
        }
        return authorsDao;
    }
}