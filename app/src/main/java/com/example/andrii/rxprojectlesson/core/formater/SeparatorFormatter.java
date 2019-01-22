package com.example.andrii.rxprojectlesson.core.formater;

public class SeparatorFormatter implements Formatter {

    private String separator;
    private int minOffset;
    private int maxOffset;
    private int step;

    public SeparatorFormatter(String separator, int minOffset, int maxOffset, int step) {
        this.separator = separator;
        this.minOffset = minOffset;
        this.maxOffset = maxOffset;
        this.step = step;
    }

    @Override
    public String format(String s) {
        s = removeSeparators(s);
        return insertSpaces(s);
    }

    private String removeSeparators(String s) {
        s = s.replace(separator, "");
        return s;
    }

    private String insertSpaces(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        int length = s.length();

        for (int offset = maxOffset; offset >= minOffset ; offset -= step) {
            if (length > offset) {
                stringBuilder.insert(offset, separator);
            }
        }

        return stringBuilder.toString();
    }
}
