import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Snake {
    private String snakeiness;

    public Snake(int snakeSize) {
        super();
        this.snakeiness = growASnake(snakeSize);
    }

    public boolean snakeSexer() {
        return snakeiness.length() % 2 == 0;
    }

    public String growASnake(int snakeSize) {
        StringJoiner snakeGrower = new StringJoiner("");
        snakeGrower.setEmptyValue("");
        for (int i = 0; i < snakeSize; i++) {
            snakeGrower.add("a");
        }
        return snakeGrower.toString();
    }

    public String getSnakeiness() {
        return snakeiness;
    }

    public void setSnakeiness(String snakeiness) {
        this.snakeiness = snakeiness;
    }

    public static Predicate<Snake> isFemale() {
        return (s) -> s.snakeSexer();
    }

    public static Predicate<Snake> isMale() {
        return (s) -> !s.snakeSexer();
    }

    public static List<Snake> knotSorting(ArrayDeque<Snake> knot, Predicate<Snake> predicate) {
        return knot.stream().filter(predicate).collect(Collectors.<Snake>toList());
    }

}

public class SlitheringSnakes {

    public static void main(String[] args) {
        ArrayDeque<Snake> knotIsAGroupOfSnakesApparently = new ArrayDeque<>();
        Random aProperEnviorementForASnake = new Random();
//		Predicate<Snake> whatIsANamingConventionForPredicatesAnyway = (s) -> s.snakeSexer();

        while (knotIsAGroupOfSnakesApparently.size() < 50) {
            knotIsAGroupOfSnakesApparently.offer(new Snake(aProperEnviorementForASnake.nextInt(50) + 1));
        }
        List<Snake> femaleSnakes = new ArrayList<Snake>();
        List<Snake> maleSnakes = new ArrayList<Snake>();

        femaleSnakes = Snake.knotSorting(knotIsAGroupOfSnakesApparently, Snake.isFemale());
        maleSnakes = Snake.knotSorting(knotIsAGroupOfSnakesApparently, Snake.isFemale().negate());


//		femaleSnakes =  knotIsAGroupOfSnakesApparently.stream().filter(s -> s.snakeSexer()).collect(Collectors.<Snake>toList());
//		maleSnakes =  knotIsAGroupOfSnakesApparently.stream().filter(s -> !s.snakeSexer()).collect(Collectors.<Snake>toList());


//		knotIsAGroupOfSnakesApparently.forEach((snake) -> {
//			if (whatIsANamingConventionForPredicatesAnyway.test(snake)) {
//				femaleSnakes.add(snake);
//			} else {
//				maleSnakes.add(snake);
//			}
//		});
        System.out.println("A number of female snakes: " + femaleSnakes.size());
        System.out.println("A number of male snakes: " + maleSnakes.size());

    }

}
