package nineinfosys.resistorcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView lengthTextview,diameterTextview,conductivityTextview;
    EditText lengthEditText,diameterEditText,conductivityEditText;
    TextView result;
    Spinner lengthUnit;
    TextView result1;
    Spinner diameterUnit;
    resistorCalci resistorValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lengthTextview=(TextView)findViewById(R.id.textViewLength);
        diameterTextview=(TextView)findViewById(R.id.textViewDiameter);
        conductivityTextview=(TextView)findViewById(R.id.textViewConductivity);
        result=(TextView)findViewById(R.id.textViewResult);
        result1=(TextView)findViewById(R.id.textViewResult1);

        lengthEditText=(EditText)findViewById(R.id.editTextLength);
        diameterEditText=(EditText)findViewById(R.id.editTextDiameter);
        conductivityEditText=(EditText)findViewById(R.id.editTextConductivity);

        Button buttonCalculte=(Button) findViewById(R.id.buttonCalculate);
        Button buttonClear=(Button) findViewById(R.id.buttonClear);
        lengthUnit = (Spinner) findViewById(R.id.spinnerLength);
        diameterUnit = (Spinner) findViewById(R.id.spinnerDiameter);

        ArrayList area = new ArrayList();
        area.add("mile");
        area.add("km");
        area.add("m");
        area.add("cm");
        area.add("mm");
        area.add("inch");
        area.add("ft");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, area);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lengthUnit.setAdapter(dataAdapter);


        ArrayList area1 = new ArrayList();

        area1.add("mile");
        area1.add("km");
        area1.add("m");
        area1.add("cm");
        area1.add("mm");
        area1.add("inch");
        area1.add("ft");

        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, area1);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        diameterUnit.setAdapter(dataAdapter1);


        buttonCalculte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lengthEditText.getText().toString().trim().equals("")) {
                    lengthEditText.setError("Enter the length");
                } else if (diameterEditText.getText().toString().trim().equals("")) {
                    diameterEditText.setError("Enter Diameter");
                }
                else if (conductivityEditText.getText().toString().trim().equals("")) {
                    conductivityEditText.setError("Enter Conductivity");

                }
                else{

                    resistorCalci gfr_calci=new resistorCalci();

                    double gfr=gfr_calci.resistorCalci(Double.parseDouble(lengthEditText.getText().toString().trim()),
                            Double.parseDouble(diameterEditText.getText().toString().trim()),Double.parseDouble(conductivityEditText.getText().toString().trim()),
                            lengthUnit.getSelectedItem().toString().trim(),diameterUnit.getSelectedItem().toString().trim());


                    result.setText("Resistance of a conductor::" + gfr);



                }
            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                lengthEditText.getText().clear();
                diameterEditText.getText().clear();
                conductivityEditText.getText().clear();
                result.setText("");
                result1.setText("");

            }
        });
    }
}
