package com.techgeek.sri.graphs;


import java.util.*;

class Countries {
    String name;
    Double conversionRate;

    public Countries(String name, Double conversionRate) {
        this.name = name;
        this.conversionRate = conversionRate;
    }
}

/**
 * Given a list of currency rates , find the conversion rate for from and to
 * currencies
 */
public class CurrencyConversion {
    public static void main(String[] args) {
        String[][] rates = {
                {"USD", "JPY", "113.68"},
                {"USD", "INR", "75.99"},
                {"USD", "SD", "1.37"},
                {"USD", "AUD", "1.41"},
                {"INR", "GBP", "0.0099"},
                {"INR", "JPY", "1.50"}
        };
        HashMap<String, List<Countries>> conversionMap = new HashMap<>();
        for (String[] k : rates) {
            List<Countries> fromList = conversionMap.getOrDefault(k[0], new ArrayList<>());
            Double fromVal = new Double(k[2]);
            fromList.add(new Countries(k[1], fromVal));
            conversionMap.put(k[0], fromList);
            List<Countries> toList = conversionMap.getOrDefault(k[1], new ArrayList<>());
            toList.add(new Countries(k[0], new Double("1.0")/ fromVal));
            conversionMap.put(k[1],toList);
        }
        HashSet<String> visited = new HashSet<>();
        Double total = 1.0;
        if (conversionMap.containsKey("AUD")) {
            System.out.println(findConversionRate("GBP", "AUD", conversionMap, total, visited));
        }

    }

    private static Double findConversionRate(String from, String to,
                                             HashMap<String, List<Countries>> conversionMap,
                                             Double total, HashSet<String> visited) {
        if (from.equals(to)) {
            return total;
        }
        List<Countries> exchangeList = conversionMap.get(from);
        for (Countries country : exchangeList) {
            if (!visited.contains(country.name)) {
                visited.add(country.name);
                total  *= country.conversionRate *
                                findConversionRate(country.name, to, conversionMap, total, visited);
                if (visited.contains(to)) {
                    return total;
                }
                total = 1.0;
            }
        }
        return total;
    }
}
