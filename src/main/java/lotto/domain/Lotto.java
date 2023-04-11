package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        isDuplicate(numbers);
        validateNumber(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void isDuplicate(List<Integer> numbers){
        if(numbers.stream().distinct().count() != 6){
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있으면 안 됩니다.");
        }
    }

    private void validateNumber(List<Integer> numbers){
        if(numbers.stream().filter(num -> num>=1 && num <=45).count() != 6){
            throw new IllegalArgumentException("[ERROR] 로또 번호의 숫자는 1에서 45 사이여야 합니다.");
        }
    }

    public List<Integer> getNumbers(){
        return Collections.unmodifiableList(numbers);
    }
}
