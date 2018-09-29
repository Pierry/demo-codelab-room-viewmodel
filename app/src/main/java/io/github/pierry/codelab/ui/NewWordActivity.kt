package io.github.pierry.codelab.ui

import android.app.Activity
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import io.github.pierry.codelab.R
import io.github.pierry.codelab.viewmodel.WordViewModel
import kotlinx.android.synthetic.main.home_new_word.*

class NewWordActivity : AppCompatActivity() {

  private lateinit var wordViewModel: WordViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    wordViewModel = ViewModelProviders.of(this).get(WordViewModel::class.java)
    setContentView(R.layout.home_new_word)
    buttonSave.setOnClickListener { save() }
  }

  companion object {
    const val EXTRA_REPLY = "io.github.pierry.codelab.REPLAY"
  }

  fun save() {
    val replyIntent = Intent()
    if (TextUtils.isEmpty(editWord.getText())) {
      setResult(Activity.RESULT_CANCELED, replyIntent)
    } else {
      val word = editWord.getText().toString()
      replyIntent.putExtra(EXTRA_REPLY, word)
      setResult(Activity.RESULT_OK, replyIntent)
    }
    finish()
  }


}