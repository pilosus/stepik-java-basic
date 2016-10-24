package org.stepic.java.module3.comments;

/**
 * Created by vitaly on 24/09/16.
 */
public class TextFilter {

    public static void main(String[] args) {
        // text to be analyzed
        String textTooLong = "Hey dude :| You are better off buying my pills";
        String textTooNegative = "Hey dude I'm sad :|";
        String textTooSpammy = "Buy pills now!";
        String textOkay = "Best comment ever";

        // stop keywords
        String[] stopWords = {"buy", "XXX", "pills"};

        // initialize analyzers
        TextAnalyzer tooLong = new TooLongTextAnalyzer(25);
        TextAnalyzer tooNegative = new NegativeTextAnalyzer();
        TextAnalyzer tooSpammy = new SpamAnalyzer(stopWords);

        // array of analyzers to iterate over
        TextAnalyzer[] Analyzers = {tooLong, tooNegative, tooSpammy};

        System.out.println(checkLabels(Analyzers, textTooLong));
        System.out.println(checkLabels(Analyzers, textTooNegative));
        System.out.println(checkLabels(Analyzers, textTooSpammy));
        System.out.println(checkLabels(Analyzers, textOkay));

    }

    public static Label checkLabels(TextAnalyzer[] analyzers, String text) {
        //remove `static` keyword when taking in on stepic.org
        for (TextAnalyzer a: analyzers) {
            Label result = a.processText(text);
            if (result != Label.OK) {
                return result;
            }
        }
        return Label.OK;
    }
}