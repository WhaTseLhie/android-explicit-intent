package pardillo.john.jv.explicitintent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class NameActivity extends AppCompatActivity {

    private final static String TAG = "NAME ACTIVITY";

    private TextView txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        this.txtName = this.findViewById(R.id.textView);

        // throws an exception if the data is null
        try {
            // get the all the data from previous class
            Bundle b = this.getIntent().getExtras();
            // get the specific data
            String name = b.getString("name");
            // show the data
            this.txtName.setText("Hi " +name);
        } catch(Exception e) {
            Log.d("ERROR: ", TAG);
        }
    }
}
