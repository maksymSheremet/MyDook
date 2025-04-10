package my.code.chapter2.template_builder;

public class BuilderRunner {
    public static void main(String[] args) {
        NutritionFacts nutritionFacts = new NutritionFacts.builder(240, 8)
                .calories(100)
                .sodium(35)
                .carbohydrate(27)
                .build();

        System.out.println(nutritionFacts);
    }
}
