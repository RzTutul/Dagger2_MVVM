package com.rztechtunes.dagger2app.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rztechtunes.dagger2app.R
import com.rztechtunes.dagger2app.UserActivity
import com.rztechtunes.dagger2app.databinding.RowUserBinding
import com.rztechtunes.dagger2app.model.AdmissionModel
import com.rztechtunes.dagger2app.model.UserProfileModel
import kotlin.coroutines.coroutineContext

class UserAdapter(val context:Context): RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    var list = ArrayList<AdmissionModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val  binding = RowUserBinding.inflate(LayoutInflater.from(parent.context),parent,false);
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        with(holder)
        {
            binding.nameTV.setText(list.get(position).ApplicantsName)
            Glide.with(context).load(list.get(position).ApplicantCpmbinedImg).into(binding.imageview)
        }

        holder.itemView.setOnClickListener()
        {
            Toast.makeText(context,list.get(position).ApplicantsName,Toast.LENGTH_LONG).show()
            val intent = Intent(context, UserActivity::class.java).apply {
                putExtra("EXTRA_MESSAGE", "message")
            }
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
      return list.size
    }

    fun setDataList(data: List<AdmissionModel>) {
        list= data as ArrayList<AdmissionModel>
        notifyDataSetChanged()
    }

    class UserViewHolder(val binding: RowUserBinding) : RecyclerView.ViewHolder(binding.root)
}