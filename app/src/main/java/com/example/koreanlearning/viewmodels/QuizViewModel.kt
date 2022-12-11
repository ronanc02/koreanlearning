package com.example.koreanlearning.viewmodels;

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import com.example.koreanlearning.data.Json
import com.example.koreanlearning.model.Jsonkorean
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(application: Application) : ViewModel(
) {

    private var _score = MutableLiveData(0)
    val score: LiveData<Int>
        get() = _score

    private var _currentWordCount = MutableLiveData(0)
    val currentWordCount: LiveData<Int>
        get() = _currentWordCount

    // List of words used in the game
//    private var wordsList: MutableList<String> = mutableListOf()
    private var wordsList: List<Jsonkorean>

    private lateinit var _currentWord: String
    val currentWord: String
        get() = _currentWord

    private var _currentChoices = arrayOf("","","","")
    val currentChoices: Array<String>
        get() = _currentChoices


    init {
        Log.d("GameFragment", "GameViewModel created!")
        wordsList = Json(application.applicationContext).parseJson("jsonfile")!!.shuffled()
        getNextWord()
        getNextChoices()
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("GameFragment", "GameViewModel destroyed!")
    }

    /*
    * Updates currentWord and currentScrambledWord with the next word.
    */

    private fun getNextWord() {
        _currentWord = wordsList[_currentWordCount.value!!].body
        _currentWordCount.value = (_currentWordCount.value)?.inc()
    }

    private fun getNextChoices() {
        var x = 0
        var y = 0
        val tempWordslist = wordsList.shuffled()
        while (x < 3) {
            if (tempWordslist[y].body != wordsList[_currentWordCount.value!!].body) {
                _currentChoices[x] = tempWordslist[y].body
                ++x
            }
            ++y
        }
        _currentChoices[3] = _currentWord
        _currentChoices.shuffle()
    }

    /*
    * Re-initializes the game data to restart the game.
    */
    fun reinitializeData() {
        _score.value = 0
        _currentWordCount.value = 0
        wordsList.shuffled()
        getNextWord()
        getNextChoices()
    }


    /*
    * Increases the game score if the player's word is correct.
    */
    private fun increaseScore() {
        _score.value = (_score.value)?.inc()
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
        return if (_currentWordCount.value!! < 10) {
            getNextWord()
            getNextChoices()
            true
        } else false
    }
}