package io.github.pierry.codelab.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import io.github.pierry.codelab.R
import io.github.pierry.codelab.domain.Word

class WordListAdapter(val context: Context) : RecyclerView.Adapter<WordHolder>() {

  lateinit var mWords: List<Word>

  init {
    mWords = ArrayList<Word>()
  }

  override fun onCreateViewHolder(parent: ViewGroup, position: Int): WordHolder {
    val itemView = LayoutInflater.from(context).inflate(R.layout.recyclerview_item, parent, false)
    return WordHolder(itemView)
  }

  override fun getItemCount(): Int {
    return mWords.count()
  }

  override
  fun onBindViewHolder(holder: WordHolder, position: Int) {
    val word: Word = mWords.get(position)
    holder.bind(word.world)
  }

  fun setWords(words: List<Word>) {
    mWords = words
    notifyDataSetChanged()
  }

}