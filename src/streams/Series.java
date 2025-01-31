package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Series {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Partition numbers into even (true) and odd (false)
        Map<Boolean, List<Integer>> partitionedNumbers = numbers.stream()
                .collect(Collectors.partitioningBy(num -> num % 2 == 0));

        // Print even and odd numbers
        System.out.println("Even Numbers: " + partitionedNumbers.get(true));
        System.out.println("Odd Numbers: " + partitionedNumbers.get(false));

        //Armstrong Number
        int num = 153; // Example Armstrong number
        int length = String.valueOf(num).length();

        int armstrongSum = String.valueOf(num)
                .chars()
                .map(Character::getNumericValue)
                .map(n -> (int) Math.pow(n, length))
                .sum();

        System.out.println(num + " is Armstrong? " + (armstrongSum == num));


        //Palindrome
        String str = "madam"; // Example palindrome

        boolean isPalindrome = IntStream.range(0, str.length() / 2)
                .allMatch(i -> str.charAt(i) == str.charAt(str.length() - 1 - i));


        System.out.println(str + " is Palindrome? " + isPalindrome);

        //prime
        int nums = 29; // Example prime number

        boolean isPrime = num > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(nums))
                .noneMatch(i -> num % i == 0);

        System.out.println(num + " is Prime? " + isPrime);

        //Paindrome 2
        String str2 = "racecar"; // Example palindrome string

        String reversed = IntStream.range(0, str.length())   // Step 1: Generate index stream
                .mapToObj(i -> str.charAt(str.length() - 1 - i)) // Step 2: Reverse characters
                .map(String::valueOf)   // Step 3: Convert char to String
                .collect(Collectors.joining()); // Step 4: Join characters to form a string

        System.out.println(str + " is Palindrome? " + str2.equals(reversed));
        //reverse word
        String sentence = "Java is fun"; // Example input

        String reversedSentence = Arrays.stream(sentence.split(" "))  // Step 1: Split words
                .map(word -> new StringBuilder(word).reverse().toString()) // Step 2: Reverse each word
                .collect(Collectors.joining(" ")); // Step 3: Join words back with spaces

        System.out.println("Original: " + sentence);
        System.out.println("Reversed: " + reversedSentence);

        //prime Number 1 to 100
        IntStream.range(2, 101)  // Step 1: Stream numbers from 2 to 100
                .filter(Series::isPrime)  // Step 2: Filter prime numbers
                .forEach(System.out::println);


        //Fibonaaci
        int n = 10;  // Number of Fibonacci numbers to generate

        Stream.iterate(new long[]{0, 1}, f -> new long[]{f[1], f[0] + f[1]})  // Step 1: Generate Fibonacci pairs
                .limit(n)  // Step 2: Limit the output to 'n' Fibonacci numbers
                .map(f -> f[0])  // Step 3: Extract the Fibonacci number (first element of the pair)
                .forEach(System.out::println);  // Step 4: Print the Fibonacci numbers
    }
    public static boolean isPrime(int number) {
        return number > 1 && IntStream.range(2, (int) Math.sqrt(number) + 1)  // Step 4: Check divisibility
                .noneMatch(i -> number % i == 0);  // If any divisor exists, it's not prime
    }


}
