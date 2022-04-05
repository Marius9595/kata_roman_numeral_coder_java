import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class RomanNumeralEncoder{

    public String encode(int number) {

        String encoding = "" ;

        int digitsOfNumber = (number+"").length();

        int digitsToEncode;
        int digitsEncoded = 0;

        for (int i = digitsOfNumber-1; i >= 0; i--) {

            digitsToEncode = Integer.parseInt((number+"").substring(i, digitsOfNumber)) - digitsEncoded;
            digitsEncoded += digitsToEncode;


            encoding = toSimpleSymbols(digitsToEncode) + encoding;


        }

        return encoding;
    }

    private String toSimpleSymbols(int digitsToEncode) {

        String encoding;

        switch (digitsToEncode){
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
            default:
                encoding="";
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


    @Test
    void write_numerals_expressing_each_digit_separately_starting_with_left_most_digit(){
        assertEquals("XIV", romanNumeralEncoder.encode(14));
        assertEquals("CXV", romanNumeralEncoder.encode(115));
        assertEquals("MCXIX", romanNumeralEncoder.encode(1119));
    }

    //RED : RomanEncoderShould repeat_symbol_when_digit_are_not_directly_simple_symbols
    @Test
    void repeat_symbol_when_digit_are_not_directly_simple_symbols(){
        assertEquals("XXIV", romanNumeralEncoder.encode(20));
        //assertEquals("XXIV", romanNumeralEncoder.encode(300));
        //assertEquals("XXIV", romanNumeralEncoder.encode(350));
    }

}
