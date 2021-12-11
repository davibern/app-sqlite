package davibern.app_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import davibern.app_sqlite.entities.User;

public class UserDetailActivity extends AppCompatActivity {

    private TextView txtId, txtName, txtPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        txtId = findViewById(R.id.txtDetailUserId);
        txtName = findViewById(R.id.txtDetailUserName);
        txtPhone = findViewById(R.id.txtDetailUserPhone);

        Bundle bundle = getIntent().getExtras();
        User user = null;

        if (bundle != null) {
            user = (User) bundle.getSerializable("user");
            txtId.setText(user.getId().toString());
            txtName.setText(user.getName().toString());
            txtPhone.setText(user.getPhone().toString());
        }
    }
}