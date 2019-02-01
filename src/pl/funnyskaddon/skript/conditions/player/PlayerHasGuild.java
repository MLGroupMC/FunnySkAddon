package pl.funnyskaddon.skript.conditions.player;

import javax.annotation.Nullable;

import org.bukkit.OfflinePlayer;
import org.bukkit.event.Event;

import ch.njol.skript.lang.Condition;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import net.dzikoysk.funnyguilds.basic.user.User;
import net.dzikoysk.funnyguilds.basic.user.UserUtils;
import pl.funnyskaddon.core.utils.BasicUtil;

public class PlayerHasGuild extends Condition{
	
	private Expression<OfflinePlayer> player;
    
    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] expr, int i, Kleenean kl, ParseResult pr) {
    	player = (Expression<OfflinePlayer>) expr[0];
    	setNegated(i==1);
        return true;
    }
    
    @Override
    public String toString(@Nullable Event e, boolean b) {
        return null;
    }
    
	@Override
    public boolean check(Event e){
		try {
			OfflinePlayer p = player.getSingle(e);
	    	for(User u : UserUtils.getUsers()) {
	    		if(u.getPlayer() == p) {
	    			return BasicUtil.negation(u.hasGuild(), isNegated());
	    		}
	    	}
	    	return BasicUtil.negation(false, isNegated());
		}catch (Exception ex) {return BasicUtil.negation(false, isNegated());}
    }
    
}