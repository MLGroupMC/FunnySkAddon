package pl.funnyskaddon.skript.events.guild

import ch.njol.skript.Skript
import ch.njol.skript.lang.util.SimpleEvent
import pl.funnyskaddon.docs.FunnyDoc
import pl.funnyskaddon.events.guilds.CustomGuildCreateEvent

@FunnyDoc
class GuildCreateEvent : SimpleEvent() {

    companion object {
        init {
            Skript.registerEvent(
                "Guild Create",
                GuildCreateEvent::class.java,
                CustomGuildCreateEvent::class.java,
                "guild (create|creation)"
            )
        }
    }

}