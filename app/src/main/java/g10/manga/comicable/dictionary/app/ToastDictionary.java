package g10.manga.comicable.dictionary.app;

import g10.manga.comicable.backend.app.config.firebase.AuthConfig;

public class ToastDictionary {

    public static final String REGISTER_SUCCESS = "Successfully Registered Account, You Can Continue To Login!";
    public static final String REGISTER_FAILED = "Failed To Register Account, Please Try Again Later!!!";
    public static final String LOGIN_SUCCESS = "Login Success! Welcome " + AuthConfig.getFirebaseUser().getDisplayName();
    public static final String LOGIN_FAILED = "Login Failed, Please Try Again!";
    public static final String LOGIN_CANCELLED = "Login Cancelled!";
    public static final String NETWORK_ERROR = "Network Error. Try Again Later!";
    public static final String LOGOUT_SUCCESS = "Logout Success!";
    public static final String LOGOUT_FAILED = "Logout Failed! Please Try Again Later";
    public static final String UPDATE_USER_SUCCESS = "Profile Has Been Updated!";
    public static final String UPDATE_USER_FAILED = "Update Failed, Please Try Again!";
    public static final String READ_USER_FAILED = "Failed To Fetch User Data, Please Try Again In A Few Minutes!";
    public static final String REGISTER_TO_DATABASE_FAILED = "Failed To Register Account To Database, Please Restart The Application!";
    public static final String REGISTER_TO_DATABASE_SUCCESS = "Successfully Registered Account To Database, Enjoy Our Application!";
    public static final String REGISTER_FAILED_DUE_TO_COLLISION = "Failed To Register, An Account With The Same Credential Already Exists!!";
    public static final String REATTEMPT_REGISTER_TO_DATABASE_SUCCESS = "Successfully Registered Account To Database, Please Update Your Profile To Complete Registering!";
    public static final String WELCOME_MESSAGE = "Welcome, " + AuthConfig.getFirebaseUser().getDisplayName();
    public static final String UNKNOWN_ERROR = "Unknown Error Occurred!!";

}
