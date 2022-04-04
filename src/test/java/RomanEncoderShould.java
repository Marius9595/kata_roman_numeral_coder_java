import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class RomanNumeralEncoder{

    public String encode(int i) {
    }
}


public class RomanEncoderShould {

    RomanNumeralEncoder romanNumeralEncoder;
    @BeforeEach
    void setUp(){
        romanNumeralEncoder = new RomanNumeralEncoder();
    }

    @Test
    void pass_happy_test(){
        assertEquals(1,1);
    }


    @Test
    void encode_the_basics_symbols(){
        assertEquals("I", romanNumeralEncoder.encode(1));
    }

}
