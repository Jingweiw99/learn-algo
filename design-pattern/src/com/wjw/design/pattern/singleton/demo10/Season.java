package com.wjw.design.pattern.singleton.demo10;

public enum Season {

    SPRING("这是春天，凉爽"),
    SUMMER("夏天很热"),
    AUTUMN("秋天也很凉爽"),
    WINTER("冬天很冷");


    private final String description;

    private Season(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
