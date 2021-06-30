package com.pisey.hiltmvvmexample.ui.main

import android.app.Activity
import android.net.Uri
import android.view.View
import com.facebook.drawee.view.SimpleDraweeView
import com.google.android.material.snackbar.Snackbar

fun View.show(){
    this.visibility = View.VISIBLE
}

fun View.hide(){
    this.visibility = View.GONE
}

fun SimpleDraweeView.loadImage(url: String){
    this.setImageURI(Uri.parse(url))
}

fun Activity.snackbar(msg: String, action: (() -> Unit)? = null){
    Snackbar.make(findViewById(android.R.id.content),
    msg,
    Snackbar.LENGTH_LONG).also {
        it.setAction("OK"){
            action?.invoke()
        }
    }.show()
}