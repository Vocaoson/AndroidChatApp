package thedarkknighttech.chatapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import thedarkknighttech.chatapp.Bean.Chat;
import thedarkknighttech.chatapp.Bean.Group;

/**
 * class xử lý việc tạo phòng chat, lưu dữ liệu vào Firebase realtime database
 */
public class CreateRoom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_room);
    }
    public void CreateGroup(View view){
        EditText groupName = (EditText) findViewById(R.id.edit_group_name);
        EditText groupDescription = (EditText) findViewById(R.id.edit_group_description);

                        FirebaseDatabase.getInstance()
                        .getReference()
                        .push()
                        .setValue(new Group(groupName.getText().toString(),groupDescription.getText().toString()));
        Toast.makeText(CreateRoom.this,
                "Create group successful.",
                Toast.LENGTH_LONG)
                .show();
        finish();
    }
}
