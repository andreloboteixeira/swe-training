package day3rucksackreorg;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
//        App.round1();
        App.round2();
    }

    private static List<String> readInputRound1() throws IOException {
        String fileName = "/Users/andreloboteixeira/coding/swe-training/advent-of-code/day3rucksackreorg/app/src/main/java/day3rucksackreorg/day3-input.txt";
//        String fileName = "/Users/andreloboteixeira/coding/swe-training/advent-of-code/day3rucksackreorg/app/src/main/java/day3rucksackreorg/day3-input-test.txt";
        List<String> result = new ArrayList<>();


        BufferedReader br = null;
        try {

            br = new BufferedReader(new FileReader(fileName));

            String line;
            while ((line = br.readLine()) != null) {
//                System.out.println(line);
                result.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
        }
//        System.out.println(result);
        return result;
    }

    public static void round1(){
        try{
            List<String> rucksacks = App.readInputRound1();

            List<Character> repeatedItems = rucksacks.stream()
                    .map(rucksack -> {
                        String firstCompartment = rucksack.substring(0, rucksack.length()/2);
                        String secondCompartment = rucksack.substring(rucksack.length()/2, rucksack.length());
                        return App.findCommonChar(firstCompartment, secondCompartment);
                    }).collect(Collectors.toList());

            System.out.println(repeatedItems);

            List<Integer> costs = repeatedItems.stream()
                    .map(cost -> App.computeReorgCost(cost))
                    .collect(Collectors.toList());

            Integer totalReorgCost = costs.stream().reduce(0, (subTotal, element) -> {
                return subTotal + element;
            });

            System.out.println(">>> totalReorgCost");
            System.out.println(totalReorgCost);

        } catch (Exception error){
            System.out.println(error);
        }
    }

    private static List<List<String>> readInputRound2() throws IOException {
        String fileName = "/Users/andreloboteixeira/coding/swe-training/advent-of-code/day3rucksackreorg/app/src/main/java/day3rucksackreorg/day3-input.txt";
//        String fileName = "/Users/andreloboteixeira/coding/swe-training/advent-of-code/day3rucksackreorg/app/src/main/java/day3rucksackreorg/day3-input-test-round2.txt";
        List<List<String>> result = new ArrayList<>();
        List<String> group = new ArrayList();

        BufferedReader br = null;
        try {

            br = new BufferedReader(new FileReader(fileName));

            String line;
            Integer n = 0;
            while ((line = br.readLine()) != null) {
                group.add(line);
                n++;
                if(n % 3 == 0) {
                    result.add(group);
                    group = new ArrayList();
                }
//                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
        }
        System.out.println(result);
        return result;
    }

    public static void round2(){
        try{
            List<List<String>> groupRucksacks = App.readInputRound2();

            List<Character> groupsBadges = groupRucksacks.stream()
                    .map(groupRucksack -> {
                        // assumption that the common between two is the common between the three
                        List<Character> chars = App.findAllCommonChars(groupRucksack.get(0), groupRucksack.get(1));
                        return chars.stream()
                                .filter(candidate -> candidate == App.findCommonChar("" + candidate, groupRucksack.get(2)))
                                .findFirst()
                                .orElse(null);
                    })
                    .collect(Collectors.toList());

            System.out.println(">>> groupsBadges");
            System.out.println(groupsBadges);

            Integer totalReorgCost = groupsBadges.stream()
                    .map(badge -> App.computeReorgCost(badge))
                    .reduce(0, (subTotal, cost) -> subTotal + cost);

            System.out.println(">>> totalReorgCost");
            System.out.println(totalReorgCost);

        } catch (Exception error){
            System.out.println(error);
        }
    }

    public static Integer computeReorgCost(Character type){
        Integer val = 0;
        if((int)type >= 97 && (int)type <= 122){
            val = (int)type - 96;
        }
        if((int)type >= 65 && (int)type <= 90){
            val = (int)type - 38;
        }
        System.out.println(val);
        return val;
    }

    public static List<Character> findAllCommonChars(String first, String second){
        Map<Character, Boolean> occured = new HashMap<Character, Boolean>();
        List<Character> chars = new ArrayList();
        for(int i = 0; i < first.length(); i++){
            char currCharFirst = first.charAt(i);
            for(int j = 0; j < second.length(); j++){
                char currCharSecond = second.charAt(j);
                if(currCharFirst == currCharSecond){
                    if(!occured.containsKey(currCharFirst)){
                        occured.put(currCharFirst, true);
                        chars.add(currCharFirst);
                    }
                }
            }
        }
        return chars;
    }

    public static Character findCommonChar(String first, String second){
        // assuming only one
        char commonChar = '0';
        for(int i = 0; i < first.length(); i++){
            char currCharFirst = first.charAt(i);
            for(int j = 0; j < second.length(); j++){
                char currCharSecond = second.charAt(j);
                if(currCharFirst == currCharSecond){
                    commonChar = currCharFirst;
                    j = second.length();
                    i = first.length();
                }
            }
        }
        return commonChar;
    }
}
