package org.stepic.java.module3.comments;

/**
 * Created by vitaly on 24/09/16.
 */
public abstract class KeywordAnalyzer implements TextAnalyzer {

    protected abstract String[] getKeywords();

    protected abstract Label getLabel();

    public Label processText(String text) {
        String[] items = this.getKeywords();
        for (String stopWord: items) {
            if (text.contains(stopWord)) {
                return this.getLabel();
            }
        }
        return Label.OK;
    }
}
