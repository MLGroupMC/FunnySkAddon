package pl.funnyskaddon.skript.expressions.config

import ch.njol.skript.Skript
import ch.njol.skript.doc.Description
import ch.njol.skript.doc.Examples
import ch.njol.skript.doc.Name
import ch.njol.skript.lang.ExpressionType
import org.bukkit.event.Event
import org.bukkit.inventory.ItemStack
import pl.funnyskaddon.FunnySkAddon
import pl.funnyskaddon.docs.FunnyDoc
import pl.funnyskaddon.skript.expressions.FunnyExpression

@FunnyDoc
@Name("Items To Join Guild")
@Description("Zwraca przedmioty potrzebne aby dołączyć do gildii")
@Examples(
    "send \"%required items to join guild%\"",
    "set {_items} to required items to join guild"
)
class ConfigItemsToJoinGuildVipExpression : FunnyExpression<ItemStack>() {

    companion object {
        init {
            Skript.registerExpression(
                ConfigItemsToJoinGuildVipExpression::class.java,
                ItemStack::class.java,
                ExpressionType.PROPERTY,
                "[required] items (to|for) join guuild"
            )
        }
    }

    override fun get(event: Event): Array<ItemStack> {
        return FunnySkAddon.fgConfiguration.joinItems.toTypedArray()
    }

    override fun getReturnType(): Class<ItemStack> {
        return ItemStack::class.java
    }

}