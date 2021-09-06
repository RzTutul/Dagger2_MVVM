package com.rztechtunes.dagger2app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.rztechtunes.dagger2app.database.model.UserEntity
import com.rztechtunes.dagger2app.databinding.ActivityUserBinding
import com.rztechtunes.dagger2app.viewmodel.UserViewModel

class UserActivity : AppCompatActivity() {
    lateinit var binding: ActivityUserBinding
    lateinit var viewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        binding.saveBtn.setOnClickListener {

            val entity =UserEntity(firstName = binding.firstNameET.text.toString(),lastName =binding.secoundNameET.text.toString())

            viewModel.insertUser(entity)
        }



        viewModel.getAllUserList().observe(this,object :Observer<List<UserEntity>>{
            override fun onChanged(t: List<UserEntity>?) {

                if (t != null) {
                    binding.nameTV.setText("")
                    t.forEach {
                        binding.nameTV.append(it.firstName+" "+it.lastName+"\n")
                    }
                }

            }
        })

    }
}