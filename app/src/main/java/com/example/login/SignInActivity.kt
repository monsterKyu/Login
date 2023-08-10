package com.example.login

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignInActivity : AppCompatActivity() {
    //private lateinit var resultLauncher: ActivityResultLauncher<intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputId = findViewById<EditText>(R.id.input_id)
        val inputPsw = findViewById<EditText>(R.id.input_psw)
        val btn = findViewById<Button>(R.id.btn_login)

        btn.isEnabled = false

        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Check the input fields and enable the button accordingly
                btn.isEnabled = inputId.text.isNotBlank() && inputPsw.text.isNotBlank()

            }

            override fun afterTextChanged(s: Editable?) {}

        }

        btn.setOnClickListener {
            val iD=inputId.text.toString()
            val password = inputPsw.text.toString()


            if (iD.isNotBlank() && password.isNotBlank()){
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("username",iD)
                startActivity(intent)
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
            } else{
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
            }

        }

        inputId.addTextChangedListener(textWatcher)
        inputPsw.addTextChangedListener(textWatcher)

        val btn_join = findViewById<Button>(R.id.btn_join)
        btn_join.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}