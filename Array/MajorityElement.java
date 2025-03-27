package Array;

// https://leetcode.com/problems/majority-element
public class MajorityElement {
    /*

    ## What is the Boyer-Moore Voting Algorithm?

    The Boyer-Moore Voting Algorithm is designed to identify the majority element in an array, assuming such an element exists.
    It uses a simple yet ingenious approach by maintaining two variables:

    --- Candidate: The current guess for the majority element.
    --- Counter: A measure of how confident we are in the candidate.

    The algorithm processes the array sequentially, updating the candidate and counter based on each element it encounters.
    At the end, the surviving candidate is the majority element.

    ## Key Idea

    The algorithm works like a voting system. The majority element, because it appears more than half the time,
    will "outvote" all other elements combined. The counter keeps a running tally, increasing when the candidate gains
    support and decreasing when it faces opposition, ensuring the majority element eventually prevails.

    */

    public static int majorityElement(int[] nums) {
        int counter = 0;
        int contender = 0;

        for (int i : nums) {
            if (counter == 0) {
                contender = i;
                counter = 1;
            } else {
                if (i == contender) counter++;
                else counter--;
            }
        }

        return contender;
    }
}
