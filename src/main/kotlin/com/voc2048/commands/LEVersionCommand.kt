package com.voc2048.commands

import com.voc2048.util.LangUtil.Companion.sendMessageLocale
import org.bukkit.command.CommandExecutor

/**
 * LEVersionCommand 處理 /leversion 指令，提供插件版本信息。
 */
class LEVersionCommand : CommandExecutor {
    override fun onCommand(
        sender: org.bukkit.command.CommandSender,
        command: org.bukkit.command.Command,
        label: String,
        args: Array<out String>
    ): Boolean {
        sender.sendMessageLocale("Message.Command.Version.Info", mapOf(Pair("%version%", "1.0.0"))) // 這裡可以替換為實際的版本號
        return true
    }
}