import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


class RomanNumeralEncoder{

    private ArrayList<Integer> numeralValuesForSimpleSymbols = new ArrayList<>(Arrays.asList(1, 5, 10, 50, 100, 500, 1000));

    public String encode(int number) {

        String encoding = "" ;

        int digitsOfNumber = (number+"").length();

        int digitsToEncode;
        int digitsEncoded = 0;

        for (int i = digitsOfNumber-1; i >= 0; i--) {

            digitsToEncode = Integer.parseInt((number+"").substring(i, digitsOfNumber)) - digitsEncoded;
            digitsEncoded += digitsToEncode;

            encoding = translateToSymbols(encoding, digitsToEncode);
        }

        return encoding;
    }

    private String translateToSymbols(String encoding, int digitsToEncode) {

        int extractor;
        char[] digits;
        while(digitsToEncode > 0){

            digits =  (digitsToEncode +"").toCharArray();
            extractor = 1;

            extractor = setExtractor(extractor, digits);

            if(numeralValuesForSimpleSymbols.contains(digitsToEncode)){
                encoding = toSimpleSymbols(digitsToEncode) + encoding;
                digitsToEncode = 0;

            }else{
                encoding = toSimpleSymbols(extractor) + encoding;
                digitsToEncode -= extractor;
            }

        }
        return encoding;
    }

    private int setExtractor(int extractor, char[] digits) {
        for (char digit: digits) {
            if(digit == '0'){
                extractor *= 10;
            }
        }
        return extractor;
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
        assertEquals("V", romanNumeralEncoder.encode(5));
        assertEquals("X", romanNumeralEncoder.encode(10));
        assertEquals("L", romanNumeralEncoder.encode(50));
        assertEquals("C", romanNumeralEncoder.encode(100));
        assertEquals("D", romanNumeralEncoder.encode(500));
        assertEquals("M", romanNumeralEncoder.encode(1000));
    }


    @Test
    void write_numerals_expressing_each_digit_separately_starting_with_left_most_digit(){
        assertEquals("CXV", romanNumeralEncoder.encode(115));
        assertEquals("MCX", romanNumeralEncoder.encode(1110));
    }

    //GREEN : RomanEncoderShould repeat_symbol_when_digit_are_not_directly_simple_symbols
    @Test
    void repeat_symbol_when_digit_are_not_directly_simple_symbols(){
        assertEquals("VIII", romanNumeralEncoder.encode(8));
        assertEquals("XII", romanNumeralEncoder.encode(12));
        assertEquals("XX", romanNumeralEncoder.encode(20));
        assertEquals("XXIII", romanNumeralEncoder.encode(23));
        assertEquals("CCC", romanNumeralEncoder.encode(300));
        assertEquals("CCCXXVI", romanNumeralEncoder.encode(326));
        assertEquals("CCCL", romanNumeralEncoder.encode(350));
    }

}
