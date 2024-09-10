package petterim1.customitemexample;

import cn.nukkit.item.ItemTool;
import cn.nukkit.item.custom.CustomItem;
import cn.nukkit.item.custom.CustomItemManager;
import cn.nukkit.item.custom.ItemDefinition;

// You can also extend other existing item behavior like ItemArmor, ItemEdible or ItemTool
// Just remember to implement CustomItem
public class MyCustomSword extends ItemTool implements CustomItem {

    public static final String IDENTIFIER = "wiki:custom_sword";

    // NOTE: Nukkit currently still saves items by their legacy ID so make sure there are no conflicting IDs between plugins!
    public static final int NUKKIT_ID = CustomItemManager.LOWEST_CUSTOM_ITEM_ID + 4;

    // Remember to register the definition using CustomItemManager.get().registerDefinition() on startup
    public static final ItemDefinition DEFINITION =
            ItemDefinition.builder().identifier(IDENTIFIER).legacyId(NUKKIT_ID).implementation(MyCustomSword.class)
                    .texture("custom_sword").creativeCategory(ItemDefinition.CreativeCategory.EQUIPMENT)
                    .canDestroyInCreative(false).creativeGroup("itemGroup.name.sword").overrideDisplayName("§l§dMy Custom Sword").build();

    public MyCustomSword() {
        this(0);
    }

    public MyCustomSword(Integer meta) {
        this(meta, 1);
    }

    public MyCustomSword(Integer meta, int count) {
        super(NUKKIT_ID, meta, count, "My Custom Sword");
    }

    @Override
    public ItemDefinition getItemDefinition() {
        return DEFINITION;
    }

    @Override
    public int getMaxDurability() {
        return 1600;
    }

    @Override
    public boolean isSword() {
        return true;
    }

    @Override
    public int getTier() {
        return ItemTool.TIER_DIAMOND;
    }

    @Override
    public int getAttackDamage() {
        return 8;
    }
}
