package de.ithock.fishlang;

import com.intellij.lang.Language;

/*
d93f9
ff5555
ff79c6
 */
public class FishLanguage extends Language {

    public static final FishLanguage INSTANCE = new FishLanguage();

    private FishLanguage() {
        super("Fish");
    }

}