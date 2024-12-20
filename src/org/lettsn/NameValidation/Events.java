package org.lettsn.NameValidation;

import arc.util.*;
import mindustry.game.*;
import mindustry.game.EventType.*;
import static org.lettsn.NameValidation.Constants.allowedPattern;
import static org.lettsn.NameValidation.Utilities.checkUsername;

/**
 * A class used to hold all events related to this plugin.
 */
public class Events {
    /**
     * Initializes all events for this plugin.
     */
    public static void init() {
        arc.Events.on(EventType.PlayerConnect.class, Events::validateUsernameEvent);
    }

    public static void validateUsernameEvent(PlayerConnect event) {
        Boolean usernameAllowed = checkUsername(event.player.plainName());
        boolean usernameEmpty = event.player.name().isEmpty();

        if (usernameAllowed && !usernameEmpty) {
            return;
        }

        Log.info(String.format("Kicking player %s with UUID %s for an invalid username.", event.player.plainName(), event.player.uuid()));
        event.player.kick("Invalid username! Regex pattern: " + allowedPattern, 0);
    }
}
