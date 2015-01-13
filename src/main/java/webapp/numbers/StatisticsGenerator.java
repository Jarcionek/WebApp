package webapp.numbers;

import java.util.List;

public class StatisticsGenerator {

    public Object generateStatistics(List<Integer> numbers) {
        return new Statistics(numbers, rms(numbers), am(numbers), gm(numbers), hm(numbers));
    }

    private static Double rms(List<Integer> numbers) {
        double sumOfSquares = numbers.stream().mapToDouble(n -> n * n).sum();
        return Math.sqrt(sumOfSquares / numbers.size());
    }

    private static Double am(List<Integer> numbers) {
        double sum = numbers.stream().mapToDouble(Integer::doubleValue).sum();
        return sum / numbers.size();
    }

    private static Double gm(List<Integer> numbers) {
        double product = numbers.stream().mapToDouble(Integer::doubleValue).reduce((a, b) -> a * b).getAsDouble();
        return root(product, numbers.size());
    }

    private static Double hm(List<Integer> numbers) {
        double sumOfReciprocals = numbers.stream().mapToDouble(n -> 1.0d / n).sum();
        return numbers.size() / sumOfReciprocals;
    }

    private static double root(double number, double degree) {
        return Math.pow(number, 1.0d / degree);
    }
}
