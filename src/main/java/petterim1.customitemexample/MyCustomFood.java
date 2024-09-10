package petterim1.customitemexample;

import cn.nukkit.item.ItemEdible;
import cn.nukkit.item.custom.CustomItem;
import cn.nukkit.item.custom.CustomItemManager;
import cn.nukkit.item.custom.ItemDefinition;
import cn.nukkit.item.food.Food;
import cn.nukkit.item.food.FoodNormal;

// You can also extend other existing item behavior like ItemArmor, ItemEdible or ItemTool
// Just remember to implement CustomItem
public class MyCustomFood extends ItemEdible implements CustomItem {

    public static final String IDENTIFIER = "wiki:custom_food";

    // NOTE: Nukkit currently still saves items by their legacy ID so make sure there are no conflicting IDs between plugins!
    public static final int NUKKIT_ID = CustomItemManager.LOWEST_CUSTOM_ITEM_ID + 2;

    // Remember to register the definition using CustomItemManager.get().registerDefinition() on startup
    public static final ItemDefinition DEFINITION =
            ItemDefinition.builder().identifier(IDENTIFIER).legacyId(NUKKIT_ID).implementation(MyCustomFood.class)
                    .texture("custom_food").creativeCategory(ItemDefinition.CreativeCategory.EQUIPMENT).build();

    @SuppressWarnings("unused")
    private static final Food FOOD = Food.registerFood(new FoodNormal(6, 1.2F).addRelative(NUKKIT_ID), Main.INSTANCE);

    public MyCustomFood() {
        this(0);
    }

    public MyCustomFood(Integer meta) {
        this(meta, 1);
    }

    public MyCustomFood(Integer meta, int count) {
        super(NUKKIT_ID, meta, count, "My Custom Food");
    }

    @Override
    public ItemDefinition getItemDefinition() {
        return DEFINITION;
    }

    @Override
    public boolean isDrink() {
        return true;
    }

    @Override
    public boolean canAlwaysEat() {
        return true;
    }
}
