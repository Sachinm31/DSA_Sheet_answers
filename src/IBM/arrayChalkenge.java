package IBM;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;
public class arrayChalkenge {



        /*
         * Complete the 'arraychallenge' function below.
         * The function is expected to return a LONG_INTEGER_ARRAY.
         * The function accepts LONG_INTEGER_ARRAY arr as parameter.
         */

        public static List<Long> arraychallenge(List<Long> arr) {
            // List to store the final counter values for each element
            List<Long> finalCounters = new ArrayList<>();

            // Iterate through each element in the array (arr[i])
            for (int i = 0; i < arr.size(); i++) {
                // 1. Initializes a counter to 0 for the current element
                long counter = 0;
                long currentElement = arr.get(i);

                // 2. Compares the element with each element to its left (arr[j], where j < i)
                for (int j = 0; j < i; j++) {
                    long leftElement = arr.get(j);

                    if (leftElement > currentElement) {
                        // If the left element is greater, subtract the absolute difference from the counter
                        // Absolute difference is |leftElement - currentElement|
                        long difference = Math.abs(leftElement - currentElement);
                        counter -= difference;
                    } else {
                        // If the left element is smaller or equal, add the absolute difference to the counter
                        // Absolute difference is |leftElement - currentElement|
                        long difference = Math.abs(leftElement - currentElement);
                        counter += difference;
                    }
                }

                // 3. Returns a new array containing the final counter values for each element
                finalCounters.add(counter);
            }

            return finalCounters;
        }
        
}
