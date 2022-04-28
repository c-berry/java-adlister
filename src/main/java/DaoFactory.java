public class DaoFactory {
    private static Ads adsDao;
    private static Products productsDao;

    public static Products getProductsDao(){
        if (productsDao == null) {
            productsDao = new ListProductsDao();
        }
        return productsDao;
    }

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new ListAdsDao();
        }
        return adsDao;
    }
}