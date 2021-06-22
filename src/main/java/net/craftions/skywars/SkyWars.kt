package net.craftions.skywars

import net.craftions.api.game.Game
import net.craftions.api.game.util.GameBuilder
import net.craftions.api.language.Language
import net.craftions.skywars.util.PathUtil
import org.bukkit.Bukkit
import org.bukkit.event.inventory.InventoryType
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

class SkyWars : JavaPlugin() {

    override fun onEnable() {
        val configFile: File = File("plugins/SkyWars/config.yml")

        val gameInstance: Game = GameBuilder().setName("SkyWars")
                .setColorCode("§b")
                .setDefaultInventory(Bukkit.createInventory(null, InventoryType.PLAYER))
                .setLanguageCode(Language.Code.ENGLISH)
                .setStartTime(30)
                .setEndTime(900)
                .setMinPlayers(2)
                .setUseTeams(true)
                .setUseTeamSpawns(true)
                .setWaitingLobby(null)
                .build()
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}