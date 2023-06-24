package g10.manga.comicable.flag.app;

public class ClazzFlag {

    public static boolean methodExists(Class<?> clazz, String method) {
        try {
            clazz.getDeclaredMethod(method);
            return true;
        }
        catch (NoSuchMethodException e) {
            return false;
        }
    }
}
