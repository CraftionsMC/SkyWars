package net.craftions.skywars

import net.craftions.api.config.Config
import net.craftions.api.game.Game
import net.craftions.api.game.util.GameBuilder
import net.craftions.api.game.util.TeamBuilder
import net.craftions.api.language.Language
import net.craftions.skywars.util.PathUtil
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.event.inventory.InventoryType
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

class SkyWars : JavaPlugin() {

    companion object {
        var config: Config? = null;
    }

    override fun onEnable() {
        val configFile: File = File("plugins/SkyWars/config.yml")

        PathUtil.makeRootDirectory(configFile);

        val cfg: Config = Config(configFile, "sw_conf");
        SkyWars.config = cfg

        setDefaultValue("waiting", Location(Bukkit.getWorld("world"), 0.0, 100.0, 0.0))
        setDefaultValue("spawn_red", Location(Bukkit.getWorld("world"), 0.0, 100.0, 0.0))
        setDefaultValue("spawn_blue", Location(Bukkit.getWorld("world"), 0.0, 100.0, 0.0))
        setDefaultValue("spawn_green", Location(Bukkit.getWorld("world"), 0.0, 100.0, 0.0))
        setDefaultValue("spawn_yellow", Location(Bukkit.getWorld("world"), 0.0, 100.0, 0.0))
        setDefaultValue("spawn_orange", Location(Bukkit.getWorld("world"), 0.0, 100.0, 0.0))
        setDefaultValue("spawn_purple", Location(Bukkit.getWorld("world"), 0.0, 100.0, 0.0))

        SkyWars.config!!.reload(true)

        val gameInstance: Game = GameBuilder().setName("SkyWars")
            .setColorCode("§b")
            .setDefaultInventory(Bukkit.createInventory(null, InventoryType.PLAYER))
            .setLanguageCode(Language.Code.ENGLISH)
            .setStartTime(30)
            .setEndTime(900)
            .setMinPlayers(2)
            .setUseTeams(true)
            .setUseTeamSpawns(true)
            .setWaitingLobby(SkyWars.config!!.get("waiting") as Location?)
            .addTeam(
                TeamBuilder()
                    .setName("Red")
                    .setSpawn(SkyWars.config!!.get("spawn_red") as Location?)
                    .setColor("§c")
                    .build()
            )
            .addTeam(
                TeamBuilder()
                    .setName("Blue")
                    .setSpawn(SkyWars.config!!.get("spawn_blue") as Location?)
                    .setColor("§9")
                    .build()
            )
            .addTeam(
                TeamBuilder()
                    .setName("Green")
                    .setSpawn(SkyWars.config!!.get("spawn_green") as Location?)
                    .setColor("§a")
                    .build()
            )
            .addTeam(
                TeamBuilder()
                    .setName("Yellow")
                    .setSpawn(SkyWars.config!!.get("spawn_yellow") as Location?)
                    .setColor("§e")
                    .build()
            )
            .addTeam(
                TeamBuilder()
                    .setName("Orange")
                    .setSpawn(SkyWars.config!!.get("spawn_orange") as Location?)
                    .setColor("§6")
                    .build()
            )
            .addTeam(
                TeamBuilder()
                    .setName("Purple")
                    .setSpawn(SkyWars.config!!.get("spawn_purple") as Location?)
                    .setColor("§d")
                    .build()
            )
            .build()
    }

    private fun setDefaultValue(path: String, value: Any) {
        if (SkyWars.config!!.get(path) == null) {
            SkyWars.config!!.set(path, value)
            SkyWars.config!!.reload(true)
        }
    }
}