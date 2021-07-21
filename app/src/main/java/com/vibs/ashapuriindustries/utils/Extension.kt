package com.shreejipackaging.utils

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.google.android.material.snackbar.Snackbar


fun View.setVisibility(isVisible: Boolean) {
    if (isVisible) {
        this.visibility = View.VISIBLE
    } else {
        this.visibility = View.GONE
    }

}

fun View.animateToShow() {
    this.animate()
        .setDuration(20)
        .alpha(1f)
        .start()
}

fun View.animateToHide() {
    this.animate()
        .setDuration(20)
        .alpha(0f)
        .start()
}

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun Context.toast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun View.showSnackBar(msg: String) {
    Snackbar.make(this, msg, Snackbar.LENGTH_SHORT).show()
}

fun ActionBar?.setupActionBar() {
    this?.setDisplayHomeAsUpEnabled(true)
    this?.setDisplayShowHomeEnabled(true)
    this?.setDisplayShowTitleEnabled(false)
}