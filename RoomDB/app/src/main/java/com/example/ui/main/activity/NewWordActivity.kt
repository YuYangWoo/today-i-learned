package com.example.ui.main.activity

import android.app.Activity
import android.content.Intent
import android.text.TextUtils
import android.widget.EditText
import com.example.roomdb.R
import com.example.roomdb.databinding.ActivityNewWordBinding
import com.example.ui.main.base.BaseActivity

class NewWordActivity : BaseActivity<ActivityNewWordBinding>(R.layout.activity_new_word) {
    private lateinit var editWordView: EditText
    override fun init() {
        super.init()
        editWordView = findViewById(R.id.edit_word)
        binding.buttonSave.setOnClickListener {
            val replyIntent = Intent()
            if(TextUtils.isEmpty(binding.editWord.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            }
            else {
                val word = editWordView.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, word)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }
    companion object {
        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
    }
}