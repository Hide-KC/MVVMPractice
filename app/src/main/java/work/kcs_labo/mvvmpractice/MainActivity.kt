package work.kcs_labo.mvvmpractice

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

const val MAIN_FRAG = "MAIN"
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ViewModelの生成
        //特に使うわけじゃないけど、onCreateで生成しなければならない
        obtainViewModel()

        //Fragmentに置換
        val fragment = MainFragment.newInstance()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame, fragment, MAIN_FRAG)
        transaction.commit()
    }

    fun obtainViewModel() = ViewModelProviders.of(this).get(MainViewModel::class.java)
}
