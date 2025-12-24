package com.voc2048.util

import com.voc2048.LuckyEnchantment
import com.voc2048.LuckyEnchantment.Companion.luckyEnchantment
import org.bukkit.command.CommandSender
import java.util.Properties

class LangUtil {

    companion object {
        /**
         * 目前語言代碼
         * zh_tw - 繁體中文
         * en_us - 英文
         * ...
         */
        var currLang = "zh_tw"

        /**
         * 根據鍵值獲取對應的語言字符串
         * @param key 鍵值
         * @return 對應的語言字符串
         */
        fun getString(key: String): String {
            return readFromFile(key, currLang)
        }

        /**
         * 根據鍵值和當前語言代碼獲取對應的語言字符串
         * @param key 鍵值
         * @param langCode 語言代碼
         * @return 對應的語言字符串
         */
        internal fun readFromFile(key: String, langCode: String): String {
            return try {
                val inputStream = LangUtil::class.java.classLoader.getResourceAsStream("lang/$langCode.properties")
                    ?: return "?"
                val properties = Properties()
                properties.load(inputStream)
                properties.getProperty(key, "?")
            } catch (e: Exception) {
                luckyEnchantment.logger.info("Failed to read language file for $langCode: ${e.message}")
                "?"
            }
        }

        /**
         * 擴展 CommandSender 類，添加根據鍵值發送本地化消息的方法
         * @param key 鍵值
         * @param args 可選的參數，用於替換消息中的佔位符
         */
        fun CommandSender.sendMessageLocale(key: String, vararg args: Map<String, String>) {
            this.sendMessage(args.map{
                getString(key).replace(it.keys.first(), it.values.first())
            }.firstOrNull() ?: getString(key))
        }
    }
}