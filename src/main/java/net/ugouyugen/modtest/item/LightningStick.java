package net.ugouyugen.modtest.item;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LightningStick extends Item{

    // constructor
    public LightningStick(Item.Settings settings) {
        super(settings);
    }
    // override use method, which is one of the event listener methods.
    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {

        if (world.isClient) {
            // return exit code "PASS"
            return ActionResult.PASS;
        }
        // get block position, 10 blocks ahead.
        BlockPos frontOfPlayer = user.getBlockPos().offset(user.getHorizontalFacing(), 10);

        // Spawn the lightning bolt.
        LightningEntity lightningBolt = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
        lightningBolt.setPosition(frontOfPlayer.toCenterPos());
        world.spawnEntity(lightningBolt);
        // return exit code "SUCCESS"
        return ActionResult.SUCCESS;
    }
}
