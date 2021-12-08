package davibern.app_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import davibern.app_sqlite.utilities.Utilities;

public class RegisterNewUserActivity extends AppCompatActivity {

    private EditText edtID, edtName, edtPhone;
    private Button btnRegisterNewUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_new_user);

        edtID = findViewById(R.id.edtID);
        edtName = findViewById(R.id.edtName);
        edtPhone = findViewById(R.id.edtPhone);
        btnRegisterNewUser = findViewById(R.id.btnRegisterNewUser);
        btnRegisterNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerNewUser();
            }
        });
    }

    private void registerNewUser() {

        // Check if there is any field blank
        if (isValid()) {
            // Open connection
            ConectionSQLiteHelper conn = new ConectionSQLiteHelper(this, "bd_users", null, 1);
            // Set DB to edit mode
            SQLiteDatabase db = conn.getWritableDatabase();

            // Map to save data from input activity
            ContentValues values = new ContentValues();
            values.put(Utilities.FIELD_ID, edtID.getText().toString());
            values.put(Utilities.FIELD_NAME, edtName.getText().toString());
            values.put(Utilities.FIELD_PHONE, edtPhone.getText().toString());

            // Variable have the number of row affected to use insert
            // Insert need: table, field key and values
            Long result = db.insert(Utilities.TABLE_USER, Utilities.FIELD_ID, values);

            if (result > 0) {
                Toast.makeText(this, "User added satisfactory.", Toast.LENGTH_SHORT).show();
                cleanFields();
                // close connection
                db.close();
            } else {
                Toast.makeText(this, "Cannot add a new user", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private boolean isValid() {
        boolean result = true;

        if (edtID.length() == 0 || edtName.length() == 0 || edtPhone.length() == 0) {
            result = false;
            Toast.makeText(this, "Error: any field blank!", Toast.LENGTH_SHORT).show();
        }

        return result;
    }

    private void cleanFields() {
        edtID.setText("");
        edtName.setText("");
        edtPhone.setText("");
    }
}