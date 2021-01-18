package pl.funnyskaddon.skript.conditions

import ch.njol.skript.lang.Expression
import ch.njol.skript.lang.SkriptParser
import ch.njol.util.Kleenean
import net.dzikoysk.funnyguilds.basic.guild.Guild
import org.bukkit.event.Event
import pl.funnyskaddon.util.GuildUtil

abstract class GuildCondition : FunnyCondition() {

    lateinit var guild: Expression<Any>

    override fun init(
        expression: Array<Expression<*>?>,
        matchedPattern: Int,
        isDelayed: Kleenean?,
        parseResult: SkriptParser.ParseResult?
    ): Boolean {
        guild = expression[0] as Expression<Any>
        if (parseResult != null) {
            isNegated = ((matchedPattern > 1) xor (parseResult.mark == 1))
        }
        return true
    }

    fun getGuild(event: Event?): Guild? {
        return try {
            GuildUtil.getGuild(guild.getSingle(event))
        } catch (ex: Exception) {
            null
        }
    }

}