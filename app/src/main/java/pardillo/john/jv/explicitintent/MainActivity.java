package pardillo.john.jv.explicitintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtName;
    private Button btnSave, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.txtName = this.findViewById(R.id.editText);
        this.btnSave = this.findViewById(R.id.button);
        this.btnClear = this.findViewById(R.id.button2);

        this.btnSave.setOnClickListener(this);
        this.btnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.button:
                // get the string from the editText
                String name = this.txtName.getText().toString();

                // check if the string is empty
                if(TextUtils.isEmpty(name)) {
                    // prompt if the string is empty
                    Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show();
                } else {
                    // setup to call name activity
                    Intent intent = new Intent(this, NameActivity.class);
                    // carry data to name activity
                    intent.putExtra("name", name);
                    // call activity
                    startActivity(intent);

                    // set the editText to blank for ease
                    this.txtName.setText("");
                }

                break;
            case R.id.button2:
                // clear editText
                this.txtName.setText("");

                break;
        }
    }
}
