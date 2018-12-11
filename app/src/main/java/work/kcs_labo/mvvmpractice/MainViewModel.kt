package work.kcs_labo.mvvmpractice

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val inputText = MutableLiveData<String>()

    fun setInputText(value: String){
        inputText.value = value
    }
}