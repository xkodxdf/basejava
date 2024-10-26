package com.xkodxdf.webapp.model;

import java.util.Objects;

public class TextSection extends Section {

    private String content;


    public TextSection(SectionType type) {
        this(type, "");
    }

    public TextSection(SectionType type, String content) {
        super(type);
        Objects.requireNonNull(content);
        this.content = content;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        Objects.requireNonNull(content);
        this.content = content;
    }


    @Override
    protected void printContent() {
        System.out.println(content);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextSection that = (TextSection) o;
        return Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(content);
    }

    @Override
    public String toString() {
        return "PlainSection{" +
                "content='" + content + '\'' +
                '}';
    }
}