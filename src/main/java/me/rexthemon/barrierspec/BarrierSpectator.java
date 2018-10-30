package me.rexthemon.barrierspec;

import org.bukkit.command.Command;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.rexthemon.barrierspec.commands.BSToggleCommand;
import me.rexthemon.barrierspec.events.UserJoinEvent;
import me.rexthemon.barrierspec.events.UserLeaveEvent;
import me.rexthemon.barrierspec.tasks.SetSpectatorTask;
import me.rexthemon.barrierspec.utils.Core;

public class BarrierSpectator extends JavaPlugin {

	private static BarrierSpectator instance;

	@Override
	public void onEnable() {
		instance = this;

		registerCommands(
				new BSToggleCommand());

		registerEvents(
				new UserLeaveEvent(),
				new UserJoinEvent());

		new SetSpectatorTask().runTaskTimer(this, 1, 0);
	}

	@Override
	public void onDisable() {
		instance = null;
	}

	private void registerCommands(Command... cmds) {

		for (final Command cmd : cmds)
			Core.registerCommand(cmd);
	}

	private void registerEvents(Listener... listeners) {
		final PluginManager pm = getServer().getPluginManager();

		for (final Listener l : listeners)
			pm.registerEvents(l, this);
	}

	public static BarrierSpectator getInstance() {
		return instance;
	}

}
