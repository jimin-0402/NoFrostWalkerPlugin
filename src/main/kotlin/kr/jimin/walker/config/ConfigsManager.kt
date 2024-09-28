package kr.jimin.walker.config

import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.Plugin
import java.io.File
import java.io.IOException
import java.io.InputStreamReader

class ConfigsManager(
    private val plugin: Plugin
) {
    private val defaultConfig: YamlConfiguration
    private var config: YamlConfiguration? = null


    init {
        this.defaultConfig = loadDefaultConfig("config.yml")
        loadConfigurations()
    }

    private fun loadDefaultConfig(fileName: String): YamlConfiguration {
        return try {
            plugin.getResource(fileName)?.let { inputStream ->
                InputStreamReader(inputStream).use { reader ->
                    YamlConfiguration.loadConfiguration(reader)
                }
            } ?: YamlConfiguration()
        } catch (e: IOException) {
            e.printStackTrace()
            YamlConfiguration()
        }
    }

    private fun loadConfigurations() {
        config = loadConfiguration("config.yml", defaultConfig)
    }

    private fun loadConfiguration(fileName: String, defaultConfig: YamlConfiguration): YamlConfiguration {
        val file = File(plugin.dataFolder, fileName)
        if (!file.exists() && plugin.getResource(fileName) != null) {
            plugin.saveResource(fileName, false)
        }
        return YamlConfiguration.loadConfiguration(file)
    }

    fun reloadYaml() {
        loadConfigurations()
    }

    fun getConfig(): YamlConfiguration {
        return config ?: defaultConfig
    }



}