package ro.pub.cs.systems.eim.varianta7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivitysecondary extends AppCompatActivity {
    private EditText text11;
    private EditText text22;
    private EditText text33;
    private EditText text44;
    private Button sum;
    private Button prod;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.button)
                setResult(RESULT_OK, null);
            else if (view.getId() == R.id.button11)
                setResult(RESULT_CANCELED, null);
            finish();
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activitysecondary);
        Intent intent = getIntent();
        text11 = findViewById(R.id.buton44);
        text22 = findViewById(R.id.buton33);
        text33 = findViewById(R.id.buton22);
        text44 = findViewById(R.id.buton11);
        sum = findViewById(R.id.button);
        prod = findViewById(R.id.button11);

        if (intent != null && intent.getExtras() != null) {
            text11.setText(String.valueOf(intent.getIntExtra("NUMBER_OF_CLICKS", 0)));
            text22.setText(String.valueOf(intent.getIntExtra("NUMBER_OF_CLICKS1", 0)));
            text33.setText(String.valueOf(intent.getIntExtra("NUMBER_OF_CLICKS2", 0)));
            text44.setText(String.valueOf(intent.getIntExtra("NUMBER_OF_CLICKS3", 0)));
        }


        sum = (Button) findViewById(R.id.button);
        sum.setOnClickListener(buttonClickListener);
        prod = (Button) findViewById(R.id.button11);
        prod.setOnClickListener(buttonClickListener);
       sum.setOnClickListener(v -> {
            Intent resultIntent = new Intent();
            int resultsum = Integer.parseInt(text11.getText().toString()) + Integer.parseInt(text22.getText().toString())+Integer.parseInt(text33.getText().toString())+Integer.parseInt(text44.getText().toString());
            resultIntent.putExtra("pressedButton", resultsum);
            setResult(RESULT_OK, resultIntent);
            finish();
        });

        prod.setOnClickListener(v -> {
            Intent resultIntent = new Intent();
            int resultprod = Integer.parseInt(text11.getText().toString()) * Integer.parseInt(text22.getText().toString())*Integer.parseInt(text33.getText().toString())*Integer.parseInt(text44.getText().toString());
            resultIntent.putExtra("pressedButton", resultprod);
            setResult(RESULT_CANCELED, resultIntent);
            finish();
        });

    }
}