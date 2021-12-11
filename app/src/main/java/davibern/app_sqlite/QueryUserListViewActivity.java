package davibern.app_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import davibern.app_sqlite.entities.User;
import davibern.app_sqlite.utilities.Utilities;

public class QueryUserListViewActivity extends AppCompatActivity {

    private ListView listViewUsers;
    private ArrayList<String> listUserInformation;
    private ArrayList<User> listUsers;
    private ConectionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_user_list_view);

        conn = new ConectionSQLiteHelper(getApplicationContext(), "bd_users", null, 1);
        listViewUsers = findViewById(R.id.listViewUser);

        queryListUsers();

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listUserInformation);
        listViewUsers.setAdapter(adapter);

        listViewUsers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String information = "Id: " + listUsers.get(position).getId() + "\n";
                information += "Name: " + listUsers.get(position).getName() + "\n";
                information += "Phone: " + listUsers.get(position).getPhone();

                Toast.makeText(getApplicationContext(), information, Toast.LENGTH_SHORT).show();

                User user = listUsers.get(position);

                Intent i = new Intent(getApplicationContext(), UserDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("user", user);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }

    private void queryListUsers() {
        SQLiteDatabase db = conn.getReadableDatabase();

        User user = null;
        listUsers = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from " + Utilities.TABLE_USER, null);

        while(cursor.moveToNext()) {
            user = new User();
            user.setId(cursor.getInt(0));
            user.setName(cursor.getString(1));
            user.setPhone(cursor.getString(2));

            listUsers.add(user);
        }

        requestList();
    }

    private void requestList() {
        listUserInformation = new ArrayList<>();

        for (int i = 0; i < listUsers.size(); i++) {
            listUserInformation.add(listUsers.get(i).getId() + " - " + listUsers.get(i).getName());
        }
    }

}