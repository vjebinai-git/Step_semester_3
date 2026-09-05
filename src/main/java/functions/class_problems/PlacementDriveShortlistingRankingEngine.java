package functions.assigment_problems;

import java.util.Arrays;

public class PlacementDriveShortlistingRankingEngine {

    static class Candidate implements Comparable<Candidate> {

        private String name;
        private double cgpa;
        private int codingScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        public static boolean isEligible(double cgpa) {
            return cgpa >= 7.5;
        }

        public static boolean isEligible(double cgpa, int codingScore) {
            return cgpa >= 6.5 && codingScore >= 60;
        }

        private double getCompositeScore() {
            return (cgpa * 10) + codingScore;
        }

        @Override
        public int compareTo(Candidate other) {
            return Double.compare(
                    other.getCompositeScore(),
                    this.getCompositeScore()
            );
        }

        public String getResult(int rank) {
            return rank + ". " + name + " (" + getCompositeScore() + ")";
        }
    }

    public static String shortlistAndRank(Candidate[] candidates) {

        int count = 0;

        for (Candidate candidate : candidates) {

            if (Candidate.isEligible(candidate.cgpa)
                    || Candidate.isEligible(candidate.cgpa, candidate.codingScore)) {
                count++;
            }
        }

        Candidate[] shortlisted = new Candidate[count];

        int index = 0;

        for (Candidate candidate : candidates) {

            if (Candidate.isEligible(candidate.cgpa)
                    || Candidate.isEligible(candidate.cgpa, candidate.codingScore)) {
                shortlisted[index] = candidate;
                index++;
            }
        }

        Arrays.sort(shortlisted);

        String result = "";

        for (int i = 0; i < shortlisted.length; i++) {

            result += shortlisted[i].getResult(i + 1);

            if (i < shortlisted.length - 1) {
                result += " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };

        System.out.println(shortlistAndRank(candidates));
    }
}