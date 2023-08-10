package com.example.login

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val inputName = findViewById<EditText>(R.id.input_name)
        val inputID = findViewById<EditText>(R.id.input_id)
        val inputPsw = findViewById<EditText>(R.id.input_psw)
        val btnJoin = findViewById<Button>(R.id.btn_join)

        btnJoin.isEnabled = false

        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Check the input fields and enable the button accordingly
                btnJoin.isEnabled = inputName.text.isNotBlank() &&
                        inputID.text.isNotBlank() &&
                        inputPsw.text.isNotBlank()
            }

            override fun afterTextChanged(s: Editable?) {}

        }
        inputName.addTextChangedListener(textWatcher)
        inputID.addTextChangedListener(textWatcher)
        inputPsw.addTextChangedListener(textWatcher)

        btnJoin.setOnClickListener {
            val name = inputName.text
            val id = inputID.text
            val psw = inputPsw.text
            if (name.isNotBlank() && id.isNotBlank() && psw.isNotBlank()) {
                Toast.makeText(this, "회원가입 성공", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "이름, 아이디, 비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show()
            }
            finish()
        }
    }
}





