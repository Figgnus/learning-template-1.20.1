package net.figgnus.learning.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

public class MetalDetectorItem extends Item {

    //extends fix
    public MetalDetectorItem(Settings settings) {
        super(settings);
    }


    //method override
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        if(!context.getWorld().isClient()) {

            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            //loop searching for a valuable block
            for (int i = 0; i <= positionClicked.getY() + 64; i++) {
                BlockState state = context.getWorld().getBlockState(positionClicked.down(i));

                if (isValuableBlock(state)) {
                    outputValuableCoordinates(positionClicked.down(i), player, state.getBlock());
                    foundBlock = true;
                    break;
                }
            }
            //output message (fail)
            if (!foundBlock) {
                player.sendMessage(Text.literal("No valuables found :("));
            }
        }

        //using durability
        context.getStack().damage(1, context.getPlayer(),
                playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));


        return ActionResult.SUCCESS;
    }

    //↓ set valuable block
    private boolean isValuableBlock(BlockState state){
        return state.isOf(Blocks.IRON_ORE) || state.isOf(Blocks.DIAMOND_ORE);
    }
    //↓ output message (success)
    private void outputValuableCoordinates(BlockPos blockPos, PlayerEntity player, Block block){
        player.sendMessage(Text.literal("Found " + block.asItem().getName().getString() +
                " at " + "(" + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ()
                + ")"),false);
    }
}
