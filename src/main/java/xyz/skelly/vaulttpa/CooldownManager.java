package xyz.skelly.vaulttpa;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static xyz.skelly.vaulttpa.VaultTPA.config;

public class CooldownManager {

	private final Map<UUID, Long> cooldowns = new HashMap<>();

	public static final long DEFAULT_COOLDOWN = config.getLong("cooldownTime");

	public void setCooldown(UUID player, long time){
		if(time < 1) {
			cooldowns.remove(player);
		} else {
			cooldowns.put(player, time);
		}
	}

	public Long getCooldown(UUID player){
		return cooldowns.getOrDefault(player, Long.valueOf(0));
	}
}