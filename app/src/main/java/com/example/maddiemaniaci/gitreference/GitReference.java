package com.example.maddiemaniaci.gitreference;

/**
 * Created by maddiemaniaci on 2/22/18.
 */

public class GitReference {

    private String command;
    private String example;
    private String explanation;
    private String section;

    public GitReference() {}

    public String getCommand() {
        return this.command;
    }

    public String getExample() {
        return this.example;
    }

    public String getExplanation() {
        return this.explanation;
    }

    public String getSection() {
        return this.section;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
