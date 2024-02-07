package com.yothman.getcontactapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yothman.getcontactapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var name :String
    lateinit var phone :String
    lateinit var  descrption:String
    lateinit var adapter:ContactAdapter
    var contactList = mutableListOf<ContactData>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRv()
        saveBtnClick()




    }

    private fun initRv() {
        adapter = ContactAdapter(contactList)
        binding.ContactUserRv.adapter =adapter
        adapter.listner = ContactAdapter.OnContactclickListner { contact ->
            val intent = Intent(this,ContactDetails::class.java)
            intent.putExtra(Constans.contact,contact)
            startActivity(intent)
            
        }


    }

    fun textValidation() :Boolean{

        name = binding.ContactNameETi.text?.trim().toString()
        phone = binding.ContactNumberETi.text?.trim().toString()
        binding.ContactNameTi.error = validName(name)
        binding.ContactNumberTi.error = validPhoneNumber(phone)

        if (validName(name)==null&&validPhoneNumber(phone)==null)
            return true
        else
            return false

    }

    fun validName(name : String): String? {
        if (name.isEmpty())
            return "Fill the name text"
        if (name.trim().length<3)
            return "Invalid Name 'min 3 characters'"
        return null

    }

    fun validPhoneNumber(PhoneNumber:String):String?{

        if (PhoneNumber.isEmpty())
            return "Fill the number text"
        if (PhoneNumber.trim().length<11)
            return "Invalid phone number 'must be 11 digit"
        return null

    }

   fun saveBtnClick(){
       binding.ContactSaveBtn.setOnClickListener {

           if (!textValidation()){
               return@setOnClickListener
           }

           name = binding.ContactNameETi.text?.trim().toString()
           phone = binding.ContactNumberETi.text?.trim().toString()
           descrption = binding.ContactDescrptionETi.text?.trim().toString()

           val contact  = ContactData(name,phone,descrption)

           contactList.add(contact)
           adapter.notifyItemInserted(contactList.size-1)
       }


   }
}