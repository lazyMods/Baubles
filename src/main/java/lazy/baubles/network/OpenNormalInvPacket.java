package lazy.baubles.network;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class OpenNormalInvPacket {

    public OpenNormalInvPacket(PacketBuffer buf) {
    }

    public OpenNormalInvPacket() {
    }

    public void toBytes(PacketBuffer buf) {
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayerEntity playerEntity = ctx.get().getSender();
            if (playerEntity != null) {
                playerEntity.containerMenu.removed(playerEntity);
                playerEntity.containerMenu = playerEntity.inventoryMenu;
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
