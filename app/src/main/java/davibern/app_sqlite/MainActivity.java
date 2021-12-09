package davibern.app_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnRegisterActivity;
    private Button btnQueryUserActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegisterActivity = findViewById(R.id.btnRegisterActivity);
        btnQueryUserActivity = findViewById(R.id.btnQueryUserActivity);

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
}