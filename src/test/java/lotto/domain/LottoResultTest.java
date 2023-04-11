package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    void z() throws Exception{
        int ticketNumber = 8;
        int bonusNumber = 7;
        List<Integer> winningNumber = new ArrayList<>(List.of(1,2,3,4,5,6));
        List<List<Integer>> lottoTickets = new ArrayList<>();
        lottoTickets.add(List.of(1,2,4,3,5,6)); //1
        lottoTickets.add(List.of(7,2,4,3,5,6)); //2
        lottoTickets.add(List.of(10,11,4,3,5,6)); // 4
        lottoTickets.add(List.of(10,12,24,3,5,6)); // 5
        lottoTickets.add(List.of(10,7,24,3,5,6)); //5
        lottoTickets.add(List.of(1,2,4,3,5,6)); //1
        lottoTickets.add(List.of(9,1,4,3,5,6)); //3
        lottoTickets.add(List.of(9,2,4,3,5,42)); //4

        LottoResult lottoResult = new LottoResult(lottoTickets,winningNumber,bonusNumber);
        HashMap<String,Integer> result = lottoResult.countWin();
        HashMap<String,Integer> test = new HashMap<>();
        test.put("secondPrize",1);
        test.put("fourthPrize",2);
        test.put("thirdPrize",1);
        test.put("fifthPrize",2);
        test.put("firstPrize",2);

        assertEquals(test,result);
    }


}