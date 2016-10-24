package org.stepic.java.module3.comments;

/**
 * Created by vitaly on 24/09/16.
 */
interface TextAnalyzer {
    Label processText(String text);
}

enum Label {
    SPAM,
    NEGATIVE_TEXT,
    TOO_LONG,
    OK
}