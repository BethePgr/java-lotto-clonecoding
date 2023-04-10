package lotto.view;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private InputView inputView;

    @BeforeEach
    void setUp(){
       inputView = new InputView();
    }

    @Test
    void 빈칸이면_예외() throws Exception {
        //given
        String input = "";
        assertThrows(IllegalArgumentException.class,()->inputView.checkAll(input));
    }

    @Test
    void 시작이0이면_예외() throws Exception {
        //given
        String input = "01000";
        assertThrows(IllegalArgumentException.class,()->inputView.checkAll(input));
    }

    @Test
    void 숫자로만_이루어진게아니면_예외() throws Exception {
        //given
        String input = "ㅂ100ㅇ";
        assertThrows(IllegalArgumentException.class,()->inputView.checkAll(input));
    }

    @Test
    void 나머지_존재시_예외() throws Exception {
        //given
        String input = "1200";
        assertThrows(IllegalArgumentException.class,()->inputView.checkAll(input));
    }

    @Test
    void 예외가_발생하면안됨() throws Exception {
        //given
        String input = "1000";
        assertDoesNotThrow(() -> {
            inputView.checkAll(input);
        });
    }
}