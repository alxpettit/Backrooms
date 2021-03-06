package net.ludocrypt.backrooms.blocks;

import java.util.Random;
import java.util.function.Consumer;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.misc.BackroomsSoundEvents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Wallpaper extends Block {

	public Wallpaper() {

		super(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).sounds(BlockSoundGroup.WOOD)
				.hardness(3).resistance(3));
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand,
			BlockHitResult hit) {
		Random rand = world.random;
		ItemStack itemStack = player.getStackInHand(hand);
		if (itemStack.getItem() == Items.SHEARS || itemStack.getItem() instanceof AxeItem) {
			if (!world.isClient && !state.getBlock().isIn(BlockTags.FIRE)) {
				itemStack.damage(1, (LivingEntity) player, (Consumer<LivingEntity>) ((e) -> {
					((LivingEntity) e).sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
				}));
			}

			ItemStack normal = new ItemStack(Backrooms.WALLPAPER_PATTERN, rand.nextInt(4) + 1);
			ItemStack dotted = new ItemStack(Backrooms.DOTTED_WALLPAPER_PATTERN, rand.nextInt(4) + 1);
			ItemStack red = new ItemStack(Backrooms.RED_WALLPAPER_PATTERN, rand.nextInt(4) + 1);
			ItemStack dottedred = new ItemStack(Backrooms.DOTTED_RED_WALLPAPER_PATTERN, rand.nextInt(4) + 1);
			ItemEntity normalItem = new ItemEntity(world, hit.getPos().getX(), hit.getPos().getY(), hit.getPos().getZ(),
					normal);
			ItemEntity dottedItem = new ItemEntity(world, hit.getPos().getX(), hit.getPos().getY(), hit.getPos().getZ(),
					dotted);
			ItemEntity redItem = new ItemEntity(world, hit.getPos().getX(), hit.getPos().getY(), hit.getPos().getZ(),
					red);
			ItemEntity dottedRedItem = new ItemEntity(world, hit.getPos().getX(), hit.getPos().getY(), hit.getPos().getZ(),
					dottedred);

			if (world.getBlockState(pos) == Backrooms.WALLPAPER.getDefaultState()) {
				world.spawnEntity(normalItem);
			}
			if (world.getBlockState(pos) == Backrooms.DOTTED_WALLPAPER.getDefaultState()) {
				world.spawnEntity(dottedItem);
			}
			if (world.getBlockState(pos) == Backrooms.RED_WALLPAPER.getDefaultState()) {
				world.spawnEntity(redItem);
			}
			if (world.getBlockState(pos) == Backrooms.DOTTED_RED_WALLPAPER.getDefaultState()) {
				world.spawnEntity(dottedRedItem);
			}


			world.setBlockState(pos, Blocks.OAK_PLANKS.getDefaultState());
			player.playSound(BackroomsSoundEvents.TEAR, 1, 1);
			Backrooms.grantAdvancement(player, new Identifier("backrooms", "tear_wallpaper"));
			return ActionResult.SUCCESS;
		} else {
			return ActionResult.FAIL;
		}

	}
}
