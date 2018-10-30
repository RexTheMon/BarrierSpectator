package me.rexthemon.barrierspec.tasks;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.rexthemon.barrierspec.commands.BSToggleCommand;

public class SetSpectatorTask extends BukkitRunnable {

	@Override
	public void run() {

		for (final Player player : Bukkit.getOnlinePlayers()) {
			final Block block = player.getTargetBlock(null, 5);

			if (!BSToggleCommand.map.get(player.getName())) {
				if (block.getType() == Material.BARRIER) {
					player.setGameMode(GameMode.ADVENTURE);

				} else {
					player.setGameMode(GameMode.SURVIVAL);
				}
			}
		}
	}
}