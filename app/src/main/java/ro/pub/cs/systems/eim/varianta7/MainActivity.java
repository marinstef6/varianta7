package ro.pub.cs.systems.eim.varianta7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText text1;
    private EditText text2;
    private EditText text3;
    private EditText text4;

    private Button set;
    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private Button NavigateToSecondaryActivity;

    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.left_button) {
                set.setText(String.valueOf(" "));
                Intent intent = new Intent(getApplicationContext(), MainActivitysecondary.class);
                //aici a trebuit sa fac suma lor

                intent.putExtra("NUMBER_OF_CLICKS", Integer.parseInt(text1.getText().toString()));
                intent.putExtra("NUMBER_OF_CLICKS1", Integer.parseInt(text2.getText().toString()));
                intent.putExtra("NUMBER_OF_CLICKS2", Integer.parseInt(text3.getText().toString()));
                intent.putExtra("NUMBER_OF_CLICKS3", Integer.parseInt(text4.getText().toString()));

                startActivityForResult(intent, Constants.SECONDARY_ACTIVITY_REQUEST_CODE);
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = findViewById(R.id.left_edit_text);
        text2 = findViewById(R.id.right_edit_text);
        text3 = findViewById(R.id.left_edit_text2);
        text4 = findViewById(R.id.left_edit_text1);
        set = findViewById(R.id.left_button);
        set.setOnClickListener(new ButtonClickListener());
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Constants.SECONDARY_ACTIVITY_REQUEST_CODE && data != null) {

            int result = data.getIntExtra("pressedButton", -1);

            if (resultCode == RESULT_OK) {
                // Afișează mesaj pentru suma
                Toast.makeText(this, "Suma este: " + result, Toast.LENGTH_LONG).show();
            } else if (resultCode == RESULT_CANCELED) {
                // Afișează mesaj pentru produs
                Toast.makeText(this, "Produsul este: " + result, Toast.LENGTH_LONG).show();
            }
        }
    }
}

