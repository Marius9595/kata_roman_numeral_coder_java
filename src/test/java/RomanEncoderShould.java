import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class RomanNumeralEncoder{

    public String encode(int number) {

        String encoding = "";

        switch (number){
            case 1:
                encoding = "I";
                break;
            case 4:
                encoding = "IV";
                break;
            case 5:
                encoding = "V";
                break;
            case 9:
                encoding = "IX";
                break;
            case 10:
                encoding = "X";
                break;
            case 50:
                encoding = "L";
                break;
            case 100:
                encoding = "C";
                break;
            case 500:
                encoding = "D";
                break;
            case 1000:
                encoding = "M";
                break;
        }

        return encoding;
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
        assertEquals("IV", romanNumeralEncoder.encode(4));
        assertEquals("V", romanNumeralEncoder.encode(5));
        assertEquals("IX", romanNumeralEncoder.encode(9));
        assertEquals("X", romanNumeralEncoder.encode(10));
        assertEquals("L", romanNumeralEncoder.encode(50));
        assertEquals("C", romanNumeralEncoder.encode(100));
        assertEquals("D", romanNumeralEncoder.encode(500));
        assertEquals("M", romanNumeralEncoder.encode(1000));
    }



}
