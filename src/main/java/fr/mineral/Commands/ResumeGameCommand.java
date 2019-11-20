package fr.mineral.Commands;

import fr.mineral.Core.Equipe;
import fr.mineral.Translation.Lang;
import fr.mineral.mineralcontest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ResumeGameCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("resume")) {
            Equipe teamNonPleine = mineralcontest.plugin.getGame().getEquipeNonPleine();
            if(mineralcontest.plugin.getGame().isGamePaused() && teamNonPleine == null) {
                mineralcontest.plugin.getGame().resumeGame();
            } else {
                sender.sendMessage(mineralcontest.prefixErreur + Lang.translate((String) mineralcontest.LANG.get("error_when_resume")));
                if(teamNonPleine != null) sender.sendMessage(mineralcontest.prefixErreur + Lang.translate((String) mineralcontest.LANG.get("admin_team_non_empty"), teamNonPleine));
            }
        }
        return false;
    }
}
