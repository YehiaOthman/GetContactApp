package com.yothman.getcontactapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(val ContactList:List<ContactData>):RecyclerView.Adapter<ContactAdapter.ViewHolder>() {
    class ViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        val nameTv :TextView = itemView.findViewById(R.id.ContactUserNameTv)
        val phoneNumTv :TextView = itemView.findViewById(R.id.ContactUserNumberTv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_view_rv,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return ContactList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = ContactList[position]
        holder.nameTv.text = contact.Name
        holder.phoneNumTv.text = contact.Phone
        holder.itemView.setOnClickListener{
            listner?.onClick(contact)
        }
        holder.nameTv.setOnClickListener {
            NameListner?.onClick(contact)
        }
    }

    fun interface  OnContactclickListner{
        fun onClick(contact : ContactData)
    }

    var listner: OnContactclickListner? = null

    interface OnNameClickListner{
        fun onClick(contact :ContactData)
    }

    var NameListner: OnNameClickListner? = null

}