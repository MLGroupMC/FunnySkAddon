package pl.funnyskaddon.skript.effects.player

import ch.njol.skript.Skript
import org.bukkit.event.Event
import pl.funnyskaddon.skript.effects.PlayerEffect

class PlayerAddDeathsEffect : PlayerEffect<Number>(true) {

    companion object {
        init {
            Skript.registerEffect(
                PlayerAddDeathsEffect::class.java,
                "add %number% death[s] to %offlineplayer%(|'s) [rank|ranking]"
            )
        }
    }

    override fun execute(event: Event?) {
        val user = getUser(event)

        var change = 0
        val value = getValue(event)
        if (value != null) {
            change = value.toInt()
        }

        user?.rank?.deaths = user?.rank?.deaths?.plus(change)!!
    }

}