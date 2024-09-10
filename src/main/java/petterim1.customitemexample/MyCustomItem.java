package petterim1.customitemexample;

import cn.nukkit.item.Item;
import cn.nukkit.item.custom.CustomItem;
import cn.nukkit.item.custom.CustomItemManager;
import cn.nukkit.item.custom.ItemDefinition;

// You can also extend other existing item behavior like ItemArmor, ItemEdible or ItemTool
// Just remember to implement CustomItem
public class MyCustomItem extends Item implements CustomItem {

    public static final String IDENTIFIER = "wiki:custom_item";

    // NOTE: Nukkit currently still saves items by their legacy ID so make sure there are no conflicting IDs between plugins!
    public static final int NUKKIT_ID = CustomItemManager.LOWEST_CUSTOM_ITEM_ID + 3;

    // Remember to register the definition using CustomItemManager.get().registerDefinition() on startup
    public static final ItemDefinition DEFINITION =
            ItemDefinition.builder().identifier(IDENTIFIER).legacyId(NUKKIT_ID).implementation(MyCustomItem.class)
                    .texture("custom_item").foil(true).creativeCategory(ItemDefinition.CreativeCategory.EQUIPMENT).build();

    public MyCustomItem() {
        this(0);
    }

    public MyCustomItem(Integer meta) {
        this(meta, 1);
    }

    public MyCustomItem(Integer meta, int count) {
        super(NUKKIT_ID, meta, count, "My Custom Item");
    }

    @Override
    public ItemDefinition getItemDefinition() {
        return DEFINITION;
    }

    @Override
    public int getMaxStackSize() {
        return 16;
    }

    @Override
    public boolean allowOffhand() {
        return true;
    }
}
