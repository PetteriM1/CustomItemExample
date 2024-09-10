package petterim1.customitemexample;

import cn.nukkit.item.ItemArmor;
import cn.nukkit.item.custom.CustomItem;
import cn.nukkit.item.custom.CustomItemManager;
import cn.nukkit.item.custom.ItemDefinition;

// You can also extend other existing item behavior like ItemArmor, ItemEdible or ItemTool
// Just remember to implement CustomItem
public class MyCustomChestplate extends ItemArmor implements CustomItem {

    public static final String IDENTIFIER = "wiki:custom_chestplate";

    // NOTE: Nukkit currently still saves items by their legacy ID so make sure there are no conflicting IDs between plugins!
    public static final int NUKKIT_ID = CustomItemManager.LOWEST_CUSTOM_ITEM_ID + 1;

    // Remember to register the definition using CustomItemManager.get().registerDefinition() on startup
    public static final ItemDefinition DEFINITION =
            ItemDefinition.builder().identifier(IDENTIFIER).legacyId(NUKKIT_ID).implementation(MyCustomChestplate.class)
                    .texture("custom_chestplate").creativeCategory(ItemDefinition.CreativeCategory.EQUIPMENT).build();

    public MyCustomChestplate() {
        this(0);
    }

    public MyCustomChestplate(Integer meta) {
        this(meta, 1);
    }

    public MyCustomChestplate(Integer meta, int count) {
        super(NUKKIT_ID, meta, count, "My Custom Chestplate");
    }

    @Override
    public ItemDefinition getItemDefinition() {
        return DEFINITION;
    }

    @Override
    public int getTier() {
        return ItemArmor.TIER_DIAMOND;
    }

    @Override
    public boolean isChestplate() {
        return true;
    }

    @Override
    public int getArmorPoints() {
        return 8;
    }

    @Override
    public int getMaxDurability() {
        return 600;
    }

    @Override
    public int getToughness() {
        return 2;
    }
}
