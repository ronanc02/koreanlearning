package com.example.koreanlearning

import androidx.lifecycle.ViewModel

class CardViewModel : ViewModel() {

    // Declare private mutable variable that can only be modified
    // within the class it is declared.
    private var _koreanword = "hello"

    // Declare another public immutable field and override its getter method.
    // Return the private property's value in the getter method.
    // When count is accessed, the get() function is called and
    // the value of _count is returned.
    val koreanword: String
        get() = _koreanword
}