package drzhark.mocreatures.entity.ambient;


import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import drzhark.mocreatures.MoCreatures;
import drzhark.mocreatures.entity.MoCEntityTameableAmbient;
import drzhark.mocreatures.network.packet.MoCPacketAnimation;

public class MoCEntityCrab extends MoCEntityTameableAmbient

{
    public MoCEntityCrab(World world)
    {
        super(world);
        setSize(0.3F, 0.3F);
        //health = 6;
        setEdad(50 + rand.nextInt(50));
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(6.0D);
    }

    @Override
    public float getMoveSpeed()
    {
        return 0.15F;
    }

    @Override
    public void selectType()
    {
        if (getType() == 0)
        {
            setType(rand.nextInt(2) + 1);
        }

    }

    @Override
    public ResourceLocation getTexture()
    {
        switch (getType())
        {
        case 1:
            return MoCreatures.proxy.getTexture("craba.png");
        case 2:
            return MoCreatures.proxy.getTexture("crabb.png");
        default:
            return MoCreatures.proxy.getTexture("craba.png");
        }
    }

    

    @Override
    public void onLivingUpdate()
    {
        super.onLivingUpdate();

        if (MoCreatures.isServer())
        {
            if (fleeingTick == 3)
            {
                MoCreatures.packetPipeline.sendToDimension(new MoCPacketAnimation(this.getEntityId(), 1), this.worldObj.provider.dimensionId);
            }
        }
    }

    @Override
    protected void fall(float f)
    {
    }

    @Override
    public void performAnimation(int animationType)
    {
        if (animationType == 1) //fleeing animation finishes
        {
            this.fleeingTick = 0;
        }
    }

    @Override
    protected Item func_146068_u()
    {
        return MoCreatures.crabmeat;
    }

    @Override
    public boolean isOnLadder()
    {
        return isCollidedHorizontally;
    }

    public boolean climbing()
    {
        return !onGround && isOnLadder();
    }

    @Override
    public void jump()
    {
    }


    @Override
    public float getSizeFactor() 
    {   
        return 0.7F * (float)getEdad() * 0.01F;
    }
    
    @Override
    public boolean canBreatheUnderwater()
    {
        return true;
    }
    
    public boolean isFleeing()
    {
        return this.fleeingTick != 0;
    }
    
    /**
     * Get this Entity's EnumCreatureAttribute
     */
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.ARTHROPOD;
    }
    
    protected boolean canBeTrappedInNet() 
    {
        return true;
    }
    
    @Override
    public boolean renderName()
    {
        return getDisplayName() && (riddenByEntity == null);
    }
    
    @Override
    public int nameYOffset()
    {
        return -20;
    }
}