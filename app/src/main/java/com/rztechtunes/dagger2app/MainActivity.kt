package com.rztechtunes.dagger2app

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.rztechtunes.dagger2app.adapter.UserAdapter
import com.rztechtunes.dagger2app.databinding.ActivityMainBinding
import com.rztechtunes.dagger2app.model.NidResponse
import com.rztechtunes.dagger2app.model.UserProfileModel
import com.rztechtunes.dagger2app.viewmodel.AdmissionViewModel
import com.rztechtunes.dagger2app.viewmodel.VerifyViewModel

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: VerifyViewModel
    lateinit var binding: ActivityMainBinding;
    lateinit var adapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val list = ArrayList<UserProfileModel>()
        list.add(UserProfileModel("Tutul", "Mirpur", "1231321"))
        list.add(UserProfileModel("Shuvo", "Mirpur", "fas"))

        adapter = UserAdapter( this)
        binding.reccylerView.layoutManager = LinearLayoutManager(this)
        binding.reccylerView.adapter = adapter


       val  viewModel = ViewModelProviders.of(this).get(VerifyViewModel::class.java)

        viewModel.getVerifyData().observe(this, Observer {
            Log.d("Dataadsa", it.data[0].name)

        })


        val admissionModel = ViewModelProviders.of(this).get(AdmissionViewModel::class.java)

        admissionModel.getAdmissionData().observe(this, Observer {
            Log.d("admisison",it.data[0].ApplicantsName)

            adapter.setDataList(it.data)
        })

    }
}