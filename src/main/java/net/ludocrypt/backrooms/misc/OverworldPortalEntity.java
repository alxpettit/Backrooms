package net.ludocrypt.backrooms.misc;

import java.util.Random;

import com.qouteall.immersive_portals.portal.Portal;

import net.ludocrypt.backrooms.config.BackroomsConfig;
import net.ludocrypt.backrooms.dimension.Level0Dimension;
import net.ludocrypt.backrooms.dimension.Level0DimensionType;
import net.ludocrypt.backrooms.dimension.Level0DottedDimension;
import net.ludocrypt.backrooms.dimension.Level0DottedDimensionType;
import net.ludocrypt.backrooms.dimension.Level0RedDimension;
import net.ludocrypt.backrooms.dimension.Level0RedDimensionType;
import net.ludocrypt.backrooms.dimension.Level1Dimension;
import net.ludocrypt.backrooms.dimension.Level1DimensionType;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.entity.EntityType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Heightmap;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.explosion.Explosion.DestructionType;

public class OverworldPortalEntity extends Portal {

	public OverworldPortalEntity(EntityType<?> entityType_1, World world_1) {
		super(entityType_1, world_1);
	}

	public static void shortDoor(ServerWorld world, BlockPos pos, BlockPattern.Result pattern) {

		ServerWorld Overworld = world.getServer().getWorld(DimensionType.OVERWORLD);
		ServerWorld Level0 = world.getServer().getWorld(Level0DimensionType.LEVEL0);
		ServerWorld Level0Red = world.getServer().getWorld(Level0RedDimensionType.LEVEL0RED);
		ServerWorld Level0Dotted = world.getServer().getWorld(Level0DottedDimensionType.LEVEL0DOTTED);
		ServerWorld Level1 = world.getServer().getWorld(Level1DimensionType.LEVEL1);

		Random generator = new Random(world.getSeed());
		Random generator2 = new Random(world.getSeed());
		Random generator3 = new Random(world.getSeed());
		long seed = world.getSeed();
		long l = generator.nextLong();
		long m = generator.nextLong();
		long n = generator.nextLong();
		long o = pos.getX() * l ^ pos.getY() * m ^ pos.getZ() * n ^ seed;
		generator = new Random(o);
		generator2 = new Random(o+1);
		generator3 = new Random(o+2);

		Random rnd = new Random();

		int x1 = rnd.nextInt(1001 + 1000) - 1000;

		int z1 = rnd.nextInt(1001 + 1000) - 1000;

		int y1 = Overworld.getTopY(Heightmap.Type.OCEAN_FLOOR, x1, z1) + Overworld.getSeaLevel() + 1;

		int chunkz = (rnd.nextInt(64 + 63) - 63) * 16;

		Portal portal = new Portal(entityType, world);

		portal.updatePosition(pos.getX() + 1, pos.getY() + 1.5, pos.getZ());

		if (world.dimension instanceof Level0Dimension) {
			if (generator.nextDouble() < BackroomsConfig.getInstance().SameDimensionChance) {
				portal.destination = new Vec3d(x1, 3.5, chunkz);
				portal.dimensionTo = Level0DimensionType.LEVEL0;
				Level0.setBlockState(new BlockPos(x1, 2, chunkz), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 1, 0), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 2, 0), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 0, 0), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 1, 0), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 2, 0), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 0, -1), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 1, -1), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 2, -1), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 0, -1), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 1, -1), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 2, -1), Blocks.AIR.getDefaultState(), 2);
			} else {
				if (generator2.nextDouble() < BackroomsConfig.getInstance().RedRoomChance) {
					portal.destination = new Vec3d(x1, 3.5, chunkz);
					portal.dimensionTo = Level0RedDimensionType.LEVEL0RED;
					Level0Red.setBlockState(new BlockPos(x1, 2, chunkz), Blocks.AIR.getDefaultState(), 2);
					Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 1, 0), Blocks.AIR.getDefaultState(), 2);
					Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 2, 0), Blocks.AIR.getDefaultState(), 2);
					Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 0, 0), Blocks.AIR.getDefaultState(), 2);
					Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 1, 0), Blocks.AIR.getDefaultState(), 2);
					Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 2, 0), Blocks.AIR.getDefaultState(), 2);
					Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 0, -1), Blocks.AIR.getDefaultState(), 2);
					Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 1, -1), Blocks.AIR.getDefaultState(), 2);
					Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 2, -1), Blocks.AIR.getDefaultState(), 2);
					Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 0, -1), Blocks.AIR.getDefaultState(),
							2);
					Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 1, -1), Blocks.AIR.getDefaultState(),
							2);
					Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 2, -1), Blocks.AIR.getDefaultState(),
							2);
				} else {
					if (generator3.nextDouble() < BackroomsConfig.getInstance().DottedRoomChance) {
						portal.destination = new Vec3d(pos.getX()-1, pos.getY()+2, pos.getZ());
						portal.dimensionTo = Level0DottedDimensionType.LEVEL0DOTTED;
					} else if (generator2.nextDouble() < BackroomsConfig.getInstance().Level1Chance) {
						portal.destination = new Vec3d(x1, 3.5, chunkz);
						portal.dimensionTo = Level1DimensionType.LEVEL1;
						Level1.setBlockState(new BlockPos(x1, 2, chunkz), Blocks.AIR.getDefaultState(), 2);
						Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 1, 0), Blocks.AIR.getDefaultState(), 2);
						Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 2, 0), Blocks.AIR.getDefaultState(), 2);
						Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 0, 0), Blocks.AIR.getDefaultState(),
								2);
						Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 1, 0), Blocks.AIR.getDefaultState(),
								2);
						Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 2, 0), Blocks.AIR.getDefaultState(),
								2);
						Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 0, -1), Blocks.AIR.getDefaultState(),
								2);
						Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 1, -1), Blocks.AIR.getDefaultState(),
								2);
						Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 2, -1), Blocks.AIR.getDefaultState(),
								2);
						Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 0, -1), Blocks.AIR.getDefaultState(),
								2);
						Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 1, -1), Blocks.AIR.getDefaultState(),
								2);
						Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 2, -1), Blocks.AIR.getDefaultState(),
								2);
					} else {
						portal.destination = new Vec3d(x1, y1 + 0.5, z1);
						portal.dimensionTo = DimensionType.OVERWORLD;
						Overworld.createExplosion(null, x1, y1, z1, 4, false, DestructionType.DESTROY);
					}
				}

			}

		} else if (world.dimension instanceof Level0RedDimension) {
			if (generator.nextDouble() < BackroomsConfig.getInstance().SameDimensionChance) {
				portal.destination = new Vec3d(x1, 3.5, chunkz);
				portal.dimensionTo = Level0RedDimensionType.LEVEL0RED;
				Level0Red.setBlockState(new BlockPos(x1, 2, chunkz), Blocks.AIR.getDefaultState(), 2);
				Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 1, 0), Blocks.AIR.getDefaultState(), 2);
				Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 2, 0), Blocks.AIR.getDefaultState(), 2);
				Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 0, 0), Blocks.AIR.getDefaultState(), 2);
				Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 1, 0), Blocks.AIR.getDefaultState(), 2);
				Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 2, 0), Blocks.AIR.getDefaultState(), 2);
				Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 0, -1), Blocks.AIR.getDefaultState(), 2);
				Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 1, -1), Blocks.AIR.getDefaultState(), 2);
				Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 2, -1), Blocks.AIR.getDefaultState(), 2);
				Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 0, -1), Blocks.AIR.getDefaultState(), 2);
				Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 1, -1), Blocks.AIR.getDefaultState(), 2);
				Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 2, -1), Blocks.AIR.getDefaultState(), 2);
			} else if (generator2.nextDouble() < BackroomsConfig.getInstance().Level1Chance) {
				portal.destination = new Vec3d(x1, 3.5, chunkz);
				portal.dimensionTo = Level1DimensionType.LEVEL1;
				Level1.setBlockState(new BlockPos(x1, 2, chunkz), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 1, 0), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 2, 0), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 0, 0), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 1, 0), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 2, 0), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 0, -1), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 1, -1), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 2, -1), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 0, -1), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 1, -1), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 2, -1), Blocks.AIR.getDefaultState(), 2);
			} else {
				portal.destination = new Vec3d(x1, 3.5, chunkz);
				portal.dimensionTo = Level0DimensionType.LEVEL0;
				Level0.setBlockState(new BlockPos(x1, 2, chunkz), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 1, 0), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 2, 0), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 0, 0), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 1, 0), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 2, 0), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 0, -1), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 1, -1), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 2, -1), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 0, -1), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 1, -1), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 2, -1), Blocks.AIR.getDefaultState(), 2);
			}
		} else if (world.dimension instanceof Level1Dimension) {
			if (generator.nextDouble() < BackroomsConfig.getInstance().SameDimensionChance) {
				portal.destination = new Vec3d(x1, 3.5, chunkz);
				portal.dimensionTo = Level1DimensionType.LEVEL1;
				Level1.setBlockState(new BlockPos(x1, 2, chunkz), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 1, 0), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 2, 0), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 0, 0), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 1, 0), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 2, 0), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 0, -1), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 1, -1), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 2, -1), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 0, -1), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 1, -1), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 2, -1), Blocks.AIR.getDefaultState(), 2);
			} else if (generator2.nextDouble() < BackroomsConfig.getInstance().Level0Chance) {
				portal.destination = new Vec3d(x1, 3.5, chunkz);
				portal.dimensionTo = Level0DimensionType.LEVEL0;
				Level0.setBlockState(new BlockPos(x1, 2, chunkz), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 1, 0), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 2, 0), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 0, 0), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 1, 0), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 2, 0), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 0, -1), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 1, -1), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 2, -1), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 0, -1), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 1, -1), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 2, -1), Blocks.AIR.getDefaultState(), 2);
			} else {
				portal.destination = new Vec3d(x1, y1 + 1, z1);
				portal.dimensionTo = DimensionType.OVERWORLD;
				Overworld.createExplosion(null, x1, y1, z1, 4, false, DestructionType.DESTROY);
			}
		} else if (world.dimension instanceof Level0DottedDimension) {
			portal.destination = new Vec3d(pos.getX()-1, pos.getY()+2, pos.getZ());
			portal.dimensionTo = Level0DimensionType.LEVEL0;
		}

		if (generator.nextDouble() < 0.5) {
			portal.yaw = 0;
			portal.axisW = new Vec3d(1, 0, 0);
		} else {
			portal.yaw = 180;
			portal.axisW = new Vec3d(-1, 0, 0);
		}

		portal.axisH = new Vec3d(0, 1, 0);

		portal.width = 2;
		portal.height = 3;

		world.spawnEntity(portal);

	}

	public static void tallDoor(ServerWorld world, BlockPos pos, BlockPattern.Result pattern) {

		ServerWorld Overworld = world.getServer().getWorld(DimensionType.OVERWORLD);
		ServerWorld Level0 = world.getServer().getWorld(Level0DimensionType.LEVEL0);
		ServerWorld Level0Red = world.getServer().getWorld(Level0RedDimensionType.LEVEL0RED);
		ServerWorld Level1 = world.getServer().getWorld(Level1DimensionType.LEVEL1);

		Random generator = new Random(world.getSeed());
		Random generator2 = new Random(world.getSeed());
		Random generator3 = new Random(world.getSeed());
		long seed = world.getSeed();
		long l = generator.nextLong();
		long m = generator.nextLong();
		long n = generator.nextLong();
		long o = pos.getX() * l ^ pos.getY() * m ^ pos.getZ() * n ^ seed;
		generator = new Random(o);
		generator2 = new Random(o+1);
		generator3 = new Random(o+2);

		Random rnd = new Random();

		int x1 = rnd.nextInt(1001 + 1000) - 1000;

		int z1 = rnd.nextInt(1001 + 1000) - 1000;

		int y1 = Overworld.getTopY(Heightmap.Type.OCEAN_FLOOR, x1, z1) + Overworld.getSeaLevel() + 1;

		int chunkz = (rnd.nextInt(64 + 63) - 63) * 16;

		Portal portal = new Portal(entityType, world);

		portal.updatePosition(pos.getX() + 1, pos.getY() + 2, pos.getZ());

		if (world.dimension instanceof Level0Dimension) {
			if (generator.nextDouble() < BackroomsConfig.getInstance().SameDimensionChance) {
				portal.destination = new Vec3d(x1, 4, chunkz);
				portal.dimensionTo = Level0DimensionType.LEVEL0;
				Level0.setBlockState(new BlockPos(x1, 2, chunkz), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 1, 0), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 2, 0), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 0, 0), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 1, 0), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 2, 0), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 0, -1), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 1, -1), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 2, -1), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 0, -1), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 1, -1), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 2, -1), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 3, 0), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 3, 0), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 3, -1), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 3, -1), Blocks.AIR.getDefaultState(), 2);
			} else {
				if (generator2.nextDouble() < BackroomsConfig.getInstance().RedRoomChance) {
					portal.destination = new Vec3d(x1, 4, chunkz);
					portal.dimensionTo = Level0RedDimensionType.LEVEL0RED;
					Level0Red.setBlockState(new BlockPos(x1, 2, chunkz), Blocks.AIR.getDefaultState(), 2);
					Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 1, 0), Blocks.AIR.getDefaultState(), 2);
					Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 2, 0), Blocks.AIR.getDefaultState(), 2);
					Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 0, 0), Blocks.AIR.getDefaultState(), 2);
					Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 1, 0), Blocks.AIR.getDefaultState(), 2);
					Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 2, 0), Blocks.AIR.getDefaultState(), 2);
					Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 0, -1), Blocks.AIR.getDefaultState(), 2);
					Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 1, -1), Blocks.AIR.getDefaultState(), 2);
					Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 2, -1), Blocks.AIR.getDefaultState(), 2);
					Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 0, -1), Blocks.AIR.getDefaultState(),
							2);
					Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 1, -1), Blocks.AIR.getDefaultState(),
							2);
					Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 2, -1), Blocks.AIR.getDefaultState(),
							2);
					Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 3, 0), Blocks.AIR.getDefaultState(), 2);
					Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 3, 0), Blocks.AIR.getDefaultState(), 2);
					Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 3, -1), Blocks.AIR.getDefaultState(), 2);
					Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 3, -1), Blocks.AIR.getDefaultState(),
							2);
				} else {
					if (generator3.nextDouble() < BackroomsConfig.getInstance().DottedRoomChance) {
						portal.destination = new Vec3d(pos.getX()+1, pos.getY()+2, pos.getZ());
						portal.dimensionTo = Level0DottedDimensionType.LEVEL0DOTTED;
					} else if (generator2.nextDouble() < BackroomsConfig.getInstance().Level1Chance) {
						portal.destination = new Vec3d(x1, 4, chunkz);
						portal.dimensionTo = Level1DimensionType.LEVEL1;
						Level1.setBlockState(new BlockPos(x1, 2, chunkz), Blocks.AIR.getDefaultState(), 2);
						Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 1, 0), Blocks.AIR.getDefaultState(), 2);
						Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 2, 0), Blocks.AIR.getDefaultState(), 2);
						Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 0, 0), Blocks.AIR.getDefaultState(),
								2);
						Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 1, 0), Blocks.AIR.getDefaultState(),
								2);
						Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 2, 0), Blocks.AIR.getDefaultState(),
								2);
						Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 0, -1), Blocks.AIR.getDefaultState(),
								2);
						Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 1, -1), Blocks.AIR.getDefaultState(),
								2);
						Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 2, -1), Blocks.AIR.getDefaultState(),
								2);
						Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 0, -1), Blocks.AIR.getDefaultState(),
								2);
						Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 1, -1), Blocks.AIR.getDefaultState(),
								2);
						Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 2, -1), Blocks.AIR.getDefaultState(),
								2);
						Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 3, 0), Blocks.AIR.getDefaultState(), 2);
						Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 3, 0), Blocks.AIR.getDefaultState(),
								2);
						Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 3, -1), Blocks.AIR.getDefaultState(),
								2);
						Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 3, -1), Blocks.AIR.getDefaultState(),
								2);
					} else {
						portal.destination = new Vec3d(x1, y1 + 1, z1);
						portal.dimensionTo = DimensionType.OVERWORLD;
						Overworld.createExplosion(null, x1, y1, z1, 4, false, DestructionType.DESTROY);
					}
				}
			}

		} else if (world.dimension instanceof Level0RedDimension) {
			if (generator.nextDouble() < BackroomsConfig.getInstance().SameDimensionChance) {
				portal.destination = new Vec3d(x1, 4, chunkz);
				portal.dimensionTo = Level0RedDimensionType.LEVEL0RED;
				Level0Red.setBlockState(new BlockPos(x1, 2, chunkz), Blocks.AIR.getDefaultState(), 2);
				Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 1, 0), Blocks.AIR.getDefaultState(), 2);
				Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 2, 0), Blocks.AIR.getDefaultState(), 2);
				Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 0, 0), Blocks.AIR.getDefaultState(), 2);
				Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 1, 0), Blocks.AIR.getDefaultState(), 2);
				Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 2, 0), Blocks.AIR.getDefaultState(), 2);
				Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 0, -1), Blocks.AIR.getDefaultState(), 2);
				Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 1, -1), Blocks.AIR.getDefaultState(), 2);
				Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 2, -1), Blocks.AIR.getDefaultState(), 2);
				Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 0, -1), Blocks.AIR.getDefaultState(), 2);
				Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 1, -1), Blocks.AIR.getDefaultState(), 2);
				Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 2, -1), Blocks.AIR.getDefaultState(), 2);
				Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 3, 0), Blocks.AIR.getDefaultState(), 2);
				Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 3, 0), Blocks.AIR.getDefaultState(), 2);
				Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 3, -1), Blocks.AIR.getDefaultState(), 2);
				Level0Red.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 3, -1), Blocks.AIR.getDefaultState(), 2);
			} else if (generator2.nextDouble() < BackroomsConfig.getInstance().Level1Chance) {
				portal.destination = new Vec3d(x1, 4, chunkz);
				portal.dimensionTo = Level1DimensionType.LEVEL1;
				Level1.setBlockState(new BlockPos(x1, 2, chunkz), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 1, 0), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 2, 0), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 0, 0), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 1, 0), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 2, 0), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 0, -1), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 1, -1), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 2, -1), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 0, -1), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 1, -1), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 2, -1), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 3, 0), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 3, 0), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 3, -1), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 3, -1), Blocks.AIR.getDefaultState(), 2);
			} else {
				portal.destination = new Vec3d(x1, 4, chunkz);
				portal.dimensionTo = Level0DimensionType.LEVEL0;
				Level0.setBlockState(new BlockPos(x1, 2, chunkz), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 1, 0), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 2, 0), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 0, 0), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 1, 0), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 2, 0), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 0, -1), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 1, -1), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 2, -1), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 0, -1), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 1, -1), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 2, -1), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 3, 0), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 3, 0), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 3, -1), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 3, -1), Blocks.AIR.getDefaultState(), 2);
			}
		} else if (world.dimension instanceof Level1Dimension) {
			if (generator.nextDouble() < BackroomsConfig.getInstance().SameDimensionChance) {
				portal.destination = new Vec3d(x1, 4, chunkz);
				portal.dimensionTo = Level1DimensionType.LEVEL1;
				Level1.setBlockState(new BlockPos(x1, 2, chunkz), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 1, 0), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 2, 0), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 0, 0), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 1, 0), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 2, 0), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 0, -1), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 1, -1), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 2, -1), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 0, -1), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 1, -1), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 2, -1), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 3, 0), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 3, 0), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 3, -1), Blocks.AIR.getDefaultState(), 2);
				Level1.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 3, -1), Blocks.AIR.getDefaultState(), 2);
			} else if (generator2.nextDouble() < BackroomsConfig.getInstance().Level0Chance) {
				portal.destination = new Vec3d(x1, 4, chunkz);
				portal.dimensionTo = Level0DimensionType.LEVEL0;
				Level0.setBlockState(new BlockPos(x1, 2, chunkz), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 1, 0), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 2, 0), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 0, 0), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 1, 0), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 2, 0), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 0, -1), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 1, -1), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 2, -1), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 0, -1), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 1, -1), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 2, -1), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 3, 0), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 3, 0), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(0, 3, -1), Blocks.AIR.getDefaultState(), 2);
				Level0.setBlockState(new BlockPos(x1, 2, chunkz).add(-1, 3, -1), Blocks.AIR.getDefaultState(), 2);
			} else {
				portal.destination = new Vec3d(x1, y1 + 1, z1);
				portal.dimensionTo = DimensionType.OVERWORLD;
				Overworld.createExplosion(null, x1, y1, z1, 4, false, DestructionType.DESTROY);
			}
		} else if (world.dimension instanceof Level0DottedDimension) {
			portal.destination = new Vec3d(pos.getX()+1, pos.getY()+2, pos.getZ());
			portal.dimensionTo = Level0DimensionType.LEVEL0;
		}

		if (generator.nextDouble() < 0.5) {
			portal.yaw = 0;
			portal.axisW = new Vec3d(1, 0, 0);
		} else {
			portal.yaw = 180;
			portal.axisW = new Vec3d(-1, 0, 0);
		}

		portal.axisH = new Vec3d(0, 1, 0);

		portal.width = 2;
		portal.height = 4;

		world.spawnEntity(portal);

	}
}
