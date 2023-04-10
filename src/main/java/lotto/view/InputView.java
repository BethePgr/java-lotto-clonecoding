package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final static String START_MESSAGE = "구입 금액을 입력해주세요.";

    public String inputStartMoney(){
        System.out.println(START_MESSAGE);
        return Console.readLine();
    }

    public void checkAll(String input){
        if(notEmpty(input) || startWith0(input) || noRemain(input) || notOnlyNumber(input)){
            throw new IllegalArgumentException("[ERROR] 숫자로 이루어져야하며, 1000이상이면서"
                + "1000으로 나누어떨어져야한다.");
        }
    }
    //비어있으면 true
    private boolean notEmpty(String input){
        return input.isEmpty();
    }

    //0으로 시작하면 true
    private boolean startWith0(String input){
        return input.charAt(0) == '0';
    }

    //1000 나눈 나머지가 0이 아니면 true
    private boolean noRemain(String input){
        return (Integer.parseInt(input) % 1000) != 0;
    }

    //숫자 아닌게 있으면 true
    private boolean notOnlyNumber(String input){
        String reg = "^[0-9]+$";
        return !input.matches(reg);
    }
}
