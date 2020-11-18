package cc.sukazyo.entityalchemy.gameobj.item;

import cc.sukazyo.entityalchemy.EntityAlchemy;
import cc.sukazyo.entityalchemy.event.EventGameObjectRegister;
import cc.sukazyo.entityalchemy.logic.recipe.ExtractorRecipe;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraftforge.common.util.EnumHelper;
import org.jetbrains.annotations.NotNull;

public class ItemExtractor extends ItemTool {
	
	public static final String ID = "extractor";
	
	private static final ToolMaterial entity_alchemy_extractor = EnumHelper.addToolMaterial("entity_alchemy_extractor", 2, 80, 5.0f, 1.5f, 1);
	
	public ItemExtractor () {
		super(entity_alchemy_extractor, ExtractorRecipe.extractStack.keySet());
		this.setRegistryName(EntityAlchemy.MODID, ID);
		this.setCreativeTab(EventGameObjectRegister.itemTab);
		this.setTranslationKey(EntityAlchemy.MODID + '.' + ID);
	}
	
	@Override
	public float getDestroySpeed (@NotNull ItemStack stack, IBlockState state) {
		return ExtractorRecipe.extractStack.containsKey(state.getBlock()) ? entity_alchemy_extractor.getEfficiency() : super.getDestroySpeed(stack, state);
	}
	
	@Override
	public boolean canHarvestBlock (IBlockState blockIn) {
		return ExtractorRecipe.extractStack.containsKey(blockIn.getBlock());
	}
	
}
