package davibern.app_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnRegisterActivity;
    private Button btnQueryUserActivity;
    private Button btnQueryUserSpinnerActivity;
    private Button btnQueryUserListView;
    private Button btnQueryUserRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegisterActivity = findViewById(R.id.btnRegisterActivity);
        btnQueryUserActivity = findViewById(R.id.btnQueryUserActivity);
        btnQueryUserSpinnerActivity = findViewById(R.id.btnQueryUserSpinnerActivity);
        btnQueryUserListView = findViewById(R.id.btnQueryUserListView);
        btnQueryUserRecyclerView = findViewById(R.id.btnQueryUserRecyclerView);

        btnRegisterActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRegisterActivity();
            }
        });

        btnQueryUserActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showQueryUserActivity();
            }
        });

        btnQueryUserSpinnerActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showQueryUserSpinnerActivity();
            }
        });

        btnQueryUserListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showQueryUserListViewActivity();
            }
        });

        btnQueryUserRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showQueryUserRecyclerViewActivity();
            }
        });

        ConectionSQLiteHelper conn = new ConectionSQLiteHelper(this, "bd_users", null, 1);
    }

    private void showRegisterActivity() {
        Intent i = new Intent(this, RegisterNewUserActivity.class);
        startActivity(i);
    }

    private void showQueryUserActivity() {
        Intent i = new Intent(this, QueryUserActivity.class);
        startActivity(i);
    }

    private void showQueryUserSpinnerActivity() {
        Intent i = new Intent(this, QueryUserSpinnerActivity.class);
        startActivity(i);
    }

    private void showQueryUserListViewActivity() {
        Intent i = new Intent(this, QueryUserListViewActivity.class);
        startActivity(i);
    }

    private void showQueryUserRecyclerViewActivity() {
        Intent i = new Intent(this, QueryUserRecyclerViewActivity.class);
        startActivity(i);
    }
}