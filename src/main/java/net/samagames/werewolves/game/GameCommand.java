package net.samagames.werewolves.game;

import net.samagames.werewolves.WWPlugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/*
 * This file is part of Thiercelieux.
 *
 * Thiercelieux is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Thiercelieux is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Thiercelieux.  If not, see <http://www.gnu.org/licenses/>.
 */
public class GameCommand implements CommandExecutor
{
    private WWPlugin plugin;

    public GameCommand(WWPlugin pl)
    {
        this.plugin = pl;
    }

    @Override
    public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3)
    {
        if (arg3.length == 1 && "nextevent".equalsIgnoreCase(arg3[0]) && arg0.hasPermission("thiercelieux.nextevent"))
            switch (this.plugin.getGame().getGameState())
            {
            case DAY_1:
            case DAY_2:
                this.plugin.getGame().nextDayEvent();
                break ;
            case NIGHT:
                this.plugin.getGame().nextNightEvent();
                break ;
            default:
                break ;
            }
        if (arg3.length == 1 && "check".equalsIgnoreCase(arg3[0]) && arg0.hasPermission("thiercelieux.check"))
            this.plugin.getGame().checkEnd();
        return true;
    }

}
