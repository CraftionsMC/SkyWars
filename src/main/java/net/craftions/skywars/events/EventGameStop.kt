package net.craftions.skywars.events

import net.craftions.api.game.events.GameEndEvent
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

class EventGameStop : Listener {

    @EventHandler
    fun onStop(event: GameEndEvent){

    }
}