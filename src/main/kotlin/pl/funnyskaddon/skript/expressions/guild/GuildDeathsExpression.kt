package pl.funnyskaddon.skript.expressions.guild

import ch.njol.skript.Skript
import ch.njol.skript.doc.Description
import ch.njol.skript.doc.Examples
import ch.njol.skript.doc.Name
import ch.njol.skript.lang.ExpressionType
import org.bukkit.event.Event
import pl.funnyskaddon.docs.FunnyDoc
import pl.funnyskaddon.skript.expressions.GuildExpression

@FunnyDoc
@Name("Guild Deaths")
@Description("Zwraca liczbe śmierci gildii (sume wszystkich śmierci jej członków)")
@Examples(
    "send \"%\"\"FajnaGildia\"\" guild deaths%\"",
    "set {_deaths} to \"FajnaGildia\" guild deaths"
)
class GuildDeathsExpression : GuildExpression<Int>() {

    companion object {
        init {
            Skript.registerExpression(
                GuildDeathsExpression::class.java,
                Int::class.javaObjectType,
                ExpressionType.PROPERTY,
                "%object%(|'s) guild [(rank|ranking)] deaths [amount|count]"
            )
        }
    }

    override fun get(event: Event): Array<Int>? {
        val guild = getGuild(event)

        if (guild != null) {
            return arrayOf(guild.rank.deaths)
        }

        return null
    }

    override fun getReturnType(): Class<Int> {
        return Int::class.javaObjectType
    }

}