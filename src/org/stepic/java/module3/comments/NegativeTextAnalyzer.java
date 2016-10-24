package org.stepic.java.module3.comments;

/**
 * Created by vitaly on 24/09/16.
 */
public class NegativeTextAnalyzer extends KeywordAnalyzer implements TextAnalyzer {

    private final String[] STOP = {":(", "=(", ":|"};

    public String[] getKeywords() { return STOP; }

    public Label getLabel() { return Label.NEGATIVE_TEXT; }
}
