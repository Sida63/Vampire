package cn.edu.xjtu.se.vampire.util;

/**
 *
 * @author aetf
 */
public class Constants {
    public static final String AUTH_BEAN = "authBean";
    public static final String VALID_USER = "user";
    public static final String USER_NAME = "username";
    public static final String PASSWORD = "password";
    public static final String PASSWORD_CONFIRM = "password_confirm";
    public static final String EMAIL_ADDRESS = "emailAddr";
    public static final String REMEMBER_USERNAME = "remember";
    public static final String ORIG_URL = "origURL";
    public static final String DATA_SOURCE = "dataSource";
    public static final String ACTION = "act";
    public static final String MSG_CODE = "msgCode";
    public static final String MONTH = "month";
    

    public static final int AUTH_ACTION_LOGIN = 0;
    public static final int AUTH_ACTION_REG = 1;
    public static final int AUTH_ACTION_LOGOUT = 2;
    
    public static final int ACT_STATISTICS = 0;
    public static final int ACT_QUERY = 1;
    public static final int ACT_ADD = 2;
    public static final int ACT_UPDATE = 3;
    public static final int ACT_DELETE = 4;

    /**
     * The page user requested need login.
     */
    public static final int MSG_NEED_LOGIN = 1;
    
    /**
     * There are some feild not filled.
     */
    public static final int MSG_UNFILLED_PARAM = 2;
    
    /**
     * The username not found or password wrong.
     */
    public static final int MSG_USERNAME_PASS_WRONG = 3;
    
    /**
     * Username contains invalid character or too long or too short.
     */
    public static final int MSG_INVALID_USERNAME = 4;
    
    /**
     * Password contains invalid character or too long or too short.
     */
    public static final int MSG_INVALID_PASSWORD = 5;
    
    /**
     * Email address is not a valid form.
     */
    public static final int MSG_INVALID_EMAIL = 6;
    
    /**
     * Password and confirm do not match.
     */
    public static final int MSG_PW_MISSMATCH = 7;
    
    /**
     * Server internal error, maybe try later.
     */
    public static final int MSG_INTERNAL_ERROR = 8;
    
    /**
     * Username already exists.
     */
    public static final int MSG_USERNAME_EXIST = 9;

}
