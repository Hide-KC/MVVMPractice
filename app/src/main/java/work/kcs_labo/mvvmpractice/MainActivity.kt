package work.kcs_labo.mvvmpractice

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import kotlinx.android.synthetic.main.activity_main.*
import work.kcs_labo.mvvmpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Viewの生成（inflate）
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        //または次も可
//        val binding = ActivityMainBinding.inflate(layoutInflater)

        //MainViewModelの生成
        val viewmodel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewmodel.inputText.observe(this, Observer { input ->
            if (input != null) {
                //UI更新
                this.output.text = input
            }
        })

        //BindingインスタンスにViewModelを追加
        //これでMainActivityのViewとViewModelとが紐づけされる
        binding.viewmodel = viewmodel

        //TextWatcherで入力監視
        input.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //ここでViewModelを参照
                if (s != null) viewmodel.inputText.value = s.toString()
            }
        })
    }
}
