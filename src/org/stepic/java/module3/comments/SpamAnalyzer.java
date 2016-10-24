package org.stepic.java.module3.comments;

/**
 * Created by vitaly on 24/09/16.
 */
public class SpamAnalyzer extends KeywordAnalyzer implements TextAnalyzer {

    private String[] keywords;

    public SpamAnalyzer(String[] keywords) { this.keywords = keywords; }

    public String[] getKeywords() { return keywords; }

    public Label getLabel() { return Label.SPAM; }

}
