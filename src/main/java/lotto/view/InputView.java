package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String LOTTO_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public int getPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> getLottoNumber() {
        System.out.println(LOTTO_NUMBER_MESSAGE);
        return Arrays.stream(Console.readLine().split(",")).map(Integer::parseInt).collect(
            Collectors.toList());
    }

    public int getLottoBonusNumber(){
        System.out.println(LOTTO_BONUS_NUMBER_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }
}
