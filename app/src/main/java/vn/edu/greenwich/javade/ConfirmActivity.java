package vn.edu.greenwich.javade;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConfirmActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        TextView tvUsername = findViewById(R.id.tvUsername_Test);
        TextView tvReporter = findViewById(R.id.tvReporter_Test);
        TextView tvAddress = findViewById(R.id.tvAddress_Test);
        TextView tvBedrooms = findViewById(R.id.tvBedrooms_Test);
        TextView tvPrices = findViewById(R.id.tvPrice_Test);
        TextView tvFurniture = findViewById(R.id.tvFurniture_Test);
        TextView tvNotes = findViewById(R.id.tvPropertytype_Test);
        TextView tvTime = findViewById(R.id.tvCreatedTime);

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String format = myFormatObj.format(myDateObj);

        String username = "";
        String reporter = "";
        String address = "";
        String bedrooms = "";
        String price = "";
        String furniture = "";
        String propertytype = "";

        Intent intent = getIntent();

        // 1st method to receive data.
        Bundle bundle = intent.getExtras();

        if (bundle != null) {
            username = bundle.getString("username");
            reporter = bundle.getString("reporter");
            address = bundle.getString("address");
            bedrooms = bundle.getString("bedrooms");
            price = bundle.getString("price");
            furniture = bundle.getString("furniture");
            propertytype = bundle.getString("property_type");
        }

        // 2nd method to receive data.
        //username = intent.getStringExtra("username");
        //password = intent.getStringExtra("password");

        tvUsername.setText(username);
        tvReporter.setText(reporter);
        tvAddress.setText(address);
        tvBedrooms.setText(bedrooms);
        tvPrices.setText(price);
        tvFurniture.setText(furniture);
        tvNotes.setText(propertytype);
        tvTime.setText(format);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button btnConfirm = findViewById(R.id.btnConfirm);
        btnConfirm.setOnClickListener(btnConfirmBtn);
    }

    private View.OnClickListener btnConfirmBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent putText = new Intent(v.getContext(), SuccessfulActivity.class);
            startActivity(putText);
            finish();
        }
    };

    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}