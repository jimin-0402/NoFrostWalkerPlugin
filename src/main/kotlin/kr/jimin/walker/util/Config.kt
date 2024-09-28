package kr.jimin.walker.util

import kr.jimin.walker.NoFrostWalkerPlugin

enum class Config(val path: String) {

    ENABLE("enable");

    var value: Any?
        get() = NoFrostWalkerPlugin.instance.getConfigsManager().getConfig().getString(path)

        set(value) {
            setValue(value, true)
        }

    fun setValue(value: Any?, save: Boolean) {
        val configFile = NoFrostWalkerPlugin.instance.getConfigsManager().getConfig()
        configFile.set(path, value)
        try {
            if (save) configFile.save(NoFrostWalkerPlugin.instance.dataFolder.toPath().resolve("config.yml").toFile())
        } catch (e: Exception) {
            NoFrostWalkerPlugin().logger.severe("변경 사항을 적용하지 못했습니다. config.yml")
        }
    }

    override fun toString(): String {
        return value?.toString() ?: ""
    }

}