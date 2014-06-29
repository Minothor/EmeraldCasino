package emeraldCasino.renderers.items;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemCardHandRenderer implements IItemRenderer {

	@Override
	public boolean handleRenderType(ItemStack itemStack, ItemRenderType type) {
		return (type==ItemRenderType.FIRST_PERSON_MAP);
	}

	@Override
	public void renderItem(ItemRenderType arg0, ItemStack arg1, Object... arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType arg0, ItemStack arg1,
			ItemRendererHelper arg2) {
		// TODO Auto-generated method stub
		return false;
	}

}
