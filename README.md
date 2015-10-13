# 安卓表单输入验证开源库系统学习Demo
## 一、Android Validate  表单验证开源库使用
> 【开源库地址：[https://github.com/throrin19/Android-Validator](https://github.com/throrin19/Android-Validator "https://github.com/throrin19/Android-Validator")】
> 
> validator开源库的作用是用来对Android平台的输入框内容或者TextView内容进行相关验证。

## 常用验证功能：
1. Email（电子邮箱）
2. 手机号码格式验证
3. Required（必填）
4. NotBlank（非空数据）
5. Digits（只能数字）
6. 二选一必填验证
7. 重复密码验证
8. HttpUrl验证

## 基本使用流程：

1. 创建一个最外层的Form表单类，用来装载控件
2. 创建一个验证用的Validate类，将待验证的EditText传进去
3. 使用addValidator加入要判断验证的类型
4. 第一步创建的Form表单类实例使用addValidates方法添加进上面的Validate类实例
5. 调用from.validate（）方法开始验证：true表示成功，false表示失败

## 简单代码示例：

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
# 二、MaterialEditText开源库的使用
---
## 简介与库地址
>其实在AppCompat V21中就提供了Material Design的控件外观支持，其中就有一个EditText，但是此EditText使用起来不是很方便，
才有了MaterialEditText开源库的诞生，下面就随我一起来学习一下此开源库的使用。

>【开源库地址：[https://github.com/rengwuxian/MaterialEditText](https://github.com/rengwuxian/MaterialEditText "https://github.com/rengwuxian/MaterialEditText")】

## MaterialEditText的配置属性详解
1. 代码中使用setEnabled(boolean enabled)方法设置MaterialEditText是否为可编辑状态；
2. 悬浮的标签（Floating Label）：
	1. app:met_floatingLabel="normal"：低亮的悬浮标签；
	2. app:met_floatingLabel="highlight"：高亮的悬浮标签；
	3. app:met_floatingLabelTextColor="#8805ad"：默认的悬浮低亮标签为灰色，高亮为黑色，此属性可以自定义悬浮标签颜色。
3. 帮助文字（Helper Text）：
	1. app:met_helperText="Helper Text"：设置helpertext文字；
	2. app:met_helperTextColor="#795548"：设置hlpertext文字颜色。
4. EditText下划线（underline）：
	1. app:met_hideUnderline="true"：underline显示开关；
	2. app:met_underlineColor="#003587"：underline颜色。 
5. 错误提示：
	1. app:met_errorColor="#ddaa00"：设置错误提示的颜色；
	2. setError(CharSequence error)：设置error提示文本。
6. 最长/最短字符数：
	1. app:met_minCharacters="3"：设置最小字符数限制；
	2. app:met_maxCharacters="5"：设置最大字符数限制。
7. 自定义Validation：自定义匹配规则，检查输入内容是否匹配。
	
	```
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
	```

8. 自定义字体样式：在main文件夹中新建assets/fonts目录，并将自定义字体放到下面
	1. app:met_accentTypeface="fonts/Roboto-LightItalic.ttf"：设置悬浮标签、helpertext、字数提示等字体；
	2. app:met_typeface="fonts/Roboto-LightItalic.ttf"：设置EditText输入内容的字体格式。
9. 清除按钮：app:met_clearButton="true"：clearbutton是否展示的开关。
10. 为EditText添加icon：
	1.  app:met_iconLeft="@mipmap/ic_phone"：设置左icon图标【同理有met_iconRight】；
	2.  app:met_iconPadding="0dp"：设置图片的padding值，默认为16dp；
