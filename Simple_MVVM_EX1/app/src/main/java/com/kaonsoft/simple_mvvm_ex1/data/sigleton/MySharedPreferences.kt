package com.kaonsoft.simple_mvvm_ex1.data.sigleton

import android.content.Context
import android.content.SharedPreferences
import com.kaonsoft.simple_mvvm_ex1.data.model.Information

object MySharedPreferences {
    private val MY_ACCOUNT : String = "account"
    private var student: Information.Account = Information.Account()

    // 사용자 정보 Set
    fun setInformation(context: Context, type: String, department: String, studentId: String, name: String, college: String) {
        val prefs : SharedPreferences = context.getSharedPreferences(MY_ACCOUNT, Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = prefs.edit().apply{
            putString("MY_TYPE", type)
            putString("MY_DEPARTMENT", department)
            putString("MY_STUDENT_ID", studentId)
            putString("MY_NAME", name)
            putString("MY_COLLEGE", college)
        }
        editor.commit()
    }

    // 사용자 정보 얻기
    fun getInformation(context: Context): Information.Account{
        val prefs : SharedPreferences = context.getSharedPreferences(MY_ACCOUNT, Context.MODE_PRIVATE)
        with(student) {
            type = prefs.getString("MY_TYPE", "").toString()
            department = prefs.getString("MY_DEPARTMENT", "").toString()
            studentId = prefs.getString("MY_STUDENT_ID", "").toString()
            studentName = prefs.getString("MY_NAME", "").toString()
            college = prefs.getString("MY_COLLEGE", "").toString()
        }
        return student
    }

    // 사용자 Id Set
    fun setUserId(context: Context, input: String) {
        val prefs : SharedPreferences = context.getSharedPreferences(MY_ACCOUNT, Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = prefs.edit()
        editor.putString("MY_ID", input)
        editor.commit()
    }

    fun getUserId(context: Context): String {
        val prefs : SharedPreferences = context.getSharedPreferences(MY_ACCOUNT, Context.MODE_PRIVATE)
        return prefs.getString("MY_ID", "").toString()
    }

    fun setUserPass(context: Context, input: String) {
        val prefs : SharedPreferences = context.getSharedPreferences(MY_ACCOUNT, Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = prefs.edit()
        editor.putString("MY_PASS", input)
        editor.commit()
    }

    fun getUserPass(context: Context): String {
        val prefs : SharedPreferences = context.getSharedPreferences(MY_ACCOUNT, Context.MODE_PRIVATE)
        return prefs.getString("MY_PASS", "").toString()
    }

    fun clearUser(context: Context) {
        val prefs : SharedPreferences = context.getSharedPreferences(MY_ACCOUNT, Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = prefs.edit()
        editor.clear()
        editor.commit()
    }

    fun setCheck(context: Context, input: Boolean) {
        val prefs : SharedPreferences = context.getSharedPreferences(MY_ACCOUNT, Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = prefs.edit()
        editor.putBoolean("MY_AUTO_LOGIN", input)
        editor.commit()
    }

    fun getCheck(context: Context) : Boolean{
        val prefs : SharedPreferences = context.getSharedPreferences(MY_ACCOUNT, Context.MODE_PRIVATE)
        return prefs.getBoolean("MY_AUTO_LOGIN", false)
    }
}