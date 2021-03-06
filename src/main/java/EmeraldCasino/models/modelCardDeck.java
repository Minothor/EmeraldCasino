// Date: 11/05/2014 20:14:54
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX
//




package emeraldCasino.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;

public class modelCardDeck extends ModelBase
{
  //fields
    ModelRenderer Base,Top,SideF,SideR,SideL,SideB,Card1,Card2;
  
  public modelCardDeck()
  {
    textureWidth = 16;
    textureHeight = 16;
    
      Base = new ModelRenderer(this, -6, 0);
      Base.addBox(0F, 0F, 0F, 8, 0, 6);
      Base.setRotationPoint(-4F, 23.66667F, -3F);
      Base.setTextureSize(16, 16);
      Base.mirror = true;
      setRotation(Base, 0F, 0F, 0F);
      Top = new ModelRenderer(this, -6, 0);
      Top.addBox(0F, 0F, 0F, 8, 0, 6);
      Top.setRotationPoint(-4F, 20.7F, -3F);
      Top.setTextureSize(16, 16);
      Top.mirror = true;
      setRotation(Top, 0F, 0F, 0F);
      SideF = new ModelRenderer(this, 0, 6);
      SideF.addBox(0F, 0F, 0F, 8, 3, 0);
      SideF.setRotationPoint(-4F, 20.7F, -3F);
      SideF.setTextureSize(16, 16);
      SideF.mirror = true;
      setRotation(SideF, 0F, 0F, 0F);
      SideR = new ModelRenderer(this, 2, 6);
      SideR.addBox(0F, 0F, 0F, 6, 3, 0);
      SideR.setRotationPoint(-4F, 20.7F, 3F);
      SideR.setTextureSize(16, 16);
      SideR.mirror = true;
      setRotation(SideR, 0F, 1.570796F, 0F);
      SideL = new ModelRenderer(this, 2, 6);
      SideL.addBox(0F, 0F, 0F, 6, 3, 0);
      SideL.setRotationPoint(4F, 20.7F, -3F);
      SideL.setTextureSize(16, 16);
      SideL.mirror = true;
      setRotation(SideL, 0F, -1.570796F, 0F);
      SideB = new ModelRenderer(this, 0, 6);
      SideB.addBox(0F, 0F, 0F, 8, 3, 0);
      SideB.setRotationPoint(4F, 20.7F, 3F);
      SideB.setTextureSize(16, 16);
      SideB.mirror = true;
      setRotation(SideB, 0F, 3.141593F, 0F);
      Card1 = new ModelRenderer(this, -6, 0);
      Card1.addBox(0F, 0F, 0F, 8, 0, 6);
      Card1.setRotationPoint(-3F, 21.7F, -3F);
      Card1.setTextureSize(16, 16);
      Card1.mirror = true;
      setRotation(Card1, 0F, -0.2094395F, 0F);
      Card2 = new ModelRenderer(this, -6, 0);
      Card2.addBox(0F, 0F, 0F, 8, 0, 6);
      Card2.setRotationPoint(-5F, 22.7F, -3F);
      Card2.setTextureSize(16, 16);
      Card2.mirror = true;
      setRotation(Card2, 0F, 0.1163553F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Base.render(f5);
    Top.render(f5);
    SideF.render(f5);
    SideR.render(f5);
    SideL.render(f5);
    SideB.render(f5);
    Card1.render(f5);
    Card2.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5,Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
