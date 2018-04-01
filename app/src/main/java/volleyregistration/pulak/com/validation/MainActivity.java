package volleyregistration.pulak.com.validation;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtName,edtSurname,edtPhone;
    TextInputLayout nameLayout,surnameLayout,phoneLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName = (EditText) findViewById(R.id.edtName);
        edtSurname = (EditText) findViewById(R.id.edtSurname);
        edtPhone = (EditText) findViewById(R.id.edtPhone);
        nameLayout = (TextInputLayout) findViewById(R.id.til1);
        surnameLayout = (TextInputLayout) findViewById(R.id.til2);
        phoneLayout = (TextInputLayout) findViewById(R.id.til3);

        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( validateData() ) {
                    //
                }
            }
        });

    }
    private boolean validateData() {
        boolean result = true;

        String name = edtName.getText().toString().trim();
        if (name == null || name.length() < 3) {

            nameLayout.setError(getString(R.string.invalidName));
            result = false;
        }
        else

        nameLayout.setErrorEnabled(false);

        String surname = edtSurname.getText().toString().trim();
        if (surname == null || surname.length() < 3) {

            surnameLayout.setError(getString(R.string.invalidSurname));
            result = false;
        }
        else

        surnameLayout.setErrorEnabled(false);

        String phone = edtPhone.getText().toString().trim();
        if (phone == null || phone.equals("")) {
            phoneLayout.setError(getString(R.string.invalidNumber));
            result = false;
        }
        else if (phone.equals("0")) {
            phoneLayout.setError(getString(R.string.invalidNumberZero));
            result = false;
        }else{
            phoneLayout.setErrorEnabled(false);
        }

        return result;
    }
}
