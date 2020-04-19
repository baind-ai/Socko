package com.example.socko

import android.content.Context


fun setState(context: Context, state: Int) {
    val sharedPref = context.getSharedPreferences("com.example.socko.prefs", Context.MODE_PRIVATE) ?: return
    with(sharedPref.edit()) {
        putInt("state", state)
        commit()
    }
}

fun getState(context: Context): Int {
    val sharedPref = context.getSharedPreferences("com.example.socko.prefs", Context.MODE_PRIVATE)
    return sharedPref.getInt("state", 0)
}

fun getMoney(context: Context): Int{
    val sharedPref = context.getSharedPreferences("com.example.socko.prefs", Context.MODE_PRIVATE)
    return sharedPref.getInt("money", 0)
}

fun setMoney(context: Context, money: Int) {
    val sharedPref = context.getSharedPreferences("com.example.socko.prefs", Context.MODE_PRIVATE) ?: return
    with(sharedPref.edit()) {
        putInt("money", money)
        commit()
    }
}

fun setTime(context: Context, time: Long) {
    val sharedPref = context.getSharedPreferences("com.example.socko.prefs", Context.MODE_PRIVATE) ?: return
    with(sharedPref.edit()) {
        putLong("time", time)
        commit()
    }
}

fun getTime(context: Context): Long{
    val sharedPref = context.getSharedPreferences("com.example.socko.prefs", Context.MODE_PRIVATE)
    return sharedPref.getLong("time", 0)
}