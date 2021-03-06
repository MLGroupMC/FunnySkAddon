package pl.funnyskaddon.skript.conditions.player

import ch.njol.skript.Skript
import ch.njol.skript.doc.Description
import ch.njol.skript.doc.Examples
import ch.njol.skript.doc.Name
import org.bukkit.event.Event
import pl.funnyskaddon.docs.FunnyDoc
import pl.funnyskaddon.skript.conditions.GuildPlayerCondition
import pl.funnyskaddon.util.isPlayerInGuildRegion

@FunnyDoc
@Name("Is In Guild Region")
@Description("Sprawdza czy gracz jest na terenie danej gildii")
@Examples(
    "if player is in guild \"AC4U\" region:",
    "if player is not in guild \"AC4U\" region:"
)
class PlayerIsInGuildRegionCondition : GuildPlayerCondition() {

    companion object {
        init {
            Skript.registerCondition(
                PlayerIsInGuildRegionCondition::class.java, "(player |)%player% is in guild %object% region",
                "(player |)%player% is(n't| not) in guild %object% region"
            )
        }
    }

    override fun check(event: Event?): Boolean {
        return try {
            getGuild(event)?.isPlayerInGuildRegion(getPlayer(event))?.xor(isNegated)!!
        } catch (ex: Exception) {
            !isNegated
        }
    }

}