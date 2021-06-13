package ej.study.chapter1.item2;

@Builder
public class NutritionFacts {
    private int servingSize;
    private int sodium;
    private int carbohydrate;
    private int servings;

    public NutritionFacts() {
    }

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public NutritionFacts(int servingSize, int sodium, int carbohydrate, int servings) {
        this.servingSize = servingSize;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
        this.servings = servings;
    }

    public static void main(String[] args) {
        // 생성자 : 매개변수가 뭐가 있는지 확인하기 어려움
        NutritionFacts nutritionfacts = new NutritionFacts(1, 6, 10, 20);

        // 자바빈 : setter를 설정함으로 매개변수를 확실히 알 수 있음
        NutritionFacts nutritionfacts2 = new NutritionFacts();

        // 빌더 : 생성자의 안정성과 가독성 모두 취할 수 있음
        NutritionFacts nutritionfacts3 = new NutritionFacts.builder()
    }
}
