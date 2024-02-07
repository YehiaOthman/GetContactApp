package com.yothman.getcontactapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class ContactData(val Name:String , val Phone:String , val Descrption:String ) :Parcelable