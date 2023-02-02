package com.techgeek.sri;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem Statment:
 * Booking.com wants to recognize k performing hotels.
 * These hotels are being identified by analyzing their user reviews and calculating a review score for each of the hotels.
 *
 * To calculate the score they have:
 *
 * A list of user reviews for each hotel
 * List of positive keywords
 * List of negative keywords
 * Positive keywords weigh 3 points each and negative keywords weigh -1 each.
 *
 * For example, given the input below:
 *
 * positive keywords: “breakfast beach city center location metro view staff price”,
 *
 * negative keywords: “not”,
 *
 * number of hotels: m = 5,
 *
 * array of hotel ids: [1,2,1,1,2],
 *
 * number of reviews: n=5,
 *
 * array of reviews: [
 *
 *      “This hotel has a nice view of the city center. The location is perfect.”,
 *
 *      “The breakfast is ok. Regarding location, it is quite far from city center but the price is cheap so it is worth.”,
 *
 *      “Location is excellent, 5 minutes from the city center. There is also a metro station very close to the hotel.”,
 *
 *      “They said I couldn’t take my dog and there were other guests with dogs! That is not fair.”,
 *
 *      “Very friendly staff and a good cost-benefit ratio. Its location is a bit far from the city center.”
 *
 * ],
 *
 * number of hotels we want to award: k = 2,
 *
 * then top k Hotels will be 2, 1.
 *
 * Function Description:
 * The function must return a list of hotel ids sorted in descending order of their total score.
 * Our function awardTopKHotels has the following parameter(s):
 *
 * positiveKeywords: a space-separated string of positive keywords in review
 * negativeKeywords : a space separated string of negative keywords in review
 * hotelIds[hotelIds[0]…hotelIds[m-1]] : an array of integers, which represents hotel IDs
 * reviews[reviews[0]…reviews[n-1]] : An array of String, which represents reviews.
 * reviews[i] is review for hotelIds[i]. reviews and hotel ids are one-to-one mapped.
 * k : the number of hotels we want to award.
 * Constraints:
 * m is always equal to n.
 * If two hotels have the same score, they should be sorted in the output based on their ID, smallest ID first.
 * The keywords to find will always be single words like “breakfast” or “noise”. Never double words like “swimming pool”.
 * Matching should be case-insensitive.
 * Dots and commas should be ignored.
 * If a word appears in a review twice, it should count twice.
 * 1 ≤ m ≤ 109 , 1 ≤ n ≤ 109 ,1 ≤ hotelIds[i] ≤ 105 , 1 ≤ k ≤ 109
 * In case one or more test cases time out, consider revisiting the runtime complexity of your algorithms.
 * If k is greater than the unique number of hotel ids, then list all the hotel ids
 * Input Format For Custom Testing:
 * Input from stdin will be processed as follows and passed to the function.
 *
 * The first line contains a sentence with space-separated positive keywords.
 * The second line contains a sentence with space-separated negative keywords.
 * The third line contains an integer M, the size of the array hotels Ids.
 * The next M lines each contain an element hotelIds[i].
 * Next line contains an integer N, the size of the array reviews.
 * The next N lines each contain an element review [i]
 * The next line contains an integer K, number of hotels we want to award.
 */
public class AwardTopKHotels {
    public static void main(String[] args) {
        String[] positive = {"breakfast", "beach", "citycenter", "location", "metro", "view", "staff", "price"};
        String[] negative = {"not"};
        String[] reviews = {
                "This hotel has a nice view of the citycenter. The location is perfect.",
                "The breakfast is ok. Regarding location, it is quite far from city center but the price is cheap so it is worth.",
                "Location is excellent, 5 minutes from the citycenter. There is also a metro station very close to the hotel.",
                "Good price but I couldn't take my dog and there were other guests with dogs!",
                "Very friendly staff and a good cost-benefit ratio. Its location is a bit far from the city center."
        };
        int[] hotelIds = {5,1,2,1,1,2,5};
       List<Integer> topKHotel = findTopKHotel(positive, negative, reviews, hotelIds,2);
        topKHotel.forEach(System.out::println);
    }

    private static List<Integer> findTopKHotel(String[] positive, String[] negative, String[] reviews, int[] hotelIds, int  k) {
        Set<String> positives = Arrays.stream(positive).map(String::toUpperCase).collect(Collectors.toSet());
        Set<String> negatives = Arrays.stream(negative).map(String::toUpperCase).collect(Collectors.toSet());
        Map<Integer, Integer> populateRating = new HashMap<>();
        for (int i = 0; i < reviews.length; i++) {
            int review = populateRating.getOrDefault(hotelIds[i], 0);

            review += processReview(reviews[i], positives, negatives);
            populateRating.put(hotelIds[i], review);

        }
        return populateRating.entrySet()
                .stream()
                .sorted(((o1, o2) -> o2.getValue() - o1.getValue()))
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private static int processReview(String review, Set<String> positives, Set<String> negatives) {
        int reviewValue = 0;

        for (String s: review.split(" ")) {
            if (s.charAt(s.length() - 1) == ',' || s.charAt(s.length() - 1) == '.' ){
                s = s.substring(0,s.length() -1);
            }
            if (positives.contains(s.toUpperCase())) {
                reviewValue += 3;
            }
            if (negatives.contains(s.toUpperCase())) {
                reviewValue -= 1;
            }
        }
        return reviewValue;
    }




}
