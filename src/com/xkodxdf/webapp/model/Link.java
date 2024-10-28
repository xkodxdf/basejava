package com.xkodxdf.webapp.model;

import java.util.Objects;

public class Link {

    private final String name;
    private final String url;


    public Link(String name) {
        this(name, "");
    }

    public Link(String name, String url) {
        Objects.requireNonNull(name, "name must not be null");
        Objects.requireNonNull(url, "url must not be null");
        this.name = name;
        this.url = url;
    }


    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }


    @Override
    public boolean equals(Object index) {
        if (this == index) return true;
        if (index == null || getClass() != index.getClass()) return false;

        Link link = (Link) index;
        return name.equals(link.name) && url.equals(link.url);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + url.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Link{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}