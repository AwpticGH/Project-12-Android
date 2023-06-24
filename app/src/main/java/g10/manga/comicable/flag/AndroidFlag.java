package g10.manga.comicable.flag;

public class AndroidFlag {

    public static boolean isModern() {
        return android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N;
    }
}
