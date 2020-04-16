package com.example.course_1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.net.Uri;

public class MailClass extends AppCompatActivity {
    Button sendButton,attachmentButton;
    EditText msgtext,topictext,receiver;
    TextView tvExtra;
    Uri URI = null;
    private static final int PICK_FROM_GALLERY = 101;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xmlmail);
        sendButton = (Button)findViewById(R.id.buttonMail1);
        attachmentButton = (Button)findViewById(R.id.buttonMail2);
        msgtext = (EditText)findViewById(R.id.editTextMail3);
        topictext = (EditText)findViewById(R.id.editTextMail2);
        receiver = (EditText)findViewById(R.id.editTextMail1);
        tvExtra = (TextView)findViewById(R.id.textViewMail);
        attachmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.putExtra("return-data", true);
                startActivityForResult(Intent.createChooser(intent, "Complete action using"), PICK_FROM_GALLERY);
            }
        });

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Intent.ACTION_SEND);
                it.putExtra(Intent.EXTRA_EMAIL, new String[]{receiver.getText().toString()});
                it.putExtra(Intent.EXTRA_SUBJECT,topictext.getText().toString());
                it.putExtra(Intent.EXTRA_TEXT,msgtext.getText());
                if (URI != null) {
                      it.putExtra(Intent.EXTRA_STREAM, URI);
                }
                it.setType("message/rfc822");
                startActivity(Intent.createChooser(it,"Choose Mail App"));
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PICK_FROM_GALLERY && resultCode == RESULT_OK) {
            URI = data.getData();
            tvExtra.setText(URI.getLastPathSegment());
            tvExtra.setVisibility(View.VISIBLE);
        }
    }

}
