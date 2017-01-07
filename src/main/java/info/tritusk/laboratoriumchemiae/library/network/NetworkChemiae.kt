package info.tritusk.laboratoriumchemiae.library.network

import java.io.ByteArrayOutputStream
import java.io.DataInputStream
import java.io.DataOutputStream
import io.netty.buffer.ByteBufInputStream
import io.netty.buffer.Unpooled
import net.minecraft.client.Minecraft
import net.minecraft.client.entity.EntityPlayerSP
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.player.EntityPlayerMP
import net.minecraft.network.PacketBuffer
import net.minecraft.network.NetHandlerPlayServer
import net.minecraft.util.math.BlockPos
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.network.FMLEventChannel
import net.minecraftforge.fml.common.network.FMLNetworkEvent
import net.minecraftforge.fml.common.network.NetworkRegistry
import net.minecraftforge.fml.common.network.internal.FMLProxyPacket

const val CHANNEL_NAME = "LabChm"

object NetworkHandler {
    
    private val channel: FMLEventChannel = NetworkRegistry.INSTANCE.newEventDrivenChannel(CHANNEL_NAME)
    
    init {
        channel.register(this)
    }
    
    @SubscribeEvent fun onClientPacket(packet: FMLNetworkEvent.ClientCustomPacketEvent) = resolveClientPacket(
        DataInputStream(ByteBufInputStream(packet.packet.payload())),
        Minecraft.getMinecraft().player
    )
    
    @SubscribeEvent fun onServerPacket(packet: FMLNetworkEvent.ServerCustomPacketEvent) = resolveServerPacket(
        DataInputStream(ByteBufInputStream(packet.packet.payload())),
        (packet.handler as NetHandlerPlayServer).playerEntity
    )
    
    fun sendPacketToDim(pkt: PacketChemiae, dim: Int) = channel.sendToDimension(pkt.encapsulate(), dim)
    
    fun sendPacketAroundPos(pkt: PacketChemiae, dim: Int, pos: BlockPos, range: Double = 2.0) = channel.sendToAllAround(
        pkt.encapsulate(),
        NetworkRegistry.TargetPoint(dim, pos.getX().toDouble(), pos.getY().toDouble(), pos.getZ().toDouble(), range))
    
    fun sendPacketToPlayer(pkt: PacketChemiae, player: EntityPlayerMP) = channel.sendTo(pkt.encapsulate(), player)
    
    fun sendPacketToAll(pkt: PacketChemiae) = channel.sendToAll(pkt.encapsulate())
    
    fun sendPacketToServer(pkt: PacketChemiae) = channel.sendToServer(pkt.encapsulate())
    
    private fun resolveClientPacket(stream: DataInputStream, player: EntityPlayerSP) {
		player.activeHand
		when (stream.readByte()) {
			
		}
    }
    
    private fun resolveServerPacket(stream: DataInputStream, player: EntityPlayerMP) {
		player.activeHand
		when (stream.readByte()) {
			
		}
    }
    
}

interface PacketChemiae {
    fun writeData(stream: DataOutputStream)
    fun readData(stream: DataInputStream, player: EntityPlayer)
}

fun PacketChemiae.encapsulate(): FMLProxyPacket {
	val bytes: ByteArrayOutputStream = ByteArrayOutputStream()
    val data: DataOutputStream = DataOutputStream(bytes)
    try {
        this.writeData(data)
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return FMLProxyPacket(PacketBuffer(Unpooled.wrappedBuffer(bytes.toByteArray())), CHANNEL_NAME)
}