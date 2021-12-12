package davibern.app_sqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;

import davibern.app_sqlite.entities.User;
import davibern.app_sqlite.utilities.Utilities;

public class QueryUserRecyclerViewActivity extends AppCompatActivity {

    ArrayList<User> listUser;
    RecyclerView recyclerView;
    ConectionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_user_recycler_view);

        conn = new ConectionSQLiteHelper(getApplicationContext(), "bd_users", null, 1);
        listUser = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        queryListUsers();

        AdapterUserData adapterUserData = new AdapterUserData(listUser, this);
        recyclerView.setAdapter(adapterUserData);
    }

    private void queryListUsers() {
        SQLiteDatabase db = conn.getReadableDatabase();
        User user = null;
        Cursor cursor = db.rawQuery("select * from " + Utilities.TABLE_USER, null);

        while(cursor.moveToNext()) {
            user = new User();
            user.setId(cursor.getInt(0));
            user.setName(cursor.getString(1));
            user.setPhone(cursor.getString(2));

            listUser.add(user);
        }
    }
}