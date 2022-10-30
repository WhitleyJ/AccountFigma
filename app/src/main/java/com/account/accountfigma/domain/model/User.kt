package com.account.accountfigma.domain.model

data class User(
    val image: String,
    val name: String,
    val subscribed: Boolean,
    var id : Int = UNDEFINED_ID
){
    companion object{
        const val UNDEFINED_ID = -1
    }
}
