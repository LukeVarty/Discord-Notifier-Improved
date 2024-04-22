package com.discordnotifications;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup("discordnotifications")
public interface DiscordNotificationsConfig extends Config {

	// Webhook config section
	@ConfigSection(
			name = "Webhook Settings",
			description = "The config for webhook content notifications",
			position = 0,
			closedByDefault = true
	)
	String webhookConfig = "webhookConfig";

	@ConfigItem(
			keyName = "webhook",
			name = "Webhook URL(s)",
			description = "The Discord Webhook URL(s) to send messages to, separated by a newline.",
			section = webhookConfig,
			position = 0
	)
	String webhook();

	@ConfigItem(
		keyName = "useMultipleWebhooks",
		name = "Would you like to use multiple webhooks?",
		description = "Select if you would like to use multiple webhooks for different purposes.",
		section = webhookConfig,
		position = 1
	)
	default boolean useMultipleWebhooks() {
		return false;
	}

	// Levelling config section
	@ConfigSection(
			name = "Levelling",
			description = "The config for levelling notifications",
			position = 1,
			closedByDefault = true
	)
	String levellingConfig = "levellingConfig";

	@ConfigItem(
			keyName = "includeLevelling",
			name = "Send Levelling Notifications",
			description = "Send messages when you level up a skill.",
			section = levellingConfig,
			position = 1
	)
	default boolean includeLevelling() {
		return false;
	}

	@ConfigItem(
			keyName = "minimumLevel",
			name = "Minimum level",
			description = "Levels greater than or equal to this value will send a message.",
			section = levellingConfig,
			position = 2
	)
	default int minLevel() {
		return 0;
	}

	@ConfigItem(
			keyName = "levelInterval",
			name = "Send every X levels",
			description = "Only levels that are a multiple of this value are sent. Level 99 will always be sent regardless of this value.",
			section = levellingConfig,
			position = 3
	)
	default int levelInterval() {
		return 1;
	}

	@ConfigItem(
			keyName = "linearLevelModifier",
			name = "Linear Level Modifier",
			description = "Send every `max(-.1x + linearLevelMax, 1)` levels. Will override `Send every X levels` if set to above zero.",
			section = levellingConfig,
			position = 4
	)
	default double linearLevelMax() {
		return 0;
	}

	@ConfigItem(
			keyName = "levelMessage",
			name = "Level Message",
			description = "Message to send to Discord on Level",
			section = levellingConfig,
			position = 5
	)
	default String levelMessage() { return "$name leveled $skill to $level"; }

	@ConfigItem(
			keyName = "andLevelMessage",
			name = "And Level Message",
			description = "Message to send to Discord when Multi Skill Level",
			section = levellingConfig,
			position = 6
	)
	default String andLevelMessage() { return ", and $skill to $level"; }

	@ConfigItem(
			keyName = "includeTotalLevelMessage",
			name = "Include total level with message",
			description = "Include total level in the message to send to Discord.",
			section = levellingConfig,
			position = 7
	)
	default boolean includeTotalLevel() { return false; }

	@ConfigItem(
			keyName = "totalLevelMessage",
			name = "Total Level Message",
			description = "Message to send to Discord when Total Level is included.",
			section = levellingConfig,
			position = 8
	)
	default String totalLevelMessage() { return " - Total Level: $total"; }

	@ConfigItem(
			keyName = "sendLevellingScreenshot",
			name = "Include levelling screenshots",
			description = "Include a screenshot when leveling up.",
			section = levellingConfig,
			position = 100
	)
	default boolean sendLevellingScreenshot() {
		return false;
	}
	// End levelling config section

	// Questing config section
	@ConfigSection(
			name = "Questing",
			description = "The config for questing notifications",
			position = 2,
			closedByDefault = true
	)
	String questingConfig = "questingConfig";

	@ConfigItem(
			keyName = "includeQuests",
			name = "Send Quest Notifications",
			description = "Send messages when you complete a quest.",
			section = questingConfig
	)
	default boolean includeQuestComplete() {
		return false;
	}

	@ConfigItem(
			keyName = "questMessage",
			name = "Quest Message",
			description = "Message to send to Discord on Quest",
			section = questingConfig,
			position = 1
	)
	default String questMessage() { return "$name has just completed: $quest"; }

	@ConfigItem(
			keyName = "sendQuestingScreenshot",
			name = "Include quest screenshots",
			description = "Include a screenshot with the Discord notification when leveling up.",
			section = questingConfig,
			position = 100
	)
	default boolean sendQuestingScreenshot() {
		return false;
	}
	// End questing config section

	// Death config section
	@ConfigSection(
			name = "Deaths",
			description = "The config for death notifications",
			position = 3,
			closedByDefault = true
	)
	String deathConfig = "deathConfig";

	@ConfigItem(
			keyName = "includeDeaths",
			name = "Send Death Notifications",
			description = "Send messages when you die to Discord.",
			section = deathConfig
	)
	default boolean includeDeaths() { return false; }

	@ConfigItem(
			keyName = "deathMessage",
			name = "Death Message",
			description = "Message to send to Discord on Death",
			section = deathConfig,
			position = 1
	)
	default String deathMessage() { return "$name has just died!"; }

	@ConfigItem(
			keyName = "sendDeathScreenshot",
			name = "Include death screenshots",
			description = "Include a screenshot with the Discord notification when you die.",
			section = deathConfig,
			position = 100
	)
	default boolean sendDeathScreenshot() {
		return false;
	}
	// End death config section

	// Clue config section
	@ConfigSection(
			name = "Clue Scrolls",
			description = "The config for clue scroll notifications",
			position = 4,
			closedByDefault = true
	)
	String clueConfig = "clueConfig";

	@ConfigItem(
			keyName = "includeClues",
			name = "Send Clue Notifications",
			description = "Send messages when you complete a clue scroll.",
			section = clueConfig
	)
	default boolean includeClues() { return false; }

	@ConfigItem(
			keyName = "clueMessage",
			name = "Clue Message",
			description = "Message to send to Discord on Clue",
			section = clueConfig,
			position = 1
	)
	default String clueMessage() { return "$name has just completed a clue scroll!"; }

	@ConfigItem(
			keyName = "sendClueScreenshot",
			name = "Include Clue screenshots",
			description = "Include a screenshot with the Discord notification when you complete a clue.",
			section = clueConfig,
			position = 100
	)
	default boolean sendClueScreenshot() {
		return false;
	}
	// End clue config section

	// Pet config section
	@ConfigSection(
			name = "Pets",
			description = "The config for pet notifications",
			position = 5,
			closedByDefault = true
	)
	String petConfig = "petConfig";

	@ConfigItem(
			keyName = "includePets",
			name = "Send Pet Notifications",
			description = "Send messages when you receive a pet.",
			section = petConfig
	)
	default boolean includePets() { return false; }

	@ConfigItem(
			keyName = "petMessage",
			name = "Pet Message",
			description = "Message to send to Discord on Pet",
			section = petConfig,
			position = 1
	)
	default String petMessage() { return "$name has just received a pet!"; }

	@ConfigItem(
			keyName = "sendPetScreenshot",
			name = "Include Pet screenshots",
			description = "Include a screenshot with the Discord notification when you receive a pet.",
			section = petConfig,
			position = 100
	)
	default boolean sendPetScreenshot() {
		return false;
	}

	@ConfigSection(
		name = "Collection logs",
		description = "The config for collection logs",
		position = 6,
		closedByDefault = true
	)
	String collectionLogsConfig = "collectionLogsConfig";

	@ConfigItem(
		keyName = "includeCollectionLogs",
		name = "Collection Log Notifications",
		description = "Message to send to Discord on collection logs completions",
		section = collectionLogsConfig,
		position = 1
	)
	default boolean includeCollectionLogs() { return false; }

	@ConfigItem(
		keyName = "collectionLogMessage",
		name = "Collection log Message",
		description = "Message to send to Discord on collection logs completions",
		section = collectionLogsConfig,
		position = 2
	)
	default String collectionLogMessage() { return "$name has just completed a collection log: $entry"; }

	@ConfigItem(
		keyName = "sendCollectionLogScreenshot",
		name = "Include collection log screenshots",
		description = "Include a screenshot with the Discord notification when you fill a new collection log slot",
		section = collectionLogsConfig,
		position = 3
	)
	default boolean sendCollectionLogScreenshot() {
		return false;
	}

	@ConfigSection(
		name = "Combat Achievements",
		description = "The config for combat achievements",
		position = 6,
		closedByDefault = true
	)
	String combatAchievementsConfig = "combatAchievementsConfig";

	@ConfigItem(
		keyName = "includeCombatAchievements",
		name = "Combat Achievements Notifications",
		description = "Message to send to Discord on combat achievements completions",
		section = combatAchievementsConfig,
		position = 1
	)
	default boolean includeCombatAchievements() { return false; }

	@ConfigItem(
		keyName = "combatAchievementsMessage",
		name = "Combat Achievement Message",
		description = "Message to send to Discord on combat achievements completions",
		section = combatAchievementsConfig,
		position = 2
	)
	default String combatAchievementsMessage() { return "$name has just completed a combat achievement: $achievement"; }

	@ConfigItem(
		keyName = "sendCombatAchievementScreenshot",
		name = "Include combat achievements screenshots",
		description = "Include a screenshot with the Discord notification when you complete a combat achievement",
		section = combatAchievementsConfig,
		position = 100
	)
	default boolean sendCombatAchievementsScreenshot() {
		return false;
	}

	// Webhook 1 config section
	@ConfigSection(
		name = "Webhook 1 Settings",
		description = "The config for webhook 1 content notifications",
		position = 0,
		closedByDefault = true
	)
	String webhookOneConfig = "webhookOneConfig";

	@ConfigItem(
		keyName = "useWebhookOne",
		name = "Use Webhook One",
		description = "Select if you would like to use this webhook",
		section = webhookOneConfig,
		position = 1
	)
	default boolean useWebhookOne() {
		return false;
	}

	@ConfigItem(
		keyName = "webhookOneString",
		name = "Webhook One URL",
		description = "Webhook One URL to send messages to.",
		section = webhookOneConfig,
		position = 2
	)
	String webhookOne();

	@ConfigItem(
		keyName = "useWebhookOneForDeath",
		name = "Use Webhook One For Deaths",
		description = "Select if you would like to use this webhook for death notifications",
		section = webhookOneConfig,
		position = 3
	)
	default boolean useWebhookOneForDeath() {
		return false;
	}	
	
	@ConfigItem(
		keyName = "useWebhookOneForLevel",
		name = "Use Webhook One For Levels",
		description = "Select if you would like to use this webhook for level notifications",
		section = webhookOneConfig,
		position = 4
	)
	default boolean useWebhookOneForLevel() {
		return false;
	}

	@ConfigItem(
		keyName = "useWebhookOneForQuest",
		name = "Use Webhook One For Quests",
		description = "Select if you would like to use this webhook for quest notifications",
		section = webhookOneConfig,
		position = 4
	)
	default boolean useWebhookOneForQuest() {
		return false;
	}

	@ConfigItem(
		keyName = "useWebhookOneForClog",
		name = "Use Webhook One For Collection Logs",
		description = "Select if you would like to use this webhook for collection log notifications",
		section = webhookOneConfig,
		position = 5
	)
	default boolean useWebhookOneForClog() {
		return false;
	}

	@ConfigItem(
		keyName = "useWebhookOneForPets",
		name = "Use Webhook One For Pets",
		description = "Select if you would like to use this webhook for pet notifications",
		section = webhookOneConfig,
		position = 6
	)
	default boolean useWebhookOneForPets() {
		return false;
	}

	@ConfigItem(
		keyName = "useWebhookOneForCA",
		name = "Use Webhook One For Combat Achievements",
		description = "Select if you would like to use this webhook for combat achievement notifications",
		section = webhookOneConfig,
		position = 7
	)
	default boolean useWebhookOneForCA() {
		return false;
	}

	// Webhook 2 config section
	@ConfigSection(
		name = "Webhook 2 Settings",
		description = "The config for webhook 2 content notifications",
		position = 0,
		closedByDefault = true
	)
	String webhookTwoConfig = "webhookTwoConfig";

	@ConfigItem(
		keyName = "useWebhookTwo",
		name = "Use Webhook One",
		description = "Select if you would like to use this webhook",
		section = webhookTwoConfig,
		position = 1
	)
	default boolean useWebhookTwo() {
		return false;
	}

	@ConfigItem(
		keyName = "webhookTwoString",
		name = "Webhook One URL",
		description = "Webhook One URL to send messages to.",
		section = webhookTwoConfig,
		position = 2
	)
	String webhookTwo();

	@ConfigItem(
		keyName = "useWebhookTwoForDeath",
		name = "Use Webhook One For Deaths",
		description = "Select if you would like to use this webhook for death notifications",
		section = webhookTwoConfig,
		position = 3
	)
	default boolean useWebhookTwoForDeath() {
		return false;
	}	
	
	@ConfigItem(
		keyName = "useWebhookTwoForLevel",
		name = "Use Webhook One For Levels",
		description = "Select if you would like to use this webhook for level notifications",
		section = webhookTwoConfig,
		position = 4
	)
	default boolean useWebhookTwoForLevel() {
		return false;
	}

	@ConfigItem(
		keyName = "useWebhookTwoForQuest",
		name = "Use Webhook One For Quests",
		description = "Select if you would like to use this webhook for quest notifications",
		section = webhookTwoConfig,
		position = 4
	)
	default boolean useWebhookTwoForQuest() {
		return false;
	}

	@ConfigItem(
		keyName = "useWebhookTwoForClog",
		name = "Use Webhook One For Collection Logs",
		description = "Select if you would like to use this webhook for collection log notifications",
		section = webhookTwoConfig,
		position = 5
	)
	default boolean useWebhookTwoForClog() {
		return false;
	}

	@ConfigItem(
		keyName = "useWebhookTwoForPets",
		name = "Use Webhook One For Pets",
		description = "Select if you would like to use this webhook for pet notifications",
		section = webhookTwoConfig,
		position = 6
	)
	default boolean useWebhookTwoForPets() {
		return false;
	}

	@ConfigItem(
		keyName = "useWebhookTwoForCA",
		name = "Use Webhook One For Combat Achievements",
		description = "Select if you would like to use this webhook for combat achievement notifications",
		section = webhookTwoConfig,
		position = 7
	)
	default boolean useWebhookTwoForCA() {
		return false;
	}
}
