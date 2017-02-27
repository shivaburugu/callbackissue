package sampleapp.shiva.com.dialogissue;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button getValueButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getValueButton = (Button)findViewById(R.id.getvalue);
        getValueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = getValue(100,true);
                Toast.makeText(MainActivity.this,"Returned Value:: "+value,Toast.LENGTH_LONG).show();
            }
        });
    }

    //need to implement
    private String getValue(int converInt, boolean showDialog){
        final String[] result = new String[1];
        if(showDialog){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Title");

            final EditText input = new EditText(this);
            input.setInputType(InputType.TYPE_CLASS_NUMBER);
            builder.setView(input);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    result[0] = input.getText().toString();
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            builder.show();

        } else {
            result[0] = Integer.toString(converInt);
        }
        return result[0];
    }


    //older version of code
    private String getValue(int converInt){
        return Integer.toString(converInt);
    }

}
