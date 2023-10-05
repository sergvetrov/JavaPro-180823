package HW8;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class ProductService {

    public static List<Product> booksToListMore250(List<Product> products) {
        return products.stream()
                .filter(p -> p.getType().equalsIgnoreCase("book") && p.getPrice() > 250)
                .toList();
    }

    public static List<Product> booksToListDiscount10per(List<Product> products) {
        return products.stream()
                .filter(p -> p.getType().equalsIgnoreCase("book") && p.isHaveDiscount())
                .peek(p -> p.setPrice(p.getPrice() * 0.9))
                .toList();
    }

    public static Product getCheapestBook(List<Product> products) {
        return products.stream()
                .filter(p -> p.getType().equalsIgnoreCase("book"))
                .min((o1, o2) -> (int) (o1.getPrice() - o2.getPrice()))
                .orElseThrow(() -> new NoSuchElementException("Продукт [категорія: Book] не знайдено"));
    }

    public static List<Product> getLastThree(List<Product> products) {
        return products.stream()
                .sorted((Comparator.comparing(Product::getAdded)))
                .skip(products.size() - 3)
                .toList();
    }

    public static double getTotalPrice(List<Product> products) {
        return products.stream()
                .filter(p -> p.getAdded().getTime() > p.getAdded().getTime() - 31_536_000_000L)
                .filter(p -> p.getType().equalsIgnoreCase("book"))
                .map(Product::getPrice)
                .filter(price -> price < 75)
                .reduce(Double::sum).get();
    }

    public static Map<String, List<Product>> toMapCategories(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getType, Collectors.mapping(p -> p, Collectors.toList())));
    }
}
