package com.lazy.baubles.proxy;

import com.lazy.baubles.api.IBauble;
import com.lazy.baubles.api.cap.IBaublesItemHandler;
import com.lazy.baubles.api.cap.caps.BaubleCap;
import com.lazy.baubles.api.cap.caps.BaublesItemHandlerCap;
import com.lazy.baubles.network.PacketHandler;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class CommonProxy {

    public void init() {
        this.addToBus();
    }

    public void addToBus() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupCommon);
    }

    public void setupCommon(FMLCommonSetupEvent event) {
        this.capRegistry();
        PacketHandler.registerMessages();
    }

    private void capRegistry() {
        CapabilityManager.INSTANCE.register(IBauble.class, new BaubleCap.IBaubleStorage(), new BaubleCap.IBaubleFactory());
        CapabilityManager.INSTANCE.register(IBaublesItemHandler.class, new BaublesItemHandlerCap.IBaublesItemHandlerStorage(), new BaublesItemHandlerCap.IBaublesItemHandlerFactory());
    }
}
