package io.github.pierry.codelab.ui

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import io.github.pierry.codelab.R
import io.github.pierry.codelab.domain.Word
import io.github.pierry.codelab.ui.adapter.WordListAdapter
import io.github.pierry.codelab.viewmodel.WordViewModel
import kotlinx.android.synthetic.main.home_activity.*
import org.jetbrains.anko.toast


class HomeActivity : AppCompatActivity() {

  private lateinit var wordViewModel: WordViewModel
  private lateinit var recyclerView: RecyclerView

  val NEW_WORD_ACTIVITY_REQUEST_CODE = 1

  lateinit var adapter: WordListAdapter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.home_activity)
    recyclerView = findViewById(R.id.recyclerview)
    wordViewModel = ViewModelProviders.of(this).get(WordViewModel::class.java)
    fab.setOnClickListener {
      val intent = Intent(this@HomeActivity, NewWordActivity::class.java)
      startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE)
    }
    recycler()
    observe()
  }

  fun recycler() {
    adapter = WordListAdapter(this)
    recyclerView.adapter = adapter
    recyclerView.layoutManager = LinearLayoutManager(this)
  }

  fun observe() {
    wordViewModel.getAllWords().observe(this, Observer<List<Word>>() {
      adapter.setWords(it!!)
    })
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    when (requestCode) {
      NEW_WORD_ACTIVITY_REQUEST_CODE -> {
        if (resultCode == Activity.RESULT_OK) {
          val word = Word(data!!.getStringExtra(NewWordActivity.EXTRA_REPLY))
          wordViewModel.insert(word)
          return
        }
        toast(getString(R.string.empty_not_saved))
      }
    }
  }
}
