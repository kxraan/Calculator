package com.example.calculator;

import java.util.ArrayList;

public class Calculations {
    private ArrayList<String> values;

    public Calculations(ArrayList<String> values) {
        this.values = new ArrayList<>(values);
    }

    public String compute() {
        while (values.contains("\u03C0")) {
            int index = values.indexOf("\u03C0");
            values.set(index, String.valueOf(Math.PI));
        }

		while (values.indexOf("/") != -1) {
        int index = values.indexOf("/");
        values.set(index, div(values.get(index - 1), values.get(index + 1)));
        values.remove(index + 1);
        values.remove(index - 1);

    }
		while (values.indexOf("*") != -1) {
        int index = values.indexOf("*");
        values.set(index, mul(values.get(index - 1), values.get(index + 1)));
        values.remove(index + 1);
        values.remove(index - 1);

    }
		while (values.indexOf("-") != -1) {
        int index = values.indexOf("-");
        values.set(index, sub(values.get(index - 1), values.get(index + 1)));
        values.remove(index + 1);
        values.remove(index - 1);

    }
		while (values.indexOf("+") != -1) {
        int index = values.indexOf("+");
        values.set(index, add(values.get(index - 1), values.get(index + 1)));
        values.remove(index + 1);
        values.remove(index - 1);

    }
		return values.get(0);
}
    public static String add(String num_1, String num_2) {

        if (num_1.contains(".") || num_2.contains(".")) {
            return String.valueOf(Double.parseDouble(num_1) + Double.parseDouble(num_2));
        } else {
            return String.valueOf(Integer.parseInt(num_1) + Integer.parseInt(num_2));
        }

    }

    public static String sub(String num_1, String num_2) {
        if (num_1.contains(".") || num_2.contains(".")) {
            return String.valueOf(Double.parseDouble(num_1) - Double.parseDouble(num_2));
        } else {
            return String.valueOf(Integer.parseInt(num_1) - Integer.parseInt(num_2));
        }
    }

    public static String mul(String num_1, String num_2) {
        if (num_1.contains(".") || num_2.contains(".")) {
            return String.valueOf(Double.parseDouble(num_1) * Double.parseDouble(num_2));
        } else {
            return String.valueOf(Integer.parseInt(num_1) * Integer.parseInt(num_2));
        }
    }

    public static String div(String num_1, String num_2) {

        if (num_1.contains(".") || num_2.contains(".") || num_2.equals("0")) {
            return String.valueOf(Double.parseDouble(num_1) / Double.parseDouble(num_2));
        } else {
            int num1 = Integer.parseInt(num_1);
            int num2 = Integer.parseInt(num_2);

            if (num1 % num2 != 0) {
                return String.valueOf((double) num1 / num2);
            }
            return String.valueOf(num1 / num2);

        }
    }
}
