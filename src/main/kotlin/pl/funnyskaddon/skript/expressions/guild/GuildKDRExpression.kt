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
@Name("Guild KDR")
@Description("Zwraca KDR gildii")
@Examples(
    "send \"%\"\"FajnaGildia\"\" guild kdr%\"",
    "set {_kdr} to \"FajnGildia\" guild kdr"
)
class GuildKDRExpression : GuildExpression<Number>() {

    companion object {
        init {
            Skript.registerExpression(
                GuildKDRExpression::class.java,
                Number::class.javaObjectType,
                ExpressionType.PROPERTY,
                "%object%(|'s) guild [(rank|ranking)] kdr"
            )
        }
    }

    override fun get(event: Event): Array<Number>? {
        val guild = getGuild(event)

        if (guild != null) {
            return arrayOf(guild.rank.kdr)
        }

        return null
    }

    override fun getReturnType(): Class<Number> {
        return Number::class.javaObjectType
    }

}