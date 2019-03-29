package ro.pub.cs.systems.eim.practicaltest01var04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText textbox = null;
    private Button button_topleft = null;
    private Button button_topright = null;
    private Button button_bottomleft = null;
    private Button button_bottomright = null;
    private Button button_center = null;
    int numberOfClicks = 0;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.button_topright:
                    //int leftNumberOfClicks = Integer.parseInt(leftEditText.getText().toString());
                    //leftNumberOfClicks++;
                    //textbox.setText(String.valueOf(leftNumberOfClicks));
                    textbox.append("TOP RIGHT, ");
                    numberOfClicks++;
                    break;
                case R.id.button_topleft:
                    //int leftNumberOfClicks = Integer.parseInt(leftEditText.getText().toString());
                    //leftNumberOfClicks++;
                    //textbox.setText(String.valueOf(leftNumberOfClicks));
                    textbox.append("TOP LEFT, ");
                    numberOfClicks++;
                    break;
                case R.id.button_bottomleft:
                    //int leftNumberOfClicks = Integer.parseInt(leftEditText.getText().toString());
                    //leftNumberOfClicks++;
                    //textbox.setText(String.valueOf(leftNumberOfClicks));
                    textbox.append("BOTTOM LEFT, ");
                    numberOfClicks++;
                    break;
                case R.id.button_bottomright:
                    //int leftNumberOfClicks = Integer.parseInt(leftEditText.getText().toString());
                    //leftNumberOfClicks++;
                    //textbox.setText(String.valueOf(leftNumberOfClicks));
                    textbox.append("BOTTOM RIGHT, ");
                    numberOfClicks++;
                    break;
                case R.id.button_center:
                    //int leftNumberOfClicks = Integer.parseInt(leftEditText.getText().toString());
                    //leftNumberOfClicks++;
                    //textbox.setText(String.valueOf(leftNumberOfClicks));
                    textbox.append("CENTER, ");
                    numberOfClicks++;
                    break;

            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textbox = (EditText)findViewById(R.id.editText2);

        button_topleft = (Button)findViewById(R.id.button_topleft);
        button_topright = (Button)findViewById(R.id.button_topright);
        button_bottomleft = (Button)findViewById(R.id.button_bottomleft);
        button_bottomright = (Button)findViewById(R.id.button_bottomright);
        button_center = (Button)findViewById(R.id.button_center);

        button_topright.setOnClickListener(buttonClickListener);
        button_topleft.setOnClickListener(buttonClickListener);
        button_bottomright.setOnClickListener(buttonClickListener);
        button_bottomleft.setOnClickListener(buttonClickListener);
        button_center.setOnClickListener(buttonClickListener);


        String text = "Numarul de click-uri este " + Integer.toString(numberOfClicks) + "\n";

        Toast.makeText(MainActivity.this,
                text, Toast.LENGTH_LONG).show();



    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("number", Integer.toString(numberOfClicks).toString());

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if(savedInstanceState.containsKey("number")){
            numberOfClicks = Integer.parseInt(savedInstanceState.getString("number"));
        }
        else
            numberOfClicks = 0;
    }
}
