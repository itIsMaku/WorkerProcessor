package cz.maku.worker;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;

import java.lang.reflect.Field;
import java.util.Arrays;

public final class WorkerUtils {

    public static boolean registerCommand(CommandExecutor commandExecutor, String fallbackPrefix, String command, String description, String usage, String... aliases) {
        try {
            Field commandMapField = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            commandMapField.setAccessible(true);
            CommandMap commandMap = (CommandMap) commandMapField.get(Bukkit.getServer());
            return commandMap.register(fallbackPrefix, new Command(command, description, usage, Arrays.asList(aliases)) {
                @Override
                public boolean execute(CommandSender sender, String commandLabel, String[] args) {
                    return commandExecutor.onCommand(sender, this, commandLabel, args);
                }
            });
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean registerCommand(CommandExecutor commandExecutor, String fallbackPrefix, String command) {
        return registerCommand(commandExecutor, fallbackPrefix, command, "Another command", "/" + command);
    }

}
