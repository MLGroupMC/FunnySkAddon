package pl.funnyskaddon.skript.conditions.guild

import ch.njol.skript.Skript
import ch.njol.skript.doc.Description
import ch.njol.skript.doc.Examples
import ch.njol.skript.doc.Name
import org.bukkit.event.Event
import pl.funnyskaddon.docs.FunnyDoc
import pl.funnyskaddon.skript.conditions.GuildCondition

@FunnyDoc
@Name("Guild PvP Is Enabled")
@Description("Sprawdza czy gildia ma włączone pvp")
@Examples(
    "if guild \"AC4U\" pvp is enabled:",
    "if guild \"AC4U\" pvp is disabled:"
)
class GuildPvPIsEnabledCondition : GuildCondition() {

    companion object {
        init {
            Skript.registerCondition(
                GuildPvPIsEnabledCondition::class.java, "guild %object% pvp is (enabled|on)",
                "guild %object% pvp is (disabled|off)"
            )
        }
    }

    override fun check(event: Event?): Boolean {
        return try {
            getGuild(event)?.pvP?.xor(isNegated)!!
        } catch (ex: Exception) {
            !isNegated
        }
    }

}