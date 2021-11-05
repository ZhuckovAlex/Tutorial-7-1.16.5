package net.project.project.block;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.project.project.Project;
import net.project.project.block.custom.FlameBlockRotate;
import net.project.project.item.ModItemGroup;
import net.project.project.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks extends Blocks {

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, Project.MOD_ID);

    public static final RegistryObject<Block> REDIUM = registerBlock("redium",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()
                    .hardnessAndResistance(2).sound(SoundType.STONE)));
    public static final RegistryObject<Block> FIREWOOD_WOOD = registerBlock("firewood_wood",
            () -> new FlameBlockRotate(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2).sound(SoundType.WOOD).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> FIREWOOD_LOG = registerBlock("firewood_log",
            () -> new FlameBlockRotate(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2).sound(SoundType.WOOD).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> STRIPPED_FIREWOOD_WOOD = registerBlock("stripped_firewood_wood",
            () -> new FlameBlockRotate(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2).sound(SoundType.WOOD).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> STRIPPED_FIREWOOD_LOG = registerBlock("stripped_firewood_log",
            () -> new FlameBlockRotate(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2).sound(SoundType.WOOD).harvestTool(ToolType.AXE)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);

        registerBlockItem(name, toReturn);

        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ModItemGroup.IRON_BLOCK)));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
