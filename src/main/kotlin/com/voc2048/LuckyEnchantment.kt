package com.voc2048

import com.voc2048.commands.LEHelpCommand
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class LuckyEnchantment : JavaPlugin() {

    companion object{
        lateinit var luckyEnchantment: LuckyEnchantment
    }

    override fun onEnable() {
        // Plugin startup logic
        luckyEnchantment = this

        // Command and Event Registration
        Bukkit.getPluginCommand("lehelp").apply {
            this?.setExecutor(LEHelpCommand())
            //this?.setDescription(LangUtil.getString("command_le_help_desc"))
            //this?.setName(LangUtil.getString("command_le_help_name"))
        }

        Bukkit.getPluginCommand("leversion").apply {
            this?.setExecutor(com.voc2048.commands.LEVersionCommand())
        }
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
