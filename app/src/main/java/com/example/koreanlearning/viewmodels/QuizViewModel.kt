package com.example.koreanlearning.viewmodels;

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel;
import com.example.koreanlearning.data.Json
import com.example.koreanlearning.model.Jsonkorean
import java.security.AccessController.getContext

class QuizViewModel(private val context: Context) : ViewModel(
) {

    private var _score = 0
    val score: Int
        get() = _score

    private var _currentWordCount = 0
    val currentWordCount: Int
        get() = _currentWordCount

    private lateinit var _currentScrambledWord: String
    val currentScrambledWord: String
        get() = _currentScrambledWord

    // List of words used in the game
//    private var wordsList: MutableList<String> = mutableListOf()
    private var wordsList: List<Jsonkorean>
    private lateinit var currentWord: String

    init {
        Log.d("GameFragment", "GameViewModel created!")
        wordsList = Json(context).parseJson("jsonfile")!!.shuffled()
        getNextWord()
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("GameFragment", "GameViewModel destroyed!")
    }

    /*
    * Updates currentWord and currentScrambledWord with the next word.
    */

    private fun getNextWord() {
        currentWord = wordsList[_currentWordCount].body
        ++_currentWordCount
    }

    /*
    * Re-initializes the game data to restart the game.
    */
    fun reinitializeData() {
        _score = 0
        _currentWordCount = 0
        wordsList.shuffled()
        getNextWord()
    }


    /*
    * Increases the game score if the player's word is correct.
    */
    private fun increaseScore() {
        ++_score
    }

    /*
    * Returns true if the player word is correct.
    * Increases the score accordingly.
    */
    fun isUserWordCorrect(playerWord: String): Boolean {
        if (playerWord.equals(currentWord, true)) {
            increaseScore()
            return true
        }
        return false
    }

    /*
    * Returns true if the current word count is less than MAX_NO_OF_WORDS
    */
    fun nextWord(): Boolean {
        return if (_currentWordCount < 10) {
            getNextWord()
            true
        } else false
    }
}