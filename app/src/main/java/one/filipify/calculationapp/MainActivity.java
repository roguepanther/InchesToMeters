package one.filipify.calculationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText inchesInput;
    private Button calculateButton;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find Views
        findViews();
        setupButtonClickListener();
    }

    private void findViews(){
        inchesInput = findViewById(R.id.edit_text_input);
        calculateButton = findViewById(R.id.button_calculate);
        resultText = findViewById(R.id.text_view_result);
    }

    // Set a listener on click of the button
    private void setupButtonClickListener() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inchesInput.getText().length() == 0){
                    Toast.makeText(MainActivity.this, "Please enter a value", Toast.LENGTH_LONG).show();
                } else {
                    double convertValue = convertToMeters();
                    displayResult(convertValue);
                }

            }
        });
    }


    // Method to perform the maths and return a decimal height value
    private double convertToMeters(){
        String userInches = inchesInput.getText().toString();

        //Converting the number string to integer
        int inches = Integer.parseInt(userInches);

        double conversion = inches / 39.37;

        return conversion;
    }

    // Method to display the result
    private void displayResult(double conversion) {
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.000");
        String conversionResult = myDecimalFormatter.format(conversion);

        resultText.setText(conversionResult + " meters");

    }


}