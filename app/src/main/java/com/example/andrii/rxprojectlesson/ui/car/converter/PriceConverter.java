package com.example.andrii.rxprojectlesson.ui.car.converter;

import com.example.andrii.rxprojectlesson.core.converter.Converter;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

public class PriceConverter implements Converter<Integer, String> {

    @Inject
    public PriceConverter() {
    }

    @Override
    public String convert(Integer oldPrice) {
        return newPrice(turnOverString(oldPrice.toString()));
    }

    private String turnOverString(String str) {
        String[] array = str.split("");
        StringBuilder newStr = new StringBuilder();
        for (int i = array.length - 1; i >= 0; i--) {
            newStr.append(array[i]);
        }
        return newStr.toString();
    }

    private String newPrice(String oldPrice) {
        List<String> newPriceArray = Arrays.asList(oldPrice.split("(?<=\\G.{3})"));
        StringBuilder newPrice = new StringBuilder();
        for (String str : newPriceArray) {
            newPrice.append(str).append(" ");
        }
        return turnOverString(newPrice.toString());
    }
}
