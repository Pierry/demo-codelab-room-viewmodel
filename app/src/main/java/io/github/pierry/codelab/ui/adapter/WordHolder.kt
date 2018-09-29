package io.github.pierry.codelab.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import io.github.pierry.codelab.R

class WordHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

  val textView: TextView = itemView.findViewById(R.id.textView) as TextView

  fun bind(text: String) {
    textView.text = text
  }

}