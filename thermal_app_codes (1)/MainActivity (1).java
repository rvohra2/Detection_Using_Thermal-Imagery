#android studio
#main functioning of app



package dic.uiet.pu.chd.thermaldata;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    static String PHP_URL = "http://192.168.42.7/PHPScripts/test.php";
    Boolean serviceRunning = false;
    EditText setURLET;
    Button uploadButton, setURLBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uploadButton = findViewById(R.id.uploadButton);
        uploadButton.setOnClickListener(this);
        setURLBTN = findViewById(R.id.setURLBTN);
        setURLBTN.setOnClickListener(this);
        setURLET = findViewById(R.id.phpURLET);
        setURLET.setText(PHP_URL);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.uploadButton:
            {
                if(!serviceRunning)
                {
                    Intent intent = new Intent(this, ThermalBackgroundService.class);
                    intent.putExtra("PHP_URL",PHP_URL);
                    startService(intent);
                    uploadButton.setText("Stop service");
                    serviceRunning = true;
                }
                else
                {
                    stopService(new Intent(this, ThermalBackgroundService.class));
                    uploadButton.setText("Start service");
                    serviceRunning = false;
                }
                break;
            }
            case R.id.setURLBTN:
            {
                PHP_URL = setURLET.getText().toString();
                Toast.makeText(getApplicationContext(),"URL set successfully!",Toast.LENGTH_SHORT).show();
                break;
            }
            default:
                break;
        }
    }
}
