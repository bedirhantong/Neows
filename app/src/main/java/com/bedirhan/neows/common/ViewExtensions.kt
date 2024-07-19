package com.bedirhan.neows.common

import android.view.View


// Makes a view visible
fun View.show() {
    this.visibility = View.VISIBLE
}

// Makes a view gone
fun View.hide() {
    this.visibility = View.GONE
}

// Makes a view invisible
fun View.invisible() {
    this.visibility = View.INVISIBLE
}