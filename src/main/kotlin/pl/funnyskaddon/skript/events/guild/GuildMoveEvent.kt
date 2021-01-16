package pl.funnyskaddon.skript.events.guild

import ch.njol.skript.Skript
import ch.njol.skript.lang.util.SimpleEvent
import pl.funnyskaddon.docs.FunnyDoc

@FunnyDoc
class GuildMoveEvent : SimpleEvent() {

    companion object {
        init {
            Skript.registerEvent(
                "Guild Move",
                GuildMoveEvent::class.java,
                net.dzikoysk.funnyguilds.event.guild.GuildMoveEvent::class.java,
                "guild move"
            )
        }
    }

}