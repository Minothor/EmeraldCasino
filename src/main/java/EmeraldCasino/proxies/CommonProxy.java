package emeraldCasino.proxies;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler{

	public void registerRenderers() {/*Server Renders Nothing*/}

	@Override
	public Object getClientGuiElement(int arg0, EntityPlayer arg1, World arg2,
			int arg3, int arg4, int arg5) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getServerGuiElement(int arg0, EntityPlayer arg1, World arg2,
			int arg3, int arg4, int arg5) {
		// TODO Auto-generated method stub
		return null;
	}

}
