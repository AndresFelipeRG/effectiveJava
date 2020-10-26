package com.effectivejava.items.item5;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import java.util.Objects;

public class SpellChecker {


    private final Dictionary dictionary;


    public SpellChecker(Dictionary dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    public boolean isValid(String word) {
        return this.dictionary.get(word) != null;
    }

    public List<String> suggestions(String typo) {
        return new ArrayList<>();
    }


}
