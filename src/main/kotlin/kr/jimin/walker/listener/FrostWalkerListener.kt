package kr.jimin.walker.listener

import kr.jimin.walker.util.Config
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.EntityBlockFormEvent

class FrostWalkerListener : Listener{

    @EventHandler
    fun onFrostWalkerUse(event: EntityBlockFormEvent) {
        if (!Config.ENABLE.toString().toBoolean()) return

        if (event.entity is Player) {
            val player = event.entity as Player
            val boots = player.inventory.armorContents[0]

            if (boots != null && boots.containsEnchantment(Enchantment.FROST_WALKER)) {
                event.isCancelled = true
            }
        }
    }

}