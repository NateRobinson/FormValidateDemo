package com.gu.formvalidatedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.rengwuxian.materialedittext.MaterialEditText;
import com.rengwuxian.materialedittext.validation.RegexpValidator;

/**
 * Created by Nate on 2015/10/12. MaterialEditText开源库使用示例
 */
public class MaterialEditTextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.material_edittext_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initEnableBt();
        initSingleLineEllipsisEt();
        initSetErrorEt();
        initValidationEt();
    }

    private void initEnableBt() {
        final EditText basicEt = (EditText) findViewById(R.id.basicEt);
        final Button enableBt = (Button) findViewById(R.id.enableBt);
        enableBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                basicEt.setEnabled(!basicEt.isEnabled());
                enableBt.setText(basicEt.isEnabled() ? "DISABLE" : "ENABLE");
            }
        });
    }

    private void initSingleLineEllipsisEt() {
        EditText singleLineEllipsisEt = (EditText) findViewById(R.id.singleLineEllipsisEt);
        singleLineEllipsisEt.setSelection(singleLineEllipsisEt.getText().length());
    }

    private void initSetErrorEt() {
        final EditText bottomTextEt = (EditText) findViewById(R.id.bottomTextEt);
        final Button setErrorBt = (Button) findViewById(R.id.setErrorBt);
        setErrorBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomTextEt.setError("1-line Error!");
            }
        });
        final Button setError2Bt = (Button) findViewById(R.id.setError2Bt);
        setError2Bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomTextEt.setError("2-line\nError!");
            }
        });
        final Button setError3Bt = (Button) findViewById(R.id.setError3Bt);
        setError3Bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomTextEt.setError("So Many Errors! So Many Errors! So Many Errors! So Many Errors! So Many Errors! So Many Errors! So Many Errors! So Many Errors!");
            }
        });
    }

    private void initValidationEt() {
        final MaterialEditText validationEt = (MaterialEditText) findViewById(R.id.validationEt);
        validationEt.addValidator(new RegexpValidator("Only Integer Valid!", "\\d+"));
        final Button validateBt = (Button) findViewById(R.id.validateBt);
        validateBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // validate
                validationEt.validate();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
