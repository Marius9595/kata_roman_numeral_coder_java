import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class RomanNumeralEncoder{

    public String encode(int number) {
        return "I";
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
        assertEquals("V", romanNumeralEncoder.encode(5));
        assertEquals("X", romanNumeralEncoder.encode(10));
        assertEquals("L", romanNumeralEncoder.encode(50));
        assertEquals("C", romanNumeralEncoder.encode(100));
        assertEquals("D", romanNumeralEncoder.encode(500));
        assertEquals("M", romanNumeralEncoder.encode(1000));
    }

}
