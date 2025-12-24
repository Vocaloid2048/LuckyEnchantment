package com.voc2048.commands

import com.voc2048.util.LangUtil
import com.voc2048.util.LangUtil.Companion.sendMessageLocale
import org.bukkit.command.CommandExecutor
import org.bukkit.entity.Player

/**
 * LEHelpCommand 處理 /lehelp 指令，提供插件幫助信息。
 */
class LEHelpCommand : CommandExecutor{
    override fun onCommand(
        sender: org.bukkit.command.CommandSender,
        command: org.bukkit.command.Command,
        label: String,
        args: Array<out String>
    ): Boolean {
        // 構建幫助信息
        val helpMessage = listOf(
            "Message.Command.Help.Help",
            "Message.Command.Help.MainGUI",
            "Message.Command.Help.Version",
        ).sorted().joinToString("\n") { LangUtil.getString(it) }

        // 發送幫助信息給指令發送者
        if (sender !is Player){
            sender.sendMessageLocale("Message.Command.Warning.CommandOnlyPlayer")
            return false
        }
        sender.sendMessage(
            LangUtil.getString("Message.Command.Help.Header") + "\n" + helpMessage + "\n" + LangUtil.getString("Message.Command.Help.Footer")
        )

        return true
    }
}