package vn.edu.greenwich.javade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SuccessfulActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successfull);
        Button btnConfirm = findViewById(R.id.btnBack);
        btnConfirm.setOnClickListener(btnBackBtn);
    }
    private View.OnClickListener btnBackBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent putText = new Intent(v.getContext(), MainActivity.class);
            startActivity(putText);
            finish();
        }
    };
}