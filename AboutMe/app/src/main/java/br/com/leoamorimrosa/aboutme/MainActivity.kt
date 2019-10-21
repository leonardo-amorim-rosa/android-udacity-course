package br.com.leoamorimrosa.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import br.com.leoamorimrosa.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // data binding
    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Leo Rosa")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // data binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.doneButton.setOnClickListener {
            addNickName(it)
        }
        binding.myName = myName
    }

    private fun addNickName(view: View) {
        // data binding
        binding.apply {
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()

            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }
        // hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
