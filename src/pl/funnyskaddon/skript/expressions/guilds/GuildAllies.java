package pl.funnyskaddon.skript.expressions.guilds;

import org.bukkit.craftbukkit.libs.jline.internal.Nullable;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import net.dzikoysk.funnyguilds.basic.guild.Guild;
import net.dzikoysk.funnyguilds.basic.guild.GuildUtils;
import net.dzikoysk.funnyguilds.basic.user.User;

public class GuildAllies extends SimpleExpression<Guild>{
    
    private Expression<Object> guild;
    
    @Override
    public Class<? extends Guild> getReturnType() {
        return Guild.class;
    }
	@Override
    public boolean isSingle() {
        return true;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] expr, int i, Kleenean kl, SkriptParser.ParseResult pr) {
    	guild = (Expression<Object>) expr[0];
        return true;
    }
	@Override
    public String toString(@Nullable Event e, boolean b) {
        return null;
    }
	@Override
    protected Guild[] get(Event e) {
		try {
			Guild g = getGuild(guild, e);
		    return g.getAllies().toArray(new Guild[g.getAllies().size()]);
		} catch(Exception ex) { return null;}
    }
	
	 private Guild getGuild(Expression<Object> obj, Event e){
		    Object o = obj.getSingle(e);
		    if(o instanceof Guild){
		        return (Guild) o;
		    } else if(o instanceof Player){
		        return User.get((Player) o).getGuild();
		    } else{
		        return GuildUtils.getByName(o.toString());
		    }
		}
}