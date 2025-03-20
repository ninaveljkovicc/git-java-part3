import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task1 {



        public static void main(String[] args) {
            // Task 1
            // Step 1: display a stream of integers
            Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
            System.out.println("Stream of Integers:");
            stream.forEach(n -> System.out.print(n + " "));

            // Step 2: create a list of random numbers using Stream.generate()
            List<Double> randomNumbers = Stream.generate(Math::random)
                    .limit(20)
                    .collect(Collectors.toList());

            System.out.println("\n");
            System.out.println("Random Numbers:");
            randomNumbers.forEach(System.out::println);

            // Step 3: collect stream elements into a list (filter even numbers)
            List<Integer> numbersList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
            List<Integer> evenNumbers = numbersList.stream()
                    .filter(n -> n % 2 == 0)
                    .collect(Collectors.toList());

            System.out.println("\n");
            System.out.println("Even Numbers:");
            evenNumbers.forEach(System.out::println);

            // Task 2: convert list to stream and collect elements into an array
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i < 10; i++) {
                list.add(i);
            }
            Integer[] array = list.stream().toArray(Integer[]::new);
            System.out.println("\nArray from List:");
            System.out.println(Arrays.toString(array));

            // filter values that start with "c", convert to uppercase, sort in descending order
            List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
            List<String> filteredSortedUppercase = myList.stream()
                    .filter(s -> s.startsWith("c"))
                    .map(String::toUpperCase)
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toList());

            System.out.println("\nFiltered, Uppercase, and Sorted in Descending Order:");
            filteredSortedUppercase.forEach(System.out::println);

            // Task 3: process names with stream API
            List<String> memberNames = Arrays.asList("Amitabh", "Shekhar", "Aman", "Rahul", "Shahrukh", "Abibaba", "Salman", "Yana", "Lokesh");

            // a) display names that start with A and have length > 5
            List<String> filteredNames = memberNames.stream()
                    .filter(name -> name.startsWith("A") && name.length() > 5)
                    .collect(Collectors.toList());
            System.out.println("\nNames starting with 'A' and length > 5:");
            filteredNames.forEach(System.out::println);

            // b) sort all names and display in lowercase
            List<String> sortedLowercaseNames = memberNames.stream()
                    .map(String::toLowerCase)
                    .sorted()
                    .collect(Collectors.toList());
            System.out.println("\nSorted names in lowercase:");
            sortedLowercaseNames.forEach(System.out::println);

            // Task 3 - matching operations
            boolean allMatchS = memberNames.stream().allMatch(name -> name.contains("S"));
            boolean anyMatchS = memberNames.stream().anyMatch(name -> name.contains("S"));
            boolean noneMatchH = memberNames.stream().noneMatch(name -> name.contains("H"));

            System.out.println("\nAll names contain 'S': " + allMatchS);
            System.out.println("Any name contains 'S': " + anyMatchS);
            System.out.println("No name contains 'H': " + noneMatchH);

            // Task 3 - counting names starting with A
            long countA = memberNames.stream().filter(name -> name.startsWith("A")).count();
            System.out.println("\nNumber of names starting with A is " + countA);

            // Task 3 - find first name starting with L
            Optional<String> firstL = memberNames.stream().filter(name -> name.startsWith("L")).findFirst();
            firstL.ifPresent(name -> System.out.println("\nFirst name starting with 'L': " + name));

            // Task 4: flatten multiple lists using flatMap()
            List<Integer> list1 = Arrays.asList(1, 2, 3);
            List<Integer> list2 = Arrays.asList(4, 5, 6);
            List<Integer> list3 = Arrays.asList(7, 8, 9);

            List<Integer> mergedList = Stream.of(list1, list2, list3)
                    .flatMap(List::stream)
                    .collect(Collectors.toList());

            System.out.println("\nMerged List:");
            mergedList.forEach(System.out::println);

            // Task 5: extract letters from Map values
            Map<String, List<String>> people = new HashMap<>();
            people.put("John", Arrays.asList("555-1123", "s", "555-3389", "a"));
            people.put("Mary", Arrays.asList("555-2243", "z", "555-5264"));
            people.put("Steve", Arrays.asList("555-6654", "555-3242", "d"));

            List<String> lettersList = people.values().stream()
                    .flatMap(List::stream)
                    .filter(s -> s.matches("[a-zA-Z]"))
                    .collect(Collectors.toList());

            System.out.println("\nExtracted Letters:");
            lettersList.forEach(System.out::println);
        }


}
