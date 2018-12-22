package work.kcs_labo.mvvmpractice

import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import work.kcs_labo.mvvmpractice.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //inflate
        val binding = DataBindingUtil.inflate<FragmentMainBinding>(inflater, R.layout.fragment_main, container,false)

        //ActivityからViewModelの取得
        //LifecycleOwnerに紐づいたViewModelが返る
        val viewmodel = (activity as MainActivity).obtainViewModel()

        //ViewとViewModelとを紐づけ
        binding.viewmodel = viewmodel
        //LifecycleOwnerをセット（重要！）
        binding.setLifecycleOwner(this)

        //TextWatcherの追加
        binding.input.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.viewmodel?.setInputText(s.toString())
            }
        })

        return binding.root
    }

    companion object {
        fun newInstance(): MainFragment {
            val fragment = MainFragment()
            return fragment
        }
    }
}