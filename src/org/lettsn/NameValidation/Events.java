package org.lettsn.NameValidation;

import arc.util.*;
import mindustry.game.*;
import mindustry.game.EventType.*;
import static org.lettsn.NameValidation.Utilities.checkUsername;

/**
 * A class used to hold all events related to this plugin.
 */
public class Events {
    /**
     * Initializes all events for this plugin.
     */
    public static void load() {
        arc.Events.on(EventType.PlayerConnect.class, Events::validateUsernameEvent);
    }

    public static void validateUsernameEvent(PlayerConnect event) {
        Boolean usernameAllowed = checkUsername(event.player.plainName());
        boolean usernameEmpty = event.player.plainName().trim().isEmpty();  // isBlank() doesn't work -- likely related to Gradle
                                                                            // trying to compile to be backwards compatible.

        if (usernameAllowed && !usernameEmpty) {
            return;
        }

        String kickMessage = (!usernameEmpty) ? "Your username contains characters that are not allowed. Ensure that " +
                                                "it doesn't contain \"(Admin)\", \"(Staff)\", any capitalization variation " +
                                                "of the former, or any special UTF-8 characters." : "Usernames are not " +
                                                "allowed to be empty.";

        Log.info(String.format("Kicking player %s with UUID %s for an invalid username.", event.player.plainName(), event.player.uuid()));
        event.player.kick(kickMessage, 0);
    }
}
