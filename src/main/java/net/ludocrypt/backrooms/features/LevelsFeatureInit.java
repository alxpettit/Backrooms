package net.ludocrypt.backrooms.features;

import net.ludocrypt.backrooms.features.decorators.Level0RoomDecorator;
import net.ludocrypt.backrooms.features.decorators.Level1RoomDecorator;
import net.ludocrypt.backrooms.features.decorators.Level2RoomDecorator;
import net.ludocrypt.backrooms.features.decorators.Level3RoomDecorator;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.NopeDecoratorConfig;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class LevelsFeatureInit {

	public static Feature<DefaultFeatureConfig> LEVEL0ROOM = new Level0Room(DefaultFeatureConfig.CODEC);
	public static Feature<DefaultFeatureConfig> LEVEL0REDROOM = new Level0RedRoom(DefaultFeatureConfig.CODEC);
	public static Feature<DefaultFeatureConfig> LEVEL0DOTTEDROOM = new Level0DottedRoom(DefaultFeatureConfig.CODEC);
	public static Feature<DefaultFeatureConfig> LEVEL0DECREPITROOM = new Level0DecrepitRoom(DefaultFeatureConfig.CODEC);
	public static Feature<DefaultFeatureConfig> LEVEL0DOTTEDREDROOM = new Level0DottedRedRoom(
			DefaultFeatureConfig.CODEC);
	public static Feature<DefaultFeatureConfig> LEVEL1ROOM = new Level1Room(DefaultFeatureConfig.CODEC);
	public static Feature<DefaultFeatureConfig> LEVEL1OFFROOM = new Level1OffRoom(DefaultFeatureConfig.CODEC);
	public static Feature<DefaultFeatureConfig> LEVEL2ROOM = new Level2Room(DefaultFeatureConfig.CODEC);
	public static Feature<DefaultFeatureConfig> LEVEL2LONGROOM = new Level2LongRoom(DefaultFeatureConfig.CODEC);
	public static Feature<DefaultFeatureConfig> LEVEL2MESSYROOM = new Level2MessyRoom(DefaultFeatureConfig.CODEC);
	public static Feature<DefaultFeatureConfig> LEVEL3ROOM = new Level3Room(DefaultFeatureConfig.CODEC);
	public static Decorator<NopeDecoratorConfig> LEVEL0DECORATOR = new Level0RoomDecorator(NopeDecoratorConfig.CODEC);
	public static Decorator<NopeDecoratorConfig> LEVEL1DECORATOR = new Level1RoomDecorator(NopeDecoratorConfig.CODEC);
	public static Decorator<NopeDecoratorConfig> LEVEL2DECORATOR = new Level2RoomDecorator(NopeDecoratorConfig.CODEC);
	public static Decorator<NopeDecoratorConfig> LEVEL3DECORATOR = new Level3RoomDecorator(NopeDecoratorConfig.CODEC);

	public static void registerFeatures() {

		Registry.register(Registry.FEATURE, new Identifier("backrooms", "level0room"), LEVEL0ROOM);
		Registry.register(Registry.FEATURE, new Identifier("backrooms", "level0redroom"), LEVEL0REDROOM);
		Registry.register(Registry.FEATURE, new Identifier("backrooms", "level0dottedroom"), LEVEL0DOTTEDROOM);
		Registry.register(Registry.FEATURE, new Identifier("backrooms", "level0decrepitroom"), LEVEL0DECREPITROOM);
		Registry.register(Registry.FEATURE, new Identifier("backrooms", "level0dottedredroom"), LEVEL0DOTTEDREDROOM);
		Registry.register(Registry.FEATURE, new Identifier("backrooms", "level1room"), LEVEL1ROOM);
		Registry.register(Registry.FEATURE, new Identifier("backrooms", "level1offroom"), LEVEL1OFFROOM);
		Registry.register(Registry.FEATURE, new Identifier("backrooms", "level2room"), LEVEL2ROOM);
		Registry.register(Registry.FEATURE, new Identifier("backrooms", "level2longroom"), LEVEL2LONGROOM);
		Registry.register(Registry.FEATURE, new Identifier("backrooms", "level2messyroom"), LEVEL2MESSYROOM);
		Registry.register(Registry.FEATURE, new Identifier("backrooms", "level3room"), LEVEL3ROOM);
		Registry.register(Registry.DECORATOR, new Identifier("backrooms", "level0decorator"), LEVEL0DECORATOR);
		Registry.register(Registry.DECORATOR, new Identifier("backrooms", "level1decorator"), LEVEL1DECORATOR);
		Registry.register(Registry.DECORATOR, new Identifier("backrooms", "level2decorator"), LEVEL2DECORATOR);
		Registry.register(Registry.DECORATOR, new Identifier("backrooms", "level3decorator"), LEVEL3DECORATOR);
	}
}