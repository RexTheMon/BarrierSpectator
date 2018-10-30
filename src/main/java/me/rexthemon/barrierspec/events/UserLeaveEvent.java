package me.rexthemon.barrierspec.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import me.rexthemon.barrierspec.commands.BSToggleCommand;

public class UserLeaveEvent implements Listener {

	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent e) {
		BSToggleCommand.map.remove(e.getPlayer().getName());
	}
}
