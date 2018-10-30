package me.rexthemon.barrierspec.commands;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;

import me.rexthemon.barrierspec.utils.Core;
import me.rexthemon.barrierspec.utils.PlayerCommand;

public class BSToggleCommand extends PlayerCommand {

	public static Map<String, Boolean> map = new HashMap<>();

	public BSToggleCommand() {
		super("bstoggle");

		setAliases(Arrays.asList("bst", "bypassbs"));
		setDescription("Toggle getting your gamemode changed.");
	}

	@Override
	protected void run(Player player, String[] args) {

		if (!player.hasPermission("barrierspec.bstoggle")) {
			Core.msg(player, "&cYou do not have permission to use this command.");

			return;
		}

		if (map.get(player.getName())) {
			map.put(player.getName(), false);

			Core.msg(player, "&cBypass disabilitato");

			return;

		} else {
			map.put(player.getName(), true);

			Core.msg(player, "&aBypass abilitato");

			return;
		}
	}
}
