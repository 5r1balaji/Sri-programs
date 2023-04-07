package com.techgeek.sri.arrays;

import java.util.*;
import java.util.stream.Collectors;

/**
 * To operate a call center, at any given day, a min of 3 english speaking, 2 dutch speaking and 1 spanish
 * speaking employee need to be there. (you can have one employee speaking two or more languages)
 * An employee can atmost work for 5 days. For simplicity let's say an employee works for a standard of 8 hrs every day.
 * (not sure if hours were relevant)
 * The call center operates 7 days a week.
 * Given employees and the languages they speak, can you atleast come up with a schedule for the first week ?
 *
 * Employee 1 : English, Dutch
 * Employee 2 : English, Dutch
 * Employee 3: Spanish, Dutch
 * Employee 4: English, Dutch, Spanish
 * Employee 5: Dutch, Spanish
 * Employee 6: English, Dutch
 * Employee 7: English, Spanish
 */
public class CallCenterLanguageCapacity {
    Map<String, List<String>> employeeLanguages = new HashMap<>();
    Map<String, List<String>> languageMap;
    public static void main(String[] args) {

        CallCenterLanguageCapacity callCenterLanguageCapacity = new CallCenterLanguageCapacity();
        Map<String, List<String>> employeeLanguages = callCenterLanguageCapacity.employeeLanguages;


        employeeLanguages.put("Employee 1", Arrays.asList("English", "Dutch"));
        employeeLanguages.put("Employee 2", Arrays.asList("English", "Dutch"));
        employeeLanguages.put("Employee 3", Arrays.asList("Spanish", "Dutch"));
        employeeLanguages.put("Employee 4", Arrays.asList("English", "Dutch", "Spanish"));
        employeeLanguages.put("Employee 5", Arrays.asList("Spanish", "Dutch"));
        employeeLanguages.put("Employee 6", Arrays.asList("English", "Dutch"));
        employeeLanguages.put("Employee 7", Arrays.asList("English", "Spanish"));

        int english = 3;
        int spanish = 1;
        int dutch  = 2;

        callCenterLanguageCapacity.languageMap = constructLanguageMap(employeeLanguages);
        Set<String> weekdayEmployees = new HashSet<>();
        List<Set<String>> employeeScheduleOptions = new ArrayList<>();
        Map<String, Integer> languageConstraints = new HashMap<>();
        languageConstraints.put("English", english);
        languageConstraints.put("Dutch", dutch);
        languageConstraints.put("Spanish", spanish);


        callCenterLanguageCapacity.getSchedule(weekdayEmployees, employeeScheduleOptions, languageConstraints, new HashMap<>());

    }

    private boolean getSchedule(
            final Set<String> employeeCombinations,
            List<Set<String>> employeeScheduleOptions,
            Map<String, Integer> languageConstraints,
            Map<String, Integer> workPotential
    ) {
        if (languageConstraints.get("English") == 0 && languageConstraints.get("Dutch") == 0 && languageConstraints.get("Spanish") == 0) {
            employeeScheduleOptions.add(employeeCombinations);
            updateWorkSheet(employeeCombinations, workPotential);
            return true;
        }

        if (languageConstraints.get("English") > 0) {
            processEmployeesSpeakingLanguage("English", workPotential, employeeCombinations, languageConstraints, employeeScheduleOptions);
        }

        if (languageConstraints.get("Dutch") > 0) {
            processEmployeesSpeakingLanguage("Dutch", workPotential, employeeCombinations, languageConstraints, employeeScheduleOptions);
        }

        if (languageConstraints.get("Spanish") > 0) {
            processEmployeesSpeakingLanguage("Spanish", workPotential, employeeCombinations, languageConstraints, employeeScheduleOptions);
        }
        return false;
    }

    private void processEmployeesSpeakingLanguage(
            String language,
            Map<String, Integer> workPotential,
            Set<String> employeeCombinations,
            Map<String, Integer> languageConstraints,
            List<Set<String>> employeeScheduleOptions
    ) {
        int day = 1;
        for (String employee: languageMap.get(language)) {
            if (!employeeCombinations.contains(employee) && hasWorkPotential(employee, workPotential) && day <= 5) {
                Map<String, Integer> updatedConstraint = updateLangConstraint(employeeLanguages.get(employee), new HashMap<>(languageConstraints));
                employeeCombinations.add(employee);
                boolean isCombinationFound = getSchedule(
                        new HashSet<>(employeeCombinations),
                        employeeScheduleOptions,
                        updatedConstraint,
                        workPotential
                );
                if (isCombinationFound) {
                    day++;
                    employeeCombinations.remove(employee);
                }
            }
        }
    }

    private boolean updateWorkSheet(Set<String> employeeCombinations, Map<String, Integer> workPotential) {
        for (String employee: employeeCombinations) {
            if (hasWorkPotential(employee, workPotential)) {
                workPotential.put(employee, workPotential.getOrDefault(employee, 0) + 1);
            }
             else return false;
        }
        return true;
    }

    private static boolean hasWorkPotential(String employee, Map<String, Integer> workSheet) {
        return workSheet.getOrDefault(employee, 0) <= 5;
    }

    private static Map<String, Integer> updateLangConstraint(List<String> languages, Map<String, Integer> constraints) {
        for (String language: languages) {
            if (language.equals("English") && constraints.get("English") > 0) {
                constraints.put("English", constraints.get("English") - 1);
            }
            if (language.equals("Dutch") && constraints.get("Dutch") > 0) {
                constraints.put("Dutch", constraints.get("Dutch") - 1);
            }
            if (language.equals("Spanish") && constraints.get("Spanish") > 0) {
                constraints.put("Spanish", constraints.get("Spanish") - 1);
            }
        }
        return constraints;
    }

    private static Map<String, List<String>> constructLanguageMap(Map<String, List<String>> employeeLanguages) {
        Map<String, List<String>> languageCountMap = new HashMap<>();
        for (Map.Entry<String, List<String>> entry: employeeLanguages.entrySet() ) {
            for (String language: entry.getValue()) {
                List<String> list = languageCountMap.getOrDefault(language, new ArrayList<>());
                list.add(entry.getKey());
                languageCountMap.putIfAbsent(language, list);
            }
        }
        return languageCountMap;
    }
}
