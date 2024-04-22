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
		keyName = "useWebhookOneForScroll",
		name = "Use Webhook One For Clue Scrolls",
		description = "Select if you would like to use this webhook for clue scroll notifications",
		section = webhookOneConfig,
		position = 7
	)
	default boolean useWebhookOneForScroll() {
		return false;
	}

	@ConfigItem(
		keyName = "useWebhookOneForCA",
		name = "Use Webhook One For Combat Achievements",
		description = "Select if you would like to use this webhook for combat achievement notifications",
		section = webhookOneConfig,
		position = 8
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
		name = "Use Webhook Two",
		description = "Select if you would like to use this webhook",
		section = webhookTwoConfig,
		position = 1
	)
	default boolean useWebhookTwo() {
		return false;
	}

	@ConfigItem(
		keyName = "webhookTwoString",
		name = "Webhook Two URL",
		description = "Webhook Two URL to send messages to.",
		section = webhookTwoConfig,
		position = 2
	)
	String webhookTwo();

	@ConfigItem(
		keyName = "useWebhookTwoForDeath",
		name = "Use Webhook Two For Deaths",
		description = "Select if you would like to use this webhook for death notifications",
		section = webhookTwoConfig,
		position = 3
	)
	default boolean useWebhookTwoForDeath() {
		return false;
	}	
	
	@ConfigItem(
		keyName = "useWebhookTwoForLevel",
		name = "Use Webhook Two For Levels",
		description = "Select if you would like to use this webhook for level notifications",
		section = webhookTwoConfig,
		position = 4
	)
	default boolean useWebhookTwoForLevel() {
		return false;
	}

	@ConfigItem(
		keyName = "useWebhookTwoForQuest",
		name = "Use Webhook Two For Quests",
		description = "Select if you would like to use this webhook for quest notifications",
		section = webhookTwoConfig,
		position = 4
	)
	default boolean useWebhookTwoForQuest() {
		return false;
	}

	@ConfigItem(
		keyName = "useWebhookTwoForClog",
		name = "Use Webhook Two For Collection Logs",
		description = "Select if you would like to use this webhook for collection log notifications",
		section = webhookTwoConfig,
		position = 5
	)
	default boolean useWebhookTwoForClog() {
		return false;
	}

	@ConfigItem(
		keyName = "useWebhookTwoForPets",
		name = "Use Webhook Two For Pets",
		description = "Select if you would like to use this webhook for pet notifications",
		section = webhookTwoConfig,
		position = 6
	)
	default boolean useWebhookTwoForPets() {
		return false;
	}

	@ConfigItem(
		keyName = "useWebhookTwoForScroll",
		name = "Use Webhook Two For Clue Scrolls",
		description = "Select if you would like to use this webhook for clue scroll notifications",
		section = webhookTwoConfig,
		position = 7
	)
	default boolean useWebhookTwoForScroll() {
		return false;
	}

	@ConfigItem(
		keyName = "useWebhookTwoForCA",
		name = "Use Webhook Two For Combat Achievements",
		description = "Select if you would like to use this webhook for combat achievement notifications",
		section = webhookTwoConfig,
		position = 8
	)
	default boolean useWebhookTwoForCA() {
		return false;
	}

	// Webhook 3 config section
	@ConfigSection(
		name = "Webhook 3 Settings",
		description = "The config for webhook 3 content notifications",
		position = 0,
		closedByDefault = true
	)
	String webhookThreeConfig = "webhookThreeConfig";

	@ConfigItem(
		keyName = "useWebhookThree",
		name = "Use Webhook Three",
		description = "Select if you would like to use this webhook",
		section = webhookThreeConfig,
		position = 1
	)
	default boolean useWebhookThree() {
		return false;
	}

	@ConfigItem(
		keyName = "webhookThreeString",
		name = "Webhook Three URL",
		description = "Webhook Three URL to send messages to.",
		section = webhookThreeConfig,
		position = 2
	)
	String webhookThree();

	@ConfigItem(
		keyName = "useWebhookThreeForDeath",
		name = "Use Webhook Three For Deaths",
		description = "Select if you would like to use this webhook for death notifications",
		section = webhookThreeConfig,
		position = 3
	)
	default boolean useWebhookThreeForDeath() {
		return false;
	}	
	
	@ConfigItem(
		keyName = "useWebhookThreeForLevel",
		name = "Use Webhook Three For Levels",
		description = "Select if you would like to use this webhook for level notifications",
		section = webhookThreeConfig,
		position = 4
	)
	default boolean useWebhookThreeForLevel() {
		return false;
	}

	@ConfigItem(
		keyName = "useWebhookThreeForQuest",
		name = "Use Webhook Three For Quests",
		description = "Select if you would like to use this webhook for quest notifications",
		section = webhookThreeConfig,
		position = 4
	)
	default boolean useWebhookThreeForQuest() {
		return false;
	}

	@ConfigItem(
		keyName = "useWebhookThreeForClog",
		name = "Use Webhook Three For Collection Logs",
		description = "Select if you would like to use this webhook for collection log notifications",
		section = webhookThreeConfig,
		position = 5
	)
	default boolean useWebhookThreeForClog() {
		return false;
	}

	@ConfigItem(
		keyName = "useWebhookThreeForPets",
		name = "Use Webhook Three For Pets",
		description = "Select if you would like to use this webhook for pet notifications",
		section = webhookThreeConfig,
		position = 6
	)
	default boolean useWebhookThreeForPets() {
		return false;
	}

	@ConfigItem(
		keyName = "useWebhookThreeForScroll",
		name = "Use Webhook Three For Clue Scrolls",
		description = "Select if you would like to use this webhook for clue scroll notifications",
		section = webhookThreeConfig,
		position = 7
	)
	default boolean useWebhookThreeForScroll() {
		return false;
	}

	@ConfigItem(
		keyName = "useWebhookThreeForCA",
		name = "Use Webhook Three For Combat Achievements",
		description = "Select if you would like to use this webhook for combat achievement notifications",
		section = webhookThreeConfig,
		position = 8
	)
	default boolean useWebhookThreeForCA() {
		return false;
	}

	// Webhook 4 config section
	@ConfigSection(
		name = "Webhook 4 Settings",
		description = "The config for webhook 4 content notifications",
		position = 0,
		closedByDefault = true
	)
	String webhookFourConfig = "webhookFourConfig";

	@ConfigItem(
		keyName = "useWebhookFour",
		name = "Use Webhook Four",
		description = "Select if you would like to use this webhook",
		section = webhookFourConfig,
		position = 1
	)
	default boolean useWebhookFour() {
		return false;
	}

	@ConfigItem(
		keyName = "webhookFourString",
		name = "Webhook Four URL",
		description = "Webhook Four URL to send messages to.",
		section = webhookFourConfig,
		position = 2
	)
	String webhookFour();

	@ConfigItem(
		keyName = "useWebhookFourForDeath",
		name = "Use Webhook Four For Deaths",
		description = "Select if you would like to use this webhook for death notifications",
		section = webhookFourConfig,
		position = 3
	)
	default boolean useWebhookFourForDeath() {
		return false;
	}	
	
	@ConfigItem(
		keyName = "useWebhookFourForLevel",
		name = "Use Webhook Four For Levels",
		description = "Select if you would like to use this webhook for level notifications",
		section = webhookFourConfig,
		position = 4
	)
	default boolean useWebhookFourForLevel() {
		return false;
	}

	@ConfigItem(
		keyName = "useWebhookFourForQuest",
		name = "Use Webhook Four For Quests",
		description = "Select if you would like to use this webhook for quest notifications",
		section = webhookFourConfig,
		position = 4
	)
	default boolean useWebhookFourForQuest() {
		return false;
	}

	@ConfigItem(
		keyName = "useWebhookFourForClog",
		name = "Use Webhook Four For Collection Logs",
		description = "Select if you would like to use this webhook for collection log notifications",
		section = webhookFourConfig,
		position = 5
	)
	default boolean useWebhookFourForClog() {
		return false;
	}

	@ConfigItem(
		keyName = "useWebhookFourForPets",
		name = "Use Webhook Four For Pets",
		description = "Select if you would like to use this webhook for pet notifications",
		section = webhookFourConfig,
		position = 6
	)
	default boolean useWebhookFourForPets() {
		return false;
	}

	@ConfigItem(
		keyName = "useWebhookFourForScroll",
		name = "Use Webhook Four For Clue Scrolls",
		description = "Select if you would like to use this webhook for clue scroll notifications",
		section = webhookFourConfig,
		position = 7
	)
	default boolean useWebhookFourForScroll() {
		return false;
	}

	@ConfigItem(
		keyName = "useWebhookFourForCA",
		name = "Use Webhook Four For Combat Achievements",
		description = "Select if you would like to use this webhook for combat achievement notifications",
		section = webhookFourConfig,
		position = 8
	)
	default boolean useWebhookFourForCA() {
		return false;
	}

	// Webhook 5 config section
	@ConfigSection(
		name = "Webhook 5 Settings",
		description = "The config for webhook 5 content notifications",
		position = 0,
		closedByDefault = true
	)
	String webhookFiveConfig = "webhookFiveConfig";

	@ConfigItem(
		keyName = "useWebhookFive",
		name = "Use Webhook Five",
		description = "Select if you would like to use this webhook",
		section = webhookFiveConfig,
		position = 1
	)
	default boolean useWebhookFive() {
		return false;
	}

	@ConfigItem(
		keyName = "webhookFiveString",
		name = "Webhook Five URL",
		description = "Webhook Five URL to send messages to.",
		section = webhookFiveConfig,
		position = 2
	)
	String webhookFive();

	@ConfigItem(
		keyName = "useWebhookFiveForDeath",
		name = "Use Webhook Five For Deaths",
		description = "Select if you would like to use this webhook for death notifications",
		section = webhookFiveConfig,
		position = 3
	)
	default boolean useWebhookFiveForDeath() {
		return false;
	}	
	
	@ConfigItem(
		keyName = "useWebhookFiveForLevel",
		name = "Use Webhook Five For Levels",
		description = "Select if you would like to use this webhook for level notifications",
		section = webhookFiveConfig,
		position = 4
	)
	default boolean useWebhookFiveForLevel() {
		return false;
	}

	@ConfigItem(
		keyName = "useWebhookFiveForQuest",
		name = "Use Webhook Five For Quests",
		description = "Select if you would like to use this webhook for quest notifications",
		section = webhookFiveConfig,
		position = 4
	)
	default boolean useWebhookFiveForQuest() {
		return false;
	}

	@ConfigItem(
		keyName = "useWebhookFiveForClog",
		name = "Use Webhook Five For Collection Logs",
		description = "Select if you would like to use this webhook for collection log notifications",
		section = webhookFiveConfig,
		position = 5
	)
	default boolean useWebhookFiveForClog() {
		return false;
	}

	@ConfigItem(
		keyName = "useWebhookFiveForPets",
		name = "Use Webhook Five For Pets",
		description = "Select if you would like to use this webhook for pet notifications",
		section = webhookFiveConfig,
		position = 6
	)
	default boolean useWebhookFiveForPets() {
		return false;
	}

	@ConfigItem(
		keyName = "useWebhookFiveForScroll",
		name = "Use Webhook Five For Clue Scrolls",
		description = "Select if you would like to use this webhook for clue scroll notifications",
		section = webhookFiveConfig,
		position = 7
	)
	default boolean useWebhookFiveForScroll() {
		return false;
	}

	@ConfigItem(
		keyName = "useWebhookFiveForCA",
		name = "Use Webhook Five For Combat Achievements",
		description = "Select if you would like to use this webhook for combat achievement notifications",
		section = webhookFiveConfig,
		position = 8
	)
	default boolean useWebhookFiveForCA() {
		return false;
	}

	// Webhook 6 config section
	@ConfigSection(
		name = "Webhook 6 Settings",
		description = "The config for webhook 6 content notifications",
		position = 0,
		closedByDefault = true
	)
	String webhookSixConfig = "webhookSixConfig";

	@ConfigItem(
		keyName = "useWebhookSix",
		name = "Use Webhook Six",
		description = "Select if you would like to use this webhook",
		section = webhookSixConfig,
		position = 1
	)
	default boolean useWebhookSix() {
		return false;
	}

	@ConfigItem(
		keyName = "webhookSixString",
		name = "Webhook Six URL",
		description = "Webhook Six URL to send messages to.",
		section = webhookSixConfig,
		position = 2
	)
	String webhookSix();

	@ConfigItem(
		keyName = "useWebhookSixForDeath",
		name = "Use Webhook Six For Deaths",
		description = "Select if you would like to use this webhook for death notifications",
		section = webhookSixConfig,
		position = 3
	)
	default boolean useWebhookSixForDeath() {
		return false;
	}	
	
	@ConfigItem(
		keyName = "useWebhookSixForLevel",
		name = "Use Webhook Six For Levels",
		description = "Select if you would like to use this webhook for level notifications",
		section = webhookSixConfig,
		position = 4
	)
	default boolean useWebhookSixForLevel() {
		return false;
	}

	@ConfigItem(
		keyName = "useWebhookSixForQuest",
		name = "Use Webhook Six For Quests",
		description = "Select if you would like to use this webhook for quest notifications",
		section = webhookSixConfig,
		position = 4
	)
	default boolean useWebhookSixForQuest() {
		return false;
	}

	@ConfigItem(
		keyName = "useWebhookSixForClog",
		name = "Use Webhook Six For Collection Logs",
		description = "Select if you would like to use this webhook for collection log notifications",
		section = webhookSixConfig,
		position = 5
	)
	default boolean useWebhookSixForClog() {
		return false;
	}

	@ConfigItem(
		keyName = "useWebhookSixForPets",
		name = "Use Webhook Six For Pets",
		description = "Select if you would like to use this webhook for pet notifications",
		section = webhookSixConfig,
		position = 6
	)
	default boolean useWebhookSixForPets() {
		return false;
	}

	@ConfigItem(
		keyName = "useWebhookSixForScroll",
		name = "Use Webhook Six For Clue Scrolls",
		description = "Select if you would like to use this webhook for clue scroll notifications",
		section = webhookSixConfig,
		position = 7
	)
	default boolean useWebhookSixForScroll() {
		return false;
	}

	@ConfigItem(
		keyName = "useWebhookSixForCA",
		name = "Use Webhook Six For Combat Achievements",
		description = "Select if you would like to use this webhook for combat achievement notifications",
		section = webhookSixConfig,
		position = 8
	)
	default boolean useWebhookSixForCA() {
		return false;
	}

	// Webhook 7 config section
	@ConfigSection(
		name = "Webhook 7 Settings",
		description = "The config for webhook 7 content notifications",
		position = 0,
		closedByDefault = true
	)
	String webhookSevenConfig = "webhookSevenConfig";

	@ConfigItem(
		keyName = "useWebhookSeven",
		name = "Use Webhook Seven",
		description = "Select if you would like to use this webhook",
		section = webhookSevenConfig,
		position = 1
	)
	default boolean useWebhookSeven() {
		return false;
	}

	@ConfigItem(
		keyName = "webhookSevenString",
		name = "Webhook Seven URL",
		description = "Webhook Seven URL to send messages to.",
		section = webhookSevenConfig,
		position = 2
	)
	String webhookSeven();

	@ConfigItem(
		keyName = "useWebhookSevenForDeath",
		name = "Use Webhook Seven For Deaths",
		description = "Select if you would like to use this webhook for death notifications",
		section = webhookSevenConfig,
		position = 3
	)
	default boolean useWebhookSevenForDeath() {
		return false;
	}	
	
	@ConfigItem(
		keyName = "useWebhookSevenForLevel",
		name = "Use Webhook Seven For Levels",
		description = "Select if you would like to use this webhook for level notifications",
		section = webhookSevenConfig,
		position = 4
	)
	default boolean useWebhookSevenForLevel() {
		return false;
	}

	@ConfigItem(
		keyName = "useWebhookSevenForQuest",
		name = "Use Webhook Seven For Quests",
		description = "Select if you would like to use this webhook for quest notifications",
		section = webhookSevenConfig,
		position = 4
	)
	default boolean useWebhookSevenForQuest() {
		return false;
	}

	@ConfigItem(
		keyName = "useWebhookSevenForClog",
		name = "Use Webhook Seven For Collection Logs",
		description = "Select if you would like to use this webhook for collection log notifications",
		section = webhookSevenConfig,
		position = 5
	)
	default boolean useWebhookSevenForClog() {
		return false;
	}

	@ConfigItem(
		keyName = "useWebhookSevenForPets",
		name = "Use Webhook Seven For Pets",
		description = "Select if you would like to use this webhook for pet notifications",
		section = webhookSevenConfig,
		position = 6
	)
	default boolean useWebhookSevenForPets() {
		return false;
	}

	@ConfigItem(
		keyName = "useWebhookSevenForScroll",
		name = "Use Webhook Seven For Clue Scrolls",
		description = "Select if you would like to use this webhook for clue scroll notifications",
		section = webhookSevenConfig,
		position = 7
	)
	default boolean useWebhookSevenForScroll() {
		return false;
	}

	@ConfigItem(
		keyName = "useWebhookSevenForCA",
		name = "Use Webhook Seven For Combat Achievements",
		description = "Select if you would like to use this webhook for combat achievement notifications",
		section = webhookSevenConfig,
		position = 8
	)
	default boolean useWebhookSevenForCA() {
		return false;
	}
}