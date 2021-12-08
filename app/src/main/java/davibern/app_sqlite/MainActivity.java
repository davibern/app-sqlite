package davibern.app_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnRegisterActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegisterActivity = findViewById(R.id.btnRegisterActivity);
        btnRegisterActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRegisterActivity();
            }
        });

        ConectionSQLiteHelper conn = new ConectionSQLiteHelper(this, "bd_users", null, 1);
    }

    private void showRegisterActivity() {
        Intent i = new Intent(this, RegisterNewUserActivity.class);
        startActivity(i);
    }
}