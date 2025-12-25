import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrimeCheckerTest {

    @Test
    public void testIsPrime_StandardPrimes() {
        Assertions.assertTrue(PrimeChecker.isPrime(2));
        Assertions.assertTrue(PrimeChecker.isPrime(3));
        Assertions.assertTrue(PrimeChecker.isPrime(5));
        Assertions.assertTrue(PrimeChecker.isPrime(13));
        Assertions.assertTrue(PrimeChecker.isPrime(7919));
    }

    @Test
    public void testIsPrime_NonPrimes() {
        Assertions.assertFalse(PrimeChecker.isPrime(4));
        Assertions.assertFalse(PrimeChecker.isPrime(9));
        Assertions.assertFalse(PrimeChecker.isPrime(100));
        Assertions.assertFalse(PrimeChecker.isPrime(15));
    }

    @Test
    public void testIsPrime_EdgeCases() {
        Assertions.assertFalse(PrimeChecker.isPrime(1), "1 není prvočíslo");
        Assertions.assertFalse(PrimeChecker.isPrime(0), "0 není prvočíslo");
        Assertions.assertFalse(PrimeChecker.isPrime(-7), "Záporná čísla nejsou prvočísla");
    }

    @Test
    public void testIsPrime_LargePrime() {
        Assertions.assertTrue(PrimeChecker.isPrime(104729));
    }
}