package petterim1.customitemexample;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.item.Item;
import cn.nukkit.item.custom.CustomItemManager;
import cn.nukkit.plugin.PluginBase;

public class Main extends PluginBase {

    static Main INSTANCE;

    public Main() {
        INSTANCE = this;
    }

    @Override
    public void onEnable() {
        // Register the custom item definitions
        // Note: Set "load: STARTUP" in plugin.yml
        CustomItemManager.get().registerDefinition(MyCustomChestplate.DEFINITION);
        CustomItemManager.get().registerDefinition(MyCustomFood.DEFINITION);
        CustomItemManager.get().registerDefinition(MyCustomItem.DEFINITION);
        CustomItemManager.get().registerDefinition(MyCustomSword.DEFINITION);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        // Test command to give one custom item to player
        if (commandSender instanceof Player && command.getName().equals("test")) {
            Item item = Item.get(MyCustomItem.NUKKIT_ID, 0, 1);
            ((Player) commandSender).getInventory().addItem(item);
            commandSender.sendMessage("Gave custom item");
        }
        return true;
    }
}
