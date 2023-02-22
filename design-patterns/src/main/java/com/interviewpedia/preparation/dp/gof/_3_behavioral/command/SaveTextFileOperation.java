package com.interviewpedia.preparation.dp.gof._3_behavioral.command;

public class SaveTextFileOperation implements TextFileOperation{
    private final TextFile textFile;

    public SaveTextFileOperation(TextFile textFile) {
        this.textFile = textFile;
    }

    @Override
    public String execute() {
        return textFile.save();
    }
}
