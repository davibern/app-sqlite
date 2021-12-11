package davibern.app_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import davibern.app_sqlite.entities.User;
import davibern.app_sqlite.utilities.Utilities;

public class QueryUserSpinnerActivity extends AppCompatActivity {

    private Spinner spnUser;
    private TextView txtIdQuery, txtNamequery, txtPhoneQuery;
    ArrayList<String> listPersons;
    ArrayList<User> listUsers;
    ConectionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_user_spinner);

        spnUser = findViewById(R.id.spnUser);
        txtIdQuery = findViewById(R.id.txtIDQuery);
        txtNamequery = findViewById(R.id.txtNameQuery);
        txtPhoneQuery = findViewById(R.id.txtPhoneQuery);

        conn = new ConectionSQLiteHelper(getApplicationContext(), "bd_users", null, 1);

        queryListPersons();

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, listPersons);
        spnUser.setAdapter(adapter);

        spnUser.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    txtIdQuery.setText(listUsers.get(position - 1).getId().toString());
                    txtNamequery.setText(listUsers.get(position - 1).getId().toString());
                    txtPhoneQuery.setText(listUsers.get(position - 1).getId().toString());
                } else {
                    txtIdQuery.setText("");
                    txtNamequery.setText("");
                    txtPhoneQuery.setText("");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void queryListPersons() {
        SQLiteDatabase db = conn.getReadableDatabase();
        User user = null;
        listUsers = new ArrayList<>();

        Cursor cursor = db.rawQuery("select * from " + Utilities.TABLE_USER, null);

        while (cursor.moveToNext()) {
            user = new User();
            user.setId(cursor.getInt(0));
            user.setName(cursor.getString(1));
            user.setPhone(cursor.getString(2));

            listUsers.add(user);
        }

        requestList();
    }

    private void requestList() {
        listPersons = new ArrayList<>();
        listPersons.add("Select an user...");

        for (int i = 0; i < listUsers.size(); i++) {
            listPersons.add(listUsers.get(i).getId() + " - " + listUsers.get(i).getName());
        }
    }
}