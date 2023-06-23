package g10.manga.comicable.frontend.helper;

import android.content.Context;
import android.widget.Toast;

import g10.manga.comicable.dictionary.app.ToastDictionary;

public class ToastHelper {

    public static Toast registerSuccess(Context context) {
        return Toast.makeText(context, ToastDictionary.REGISTER_SUCCESS, Toast.LENGTH_LONG);
    }

    public static Toast registerFailed(Context context) {
        return Toast.makeText(context, ToastDictionary.REGISTER_FAILED, Toast.LENGTH_LONG);
    }

    public static Toast loginSuccess(Context context) {
        return Toast.makeText(context, ToastDictionary.LOGIN_SUCCESS, Toast.LENGTH_SHORT);
    }

    public static Toast loginFailed(Context context) {
        return Toast.makeText(context, ToastDictionary.LOGIN_FAILED, Toast.LENGTH_SHORT);
    }

    public static Toast loginCancelled(Context context) {
        return Toast.makeText(context, ToastDictionary.LOGIN_CANCELLED, Toast.LENGTH_SHORT);
    }

    public static Toast networkError(Context context) {
        return Toast.makeText(context, ToastDictionary.NETWORK_ERROR, Toast.LENGTH_SHORT);
    }

    public static Toast logoutSuccess(Context context) {
        return Toast.makeText(context, ToastDictionary.LOGOUT_SUCCESS, Toast.LENGTH_LONG);
    }

    public static Toast updateUserSuccess(Context context) {
        return Toast.makeText(context, ToastDictionary.UPDATE_USER_SUCCESS, Toast.LENGTH_LONG);
    }

    public static Toast updateUserFailed(Context context) {
        return Toast.makeText(context, ToastDictionary.UPDATE_USER_FAILED, Toast.LENGTH_LONG);
    }

    public static Toast readUserFail(Context context) {
        return Toast.makeText(context, ToastDictionary.READ_USER_FAILED, Toast.LENGTH_LONG);
    }
}
