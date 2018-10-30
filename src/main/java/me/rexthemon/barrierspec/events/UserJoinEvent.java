package me.rexthemon.barrierspec.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.rexthemon.barrierspec.commands.BSToggleCommand;

public class UserJoinEvent implements Listener {

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {

		if (e.getPlayer().isOp() || e.getPlayer().hasPermission("barrierspec.bstoggle")) {
			BSToggleCommand.map.put(e.getPlayer().getName(), true);
		} else {
			BSToggleCommand.map.put(e.getPlayer().getName(), false);
		}
	}

}
