package vn.edu.greenwich.javade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Link to the layout "activity_main.xml".
        setContentView(R.layout.activity_main);

        // Get the content of string "btn_login" in "strings.xml".
        String btnLoginName = getResources().getString(R.string.btn_next);
        // Get the content of string "notification_01" in "strings.xml".
        String notification_01 = getResources().getString(R.string.notification_01);

        // Like "alert" in JavaScript.
        Toast.makeText(this, notification_01, Toast.LENGTH_LONG).show();

        // Get button "Login" from current Layout using id of button.
        Button btnLogin = findViewById(R.id.btnNext);
        // Set the name of the button.
        btnLogin.setText(btnLoginName);
        // Add an event "Click" to the button.
        btnLogin.setOnClickListener(btnLogin_Click);

    }

    private View.OnClickListener btnLogin_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Boolean isValid = true;

            TextView tvError = findViewById(R.id.tvError);
            TextView tvUsername = findViewById(R.id.tvUsername);
            TextView tvReporter = findViewById(R.id.tvReporter);
            TextView tvAddress = findViewById(R.id.tvAddress);
            TextView tvBedrooms = findViewById(R.id.tvBedrooms);
            TextView tvPrice = findViewById(R.id.tvPrice);
            TextView tvFurniture = findViewById(R.id.tvFurniture);
            TextView tvNotes = findViewById(R.id.tvPropertytype);


            String error = "";
            String username = tvUsername.getText().toString();
            String reporter = tvReporter.getText().toString();
            String address = tvAddress.getText().toString();
            String bedrooms = tvBedrooms.getText().toString();
            String price = tvPrice.getText().toString();
            String furniture = tvFurniture.getText().toString();
            String propertytype = tvNotes.getText().toString();
            String notification_02 = getResources().getString(R.string.notification_02);

            // Like "alert" in JavaScript.
            Toast.makeText(v.getContext(), notification_02, Toast.LENGTH_LONG).show();

            // Check whether username is empty or not.
            if (TextUtils.isEmpty(username)) {
                isValid = false;
                error += "* Username cannot be empty.\n";
            }

            // Check whether password is empty or not.

            if (TextUtils.isEmpty(address)) {
                isValid = false;
                error += "* Address cannot be empty.\n";
            }
            if (TextUtils.isEmpty(bedrooms)) {
                isValid = false;
                error += "* Bedrooms cannot be empty.\n";
            }
            if (TextUtils.isEmpty(price)) {
                isValid = false;
                error += "* Price cannot be empty.\n";
            }
            if (TextUtils.isEmpty(furniture)) {
                isValid = false;
                error += "* Furniture cannot be empty.\n";
            }
            if (TextUtils.isEmpty(propertytype)) {
                isValid = false;
                error += "* Property cannot be empty.\n";
            }
            if (TextUtils.isEmpty(reporter)) {
                isValid = false;
                error += "* reporter cannot be empty.\n";
            }

            // Check whether form is valid or not.
            if (isValid) {
                // Show alerts.
                Toast.makeText(v.getContext(), username, Toast.LENGTH_LONG).show();
                Toast.makeText(v.getContext(), reporter, Toast.LENGTH_LONG).show();
                Toast.makeText(v.getContext(), address, Toast.LENGTH_LONG).show();
                Toast.makeText(v.getContext(), bedrooms, Toast.LENGTH_LONG).show();
                Toast.makeText(v.getContext(), furniture, Toast.LENGTH_LONG).show();
                Toast.makeText(v.getContext(), price, Toast.LENGTH_LONG).show();
                Toast.makeText(v.getContext(), propertytype, Toast.LENGTH_LONG).show();

                Bundle accountInfo = new Bundle();
                accountInfo.putString("username", username);
                accountInfo.putString("reporter", reporter);
                accountInfo.putString("address", address);
                accountInfo.putString("bedrooms", bedrooms);
                accountInfo.putString("price", price);
                accountInfo.putString("furniture", furniture);
                accountInfo.putString("property_type", propertytype);


                Intent putText = new Intent(v.getContext(), ConfirmActivity.class);


                putText.putExtras(accountInfo);
                startActivity(putText);

            } else {

                tvError.setText(error);

                Log.e("Main Activity", error);
            }
        }
    };
}