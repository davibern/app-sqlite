package davibern.app_sqlite.utilities;

public class Utilities {

    // Constant fields table User
    public static final String TABLE_USER = "users";
    public static final String FIELD_ID = "id";
    public static final String FIELD_NAME = "name";
    public static final String FIELD_PHONE = "phone";

    public static final String CREATE_TABLE_USUARIO = "CREATE TABLE "
        + TABLE_USER + "( "
        + FIELD_ID + " INTEGER, "
        + FIELD_NAME + " TEXT, "
        + FIELD_PHONE + " TEXT)";

}
