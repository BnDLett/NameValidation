# Name Validation
A plugin that validates the username of a player in Mindustry.

# Overview
## What does this plugin do?
It ensures that a player's username does not contain a character that cannot be easily typed
on US-English 60% keyboards. It also ensures that a player's username isn't empty (such as
"[scarlet]" -- which would equate out to being an empty string when using the `.plainName()`
method).

## What is the regex?
`\A(?!\(Admin\)|\(Staff\))([ -~])+\z` <br><br>
In other words, it allows UTF-8 characters ranging from 0x20 ( ) to 0x7e (~)
(refer to [this table](https://www.utf8-chartable.de/)). It also stops players from using 
"(Admin)" and "(Staff)" in their username, which is targeted primarily towards 
[Lett's moderation plugin](https://github.com/BnDLett/moderation_system).

# Installation
## Client
This is a server plugin, which means that this plugin isn't designed to run on a Mindustry client. 
As such, this ***will not*** work on a Mindustry client.

## Headed Server
Similar to regular clients, this isn't designed to run on a headed server. You **will** need a
headless server IF you wish to use this plugin.

## Headless server
1. Install the latest `.jar`.
2. Navigate to the server root directory.
3. Paste the installed `.jar` into `[server_root]/config/mods` (with `[server_root]` being the 
root directory of the server).
4. Run/restart the server -- no additional configuration is required.
