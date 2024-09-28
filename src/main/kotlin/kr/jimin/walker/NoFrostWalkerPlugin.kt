package kr.jimin.walker

import kr.jimin.walker.config.ConfigsManager
import kr.jimin.walker.listener.FrostWalkerListener
import org.bukkit.plugin.java.JavaPlugin

class NoFrostWalkerPlugin : JavaPlugin() {
    private lateinit var configsManager: ConfigsManager

    companion object {
        lateinit var instance: NoFrostWalkerPlugin
            private set
    }

    override fun onEnable() {
        instance = this

        configsManager = ConfigsManager(this)
        configsManager.reloadYaml()

        server.pluginManager.registerEvents(FrostWalkerListener(), this)
    }


    fun getConfigsManager(): ConfigsManager {
        return configsManager
    }
}