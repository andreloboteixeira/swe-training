package day1caloriecounting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {

            try{
                List<List<Long>> input = App.readInput();

                List<Long> elvesCals = input.stream()
                        .map(elfCals -> elfCals.stream().reduce(0L, (subtotal, element) -> subtotal + element))
                        .collect(Collectors.toList());

                System.out.println("Max elf cal: ");
                Long max = elvesCals.stream().max(Long::compare).get();
                System.out.println(max);

                System.out.println("3 Max elves cal sum: ");
                Collections.sort(elvesCals, Collections.reverseOrder());
                Long threeMax =  elvesCals.subList(0, 3).stream().reduce(0L, (subtotal, element) -> subtotal + element);
                System.out.println(threeMax);


            } catch (Exception error){
                System.out.println(error);
            }

        }

        public static List<List<Long>> readInput() throws IOException {
            String fileName = "/Users/andreloboteixeira/coding/swe-training/advent-of-code/day1caloriecounting/app/src/main/java/day1caloriecounting/day1-input.txt";

            List<List<Long>> result = new ArrayList<>();
            List<Long> group = new ArrayList<>();


            BufferedReader br = null;
            try {

                br = new BufferedReader(new FileReader(fileName));

                String line;
                while ((line = br.readLine()) != null) {
                    if(!line.equals("")){
                        group.add(Long.parseLong(line));
                    } else{
                        result.add(group);
                        group = new ArrayList<>();
                    }
                }
                result.add(group);

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (br != null) {
                    br.close();
                }
            }
            //			System.out.println(result);
            return result;
        }
}
