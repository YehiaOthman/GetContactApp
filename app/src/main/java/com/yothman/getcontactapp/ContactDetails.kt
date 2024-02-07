package com.yothman.getcontactapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.IntentCompat
import com.yothman.getcontactapp.databinding.ContactDetailsBinding

class ContactDetails :AppCompatActivity() {
    lateinit var binding :ContactDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ContactDetailsBinding.inflate(layoutInflater)
        val contact = IntentCompat.getParcelableExtra(intent,Constans.contact,ContactData::class.java)
        contact?.let {contact ->
        }

        binding.userNameTv.text = contact?.Name
        binding.userNumberTv.text = contact?.Phone
        setContentView(binding.root)

    }
}