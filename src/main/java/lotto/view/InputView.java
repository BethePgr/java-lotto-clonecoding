package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {
    private static final String START_MESSAGE = "구입 금액을 입력해주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해주세요.";

    public String inputUserMoney() {
        System.out.println(START_MESSAGE);
        String money = Console.readLine();
        try {
            validMoney(money);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return money;
    }


    public String inputWinningNumber(){
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public String inputBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public void validBonusNumber(String str){
        if(isNotNumber(str) || isWrongRangeNumber(str)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45의 범위를 가진 숫자입니다.");
        }
    }


    public void validWinningNumber(String str){
        if(notExistingInputValue(str) || isWrongRangeNumber(str) || isWrongSize(str) || isDuplicateNumber(str)){
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이의 중복되지 않은 6개의 숫자여야합니다.");
        }
    }

    private boolean isDuplicateNumber(String str){
        Set<String> notDuplicateNumbers = Arrays.stream(str.split(",")).collect(Collectors.toSet());
        return notDuplicateNumbers.size() != 6;
    }

    private boolean isWrongRangeNumber(String str){
        return Arrays.stream(str.split(",")).map(num -> Integer.parseInt(num)).noneMatch(num ->
            num >=1 && num <= 45);
    }

    private boolean isWrongSize(String str){
        return Arrays.stream(str.split(",")).count() != 6;
    }


    public void validMoney(String input){
        if(notExistingInputValue(input) || isFirstLetterZero(input) || isNotDivideInto1000Units(input) || isNotNumber(input)){
            throw new IllegalArgumentException("[ERROR] 숫자로 이루어져야하며, 1000이상이면서"
                + "1000으로 나누어떨어져야한다.");
        }
    }
    //비어있으면 true
    private boolean notExistingInputValue(String input){
        return input.isEmpty();
    }

    //0으로 시작하면 true
    private boolean isFirstLetterZero(String input){
        return input.charAt(0) == '0';
    }

    //1000 나눈 나머지가 0이 아니면 true
    private boolean isNotDivideInto1000Units(String input){
        return (Integer.parseInt(input) % 1000) != 0;
    }

    //숫자 아닌게 있으면 true
    private boolean isNotNumber(String input){
        String reg = "^[0-9]+$";
        return !input.matches(reg);
    }
}
