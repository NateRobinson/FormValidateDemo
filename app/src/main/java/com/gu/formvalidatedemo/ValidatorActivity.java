package com.gu.formvalidatedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.throrinstudio.android.common.libs.validator.Form;
import com.throrinstudio.android.common.libs.validator.Validate;
import com.throrinstudio.android.common.libs.validator.validate.ConfirmValidate;
import com.throrinstudio.android.common.libs.validator.validator.EmailValidator;
import com.throrinstudio.android.common.libs.validator.validator.NotEmptyValidator;
import com.throrinstudio.android.common.libs.validator.validator.PhoneValidator;

/**
 * Created by Nate on 2015/10/10.Validator开源库使用示例
 */
public class ValidatorActivity extends AppCompatActivity {

    private EditText phoneEt, emailEt, pwdEt, pwdConfirmEt;
    private Form form;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.validator_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        phoneEt = (EditText) findViewById(R.id.phoneEt);
        emailEt = (EditText) findViewById(R.id.emailEt);
        pwdEt = (EditText) findViewById(R.id.pwdEt);
        pwdConfirmEt = (EditText) findViewById(R.id.pwdConfirmEt);

        //1.新建一个表单对象
        form = new Form();

        //2.定义一个手机号的验证对象
        Validate phoneValidate = new Validate(phoneEt);
        phoneValidate.addValidator(new PhoneValidator(this));

        //3.定义一个邮箱的验证对象
        Validate emailvValidate = new Validate(emailEt);
        emailvValidate.addValidator(new EmailValidator(this, R.string.error));
        emailvValidate.addValidator(new NotEmptyValidator(this));

        //4.定义一个验证密码是否一致的验证对象
        ConfirmValidate pwdConfirmValidate = new ConfirmValidate(pwdEt, pwdConfirmEt);
        pwdConfirmValidate.addValidator(new NotEmptyValidator(this));

        //5.将相关验证对象添加到表单对象中
        form.addValidates(phoneValidate);
        form.addValidates(emailvValidate);
        form.addValidates(pwdConfirmValidate);

        //6.监听点击事件，进行表单验证
        findViewById(R.id.validateBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (form.validate()) {
                    Toast.makeText(ValidatorActivity.this, "验证成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ValidatorActivity.this, "验证失败", Toast.LENGTH_SHORT).show();
                }
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
