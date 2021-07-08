package de.cfp.essential.tab;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TabCompleteGamemode implements TabCompleter {

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {

        if(args.length == 1) {
            List<String> list = new ArrayList<>();
            list.add("0");
            list.add("1");
            list.add("2");
            list.add("3");
            list.add("s");
            list.add("c");
            list.add("a");
            list.add("sp");
            list.add("survival");
            list.add("creative");
            list.add("adventure");
            list.add("spectator");

            return list;
        }

        return new ArrayList<>();
    }

}
