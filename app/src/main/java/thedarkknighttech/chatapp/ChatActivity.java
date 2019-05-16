package thedarkknighttech.chatapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import thedarkknighttech.chatapp.Bean.ChatMessage;
import thedarkknighttech.chatapp.Bean.Group;

/**
* class xử lý phòng chat, bao gồm show thông tin tin nhắn lấy từ Firebase database
 * listen sự thay đổi dữ liệu của db, sau đó cập nhật cho giao diện
 * lưu tin nhắn user gửi đi vào Firebase database
* */
public class ChatActivity extends AppCompatActivity {

    Group group = null;
    private FirebaseListAdapter<ChatMessage> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Intent intent = getIntent();
        group = (Group) intent.getSerializableExtra("group");
        FloatingActionButton fab =
                (FloatingActionButton)findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText input = (EditText)findViewById(R.id.input);

                // Read the input field and push a new instance
                // of ChatMessage to the Firebase database
                if(!input.getText().toString().equals("")){
                    FirebaseDatabase.getInstance()
                            .getReference(group.getGroupKey())
                            .child("messages")
                            .push()
                            .setValue(new ChatMessage(input.getText().toString(),FirebaseAuth.getInstance().getCurrentUser().getDisplayName()));
                }

                input.setText("");
            }
        });
        displayMessage();
    }
    private void displayMessage(){
        ListView listOfMessages = (ListView)findViewById(R.id.list_of_messages);

        adapter = new FirebaseListAdapter<ChatMessage>(this, ChatMessage.class,
                R.layout.item_message_received, FirebaseDatabase.getInstance().getReference(group.getGroupKey()).child("messages")) {
            @Override
            protected void populateView(View v, ChatMessage model, int position) {
                // Get references to the views of message.xml
                TextView messageText = (TextView)v.findViewById(R.id.message_text);
                TextView messageUser = (TextView)v.findViewById(R.id.message_user);
                TextView messageTime = (TextView)v.findViewById(R.id.message_time);
                ImageView imageView = (ImageView)v.findViewById(R.id.image_message_profile);
                if(position % 2 * 1.0 == 0){
                    imageView.setBackground((ContextCompat.getDrawable(getBaseContext(), R.drawable.batman)));
                } else{
                    imageView.setBackground((ContextCompat.getDrawable(getBaseContext(), R.drawable.ironman)));
                }
                // Set their text
                messageText.setText(model.getMessageText());
                messageUser.setText(model.getMessageUser());

                // Format the date before showing it
                messageTime.setText(DateFormat.format("dd-MM-yyyy (HH:mm:ss)",
                        model.getMessageTime()));
            }
        };

        listOfMessages.setAdapter(adapter);
    }
}
