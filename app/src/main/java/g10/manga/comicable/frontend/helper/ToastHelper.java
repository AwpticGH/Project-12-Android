package g10.manga.comicable.frontend.helper;

import android.content.Context;
import android.widget.Toast;

import g10.manga.comicable.dictionary.api.ResponseMessages;
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

    public static Toast logoutFailed(Context context) {
        return Toast.makeText(context, ToastDictionary.LOGOUT_FAILED, Toast.LENGTH_LONG);
    }

    public static Toast updateUserSuccess(Context context) {
        return Toast.makeText(context, ToastDictionary.UPDATE_USER_SUCCESS, Toast.LENGTH_LONG);
    }

    public static Toast updateUserFailed(Context context) {
        return Toast.makeText(context, ToastDictionary.UPDATE_USER_FAILED, Toast.LENGTH_LONG);
    }

    public static Toast readUserFailed(Context context) {
        return Toast.makeText(context, ToastDictionary.READ_USER_FAILED, Toast.LENGTH_LONG);
    }

    public static Toast registerToDatabaseFailed(Context context) {
        return Toast.makeText(context, ToastDictionary.REGISTER_TO_DATABASE_FAILED, Toast.LENGTH_LONG);
    }

    public static Toast registerToDatabaseSuccess(Context context) {
        return Toast.makeText(context, ToastDictionary.REGISTER_TO_DATABASE_SUCCESS, Toast.LENGTH_SHORT);
    }

    public static Toast registerFailedDueToCollision(Context context) {
        return Toast.makeText(context, ToastDictionary.REGISTER_FAILED_DUE_TO_COLLISION, Toast.LENGTH_SHORT);
    }

    public static Toast reattemptRegisterToDatabaseSuccess(Context context) {
        return Toast.makeText(context, ToastDictionary.REATTEMPT_REGISTER_TO_DATABASE_SUCCESS, Toast.LENGTH_LONG);
    }

    public static Toast welcomeMessage(Context context) {
        return Toast.makeText(context, ToastDictionary.WELCOME_MESSAGE, Toast.LENGTH_SHORT);
    }

    public static Toast apiSuccessful(Context context) {
        return Toast.makeText(context, ResponseMessages.FULL, Toast.LENGTH_SHORT);
    }

    public static Toast apiPartiallySuccessful(Context context) {
        return Toast.makeText(context, ResponseMessages.PARTIAL, Toast.LENGTH_LONG);
    }

    public static Toast apiFailed(Context context) {
        return Toast.makeText(context, ResponseMessages.FAILED, Toast.LENGTH_LONG);
    }

    public static Toast unknownError(Context context) {
        return Toast.makeText(context, ToastDictionary.UNKNOWN_ERROR, Toast.LENGTH_SHORT);
    }

    public static Toast createCollectionSuccess(Context context) {
        return Toast.makeText(context, ToastDictionary.CREATE_COLLECTION_SUCCESS, Toast.LENGTH_SHORT);
    }

    public static Toast createCollectionFailed(Context context) {
        return Toast.makeText(context, ToastDictionary.CREATE_COLLECTION_FAILED, Toast.LENGTH_SHORT);
    }

    public static Toast deleteCollectionSuccess(Context context) {
        return Toast.makeText(context, ToastDictionary.DELETE_COLLECTION_SUCCESS, Toast.LENGTH_SHORT);
    }

    public static Toast deleteCollectionFailed(Context context) {
        return Toast.makeText(context, ToastDictionary.DELETE_COLLECTION_FAILED, Toast.LENGTH_SHORT);
    }
}
