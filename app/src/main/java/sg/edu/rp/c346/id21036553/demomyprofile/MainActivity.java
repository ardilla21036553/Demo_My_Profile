package sg.edu.rp.c346.id21036553.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etName, etGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    etName = findViewById(R.id.etName);
    etGPA = findViewById(R.id.etGPA);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //step 1a: Get the user input from the EditText and store it in a variable
        String strName = etName.getText().toString();
        float GPA = Float.parseFloat((etGPA.getText().toString()));
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putString("name", strName);
        prefEdit.putFloat("gpa", GPA);
        prefEdit.commit();

    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        String strName = prefs.getString("name", "John");
        Float gpa = prefs.getFloat("gpa", 0 );
        etName.setText(strName);
        etGPA.setText(gpa + "");

    }

}