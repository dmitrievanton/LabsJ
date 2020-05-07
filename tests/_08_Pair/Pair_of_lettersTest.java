package _08_Pair;

import org.junit.Test;

import static org.junit.Assert.*;

public class Pair_of_lettersTest {


        @Test
        public void deletePair1() {
            var result = Pair_of_letters.deletePairedLetters1("aab");
            assertEquals("b", result);
        }

        @Test
        public void deletePair2() {
            var result = Pair_of_letters.deletePairedLetters1("abfbaf");
            assertEquals("abfbaf", result);
        }


        @Test
        public void deletePair3() {
            var result = Pair_of_letters.deletePairedLetters1("");
            assertEquals("", result);
        }

        @Test
        public void deletePair4() {
            var result = Pair_of_letters.deletePairedLetters1("1");
            assertEquals("1", result);
        }

        @Test
        public void deletePair5() {
            var result = Pair_of_letters.deletePairedLetters1("aaa");
            assertEquals("a", result);
        }

        @Test
        public void deletePair6() {
            var result = Pair_of_letters.deletePairedLetters1("aaaa");
            assertEquals("", result);
        }
}