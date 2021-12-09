package davibern.app_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import davibern.app_sqlite.utilities.Utilities;

public class QueryUserActivity extends AppCompatActivity {

    private EditText edtQueryID, edtNameQuery, edtPhoneQuery;
    private Button btnSearchQuery, btnUpdateQuery, btnDeleteQuery;
    // Object to connect with the database
    ConectionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_user);

        // Object with the connection
        conn = new ConectionSQLiteHelper(getApplicationContext(), "bd_users", null, 1);

        edtQueryID = findViewById(R.id.edtQueryID);
        edtNameQuery = findViewById(R.id.edtNameQuery);
        edtPhoneQuery = findViewById(R.id.edtPhoneQuery);

        btnSearchQuery = findViewById(R.id.btnSearchQuery);
        btnSearchQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                queryUser();
            }
        });

        btnUpdateQuery = findViewById(R.id.btnUpdateQuery);
        btnUpdateQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnDeleteQuery = findViewById(R.id.btnDeleteQuery);
        btnDeleteQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private void queryUser() {
        // Object SQLite with the connection and mode (read)
        SQLiteDatabase db = conn.getReadableDatabase();
        // Query about ID parameter
        String[] parameters = {edtQueryID.getText().toString()};
        // Field that returns the query
        String[] fields = {Utilities.FIELD_NAME, Utilities.FIELD_PHONE};

        try {
            Cursor cursor = db.query(Utilities.TABLE_USER, fields, Utilities.FIELD_ID + "=?", parameters, null, null, null);
            cursor.moveToFirst();
            edtNameQuery.setText(cursor.getString(0));
            edtPhoneQuery.setText(cursor.getString(1));
            cursor.close();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "The user doesn't exist", Toast.LENGTH_SHORT).show();
            cleanFields();
        }
    }

    private void cleanFields() {
        edtQueryID.setText("");
        edtNameQuery.setText("");
        edtPhoneQuery.setText("");
    }
}