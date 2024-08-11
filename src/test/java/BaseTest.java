import api.ProductParser;
import org.junit.jupiter.api.Test;

public class BaseTest {

    @Test
    public void test() {
        ProductParser.getProducts()
                .forEach(System.out::println);
    }
}
