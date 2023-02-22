package com.interviewpedia.preparation.dp.gof._3_behavioral.command;

public class CommandPatternMain {
    public static void main(String[] args) {
        TextFileOperationExecutor executor = new TextFileOperationExecutor();
        TextFile file = new TextFile("HelloWorld.java");
        executor.executeOperation(new OpenTextFileOperation(file));
        executor.executeOperation(new SaveTextFileOperation(file));
    }
}
