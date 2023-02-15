import diet.Food;
import diet.Menu;
import diet.NutritionalElement;
import diet.Recipe;


public class ExampleApp {

    public static void main(String[] args)  {
        Food food = new Food();
        food.defineRawMaterial("Sugar", 400, 0, 100, 0);
        food.defineRawMaterial("Mais", 70, 2.7, 12, 1.3);
        food.defineRawMaterial("Pasta", 350, 12, 72.2, 1.5);
        food.defineRawMaterial("Oil", 900, 0, 0, 100);
        food.defineRawMaterial("Nutella", 530, 6.8, 56, 31);
        
        System.out.println("Calories for the defined materials:");
        for(NutritionalElement e : food.rawMaterials()){
            System.out.println(e.getName() + " cal: " + e.getCalories());
        }

        System.out.println();
        NutritionalElement oil = food.getRawMaterial("Oil");
        System.out.println(oil.getName() + " cal: " + oil.getCalories());
        System.out.println();
        
        food.defineProduct("Crackers", 111, 2.6, 17.2, 3.5);

        System.out.println("Products for the defined materials:");
        for(NutritionalElement e : food.products()){
            System.out.println(e.getName() + " cal: " + e.getCalories());
        }

        System.out.println();
        NutritionalElement product = food.getProduct("Crackers");
        System.out.println(product.getName() + " cal: " + product.getCalories());
        System.out.println();
        
        Recipe r = food.createRecipe("Pasta and Nutella");
        r.addIngredient("Pasta", 70);
        r.addIngredient("Nutella", 30);

        System.out.println(r.getName() + " cal: " + r.getCalories()
                + " carbs: " + r.getCarbs()
                + " fat: " + r.getFat()
                + " proteins: " + r.getProteins()
        );

        System.out.println();

        NutritionalElement recipe = food.getRecipe("Pasta and Nutella");

        System.out.println(recipe.getName() + " cal: " + recipe.getCalories()
                + " carbs: " + recipe.getCarbs()
                + " fat: " + recipe.getFat()
                + " proteins: " + recipe.getProteins()
        );
        System.out.println();
        Menu menu = food.createMenu("M1");
        menu.addRecipe("Pasta and Nutella", 50);
        menu.addProduct("Crackers");
        
        System.out.println("Nutritional value for menu " + menu.getName() + 
                "\n\tCalories : " + menu.getCalories() +
                "\n\tCarbs    : " + menu.getCarbs() +
                "\n\tFat      : " + menu.getFat() +
                "\n\tProteins : " + menu.getProteins() +
                "."
                );

    }

}
