package pl.funnyskaddon.skript.events.guild.member

import ch.njol.skript.Skript
import ch.njol.skript.lang.util.SimpleEvent
import pl.funnyskaddon.docs.FunnyDoc

@FunnyDoc
class GuildMemberInviteEvent : SimpleEvent() {

    companion object {
        init {
            Skript.registerEvent(
                "Guild Member Invite",
                GuildMemberInviteEvent::class.java,
                net.dzikoysk.funnyguilds.event.guild.member.GuildMemberInviteEvent::class.java,
                "guild member (invite|invitation)"
            )
        }
    }

}